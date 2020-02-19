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

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.activities.MainActivity;
import com.clov3rlabs.jensoft.surdenic.adapters.ProductoMainAdapter;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.repo.ProductoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;

import java.util.ArrayList;
import java.util.List;


public class ProductoFragment extends Fragment implements SearchView.OnQueryTextListener {

    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(getContext());
    private List<Producto> productoList = new ArrayList<>();
    private ProductoRepo productoRepo = new ProductoRepo(getContext());


    protected RecyclerView.LayoutManager mLayoutManager;


    private RecyclerView recyclerView;
    private ProductoMainAdapter productoMainAdapter;

    public ProductoFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_producto, container, false);

        recyclerView =  rootView.findViewById(R.id.recycler_view_producto);
        setRecyclerViewLayoutManager();

        ((MainActivity)getActivity()).setToolbarTitle(getString(R.string.nav_producto));

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
        List<Producto> productoList = productoRepo.findNOBonificados();
        if (!productoList.isEmpty()){
            configureAdapter(productoList);
        }
    }

    public void configureAdapter(List<Producto> data){
        productoMainAdapter = new ProductoMainAdapter(getContext(), data);
        recyclerView.setAdapter(productoMainAdapter);
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
        productoMainAdapter.getFilter().filter(newText);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

}
