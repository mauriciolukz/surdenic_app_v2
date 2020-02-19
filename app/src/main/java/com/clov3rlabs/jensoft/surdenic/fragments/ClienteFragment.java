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
import com.clov3rlabs.jensoft.surdenic.adapters.ClienteAdapter;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.repo.ClienteRepo;
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
public class ClienteFragment extends Fragment implements SearchView.OnQueryTextListener {


    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(getContext());
    private List<Cliente> clienteLista = new ArrayList<>();
    private ClienteRepo clienteRepo = new ClienteRepo(getContext());


    protected RecyclerView.LayoutManager mLayoutManager;


    private RecyclerView recyclerView;
    private ClienteAdapter clienteAdapter;

    public ClienteFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_cliente, container, false);


        recyclerView = rootView.findViewById(R.id.recycler_view_cliente);
        setRecyclerViewLayoutManager();

        ((MainActivity)getActivity()).setToolbarTitle(getString(R.string.nav_cliente));

        getData("");
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

    private void getData(String typo_visita){
        List<Cliente> clienteList = clienteRepo.findByIdVendedor(usuario.getId_vendedor(),typo_visita);
        //configureAdapter(clienteList);

        if(!clienteList.isEmpty()){
            configureAdapter(clienteList);

        }

    }

    public void configureAdapter(List<Cliente> data){
        clienteAdapter = new ClienteAdapter(getContext(), data);
        recyclerView.setAdapter(clienteAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_main, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        /*menu.add(0, 1, menu.NONE, getString(R.string.sub_menu_cliente_todos));
        menu.add(0, 2, menu.NONE, getString(R.string.sub_menu_cliente_sin_visitar));
        menu.add(0, 3, menu.NONE, getString(R.string.sub_menu_cliente_visitados));*/

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

       if (Integer.toString(id).equals("Todos")){
           getData("");
        }

        if (Integer.toString(id).equals("Sin visitar")){
            getData("");
        }

        if (Integer.toString(id).equals("Visitados")){
            getData("");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        clienteAdapter.getFilter().filter(newText);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    @Override
    public void onResume() {
        super.onResume();
        getData("");
    }
}
