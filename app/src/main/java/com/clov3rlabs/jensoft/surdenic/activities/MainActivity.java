package com.clov3rlabs.jensoft.surdenic.activities;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.fragments.AcercaFragment;
import com.clov3rlabs.jensoft.surdenic.fragments.ClienteFragment;
import com.clov3rlabs.jensoft.surdenic.fragments.ConfiguracionFragment;
import com.clov3rlabs.jensoft.surdenic.fragments.FacturaFragment;
import com.clov3rlabs.jensoft.surdenic.fragments.ProductoFragment;
import com.clov3rlabs.jensoft.surdenic.fragments.RutaFragment;
import com.clov3rlabs.jensoft.surdenic.fragments.RutaInfoFragment;
import com.clov3rlabs.jensoft.surdenic.fragments.SincronizacionFragment;
import com.clov3rlabs.jensoft.surdenic.models.Ruta;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.repo.RutaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private int id_vendedor; // Vendedor que inicia sesion
    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(this);


    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private Handler mHandler;
    private TextView mTitle;

    private View navHeader;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    public static int navItemIndex = 0;


    private static final String TAG_HOME = "ruta";
    private static final String TAG_CLIENTES = "clientes";
    private static final String TAG_FACTURAS= "facturas";
    private static final String TAG_SINCRONIZACION = "sincronizacion";
    private static final String TAG_CONFIGURACION = "configuracion";
    private static final String TAG_ACERCA = "acerca";
    private static final String TAG_PRODUCTOS = "productos";
    public static String CURRENT_TAG = TAG_HOME;

    private RutaRepo rutaRepo = new RutaRepo(getApplication());
    private Ruta ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getResources().getString(R.string.app_name));

            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#003875")));
            actionBar.setDisplayShowHomeEnabled(true);

            actionBar.setIcon(R.mipmap.ic_launcher);
        }
        Bundle extra = getIntent().getExtras();
        if (extra!= null){
            id_vendedor = extra.getInt("id_vendedor");
            usuario = (Usuario)usuarioRepo.findById(id_vendedor);
        }



        setContentView(R.layout.activity_main);

        //
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu m = navigationView.getMenu();


        navHeader = navigationView.getHeaderView(0);

        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        setUpNavigationView();

        ruta = rutaRepo.getRutaActiva(usuario.getId_vendedor());

        if (savedInstanceState == null) {

            //ruta = (Ruta)rutaRepo.findByIdVendedor(usuario.getId_vendedor());

            if (ruta != null){
                navItemIndex = 1;
                CURRENT_TAG = TAG_CLIENTES;
            }else{
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
            }

            loadHomeFragment(false);
        }

        //



    }


    private void loadHomeFragment(boolean equal) {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        /*if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            //toggleFab();
            return;
        }*/

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (equal) {
            drawer.closeDrawers();
            return;
        }
        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        //toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // rutas
                ruta = rutaRepo.getRutaActiva(usuario.getId_vendedor());
                if (ruta == null){
                    RutaFragment rutaFragment = new RutaFragment();
                    return rutaFragment;
                }else{
                    Bundle bundleParameters = new Bundle();
                    bundleParameters.putInt("id_vendedor", usuario.getId_vendedor());
                    RutaInfoFragment rutaInfoFragment = new RutaInfoFragment();
                    rutaInfoFragment.setArguments(bundleParameters);
                    return rutaInfoFragment;
                }
            case 1:
                // clientes
                ClienteFragment clienteFragment;
                clienteFragment = new ClienteFragment();
                return clienteFragment;
            case 2:
                // facturas
                FacturaFragment facturaFragment = new FacturaFragment();
                return facturaFragment;
            case 3:
                //productos
                ProductoFragment productoFragment = new ProductoFragment();
                return productoFragment;
            case 4:
                // sincronizacion
                SincronizacionFragment sincronizacionFragment = new SincronizacionFragment();
                return sincronizacionFragment;
//            case 5:
//                // Configuracion
//                ConfiguracionFragment configuracionFragment = new ConfiguracionFragment();
//                return configuracionFragment;
            case 5:
                // acerca
                AcercaFragment acercaFragment = new AcercaFragment();
                return acercaFragment;
            default:
                return new ClienteFragment();
        }
    }

    private void setToolbarTitle() {
        //getSupportActionBar().setTitle(activityTitles[navItemIndex]);

        mTitle.setText(activityTitles[navItemIndex]);
    }

    public void setToolbarTitle(String title){
        mTitle.setText(title);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }


    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Check to see which item was being clicked and perform appropriate action

                String title = menuItem.getTitle().toString().toLowerCase();
                boolean is_equal = title.equals(CURRENT_TAG);

                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_ruta:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_clientes:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_CLIENTES;
                        break;
                    case R.id.nav_facturas:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_FACTURAS;
                        break;
                    case R.id.nav_productos:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_PRODUCTOS;
                        break;
                    case R.id.nav_sincronizacion:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_SINCRONIZACION;
                        break;
//                    case R.id.nav_configuracion:
//                        navItemIndex = 5;
//                        CURRENT_TAG = TAG_CONFIGURACION;
//                        break;
                    case R.id.nav_acerca:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_ACERCA;
                        break;
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment(is_equal);

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
//        if (shouldLoadHomeFragOnBackPress) {
//            // checking if user is on other navigation menu
//            // rather than home
//            if (navItemIndex != 0) {
//                navItemIndex = 0;
//                CURRENT_TAG = TAG_HOME;
//                loadHomeFragment(false);
//                return;
//            }
//        }


//        String tag = CURRENT_TAG;
//
//        if (CURRENT_TAG.equals(TAG_INTRANET) || CURRENT_TAG.equals(TAG_ABOUT) || CURRENT_TAG.equals(TAG_LIST_REPORT)){
//            finish();
//        }


        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
//        if (navItemIndex == 0) {
//            getMenuInflater().inflate(R.menu.main, menu);
//        }

        // when fragment is notifications, load the menu created for notifications
        /*if (navItemIndex == 3) {
            getMenuInflater().inflate(R.menu.notifications, menu);
        }*/
        // Inflater menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Search!", Toast.LENGTH_LONG).show();
            return true;
        }*/

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        /*if (id == R.id.action_mark_all_read) {
            Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }*/

        // user is in notifications fragment
        // and selected 'Clear All'
        /*if (id == R.id.action_clear_notifications) {
            Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
        }*/

        return super.onOptionsItemSelected(item);
    }

}
