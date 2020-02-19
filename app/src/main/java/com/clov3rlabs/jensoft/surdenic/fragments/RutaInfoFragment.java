package com.clov3rlabs.jensoft.surdenic.fragments;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.activities.MainActivity;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Cobro;
import com.clov3rlabs.jensoft.surdenic.models.CobroNoExitoso;
import com.clov3rlabs.jensoft.surdenic.models.Configuracion;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.models.Pedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.models.Ruta;
import com.clov3rlabs.jensoft.surdenic.models.TasaCambio;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosa;
import com.clov3rlabs.jensoft.surdenic.repo.ActualizarCartelera;
import com.clov3rlabs.jensoft.surdenic.repo.BarrioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CanalDistribucionRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ClienteRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CobroNoExitosoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CobroRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ConfiguracionRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CuentaBancoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.DepartamentoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento0Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento1Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento2Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento3Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento4Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento5Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento6Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento7Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento8Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento9Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento10Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento11Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento12Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento13Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento14Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento15Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento16Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento18Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento19Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento20Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento21Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento22Repo;
import com.clov3rlabs.jensoft.surdenic.repo.DetallePedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.FacturaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.FuerzaVentaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.MaestroPrecioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.MunicipioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.PedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ProductoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.RutaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.RutaTrabajoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.TasaCambioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.TipoPagoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.VisitaNoExitosaRepo;
import com.clov3rlabs.jensoft.surdenic.rest.ApiClient;
import com.clov3rlabs.jensoft.surdenic.rest.ApiInterface;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RutaInfoFragment extends Fragment {

    private UsuarioRepo usuarioRepo = new UsuarioRepo(getContext());
    private Usuario usuario;

    private RutaRepo rutaRepo = new RutaRepo(getContext());
    private Ruta ruta;
    private String currentDateandTime;

    private ConfiguracionRepo configuracionRepo = new ConfiguracionRepo(getContext());
    private Configuracion configuracion;

    private FacturaRepo facturaRepo = new FacturaRepo(getContext());
    private ClienteRepo clienteRepo = new ClienteRepo(getContext());
    private VisitaNoExitosaRepo visitaNoExitosaRepo = new VisitaNoExitosaRepo(getContext());
    private CobroNoExitosoRepo cobroNoExitosoRepo = new CobroNoExitosoRepo(getContext());
    private CobroRepo cobroRepo =  new CobroRepo(getContext());
    private PedidoRepo pedidoRepo = new PedidoRepo(getContext());
    private TasaCambio tasaCambio;
    private TasaCambioRepo tasaCambioRepo = new TasaCambioRepo(getContext());

    private List<Cliente> clienteLista;
    private List<Factura> facturaLista;
    private List<VisitaNoExitosa> visitaNoExitosaList;
    private List<CobroNoExitoso> cobroNoExitosoList;
    private List<Cobro> cobroList;
    private List<Pedido> pedidoList;
    private double tc;

    private List<VisitaNoExitosa> visitaNoExitosaListSinc;
    private List<CobroNoExitoso> cobroNoExitosoListSinc;
    private List<Cobro> cobroListSinc;
    private List<Pedido> pedidoListSinc;

    @BindView(R.id.usuario_nombre) TextView usuario_nombre;
    @BindView(R.id.usuario_codigo) TextView usuario_codigo;
    @BindView(R.id.usuario_ruta) TextView usuario_ruta;

    @BindView(R.id.title_ruta_actual_info) TextView title_ruta_actual_info;

    @BindView(R.id.fecha_hora_inicio_ruta) TextView fecha_hora_inicio_ruta;
    @BindView(R.id.cantidad_clientes) TextView cantidad_clientes;
    @BindView(R.id.cantidad_facturas) TextView cantidad_facturas;
    @BindView(R.id.periodo_trabajo) TextView periodo_trabajo;
    @BindView(R.id.tasa_cambio) TextView tasa_cambio;
    @BindView(R.id.retencion_ir) TextView retencion_ir;
    @BindView(R.id.retencion_imi) TextView retencion_imi;

    @BindView(R.id.title_ruta_datos_ingresado) TextView title_ruta_datos_ingresado;

    @BindView(R.id.visitas_no_exitosas) TextView visitas_no_exitosas;
    @BindView(R.id.visitas_no_exitosas_sincronizadas) TextView visitas_no_exitosas_sincronizadas;
    @BindView(R.id.cobros_no_exitosos) TextView cobros_no_exitosos;
    @BindView(R.id.cobros_no_exitosos_sincronizados) TextView cobros_no_exitosos_sincronizados;
    @BindView(R.id.cobros_exitosos) TextView cobros_exitosos;
    @BindView(R.id.cobros_exitosos_sincronizados) TextView cobros_exitosos_sincronizados;

    @BindView(R.id.pedidos) TextView pedidos;
    @BindView(R.id.pedidos_sincronizados) TextView pedidos_sicronizados;

    @BindView(R.id.btn_finalizar_ruta) Button btn_finalizar_ruta;

    public RutaInfoFragment() {
        // Required empty public constructor
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

        ((MainActivity)getActivity()).setToolbarTitle(getString(R.string.nav_info_ruta));
        View view = inflater.inflate(R.layout.fragment_ruta_info, container, false);
        ButterKnife.bind(this, view);

        int id_vendedor = getArguments().getInt("id_vendedor");
        usuario = (Usuario) usuarioRepo.findById(id_vendedor);
        configuracion = (Configuracion) configuracionRepo.findByIdVendedor(usuario.getId_vendedor()); // add usuario
        ruta =  rutaRepo.getRutaActiva(id_vendedor);
        clienteLista = clienteRepo.findByIdVendedor(usuario.getId_vendedor(),"");
        facturaLista =  facturaRepo.findByIdVendedor(usuario.getId_vendedor());
        visitaNoExitosaList = visitaNoExitosaRepo.findByIdVendedor(usuario.getId_vendedor());
        cobroNoExitosoList = cobroNoExitosoRepo.findByIdVendedor(usuario.getId_vendedor());
        cobroList = cobroRepo.findByIdVendedor(usuario.getId_vendedor());
        pedidoList = pedidoRepo.getPedidosByIdVendedor(usuario.getId_vendedor());



        visitaNoExitosaListSinc = visitaNoExitosaRepo.getSentByIdVendedor(usuario.getId_vendedor());
        cobroNoExitosoListSinc = cobroNoExitosoRepo.getSentByIdVendedor(usuario.getId_vendedor());
        cobroListSinc = cobroRepo.getSentByIdVendedor(usuario.getId_vendedor());
        pedidoListSinc = pedidoRepo.getSentByIdVendedor(usuario.getId_vendedor());

        usuario_nombre.setText(usuario.getContacto_vendedor());
        usuario_codigo.setText("Código: " + String.valueOf(usuario.getId_vendedor()));
        usuario_ruta.setText("Ruta " + String.valueOf(usuario.getRuta_trabajo()));

        title_ruta_actual_info.setPaintFlags(title_ruta_actual_info.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);



        SimpleDateFormat formatOut = new SimpleDateFormat("dd-MM-yyyy hh:mm a");

        String newDate = formatOut.format(ruta.getFecha_hora_inicio());

        fecha_hora_inicio_ruta.setText(newDate);


        if (clienteLista != null)
            cantidad_clientes.setText(String.valueOf(clienteLista.size()));
        else
            cantidad_clientes.setText("0");

        if (facturaLista != null)
            cantidad_facturas.setText(String.valueOf(facturaLista.size()));
        else
            cantidad_facturas.setText("0");


        periodo_trabajo.setText(configuracion.getPeriodo_trabajo());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        currentDateandTime = sdf.format(new Date());

        tasaCambio = tasaCambioRepo.getBydate(currentDateandTime);
        if (tasaCambio!= null){
            tc = tasaCambio.getTasa_cambio_dia();
        }else{
            tc = configuracion.getTasa_cambio();
        }
        tasa_cambio.setText(String.valueOf(tc));


        retencion_ir.setText(String.valueOf(configuracion.getRet_ir()));
        retencion_imi.setText(String.valueOf(configuracion.getRet_imi()));

        title_ruta_datos_ingresado.setPaintFlags(title_ruta_datos_ingresado.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        if (visitaNoExitosaList != null)
            visitas_no_exitosas.setText(String.valueOf(visitaNoExitosaList.size()));
        else
            visitas_no_exitosas.setText("0");

        if (cobroNoExitosoList != null)
            cobros_no_exitosos.setText(String.valueOf(cobroNoExitosoList.size()));
        else
            cobros_no_exitosos.setText("0");


        if (cobroList != null)
            cobros_exitosos.setText(String.valueOf(cobroList.size()));
        else
            cobros_exitosos.setText("0");

        if (pedidoList != null)
            pedidos.setText(String.valueOf(pedidoList.size()));
        else
            pedidos.setText("0");

        if (visitaNoExitosaListSinc != null)
            visitas_no_exitosas_sincronizadas.setText(String.valueOf(visitaNoExitosaListSinc.size()));
        else
            visitas_no_exitosas_sincronizadas.setText("0");

        if (cobroNoExitosoListSinc != null)
            cobros_no_exitosos_sincronizados.setText(String.valueOf(cobroNoExitosoListSinc.size()));
        else
            cobros_no_exitosos_sincronizados.setText("0");

        if (cobroListSinc != null)
            cobros_exitosos_sincronizados.setText(String.valueOf(cobroListSinc.size()));
        else
            cobros_exitosos_sincronizados.setText("0");


        if (pedidoListSinc != null)
            pedidos_sicronizados.setText(String.valueOf(pedidoListSinc.size()));
        else
            pedidos_sicronizados.setText("0");

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        //menu.add(0, 1, menu.NONE, getString(R.string.sub_menu_descargar_inventario));
        menu.add(0, 2, menu.NONE, getString(R.string.sub_menu_descargar_cartelera));
        /*
        inflater.inflate(R.menu.fragment_main, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
       */

    }

    @OnClick(R.id.btn_finalizar_ruta)
    void finalizarRuta(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dialogo_finalizar_ruta));
        alertDialogBuilder.setIcon(R.drawable.ic_ask);
        alertDialogBuilder.setMessage(getResources().getString(R.string.messages_finalizar_ruta));


        alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                eliminarRuta();


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

    private void eliminarRuta(){

        final ProgressDialog barProgressDialog;

        barProgressDialog = new ProgressDialog(getContext());
        barProgressDialog.setTitle(R.string.progress_diaog_title_eliminar_ruta);
        barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message_borrado));
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
        barProgressDialog.setProgress(0);
        barProgressDialog.setCancelable(false);
        barProgressDialog.show();

        RutaRepo rutaRepo = new RutaRepo(getContext());
        rutaRepo.deleteByIdVendedor(usuario.getId_vendedor());

        ClienteRepo clienteRepo = new ClienteRepo(getContext());
        clienteRepo.deleteByIdVendedor(usuario.getId_vendedor());

        FacturaRepo facturaRepo = new FacturaRepo(getContext());
        facturaRepo.deleteByIdVendedor(usuario.getId_vendedor());

        VisitaNoExitosaRepo visitaNoExitosaRepo = new VisitaNoExitosaRepo(getContext());
        visitaNoExitosaRepo.deleteByIdVendedor(usuario.getId_vendedor());

        CobroNoExitosoRepo cobroNoExitosoRepo = new CobroNoExitosoRepo(getContext());
        cobroNoExitosoRepo.deleteByIdVendedor(usuario.getId_vendedor());

        CobroRepo cobroRepo = new CobroRepo(getContext());
        cobroRepo.deleteByIdVendedor(usuario.getId_vendedor());


        PedidoRepo pedidoRepo = new PedidoRepo(getContext());
        DetallePedidoRepo detallePedidoRepo = new DetallePedidoRepo(getContext());
        List<Pedido> pedidos = pedidoRepo.getPedidosByIdVendedor(usuario.getId_vendedor());

        for (Pedido p : pedidos) {
            detallePedidoRepo.deleteByIdPedido(p.getId_pedido());
        }

        pedidoRepo.deleteByIdVendedor(usuario.getId_vendedor());

        ConfiguracionRepo configuracionRepo = new ConfiguracionRepo(getContext());
        configuracionRepo.deleteByIdVendedor(usuario.getId_vendedor());

        barProgressDialog.setProgress(30);


        // Catalogos
        BarrioRepo barrioRepo = new BarrioRepo(getContext());
        barrioRepo.deleteAll();

        CanalDistribucionRepo canalDistribucionRepo = new CanalDistribucionRepo(getContext());
        canalDistribucionRepo.deleteAll();

        CuentaBancoRepo cuentaBancoRepo = new CuentaBancoRepo(getContext());
        cuentaBancoRepo.deleteAll();

        DepartamentoRepo departamentoRepo = new DepartamentoRepo(getContext());
        departamentoRepo.deleteAll();

        FuerzaVentaRepo fuerzaVentaRepo = new FuerzaVentaRepo(getContext());
        fuerzaVentaRepo.deleteAll();

        MaestroPrecioRepo maestroPrecioRepo = new MaestroPrecioRepo(getContext());
        maestroPrecioRepo.deleteAll();

        MunicipioRepo municipioRepo = new MunicipioRepo(getContext());
        municipioRepo.deleteAll();

        ProductoRepo productoRepo = new ProductoRepo(getContext());
        productoRepo.deleteAll();

        RutaTrabajoRepo rutaTrabajoRepo = new RutaTrabajoRepo(getContext());
        rutaTrabajoRepo.deleteAll();

        TipoPagoRepo tipoPagoRepo = new TipoPagoRepo(getContext());
        tipoPagoRepo.deleteAll();

        barProgressDialog.setProgress(60);

        // Descuentos

        Descuento0Repo descuento0Repo = new Descuento0Repo(getContext());
        descuento0Repo.deleteAll();

        Descuento1Repo descuento1Repo = new Descuento1Repo(getContext());
        descuento1Repo.deleteAll();

        Descuento2Repo descuento2Repo = new Descuento2Repo(getContext());
        descuento2Repo.deleteAll();

        Descuento3Repo descuento3Repo = new Descuento3Repo(getContext());
        descuento3Repo.deleteAll();

        Descuento4Repo descuento4Repo = new Descuento4Repo(getContext());
        descuento4Repo.deleteAll();

        Descuento5Repo descuento5Repo = new Descuento5Repo(getContext());
        descuento5Repo.deleteAll();

        Descuento6Repo descuento6Repo = new Descuento6Repo(getContext());
        descuento6Repo.deleteAll();

        Descuento7Repo descuento7Repo = new Descuento7Repo(getContext());
        descuento7Repo.deleteAll();

        Descuento8Repo descuento8Repo = new Descuento8Repo(getContext());
        descuento8Repo.deleteAll();

        Descuento9Repo descuento9Repo = new Descuento9Repo(getContext());
        descuento9Repo.deleteAll();

        Descuento10Repo descuento10Repo = new Descuento10Repo(getContext());
        descuento10Repo.deleteAll();

        Descuento11Repo descuento11Repo = new Descuento11Repo(getContext());
        descuento11Repo.deleteAll();

        Descuento12Repo descuento12Repo = new Descuento12Repo(getContext());
        descuento12Repo.deleteAll();

        Descuento13Repo descuento13Repo = new Descuento13Repo(getContext());
        descuento13Repo.deleteAll();

        Descuento14Repo descuento14Repo = new Descuento14Repo(getContext());
        descuento14Repo.deleteAll();

        Descuento15Repo descuento15Repo = new Descuento15Repo(getContext());
        descuento15Repo.deleteAll();

        Descuento16Repo descuento16Repo = new Descuento16Repo(getContext());
        descuento16Repo.deleteAll();

        Descuento18Repo descuento18Repo = new Descuento18Repo(getContext());
        descuento18Repo.deleteAll();

        Descuento19Repo descuento19Repo = new Descuento19Repo(getContext());
        descuento19Repo.deleteAll();

        Descuento20Repo descuento20Repo = new Descuento20Repo(getContext());
        descuento20Repo.deleteAll();

        Descuento21Repo descuento21Repo = new Descuento21Repo(getContext());
        descuento21Repo.deleteAll();

        Descuento22Repo descuento22Repo = new Descuento22Repo(getContext());
        descuento22Repo.deleteAll();

        barProgressDialog.setProgress(100);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                barProgressDialog.dismiss();
                btn_finalizar_ruta.setEnabled(false);

                Toast toast = Toast.makeText(getContext(), R.string.messages_borrado_ruta_completada, Toast.LENGTH_SHORT);
                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                if( v != null) v.setGravity(Gravity.CENTER);
                toast.show();

            }
        }, 3000); // 3000 milliseconds delay


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 2){
            // show dialog
            actualizarInventario();
            //actualizarCartelera();

        }/*else if(id == 2){

            actualizarCartelera();
        }*/
        return super.onOptionsItemSelected(item);
    }

    public void actualizarCartelera(){

        /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_actualizar_cartelera));
        alertDialogBuilder.setIcon(R.drawable.ic_ask);
        alertDialogBuilder.setMessage(getResources().getString(R.string.messages_actualizar_cartelera));


        alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {*/
                final ProgressDialog barProgressDialog;

                barProgressDialog = new ProgressDialog(getContext());
                barProgressDialog.setTitle(R.string.progress_diaog_title_actualiza_cartelera);
                barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message_download));
                barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
                barProgressDialog.setProgress(0);
                barProgressDialog.setCancelable(false);
                barProgressDialog.show();

                ActualizarCartelera actualizarCartelera = new ActualizarCartelera(getContext(),null ,null ,barProgressDialog ,null );
                actualizarCartelera.getDescuento0();
            /*}
        });

        alertDialogBuilder.setNegativeButton(R.string.messages_send_data_negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();*/

    }


    public void actualizarInventario(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_actualizar_inventario));
        alertDialogBuilder.setIcon(R.drawable.ic_ask);
        alertDialogBuilder.setMessage(getResources().getString(R.string.messages_actualizar_inventario));


        alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                final ProgressDialog barProgressDialog;

                barProgressDialog = new ProgressDialog(getContext());
                barProgressDialog.setTitle(R.string.progress_diaog_title_actualiza_inventario);
                barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message_download));
                barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
                barProgressDialog.setProgress(0);
                barProgressDialog.setCancelable(false);
                barProgressDialog.show();

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

                            barProgressDialog.dismiss();

                            Toast toast = Toast.makeText(getContext(), R.string.info_message_actualiza_inventario, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();


                            actualizarCartelera();


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



                    }

                    @Override
                    public void onFailure(Call<List<Producto>> call, Throwable t) {
                        Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                        barProgressDialog.cancel();
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

    }

}
