package com.clov3rlabs.jensoft.surdenic.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.activities.MainActivity;
import com.clov3rlabs.jensoft.surdenic.adapters.FacturaAdapter;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.repo.FacturaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;
import com.clov3rlabs.jensoft.surdenic.rest.ApiClient;
import com.clov3rlabs.jensoft.surdenic.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FacturaFragment extends Fragment implements SearchView.OnQueryTextListener {

    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(getContext());
    private List<Factura> facturaLista = new ArrayList<>();
    private FacturaRepo facturaRepo = new FacturaRepo(getContext());

    protected RecyclerView.LayoutManager mLayoutManager;


    private RecyclerView recyclerView;
    private FacturaAdapter facturaAdapter;

    public FacturaFragment() {
        // Required empty public constructor
        usuario = (Usuario)usuarioRepo.findFirst();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_factura, container, false);

        recyclerView =  rootView.findViewById(R.id.recycler_view_factura);
        setRecyclerViewLayoutManager();

        ((MainActivity)getActivity()).setToolbarTitle(getString(R.string.nav_facturas));

        getData();
        return rootView;
    }


    public void setRecyclerViewLayoutManager(){
        int scrollPosition = 0;

        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(scrollPosition);

    }

    private void getData(){
        List<Factura> facturaList = facturaRepo.findByIdVendedor(usuario.getId_vendedor());
        if (!facturaList.isEmpty()){
            configureAdapter(facturaList);
        }
    }


    public void configureAdapter(List<Factura> data){
        facturaAdapter = new FacturaAdapter(getContext(), data);
        recyclerView.setAdapter(facturaAdapter);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_main, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        if (id == R.id.action_refresh){
//
//            getData();
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        facturaAdapter.getFilter().filter(newText);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }
}
