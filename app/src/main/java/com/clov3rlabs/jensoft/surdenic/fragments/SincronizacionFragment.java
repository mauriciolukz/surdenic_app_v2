package com.clov3rlabs.jensoft.surdenic.fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.activities.MainActivity;
import com.clov3rlabs.jensoft.surdenic.models.Cobro;
import com.clov3rlabs.jensoft.surdenic.models.CobroNoExitoso;
import com.clov3rlabs.jensoft.surdenic.models.CobroNoExitosoRequest;
import com.clov3rlabs.jensoft.surdenic.models.CobroRequest;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedidoRequest;
import com.clov3rlabs.jensoft.surdenic.models.EnvioResponse;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.models.Pedido;
import com.clov3rlabs.jensoft.surdenic.models.PedidoRequest;
import com.clov3rlabs.jensoft.surdenic.models.PedidosRequest;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosa;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosaRequest;
import com.clov3rlabs.jensoft.surdenic.repo.CobroNoExitosoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CobroRepo;
import com.clov3rlabs.jensoft.surdenic.repo.DetallePedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.PedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ProductoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.VisitaNoExitosaRepo;
import com.clov3rlabs.jensoft.surdenic.rest.ApiClient;
import com.clov3rlabs.jensoft.surdenic.rest.ApiInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SincronizacionFragment extends Fragment {

    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(getContext());

    private ProgressDialog barProgressDialog;

    private ApiInterface apiService;
    List<VisitaNoExitosaRequest> visitaNoExitosaRequestList = new ArrayList<>();
    List<CobroNoExitosoRequest> cobroNoExitosoRequestList = new ArrayList<>();
    List<CobroRequest> cobroRequestList = new ArrayList<>();

    PedidoRequest pedidoRequest;
    DetallePedidoRequest detallePedidoRequest;
    List<DetallePedidoRequest> detallePedidoRequestList;
    List<PedidoRequest> pedidoRequestList = new ArrayList<>();

    PedidosRequest pedidosRequest;

    List<VisitaNoExitosa> visitaNoExitosaList;
    List<CobroNoExitoso> cobroNoExitosoList;
    List<Cobro> cobroList;
    List<Pedido> pedidoList;
    List<DetallePedido> detallePedidoList;

    VisitaNoExitosaRepo visitaNoExitosaRepo;
    CobroNoExitosoRepo cobroNoExitosoRepo;
    CobroRepo cobroRepo;
    PedidoRepo pedidoRepo;
    DetallePedidoRepo detallePedidoRepo;

    public SincronizacionFragment() {
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

        View rootView = inflater.inflate(R.layout.fragment_sincronizacion, container, false);

        ((MainActivity)getActivity()).setToolbarTitle(getString(R.string.nav_sincronizacion));

        LinearLayout btn_enviar_visitas_no_exitsas = (LinearLayout) rootView.findViewById(R.id.btn_visitas_no_exitosas);
        LinearLayout btn_enviar_cobros_no_exitosos = (LinearLayout) rootView.findViewById(R.id.btn_cobros_no_exitosos);
        LinearLayout btn_enviar_cobros = (LinearLayout) rootView.findViewById(R.id.btn_cobros_exitosos);
        LinearLayout btn_pedidos = (LinearLayout) rootView.findViewById(R.id.btn_pedidos);

        btn_enviar_visitas_no_exitsas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                visitaNoExitosaRequestList = createRequestBodyVisitasNoExitosas();

                if (!visitaNoExitosaRequestList.isEmpty()){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_visitas_no_exitosas));
                    alertDialogBuilder.setIcon(R.drawable.ic_ask);
                    alertDialogBuilder.setMessage(R.string.messages_send_data);
                    alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            barProgressDialog = new ProgressDialog(getContext());
                            barProgressDialog.setTitle(R.string.progress_diaog_title_visitas_no_exitosas);
                            barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message));
                            barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
                            barProgressDialog.setProgress(0);
                            //barProgressDialog.setMax(visitaNoExitosaRequestList.size());
                            barProgressDialog.setCancelable(false);
                            barProgressDialog.show();

                            apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

                            Call<EnvioResponse> call = apiService.EnviarVisitasNoExitosas(usuario.getApi_key(), visitaNoExitosaRequestList, String.valueOf(usuario.getId_vendedor()));

                            call.enqueue(new Callback<EnvioResponse>() {
                                @Override
                                public void onResponse(Call<EnvioResponse> call, Response<EnvioResponse> response) {


                                    if (response.body()!= null){
                                        EnvioResponse envioResponse =  response.body();

                                        for (VisitaNoExitosa v: visitaNoExitosaList) {
                                            v.setSend(true);
                                            visitaNoExitosaRepo.update(v);
                                        }

                                        Toast toast = Toast.makeText(getContext(), R.string.visitas_no_exitosas_enviadas, Toast.LENGTH_SHORT);
                                        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                        if( v != null) v.setGravity(Gravity.CENTER);
                                        toast.show();


                                    }else{
                                        if (response.errorBody() != null) {
                                            try{

                                                Toast toast = Toast.makeText(getContext(), R.string.progress_dialog_error, Toast.LENGTH_SHORT);
                                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                                if( v != null) v.setGravity(Gravity.CENTER);
                                                toast.show();

                                                Log.i("Sincronizacion: ", response.errorBody().string());

                                            }catch (IOException ex){

                                                Log.i("Sincronizacion: ", ex.getMessage());
                                            }

                                        }
                                    }

                                    barProgressDialog.dismiss();

                                }

                                @Override
                                public void onFailure(Call<EnvioResponse> call, Throwable t) {
                                    Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                                    barProgressDialog.dismiss();

                                }

                            });

                        }

                    });


                    alertDialogBuilder.setNegativeButton(R.string.messages_send_data_negative, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();



                }else{
                    Toast.makeText(getContext().getApplicationContext(), R.string.visitas_no_exitosas_vacias, Toast.LENGTH_LONG).show();
                }

            }

        });

        btn_enviar_cobros_no_exitosos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                // validar si hay cobros no exitosas

                cobroNoExitosoRequestList = createRequestBodyCobrosNoExitosos();

                if (!cobroNoExitosoRequestList.isEmpty()){

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_cobros_no_exitosos));
                    alertDialogBuilder.setIcon(R.drawable.ic_ask);
                    alertDialogBuilder.setMessage(R.string.messages_send_data);
                    alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            barProgressDialog = new ProgressDialog(getContext());
                            barProgressDialog.setTitle(R.string.progress_diaog_title_cobros_no_exitosas);
                            barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message));
                            barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
                            barProgressDialog.setProgress(0);
                            //barProgressDialog.setMax(visitaNoExitosaRequestList.size());
                            barProgressDialog.setCancelable(false);
                            barProgressDialog.show();

                            apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

                            Call<EnvioResponse> call = apiService.EnviarCobrosNoExitosos(usuario.getApi_key(), cobroNoExitosoRequestList, String.valueOf(usuario.getId_vendedor()));

                            call.enqueue(new Callback<EnvioResponse>() {
                                @Override
                                public void onResponse(Call<EnvioResponse> call, Response<EnvioResponse> response) {


                                    if (response.body()!= null){
                                        EnvioResponse envioResponse =  response.body();

                                        for (CobroNoExitoso c: cobroNoExitosoList) {
                                            c.setSend(true);
                                            cobroNoExitosoRepo.update(c);
                                        }

                                        Toast toast = Toast.makeText(getContext(), R.string.cobross_no_exitosos_enviadas, Toast.LENGTH_SHORT);
                                        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                        if( v != null) v.setGravity(Gravity.CENTER);
                                        toast.show();


                                    }else{
                                        if (response.errorBody() != null) {
                                            try{

                                                Toast toast = Toast.makeText(getContext(), R.string.progress_dialog_error, Toast.LENGTH_SHORT);
                                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                                if( v != null) v.setGravity(Gravity.CENTER);
                                                toast.show();

                                                Log.i("Sincronizacion: ", response.errorBody().string());

                                            }catch (IOException ex){

                                                Log.i("Sincronizacion: ", ex.getMessage());
                                            }

                                        }
                                    }

                                    barProgressDialog.dismiss();

                                }

                                @Override
                                public void onFailure(Call<EnvioResponse> call, Throwable t) {
                                    Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                                    barProgressDialog.dismiss();

                                }

                            });

                        }

                    });


                    alertDialogBuilder.setNegativeButton(R.string.messages_send_data_negative, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();


                }else{
                    Toast.makeText(getContext().getApplicationContext(), R.string.cobros_no_exitosas_vacias, Toast.LENGTH_LONG).show();

                }


            }

        });

        btn_enviar_cobros.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                // validar si hay cobros

                cobroRequestList = createRequestBodyCobros();

                if (!cobroRequestList.isEmpty()){

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_cobros));
                    alertDialogBuilder.setIcon(R.drawable.ic_ask);
                    alertDialogBuilder.setMessage(R.string.messages_send_data);
                    alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            barProgressDialog = new ProgressDialog(getContext());
                            barProgressDialog.setTitle(R.string.progress_diaog_title_cobros_exitosos);
                            barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message));
                            barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
                            barProgressDialog.setProgress(0);
                            //barProgressDialog.setMax(visitaNoExitosaRequestList.size());
                            barProgressDialog.setCancelable(false);
                            barProgressDialog.show();

                            apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

                            Call<EnvioResponse> call = apiService.EnviarCobros(usuario.getApi_key(), cobroRequestList, String.valueOf(usuario.getId_vendedor()));

                            call.enqueue(new Callback<EnvioResponse>() {
                                @Override
                                public void onResponse(Call<EnvioResponse> call, Response<EnvioResponse> response) {


                                    if (response.body()!= null){
                                        EnvioResponse envioResponse =  response.body();

                                        for (Cobro c: cobroList) {
                                            c.setSend(true);
                                            cobroRepo.update(c);

                                        }

                                        Toast toast = Toast.makeText(getContext(), R.string.cobros_exitosos_enviados, Toast.LENGTH_SHORT);
                                        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                        if( v != null) v.setGravity(Gravity.CENTER);
                                        toast.show();


                                    }else{
                                        if (response.errorBody() != null) {
                                            try{

                                                Toast toast = Toast.makeText(getContext(), R.string.progress_dialog_error, Toast.LENGTH_SHORT);
                                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                                if( v != null) v.setGravity(Gravity.CENTER);
                                                toast.show();

                                                Log.i("Sincronizacion: ", response.errorBody().string());

                                            }catch (IOException ex){

                                                Log.i("Sincronizacion: ", ex.getMessage());
                                            }

                                        }
                                    }

                                    barProgressDialog.dismiss();

                                }

                                @Override
                                public void onFailure(Call<EnvioResponse> call, Throwable t) {
                                    Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                                    barProgressDialog.dismiss();

                                }

                            });

                        }

                    });


                    alertDialogBuilder.setNegativeButton(R.string.messages_send_data_negative, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                }else{

                    Toast.makeText(getContext().getApplicationContext(), R.string.cobros_exitosos_vacias, Toast.LENGTH_LONG).show();
                }

            }

        });

        btn_pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // validar si hay pedidos

                pedidosRequest = createBodyPedido();
                if(!pedidosRequest.getPedidos().isEmpty()){

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_pedidos));
                    alertDialogBuilder.setIcon(R.drawable.ic_ask);
                    alertDialogBuilder.setMessage(R.string.messages_send_data);
                    alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            barProgressDialog = new ProgressDialog(getContext());
                            barProgressDialog.setTitle(R.string.progress_diaog_title_pedidos_exitosos);
                            barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message));
                            barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
                            barProgressDialog.setProgress(0);
                            barProgressDialog.setCancelable(false);
                            barProgressDialog.show();

                            apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

                            Call<EnvioResponse> call = apiService.EnviarPedidos(usuario.getApi_key(), pedidosRequest, String.valueOf(usuario.getId_vendedor()));

                            call.enqueue(new Callback<EnvioResponse>() {
                                @Override
                                public void onResponse(Call<EnvioResponse> call, Response<EnvioResponse> response) {


                                    if (response.body()!= null){
                                        EnvioResponse envioResponse =  response.body();

                                        for (Pedido p: pedidoList) {
                                            p.setSend(true);
                                            pedidoRepo.update(p);

                                        }

                                        actualizarInventarioIndiv();


                                    }else{
                                        if (response.errorBody() != null) {
                                            try{

                                                Toast toast = Toast.makeText(getContext(), R.string.progress_dialog_error, Toast.LENGTH_SHORT);
                                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                                if( v != null) v.setGravity(Gravity.CENTER);
                                                toast.show();

                                                Log.i("Sincronizacion: ", response.errorBody().string());

                                            }catch (IOException ex){

                                                Log.i("Sincronizacion: ", ex.getMessage());
                                            }

                                        }
                                    }



                                }

                                @Override
                                public void onFailure(Call<EnvioResponse> call, Throwable t) {
                                    Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                                    barProgressDialog.dismiss();

                                }

                            });

                        }

                    });


                    alertDialogBuilder.setNegativeButton(R.string.messages_send_data_negative, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();



                }else{
                    Toast.makeText(getContext().getApplicationContext(), R.string.pedidos_vacias, Toast.LENGTH_LONG).show();
                }


            }
        });

        return rootView;

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        menu.add(0, 1, menu.NONE, getString(R.string.sub_menu_sincronizacion));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1){
            // show dialog

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dialog_title_todos));
            alertDialogBuilder.setIcon(R.drawable.ic_ask);
            alertDialogBuilder.setMessage(R.string.messages_send_data);
            alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    enviarTodos();

                }

            });


            alertDialogBuilder.setNegativeButton(R.string.messages_send_data_negative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();


        }
        return super.onOptionsItemSelected(item);
    }


    private void enviarTodos(){

        barProgressDialog = new ProgressDialog(getContext());
        barProgressDialog.setTitle(R.string.progress_diaog_title_datos);
        barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message));
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
        barProgressDialog.setProgress(0);
        barProgressDialog.setCancelable(false);
        barProgressDialog.show();

        visitaNoExitosaRequestList = createRequestBodyVisitasNoExitosas();

        if (!visitaNoExitosaRequestList.isEmpty()){

            apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

            Call<EnvioResponse> call = apiService.EnviarVisitasNoExitosas(usuario.getApi_key(), visitaNoExitosaRequestList, String.valueOf(usuario.getId_vendedor()));

            call.enqueue(new Callback<EnvioResponse>() {
                @Override
                public void onResponse(Call<EnvioResponse> call, Response<EnvioResponse> response) {


                    if (response.body()!= null){
                        EnvioResponse envioResponse =  response.body();

                        for (VisitaNoExitosa v: visitaNoExitosaList) {
                            v.setSend(true);
                            visitaNoExitosaRepo.update(v);
                        }

                        enviarCobrosNoExitosos();


                    }else{
                        if (response.errorBody() != null) {
                            try{

                                Toast toast = Toast.makeText(getContext(), R.string.progress_dialog_error, Toast.LENGTH_SHORT);
                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                if( v != null) v.setGravity(Gravity.CENTER);
                                toast.show();

                                Log.i("Sincronizacion: ", response.errorBody().string());

                            }catch (IOException ex){

                                Log.i("Sincronizacion: ", ex.getMessage());
                            }

                            barProgressDialog.dismiss();

                        }
                    }



                }

                @Override
                public void onFailure(Call<EnvioResponse> call, Throwable t) {
                    Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                    barProgressDialog.dismiss();

                }

            });

        }else{
            enviarCobrosNoExitosos();
        }

    }

    private void enviarCobrosNoExitosos(){

        cobroNoExitosoRequestList = createRequestBodyCobrosNoExitosos();

        if (!cobroNoExitosoRequestList.isEmpty()){

            apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

            Call<EnvioResponse> call = apiService.EnviarCobrosNoExitosos(usuario.getApi_key(), cobroNoExitosoRequestList, String.valueOf(usuario.getId_vendedor()));

            call.enqueue(new Callback<EnvioResponse>() {
                @Override
                public void onResponse(Call<EnvioResponse> call, Response<EnvioResponse> response) {


                    if (response.body()!= null){
                        EnvioResponse envioResponse =  response.body();

                        for (CobroNoExitoso c: cobroNoExitosoList) {
                            c.setSend(true);
                            cobroNoExitosoRepo.update(c);
                        }

                        enviarCobros();


                    }else{
                        if (response.errorBody() != null) {
                            try{

                                Toast toast = Toast.makeText(getContext(), R.string.progress_dialog_error, Toast.LENGTH_SHORT);
                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                if( v != null) v.setGravity(Gravity.CENTER);
                                toast.show();

                                Log.i("Sincronizacion: ", response.errorBody().string());

                            }catch (IOException ex){

                                Log.i("Sincronizacion: ", ex.getMessage());
                            }

                            barProgressDialog.dismiss();

                        }
                    }


                }

                @Override
                public void onFailure(Call<EnvioResponse> call, Throwable t) {
                    Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                    barProgressDialog.dismiss();

                }

            });

        }else{
            enviarCobros();
        }


    }


    private void enviarCobros(){

        cobroRequestList = createRequestBodyCobros();

        if (!cobroRequestList.isEmpty()){
            apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

            Call<EnvioResponse> call = apiService.EnviarCobros(usuario.getApi_key(), cobroRequestList, String.valueOf(usuario.getId_vendedor()));

            call.enqueue(new Callback<EnvioResponse>() {
                @Override
                public void onResponse(Call<EnvioResponse> call, Response<EnvioResponse> response) {


                    if (response.body()!= null){
                        EnvioResponse envioResponse =  response.body();

                        for (Cobro c: cobroList) {
                            c.setSend(true);
                            cobroRepo.update(c);

                        }

                        enviarPedidos();


                    }else{
                        if (response.errorBody() != null) {
                            try{

                                Toast toast = Toast.makeText(getContext(), R.string.progress_dialog_error, Toast.LENGTH_SHORT);
                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                if( v != null) v.setGravity(Gravity.CENTER);
                                toast.show();

                                Log.i("Sincronizacion: ", response.errorBody().string());

                            }catch (IOException ex){

                                Log.i("Sincronizacion: ", ex.getMessage());
                            }

                            barProgressDialog.dismiss();

                        }
                    }



                }

                @Override
                public void onFailure(Call<EnvioResponse> call, Throwable t) {
                    Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                    barProgressDialog.dismiss();

                }

            });


        }else{
            enviarPedidos();
        }
    }

    private void enviarPedidos(){

        pedidosRequest = createBodyPedido();

        if(!pedidosRequest.getPedidos().isEmpty()){

            apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

            Call<EnvioResponse> call = apiService.EnviarPedidos(usuario.getApi_key(), pedidosRequest, String.valueOf(usuario.getId_vendedor()));

            call.enqueue(new Callback<EnvioResponse>() {
                @Override
                public void onResponse(Call<EnvioResponse> call, Response<EnvioResponse> response) {


                    if (response.body()!= null){
                        EnvioResponse envioResponse =  response.body();

                        for (Pedido p: pedidoList) {
                            p.setSend(true);
                            pedidoRepo.update(p);

                        }

                        // act invent
                        actualizarInventario();




                    }else{
                        if (response.errorBody() != null) {
                            try{

                                Toast toast = Toast.makeText(getContext(), R.string.progress_dialog_error, Toast.LENGTH_SHORT);
                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                if( v != null) v.setGravity(Gravity.CENTER);
                                toast.show();

                                Log.i("Sincronizacion: ", response.errorBody().string());

                            }catch (IOException ex){

                                Log.i("Sincronizacion: ", ex.getMessage());
                            }

                            barProgressDialog.dismiss();

                        }
                    }



                }

                @Override
                public void onFailure(Call<EnvioResponse> call, Throwable t) {
                    Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                    barProgressDialog.dismiss();

                }

            });

        }else{
            barProgressDialog.dismiss();
        }


    }



    private List<VisitaNoExitosaRequest> createRequestBodyVisitasNoExitosas(){

        visitaNoExitosaRepo = new VisitaNoExitosaRepo(getContext());

        List<VisitaNoExitosaRequest> visitaNoExitosaRequestList = new ArrayList<VisitaNoExitosaRequest>();
        VisitaNoExitosaRequest visitaNoExitosaRequest;

        visitaNoExitosaList = visitaNoExitosaRepo.getToSendByIdVendedor(usuario.getId_vendedor());

        for (VisitaNoExitosa v: visitaNoExitosaList) {

            visitaNoExitosaRequest = new VisitaNoExitosaRequest();

            visitaNoExitosaRequest.setId_cliente(v.getId_cliente());
            visitaNoExitosaRequest.setId_vendedor(v.getId_vendedor());
            visitaNoExitosaRequest.setId_ruta_trabajo(v.getId_ruta_trabajo());
            visitaNoExitosaRequest.setFecha_registro(v.getFecha_registro());
            visitaNoExitosaRequest.setRazon_visita_no_exitosa(v.getRazon_visita_no_exitoso());
            visitaNoExitosaRequest.setObservaciones_visita(v.getObservaciones_visita());

            visitaNoExitosaRequestList.add(visitaNoExitosaRequest);


        }

        return visitaNoExitosaRequestList;

    }

    private List<CobroNoExitosoRequest> createRequestBodyCobrosNoExitosos(){
        cobroNoExitosoRepo = new CobroNoExitosoRepo(getContext());
        List<CobroNoExitosoRequest> cobroNoExitosoRequestList = new ArrayList<CobroNoExitosoRequest>();
        CobroNoExitosoRequest cobroNoExitosoRequest;

        cobroNoExitosoList = cobroNoExitosoRepo.getToSendByIdVendedor(usuario.getId_vendedor());


        for (CobroNoExitoso c: cobroNoExitosoList){
            cobroNoExitosoRequest = new CobroNoExitosoRequest();
            cobroNoExitosoRequest.setId_cliente(c.getId_cliente());
            cobroNoExitosoRequest.setTipo_cliente(c.getTipo_cliente());
            cobroNoExitosoRequest.setId_vendedor(c.getId_vendedor());
            cobroNoExitosoRequest.setId_ruta_trabajo(c.getId_ruta_trabajo());
            cobroNoExitosoRequest.setNum_factura(c.getNum_factura());
            cobroNoExitosoRequest.setTipo_documento(c.getTipo_documento());
            cobroNoExitosoRequest.setFecha_factura(c.getFecha_factura());
            cobroNoExitosoRequest.setMonto_pc(c.getMonto_pc());
            cobroNoExitosoRequest.setFecha_registro(c.getFecha_registro());
            cobroNoExitosoRequest.setRazon_cobro_no_exitoso(c.getRazon_cobro_no_exitoso());
            cobroNoExitosoRequest.setObservaciones_cobro(c.getObservaciones_cobro());

            //nuevos
            cobroNoExitosoRequest.setTipo_cliente(c.getTipo_cliente());
            cobroNoExitosoRequest.setMonto_total_credito(c.getMonto_total_credito());
            cobroNoExitosoRequest.setNotas_creditos(c.getNotas_creditos());
            cobroNoExitosoRequest.setNotas_debitos(c.getNotas_debitos());
            cobroNoExitosoRequest.setAbonos_creditos(c.getAbonos_creditos());

            cobroNoExitosoRequestList.add(cobroNoExitosoRequest);

        }

        return cobroNoExitosoRequestList;

    }

    private List<CobroRequest> createRequestBodyCobros(){
        cobroRepo = new CobroRepo(getContext());
        List<CobroRequest> cobroRequestList = new ArrayList<CobroRequest>();
        CobroRequest cobroRequest;

        cobroList = cobroRepo.getToSendByIdVendedor(usuario.getId_vendedor());

        for (Cobro c : cobroList){
            cobroRequest = new CobroRequest();

            cobroRequest.setId_cliente(c.getId_cliente());
            cobroRequest.setId_vendedor(c.getId_vendedor());
            cobroRequest.setId_ruta(c.getId_ruta());
            cobroRequest.setNumero_factura(c.getNumero_factura());
            cobroRequest.setMonto_pc(c.getMonto_pc());
            cobroRequest.setTipo_documento(c.getTipo_documento());
            cobroRequest.setEs_pc(c.getEs_pc());
            cobroRequest.setFecha_factura(c.getFecha_factura());
            cobroRequest.setFecha_cobro_realizado(c.getFecha_cobro_realizado());
            cobroRequest.setForma_pago(c.getForma_pago());
            cobroRequest.setNumero_recibo(c.getNumero_recibo());
            cobroRequest.setCta_deposito(c.getCta_deposito());
            cobroRequest.setBanco_emite(c.getBanco_emite());
            cobroRequest.setNumero_cheque(c.getNumero_cheque());
            cobroRequest.setFecha_emision_ck(c.getFecha_emision_ck());
            cobroRequest.setFecha_cobro_ck(c.getFecha_cobro_ck());
            cobroRequest.setMonto_nio(c.getMonto_nio());
            cobroRequest.setMonto_usd(c.getMonto_usd());
            cobroRequest.setTasa_cambio(c.getTasa_cambio());
            cobroRequest.setMonto_usd_nio(c.getMonto_usd_nio());
            cobroRequest.setMonto_abonado(c.getMonto_abonado());
            cobroRequest.setSaldo_actual(c.getSaldo_actual());
            cobroRequest.setRet_ir(c.getRet_ir());
            cobroRequest.setNum_ret_ir(c.getRet_ir());
            cobroRequest.setValor_ret_ir(c.getValor_ret_ir());
            cobroRequest.setRet_imi(c.getRet_imi());
            cobroRequest.setNum_ret_imi(c.getRet_imi());
            cobroRequest.setValor_ret_imi(c.getValor_ret_imi());
            cobroRequest.setEfectivo_recibido(c.getEfectivo_recibido());
            cobroRequest.setTipo_cliente(c.getTipo_cliente());
            cobroRequest.setMonto_total_credito(c.getMonto_total_credito());
            cobroRequest.setNotas_creditos(c.getNotas_creditos());
            cobroRequest.setNotas_debitos(c.getNotas_debitos());
            cobroRequest.setAbonos_creditos(c.getAbonos_creditos());


            cobroRequestList.add(cobroRequest);
        }


        return cobroRequestList;
    }

    private PedidosRequest createBodyPedido(){

        pedidoRepo = new PedidoRepo(getContext());
        //pedidoRepo.
        detallePedidoRepo = new DetallePedidoRepo(getContext());
        pedidosRequest = new PedidosRequest();

        pedidoRequestList = new ArrayList<PedidoRequest>();


        pedidoList = pedidoRepo.getToSendByIdVendedor(usuario.getId_vendedor());


        for (Pedido p: pedidoList) {

            pedidoRequest = new PedidoRequest();
            pedidoRequest.setId_vendedor(p.getId_vendedor());
            pedidoRequest.setId_cliente(p.getId_cliente());
            pedidoRequest.setId_precio(p.getId_precio());
            pedidoRequest.setFactor_incremento(p.getFactor_incremento());
            pedidoRequest.setFecha_venta(p.getFecha_venta());
            pedidoRequest.setTipo_pago(p.getTipo_pago());
            pedidoRequest.setSubtotal_venta(p.getSubtotal_venta());
            pedidoRequest.setDescuento_venta(p.getDescuento_venta());
            pedidoRequest.setIva_venta(p.getIva_venta());
            pedidoRequest.setTotal_factura_venta(p.getTotal_factura_venta());
            pedidoRequest.setFecha_vencimiento(p.getFecha_vencimiento());
            pedidoRequest.setTasa_cambio(p.getTasa_cambio());
            pedidoRequest.setValor_dolares(p.getValor_dolares());
            pedidoRequest.setNegociacion_especial(p.getNegociacion_especial());
            pedidoRequest.setTipo_observacion(p.getTipo_observacion());
            pedidoRequest.setTotal_vendido(p.getTotal_factura_venta());
            pedidoRequest.setValor_dolares_despues(p.getValor_dolares());
            pedidoRequest.setTotal_iva_despues(p.getTotal_iva());
            pedidoRequest.setTotal_fisico_despues(p.getTotal_fisico());
            pedidoRequest.setUtilidad_venta_despues(p.getUtilidad_venta());
            pedidoRequest.setTotal_sin_iva_despues(p.getTotal_sin_iva());
            pedidoRequest.setContacto_cliente(p.getContacto_cliente());
            pedidoRequest.setContacto_vendedor(p.getContacto_vendedor());
            pedidoRequest.setDireccion_empresa(p.getDireccion_empresa());
            pedidoRequest.setEs_pc(p.getEs_pc());
            pedidoRequest.setId_municipio(p.getId_municipio());
            pedidoRequest.setId_departamento(p.getId_departamento());
            pedidoRequest.setTipo_documento(p.getTipo_documento());
            pedidoRequest.setPendiente_autorizacion(p.getPendiente_autorizacion());
            pedidoRequest.setTotal_iva(p.getTotal_iva());
            pedidoRequest.setTotal_sin_iva(p.getTotal_sin_iva());
            pedidoRequest.setTotal_fisico(p.getTotal_fisico());
            pedidoRequest.setUtilidad_venta(p.getUtilidad_venta());//
            pedidoRequest.setMonto_autorizado(p.getMonto_autorizado());
            pedidoRequest.setAutoriza(p.getAutoriza());
            pedidoRequest.setId_ruta(p.getId_ruta());

            detallePedidoList = new ArrayList<>();
            detallePedidoList = detallePedidoRepo.getByPedido(p.getId_pedido());

            detallePedidoRequestList = new ArrayList<>();

            for (DetallePedido d: detallePedidoList) {
                detallePedidoRequest = new DetallePedidoRequest();
                detallePedidoRequest.setId_precio(d.getId_precio());

                detallePedidoRequest.setId_cliente(p.getId_cliente());
                detallePedidoRequest.setId_ruta(p.getId_ruta());
                detallePedidoRequest.setId_municipio(p.getId_municipio());
                detallePedidoRequest.setId_departamento(p.getId_departamento());
                detallePedidoRequest.setId_ruta(p.getId_ruta());
                detallePedidoRequest.setCode_promo_1(d.getCode_promo());
                detallePedidoRequest.setCode_promo_2(d.getCode_promo_2());
                detallePedidoRequest.setCode_promo_3(d.getCode_promo_3());
                detallePedidoRequest.setCode_promo_4(d.getCode_promo_4());
                detallePedidoRequest.setCode_promo_combo(d.getCode_promo_combo());
                detallePedidoRequest.setBonificado(d.getEs_bonificado());
                detallePedidoRequest.setId_canal(d.getId_canal());
                detallePedidoRequest.setId_proveedor(d.getId_proveedor());
                detallePedidoRequest.setId_familia(d.getId_familia());
                detallePedidoRequest.setId_producto(d.getId_producto());
                detallePedidoRequest.setNom_producto(d.getNom_producto());
                detallePedidoRequest.setCantidad_pedida(d.getCantidad_pedida());
                detallePedidoRequest.setCantidad_venta(d.getCantidad_venta());
                detallePedidoRequest.setCaja_vendida(d.getCaja_vendida());
                detallePedidoRequest.setPrecio_venta_antes_iva(d.getPrecio_venta_antes_iva());
                detallePedidoRequest.setPrecio_venta(d.getPrecio_venta());
                detallePedidoRequest.setPrecio_venta_desc(d.getPrecio_venta_desc());
                detallePedidoRequest.setSubtotal_venta(d.getSubtotal_venta());
                detallePedidoRequest.setSubtotal_venta_desc(d.getSubtotal_venta_desc());
                detallePedidoRequest.setPorcentaje_descuento_venta(d.getPorcentaje_descuento_venta());
                detallePedidoRequest.setDescuento_total_venta(d.getDescuento_total_venta());
                detallePedidoRequest.setSubtotal_venta_aplicar_iva(d.getSubtotal_venta_aplicar_iva());
                detallePedidoRequest.setPorcentaje_iva_antes(d.getPorcentaje_iva_antes());
                detallePedidoRequest.setTotal_iva_venta(d.getTotal_iva_venta());
                detallePedidoRequest.setTotal_factura_venta(d.getTotal_factura_venta());
                detallePedidoRequest.setDes0(d.getDes0());
                detallePedidoRequest.setDes1(d.getDes1());
                detallePedidoRequest.setDes2(d.getDes2());
                detallePedidoRequest.setDes3(d.getDes3());
                detallePedidoRequest.setDes4(d.getDes4());
                detallePedidoRequest.setDes5(d.getDes5());
                detallePedidoRequest.setDes6(d.getDes6());
                detallePedidoRequest.setDes7(d.getDes7());
                detallePedidoRequest.setDes8(d.getDes8());
                detallePedidoRequest.setDes9(d.getDes9());
                detallePedidoRequest.setDes10(d.getDes10());
                detallePedidoRequest.setDes11(d.getDes11());
                detallePedidoRequest.setDes12(d.getDes12());
                detallePedidoRequest.setDes13(d.getDes13());
                detallePedidoRequest.setDes14(d.getDes14());
                detallePedidoRequest.setDes15(d.getDes15());
                detallePedidoRequest.setDes16(d.getDes16());
                detallePedidoRequest.setDes17(d.getDes17());
                detallePedidoRequest.setDes18(d.getDes18());
                detallePedidoRequest.setDes19(d.getDes19());
                detallePedidoRequest.setDes20(d.getDes20());
                detallePedidoRequest.setDes21(d.getDes21());
                detallePedidoRequest.setDes22(d.getDes22());
                detallePedidoRequest.setEs_bonificado(d.getEs_bonificado());
                detallePedidoRequest.setReferencia_bonificado(d.getReferencia_bonificado());
                detallePedidoRequest.setEs_bonificado_2(d.getEs_bonificado_2());
                detallePedidoRequest.setReferencia_bonificado_2(d.getReferencia_bonificado_2());
                detallePedidoRequest.setEs_bonificado_3(d.getEs_bonificado_3());
                detallePedidoRequest.setReferencia_bonificado_3(d.getReferencia_bonificado_3());
                detallePedidoRequest.setEs_bonificado_4(d.getEs_bonificado_4());
                detallePedidoRequest.setReferencia_bonificado_4(d.getReferencia_bonificado_4());
                detallePedidoRequest.setEs_bonificado_5(d.getEs_bonificado_5());
                detallePedidoRequest.setReferencia_bonificado_5(d.getReferencia_bonificado_5());
                detallePedidoRequest.setPeriodo_trabajo(d.getPeriodo_trabajo());
                detallePedidoRequest.setPrecio_costo_fisico(d.getPrecio_costo_fisico());
                detallePedidoRequest.setTotal_iva_antes(d.getTotal_iva_antes());
                detallePedidoRequest.setSubtotal_fisico(d.getSubtotal_fisico());
                detallePedidoRequest.setPrecio_costo_fisico(d.getPrecio_costo_fisico());
                detallePedidoRequest.setTotal_iva_antes(d.getTotal_iva_antes());
                detallePedidoRequest.setSubtotal_iva_antes(d.getSubtotal_iva_antes());
                detallePedidoRequest.setSubtotal_fisico(d.getSubtotal_fisico());
                detallePedidoRequest.setUtilidad_venta(d.getUtilidad_venta());
                detallePedidoRequest.setTipo_precio(d.getTipo_precio());
                detallePedidoRequest.setPeriodo_trabajo(d.getPeriodo_trabajo());

                detallePedidoRequestList.add(detallePedidoRequest);

            }

            pedidoRequest.setDetalle(detallePedidoRequestList);

            pedidoRequestList.add(pedidoRequest);


        }


        pedidosRequest.setPedidos(pedidoRequestList);


        return pedidosRequest;

    }

    public void actualizarInventario(){


        final ProductoRepo productoRepo = new ProductoRepo(getContext());

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<Producto>> call = apiService.Productos(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {


                if (response.body()!= null){

                    List<Producto> productoList;
                    productoList = response.body();
                    // clean data
                    productoRepo.deleteAll();

                    for (Producto p : productoList){
                        productoRepo.create(p);
                    }


                    Toast toast = Toast.makeText(getContext(), R.string.informacion_enviada_exito, Toast.LENGTH_SHORT);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    if( v != null) v.setGravity(Gravity.CENTER);
                    toast.show();




                }else{
                    if (response.errorBody() != null) {
                        try{



                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Productos: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Productos: ", ex.getMessage());
                        }

                    }
                }

                barProgressDialog.dismiss();



            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.cancel();
            }


        });


    }



    public void actualizarInventarioIndiv(){


        final ProductoRepo productoRepo = new ProductoRepo(getContext());

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<Producto>> call = apiService.Productos(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {


                if (response.body()!= null){

                    List<Producto> productoList;
                    productoList = response.body();
                    // clean data
                    productoRepo.deleteAll();

                    for (Producto p : productoList){
                        productoRepo.create(p);
                    }


                    Toast toast = Toast.makeText(getContext(), R.string.pedidos_exitosos_enviados, Toast.LENGTH_SHORT);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    if( v != null) v.setGravity(Gravity.CENTER);
                    toast.show();




                }else{
                    if (response.errorBody() != null) {
                        try{



                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Productos: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Productos: ", ex.getMessage());
                        }

                    }
                }

                barProgressDialog.dismiss();



            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.cancel();
            }


        });


    }

}
