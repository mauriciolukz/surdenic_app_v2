package com.clov3rlabs.jensoft.surdenic.activities;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.adapters.ProductoAdapter;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.repo.ProductoRepo;
import com.clov3rlabs.jensoft.surdenic.utils.MinMaxFilter;

import android.content.Intent;
import android.graphics.Color;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ProductoActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List<Producto> productoList;
    ProductoRepo productoRepo = new ProductoRepo(this);

    ProductoAdapter productoAdapter;

    SearchView editsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);



        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_pedido);



        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }


        productoList = productoRepo.findNOBonificados();


        if (!productoList.isEmpty()){

            productoAdapter = new ProductoAdapter(this, R.layout.producto_list_item, productoList);

            ListView listView = (ListView) findViewById(R.id.list_productos);
            listView.setAdapter(productoAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    //Producto producto = productoList.get(position);

                    // show keyboard
                    InputMethodManager imm = (InputMethodManager)   getSystemService(INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                    final Producto producto = (Producto) parent.getItemAtPosition(position);

                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductoActivity.this);

                    LayoutInflater inflater = getLayoutInflater();

                    View v = inflater.inflate(R.layout.dialog_cantidad_producto, null);

                    builder.setView(v);

                    Button button_guardar_cobro_no_exitoso = (Button) v.findViewById(R.id.button_guardar_cantidad);

                    final EditText txtCantidad = (EditText) v.findViewById(R.id.cantidad_producto_busqueda);
                    txtCantidad.setFilters(new InputFilter[]{ new MinMaxFilter("1", "100000")});

                    TextView codigo_producto_seleccionado = (TextView) v.findViewById(R.id.codigo_producto_seleccionado);
                    TextView nombre_producto_seleccionado = (TextView) v.findViewById(R.id.nombre_producto_seleccionado);
                    TextView precio_producto_seleccionado = (TextView) v.findViewById(R.id.precio_producto_seleccionado);

                    codigo_producto_seleccionado.setText(producto.getId_producto());
                    nombre_producto_seleccionado.setText(producto.getNombre_producto());
                    precio_producto_seleccionado.setText(getString(R.string.moneda_nacional) + " " + String.format("%.2f", producto.getPrecio_venta()));

                    txtCantidad.requestFocus();



                    final AlertDialog dialog = builder.create();

                    button_guardar_cobro_no_exitoso.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    String cantidad = txtCantidad.getText().toString();
                                    txtCantidad.setError(null);

                                    if (TextUtils.isEmpty(cantidad)){
                                        txtCantidad.setError(getString(R.string.error_field_required));

                                    }else{
                                        Intent i = new Intent();
                                        i.putExtra(Intent.EXTRA_TEXT, producto.getId_producto());
                                        i.putExtra("cantidad", txtCantidad.getText().toString());
                                        setResult(RESULT_OK, i);
                                        finish();

                                        //hide keyboard
                                        InputMethodManager imm = (InputMethodManager)getSystemService(
                                                INPUT_METHOD_SERVICE);
                                        imm.hideSoftInputFromWindow(txtCantidad.getWindowToken(), 0);

                                        dialog.dismiss();

                                    }

                                }
                            }
                    );

                    dialog.show();

                }
            });

        }



        editsearch = (SearchView) findViewById(R.id.search);
        int searchPlateId = editsearch.getContext().getResources().getIdentifier("android:id/search_plate", null, null);
        View searchPlate = editsearch.findViewById(searchPlateId);
        if (searchPlate!=null) {
            int searchTextId = searchPlate.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);

            TextView searchText = (TextView) searchPlate.findViewById(searchTextId);

            if (searchText!=null) {
                searchText.setTextColor(Color.WHITE);
                searchText.setHintTextColor(Color.WHITE);
                searchText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }


        }

        editsearch.setOnQueryTextListener(this);



        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }



    @Override
    public boolean onQueryTextChange(String newText) {
        productoAdapter.getFilter().filter(newText);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}
