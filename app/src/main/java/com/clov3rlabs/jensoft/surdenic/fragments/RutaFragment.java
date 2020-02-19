package com.clov3rlabs.jensoft.surdenic.fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.activities.LoginActivity;
import com.clov3rlabs.jensoft.surdenic.activities.MainActivity;
import com.clov3rlabs.jensoft.surdenic.models.Barrio;
import com.clov3rlabs.jensoft.surdenic.models.CanalDistribucion;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Configuracion;
import com.clov3rlabs.jensoft.surdenic.models.CuentaBanco;
import com.clov3rlabs.jensoft.surdenic.models.Departamento;
import com.clov3rlabs.jensoft.surdenic.models.Descuento0;
import com.clov3rlabs.jensoft.surdenic.models.Descuento1;
import com.clov3rlabs.jensoft.surdenic.models.Descuento10;
import com.clov3rlabs.jensoft.surdenic.models.Descuento11;
import com.clov3rlabs.jensoft.surdenic.models.Descuento12;
import com.clov3rlabs.jensoft.surdenic.models.Descuento13;
import com.clov3rlabs.jensoft.surdenic.models.Descuento14;
import com.clov3rlabs.jensoft.surdenic.models.Descuento15;
import com.clov3rlabs.jensoft.surdenic.models.Descuento16;
import com.clov3rlabs.jensoft.surdenic.models.Descuento18;
import com.clov3rlabs.jensoft.surdenic.models.Descuento19;
import com.clov3rlabs.jensoft.surdenic.models.Descuento2;
import com.clov3rlabs.jensoft.surdenic.models.Descuento20;
import com.clov3rlabs.jensoft.surdenic.models.Descuento21;
import com.clov3rlabs.jensoft.surdenic.models.Descuento22;
import com.clov3rlabs.jensoft.surdenic.models.Descuento3;
import com.clov3rlabs.jensoft.surdenic.models.Descuento4;
import com.clov3rlabs.jensoft.surdenic.models.Descuento5;
import com.clov3rlabs.jensoft.surdenic.models.Descuento6;
import com.clov3rlabs.jensoft.surdenic.models.Descuento7;
import com.clov3rlabs.jensoft.surdenic.models.Descuento8;
import com.clov3rlabs.jensoft.surdenic.models.Descuento9;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.models.FuerzaVenta;
import com.clov3rlabs.jensoft.surdenic.models.MaestroPrecio;
import com.clov3rlabs.jensoft.surdenic.models.Municipio;
import com.clov3rlabs.jensoft.surdenic.models.RazonCobroNoExitoso;
import com.clov3rlabs.jensoft.surdenic.models.RazonVisitaNoExitosa;
import com.clov3rlabs.jensoft.surdenic.models.Ruta;
import com.clov3rlabs.jensoft.surdenic.models.RutaTrabajo;
import com.clov3rlabs.jensoft.surdenic.models.TasaCambio;
import com.clov3rlabs.jensoft.surdenic.models.TipoPago;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.repo.ActualizarCartelera;
import com.clov3rlabs.jensoft.surdenic.repo.BarrioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CanalDistribucionRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ClienteRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ConfiguracionRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CuentaBancoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.DepartamentoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento0Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento10Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento11Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento12Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento13Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento14Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento15Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento16Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento18Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento19Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento1Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento20Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento21Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento22Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento2Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento3Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento4Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento5Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento6Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento7Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento8Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento9Repo;
import com.clov3rlabs.jensoft.surdenic.repo.FacturaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.FuerzaVentaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.MaestroPrecioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.MunicipioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ProductoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.RazonCobroNoExitosoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.RazonVisitaNoExitosaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.RutaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.RutaTrabajoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.TasaCambioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.TipoPagoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;
import com.clov3rlabs.jensoft.surdenic.rest.ApiClient;
import com.clov3rlabs.jensoft.surdenic.rest.ApiInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.clov3rlabs.jensoft.surdenic.activities.MainActivity.CURRENT_TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class RutaFragment extends Fragment {

    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(getContext());

    private List<Cliente> clienteLista = new ArrayList<>();
    private ClienteRepo clienteRepo = new ClienteRepo(getContext());

    private List<Factura> facturaLista = new ArrayList<>();
    private FacturaRepo facturaRepo = new FacturaRepo(getContext());

    private DepartamentoRepo departamentoRepo = new DepartamentoRepo(getContext());
    private MunicipioRepo municipioRepo = new MunicipioRepo(getContext());
    private CanalDistribucionRepo canalDistribucionRepo = new CanalDistribucionRepo(getContext());
    private FuerzaVentaRepo fuerzaVentaRepo = new FuerzaVentaRepo(getContext());
    private RutaTrabajoRepo rutaTrabajoRepo = new RutaTrabajoRepo(getContext());
    private TipoPagoRepo tipoPagoRepo = new TipoPagoRepo(getContext());
    private MaestroPrecioRepo maestroPrecioRepo = new MaestroPrecioRepo(getContext());
    private BarrioRepo barrioRepo = new BarrioRepo(getContext());
    private CuentaBancoRepo cuentaBancoRepo = new CuentaBancoRepo(getContext());
    private ProductoRepo productoRepo = new ProductoRepo(getContext());

    private List<Descuento0> descuento0List;
    private Descuento0Repo descuento0Repo = new Descuento0Repo(getContext());

    private List<Descuento1> descuento1List;
    private Descuento1Repo descuento1Repo = new Descuento1Repo(getContext());

    private List<Descuento2> descuento2List;
    private Descuento2Repo descuento2Repo = new Descuento2Repo(getContext());

    private List<Descuento3> descuento3List;
    private Descuento3Repo descuento3Repo = new Descuento3Repo(getContext());

    private List<Descuento4> descuento4List;
    private Descuento4Repo descuento4Repo = new Descuento4Repo(getContext());

    private List<Descuento5> descuento5List;
    private Descuento5Repo descuento5Repo = new Descuento5Repo(getContext());

    private List<Descuento6> descuento6List;
    private Descuento6Repo descuento6Repo = new Descuento6Repo(getContext());

    private List<Descuento7> descuento7List;
    private Descuento7Repo descuento7Repo = new Descuento7Repo(getContext());

    private List<Descuento8> descuento8List;
    private Descuento8Repo descuento8Repo = new Descuento8Repo(getContext());

    private List<Descuento9> descuento9List;
    private Descuento9Repo descuento9Repo = new Descuento9Repo(getContext());

    private List<Descuento10> descuento10List;
    private Descuento10Repo descuento10Repo = new Descuento10Repo(getContext());

    private List<Descuento11> descuento11List;
    private Descuento11Repo descuento11Repo = new Descuento11Repo(getContext());

    private List<Descuento12> descuento12List;
    private Descuento12Repo descuento12Repo = new Descuento12Repo(getContext());

    private List<Descuento13> descuento13List;
    private Descuento13Repo descuento13Repo = new Descuento13Repo(getContext());

    private List<Descuento14> descuento14List;
    private Descuento14Repo descuento14Repo = new Descuento14Repo(getContext());

    private List<Descuento15> descuento15List;
    private Descuento15Repo descuento15Repo = new Descuento15Repo(getContext());

    private List<Descuento16> descuento16List;
    private Descuento16Repo descuento16Repo = new Descuento16Repo(getContext());

    private List<Descuento18> descuento18List;
    private Descuento18Repo descuento18Repo = new Descuento18Repo(getContext());

    private List<Descuento19> descuento19List;
    private Descuento19Repo descuento19Repo = new Descuento19Repo(getContext());

    private List<Descuento20> descuento20List;
    private Descuento20Repo descuento20Repo = new Descuento20Repo(getContext());

    private List<Descuento21> descuento21List;
    private Descuento21Repo descuento21Repo = new Descuento21Repo(getContext());

    private List<Descuento22> descuento22List;
    private Descuento22Repo descuento22Repo = new Descuento22Repo(getContext());

    private ConfiguracionRepo configuracionRepo = new ConfiguracionRepo(getContext());
    private RutaRepo rutaRepo = new RutaRepo(getContext());

    private List<TasaCambio> tasaCambioList;
    private TasaCambioRepo tasaCambioRepo = new TasaCambioRepo(getContext());

    @BindView(R.id.btn_iniciar_ruta) Button btn_iniciar_ruta;

    @BindView(R.id.txt_clientes) TextView txt_clientes;
    @BindView(R.id.txt_facturas) TextView txt_facturas;
    @BindView(R.id.txt_catalogos) TextView txt_catalogos;
    @BindView(R.id.txt_parametros) TextView txt_parametros;
    @BindView(R.id.txt_descuentos) TextView txt_descuentos;

    @BindView(R.id.progressBar_main) ProgressBar progressBar_main;
    @BindView(R.id.progressBar_clientes) ProgressBar progressBar_clientes;
    @BindView(R.id.progressBar_facturas) ProgressBar progressBar_facturas;
    @BindView(R.id.progressBar_catalogos) ProgressBar progressBar_catalogos;
    @BindView(R.id.progressBar_parametros_app) ProgressBar progressBar_parametros_app;
    @BindView(R.id.progressBar_descuentos_app) ProgressBar progressBar_descuentos_app;

    private ProgressDialog barProgressDialog;


    public RutaFragment() {
        // Required empty public constructor
        usuario = (Usuario)usuarioRepo.findFirst();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setToolbarTitle(getString(R.string.nav_inicio_ruta));

        View view = inflater.inflate(R.layout.fragment_ruta, container, false);
        ButterKnife.bind(this, view);

        progressBar_clientes.setMax(100);
        progressBar_facturas.setMax(100);
        progressBar_catalogos.setMax(100);
        progressBar_parametros_app.setMax(100);

        return view;

    }

    @OnClick(R.id.btn_iniciar_ruta)
    void iniciarRuta(){
        getDataFromAPI();
    }


    void getDataFromAPI(){
        //progressBar_main.setVisibility(View.VISIBLE);

        barProgressDialog = new ProgressDialog(getContext());
        barProgressDialog.setTitle(R.string.progress_diaog_title_descarga_ruta);
        barProgressDialog.setMessage(getResources().getString(R.string.progress_diaog_message_download));
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);
        barProgressDialog.setProgress(0);
        //barProgressDialog.setMax(visitaNoExitosaRequestList.size());
        barProgressDialog.setCancelable(false);
        barProgressDialog.show();

        getClientes();
    }

    private void getClientes(){
        progressBar_clientes.setVisibility(View.VISIBLE);

        progressBar_clientes.setProgress(10);
        txt_clientes.setText(getResources().getString(R.string.carga_clientes) + " (10%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<Cliente>> call = apiService.Clientes(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {

                progressBar_clientes.setProgress(40);
                txt_clientes.setText(getResources().getString(R.string.carga_clientes) + " (40%)");

                if (response.body()!= null){
                    clienteLista = response.body();
                    // clean data
                    clienteRepo.deleteAll();
                    for (Cliente c : clienteLista){
                        clienteRepo.create(c);
                    }

                    progressBar_clientes.setProgress(100);
                    txt_clientes.setText(getResources().getString(R.string.carga_clientes) + " (100%)");

                    getFacturas();


                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_clientes.setProgress(0);
                            txt_clientes.setText(getResources().getString(R.string.carga_clientes) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_clientes, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Clientes: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Clientes: ", ex.getMessage());
                        }

                    }
                }


            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();
            }


        });

    }

    private void getFacturas(){

        progressBar_facturas.setVisibility(View.VISIBLE);

        progressBar_facturas.setProgress(10);
        txt_facturas.setText(getResources().getString(R.string.carga_facturas) + " (10%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<Factura>> call = apiService.Facturas(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<Factura>>() {
            @Override
            public void onResponse(Call<List<Factura>> call, Response<List<Factura>> response) {

                progressBar_facturas.setProgress(40);
                txt_facturas.setText(getResources().getString(R.string.carga_facturas) + " (40%)");

                if (response.body()!= null){

                    facturaLista = response.body();
                    // clean data
                    facturaRepo.deleteAll();

                    for (Factura f : facturaLista){
                        facturaRepo.create(f);
                    }

                    progressBar_facturas.setProgress(100);
                    txt_facturas.setText(getResources().getString(R.string.carga_facturas) + " (100%)");
                    getCatalogos();


                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_facturas.setProgress(0);
                            txt_facturas.setText(getResources().getString(R.string.carga_facturas) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_facturas, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Facturas: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Facturas: ", ex.getMessage());
                        }

                    }
                }



            }

            @Override
            public void onFailure(Call<List<Factura>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();

            }


        });

    }

    private void getCatalogos(){
        progressBar_catalogos.setVisibility(View.VISIBLE);
        getDepartamentos();
    }

    private void getDepartamentos(){

        progressBar_catalogos.setProgress(5);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (5%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<Departamento>> call = apiService.Departamentos(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {

                progressBar_catalogos.setProgress(7);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (7%)");

                if (response.body()!= null){

                    List<Departamento> departamentoLista;
                    departamentoLista = response.body();
                    // clean data
                    departamentoRepo.deleteAll();

                    for (Departamento d : departamentoLista){
                        departamentoRepo.create(d);
                    }

                    progressBar_catalogos.setProgress(10);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (10%)");
                    getMunicipios();


                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_departamentos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Departamentos: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Departamentos: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();

            }


        });

    }

    private void getMunicipios(){

        progressBar_catalogos.setProgress(15);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (15%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<Municipio>> call = apiService.Municipios(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<Municipio>>() {
            @Override
            public void onResponse(Call<List<Municipio>> call, Response<List<Municipio>> response) {

                progressBar_catalogos.setProgress(17);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (17%)");

                if (response.body()!= null){

                    List<Municipio> municipioLista;
                    municipioLista = response.body();
                    // clean data
                    municipioRepo.deleteAll();

                    for (Municipio m : municipioLista){
                        municipioRepo.create(m);
                    }

                    progressBar_catalogos.setProgress(20);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (20%)");

                    getCanalaesDistribucion();


                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_municipios, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Municipios: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Municipios: ", ex.getMessage());
                        }

                    }
                }


            }

            @Override
            public void onFailure(Call<List<Municipio>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();

            }


        });

    }

    private void getCanalaesDistribucion(){

        progressBar_catalogos.setProgress(25);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (25%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<CanalDistribucion>> call = apiService.CanalesDistribucion(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<CanalDistribucion>>() {
            @Override
            public void onResponse(Call<List<CanalDistribucion>> call, Response<List<CanalDistribucion>> response) {
                progressBar_catalogos.setProgress(27);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (27%)");

                if (response.body()!= null){

                    List<CanalDistribucion> canalDistribucionLista;
                    canalDistribucionLista = response.body();
                    // clean data
                    canalDistribucionRepo.deleteAll();

                    for (CanalDistribucion cd : canalDistribucionLista){
                        canalDistribucionRepo.create(cd);
                    }

                    progressBar_catalogos.setProgress(30);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (30%)");

                    getFuerzasVenta();


                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_canales_distribucion, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Canales Distribucion: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Canales Distribucion: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<CanalDistribucion>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();
            }


        });

    }

    private void getFuerzasVenta(){

        progressBar_catalogos.setProgress(35);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (35%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<FuerzaVenta>> call = apiService.FuerzaVentas(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<FuerzaVenta>>() {
            @Override
            public void onResponse(Call<List<FuerzaVenta>> call, Response<List<FuerzaVenta>> response) {

                progressBar_catalogos.setProgress(37);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (37%)");

                if (response.body()!= null){


                    List<FuerzaVenta> fuerzaVentaLista;
                    fuerzaVentaLista = response.body();
                    // clean data
                    fuerzaVentaRepo.deleteAll();

                    for (FuerzaVenta fv : fuerzaVentaLista){
                        fuerzaVentaRepo.create(fv);
                    }

                    progressBar_catalogos.setProgress(40);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (40%)");

                    getRutaTrabajo();


                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_fuerza_venta, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Fuerza Venta: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Fuerza Venta: ", ex.getMessage());
                        }

                    }
                }


            }

            @Override
            public void onFailure(Call<List<FuerzaVenta>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();
            }


        });

    }

    private void getRutaTrabajo(){

        progressBar_catalogos.setProgress(45);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (45%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<RutaTrabajo>> call = apiService.RutasTrabajo(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<RutaTrabajo>>() {
            @Override
            public void onResponse(Call<List<RutaTrabajo>> call, Response<List<RutaTrabajo>> response) {

                progressBar_catalogos.setProgress(47);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (47%)");

                if (response.body()!= null){

                    List<RutaTrabajo> rutaTrabajoLista;
                    rutaTrabajoLista = response.body();
                    // clean data
                    rutaTrabajoRepo.deleteAll();

                    for (RutaTrabajo rt : rutaTrabajoLista){
                        rutaTrabajoRepo.create(rt);
                    }

                    progressBar_catalogos.setProgress(50);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (50%)");

                    getTiposPagos();

                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_rutas_trabajo, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Ruta Trabajo: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Ruta Trabajo: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<RutaTrabajo>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();

            }


        });

    }

    private void getTiposPagos(){

        progressBar_catalogos.setProgress(55);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (55%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<TipoPago>> call = apiService.TiposPagos(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<TipoPago>>() {
            @Override
            public void onResponse(Call<List<TipoPago>> call, Response<List<TipoPago>> response) {

                progressBar_catalogos.setProgress(57);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (57%)");

                if (response.body()!= null){

                    List<TipoPago> tipoPagoLista;
                    tipoPagoLista = response.body();
                    // clean data
                    tipoPagoRepo.deleteAll();

                    for (TipoPago tp : tipoPagoLista){
                        tipoPagoRepo.create(tp);
                    }

                    progressBar_catalogos.setProgress(60);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (60%)");


                    getMaestroPrecio();

                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_tipos_pago, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Tipos Pagos: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Tipos Pagos: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<TipoPago>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();

            }


        });

    }

    private void getMaestroPrecio(){

        progressBar_catalogos.setProgress(65);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (65%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<MaestroPrecio>> call = apiService.MaestroPrecios(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<MaestroPrecio>>() {
            @Override
            public void onResponse(Call<List<MaestroPrecio>> call, Response<List<MaestroPrecio>> response) {

                progressBar_catalogos.setProgress(67);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (67%)");

                if (response.body()!= null){

                    List<MaestroPrecio> maestroPrecioLista;
                    maestroPrecioLista = response.body();
                    // clean data
                    maestroPrecioRepo.deleteAll();

                    for (MaestroPrecio mp : maestroPrecioLista){
                        maestroPrecioRepo.create(mp);
                    }

                    progressBar_catalogos.setProgress(70);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (70%)");

                    getBarrios();

                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_maestro_precios, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Maestro Precio: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Maestro Precio: ", ex.getMessage());
                        }

                    }
                }



            }

            @Override
            public void onFailure(Call<List<MaestroPrecio>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();
            }


        });

    }

    private void getBarrios(){

        progressBar_catalogos.setProgress(75);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (75%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<Barrio>> call = apiService.Barrios(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<Barrio>>() {
            @Override
            public void onResponse(Call<List<Barrio>> call, Response<List<Barrio>> response) {

                progressBar_catalogos.setProgress(77);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (77%)");

                if (response.body()!= null){

                    List<Barrio> barrioList;
                    barrioList = response.body();
                    // clean data
                    barrioRepo.deleteAll();

                    for (Barrio b : barrioList){
                        barrioRepo.create(b);
                    }

                    progressBar_catalogos.setProgress(80);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (80%)");

                    getCuentasBanco();

                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_maestro_precios, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Barrios: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Barrios: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Barrio>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();

            }


        });


    }

    private void getCuentasBanco(){

        progressBar_catalogos.setProgress(83);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (83%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<CuentaBanco>> call = apiService.CuentasBancos(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<CuentaBanco>>() {
            @Override
            public void onResponse(Call<List<CuentaBanco>> call, Response<List<CuentaBanco>> response) {

                progressBar_catalogos.setProgress(86);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (86%)");

                if (response.body()!= null){

                    List<CuentaBanco> cuentaBancoList;
                    cuentaBancoList = response.body();
                    // clean data
                    cuentaBancoRepo.deleteAll();

                    for (CuentaBanco cb : cuentaBancoList){
                        cuentaBancoRepo.create(cb);
                    }

                    progressBar_catalogos.setProgress(89);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (89%)");

                    getProductos();

                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_maestro_precios, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Cuentas banco: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Cuentas banco: ", ex.getMessage());
                        }

                    }
                }



            }

            @Override
            public void onFailure(Call<List<CuentaBanco>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();
            }


        });

    }

    private void getProductos(){

        progressBar_catalogos.setProgress(90);
        txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (90%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<Producto>> call = apiService.Productos(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                progressBar_catalogos.setProgress(95);
                txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (95%)");

                if (response.body()!= null){

                    List<Producto> productoList;
                    productoList = response.body();
                    // clean data
                    productoRepo.deleteAll();

                    for (Producto p : productoList){
                        productoRepo.create(p);
                    }

                    progressBar_catalogos.setProgress(100);
                    txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (100%)");

                    getDatosConfiguracion();

                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_catalogos.setProgress(0);
                            txt_catalogos.setText(getResources().getString(R.string.carga_catalogos) + " (0%)");

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
                barProgressDialog.dismiss();
            }


        });
    }

    private void getDatosConfiguracion(){

        progressBar_parametros_app.setProgress(10);
        txt_parametros.setText(getResources().getString(R.string.carga_parametros) + " (10%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<Configuracion> call = apiService.DatosConfiguracion(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<Configuracion>() {
            @Override
            public void onResponse(Call<Configuracion> call, Response<Configuracion> response) {
                progressBar_parametros_app.setProgress(15);
                txt_parametros.setText(getResources().getString(R.string.carga_parametros) + " (15%)");

                if (response.body()!= null){

                    Configuracion configuracion = response.body();
                    configuracionRepo.deleteAll();

                    configuracion.setId_vendedor(usuario.getId_vendedor());
                    configuracionRepo.create(configuracion);

                    progressBar_parametros_app.setProgress(30);
                    txt_parametros.setText(getResources().getString(R.string.carga_parametros) + " (30%)");

                    getTasaCambio();

                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_parametros_app.setProgress(0);
                            txt_parametros.setText(getResources().getString(R.string.carga_parametros) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_parametros, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Parametros: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Parametros: ", ex.getMessage());
                        }

                    }
                }



            }

            @Override
            public void onFailure(Call<Configuracion> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();
                //progressBar_main.setVisibility(View.INVISIBLE);

            }


        });

    }


    private void getTasaCambio(){

        progressBar_parametros_app.setProgress(35);
        txt_parametros.setText(getResources().getString(R.string.carga_parametros) + " (35%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        Call<List<TasaCambio>> call = apiService.ObtenerTasaCambio(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));

        call.enqueue(new Callback<List<TasaCambio>>() {
            @Override
            public void onResponse(Call<List<TasaCambio>> call, Response<List<TasaCambio>> response) {
                progressBar_parametros_app.setProgress(70);
                txt_parametros.setText(getResources().getString(R.string.carga_parametros) + " (70%)");

                if (response.body()!= null){

                    tasaCambioList = response.body();

                    tasaCambioRepo.deleteAll();


                    for (TasaCambio tc: tasaCambioList) {
                        tasaCambioRepo.create(tc);
                    }

                    progressBar_parametros_app.setProgress(100);
                    txt_parametros.setText(getResources().getString(R.string.carga_parametros) + " (100%)");

                    // Se inicia descarga de promociones
                    //getDescuento0();
                    ActualizarCartelera actualizarCartelera = new ActualizarCartelera(getContext(),progressBar_descuentos_app ,txt_descuentos ,barProgressDialog ,btn_iniciar_ruta );
                    actualizarCartelera.getDescuento0();


                }else{
                    if (response.errorBody() != null) {
                        try{

                            progressBar_parametros_app.setProgress(0);
                            txt_parametros.setText(getResources().getString(R.string.carga_parametros) + " (0%)");

                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_parametros, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Tasa Cambio: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Tasa Cambio: ", ex.getMessage());
                        }

                    }
                }



            }

            @Override
            public void onFailure(Call<List<TasaCambio>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();
                barProgressDialog.dismiss();
                //progressBar_main.setVisibility(View.INVISIBLE);

            }


        });

    }


    private void getDescuento0(){

        progressBar_descuentos_app.setVisibility(View.VISIBLE);

        progressBar_descuentos_app.setProgress(1);
        txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (1%)");

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento0>> call = apiService.ObtenerDescuento0(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento0>>() {
            @Override
            public void onResponse(Call<List<Descuento0>> call, Response<List<Descuento0>> response) {

                if (response.body()!= null){

                    descuento0List = response.body();
                    // clean data
                    descuento0Repo.deleteAll();

                    for (Descuento0 d0 : descuento0List){
                        descuento0Repo.create(d0);
                    }

                    progressBar_descuentos_app.setProgress(5);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (5%)");

                    getDescuento1();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_0: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_0: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento0>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento1(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento1>> call = apiService.ObtenerDescuento1(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento1>>() {
            @Override
            public void onResponse(Call<List<Descuento1>> call, Response<List<Descuento1>> response) {

                if (response.body()!= null){

                    descuento1List = response.body();
                    // clean data
                    descuento1Repo.deleteAll();

                    for (Descuento1 d1 : descuento1List){
                        descuento1Repo.create(d1);
                    }

                    progressBar_descuentos_app.setProgress(10);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (10%)");

                    getDescuento2();


                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_1: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_1: ", ex.getMessage());
                        }

                    }
                }


            }

            @Override
            public void onFailure(Call<List<Descuento1>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento2(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento2>> call = apiService.ObtenerDescuento2(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento2>>() {
            @Override
            public void onResponse(Call<List<Descuento2>> call, Response<List<Descuento2>> response) {

                if (response.body()!= null){

                    descuento2List = response.body();
                    // clean data
                    descuento2Repo.deleteAll();

                    for (Descuento2 d2 : descuento2List){
                        descuento2Repo.create(d2);
                    }

                    progressBar_descuentos_app.setProgress(15);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (15%)");

                    getDescuento3();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_2: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_2: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento2>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento3(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento3>> call = apiService.ObtenerDescuento3(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento3>>() {
            @Override
            public void onResponse(Call<List<Descuento3>> call, Response<List<Descuento3>> response) {

                if (response.body()!= null){

                    descuento3List = response.body();
                    // clean data
                    descuento3Repo.deleteAll();

                    for (Descuento3 d3 : descuento3List){
                        descuento3Repo.create(d3);
                    }

                    progressBar_descuentos_app.setProgress(20);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (20%)");

                    getDescuento4();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_3: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_3: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento3>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento4(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento4>> call = apiService.ObtenerDescuento4(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento4>>() {
            @Override
            public void onResponse(Call<List<Descuento4>> call, Response<List<Descuento4>> response) {

                if (response.body()!= null){

                    descuento4List = response.body();
                    // clean data
                    descuento4Repo.deleteAll();

                    for (Descuento4 d4 : descuento4List){
                        descuento4Repo.create(d4);
                    }

                    progressBar_descuentos_app.setProgress(25);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (25%)");

                    getDescuento5();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_4: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_4: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento4>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento5(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento5>> call = apiService.ObtenerDescuento5(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento5>>() {
            @Override
            public void onResponse(Call<List<Descuento5>> call, Response<List<Descuento5>> response) {

                if (response.body()!= null){

                    descuento5List = response.body();
                    // clean data
                    descuento5Repo.deleteAll();

                    for (Descuento5 d5 : descuento5List){
                        descuento5Repo.create(d5);
                    }

                    progressBar_descuentos_app.setProgress(30);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (30%)");

                    getDescuento6();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_5: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_5: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento5>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento6(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento6>> call = apiService.ObtenerDescuento6(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento6>>() {
            @Override
            public void onResponse(Call<List<Descuento6>> call, Response<List<Descuento6>> response) {

                if (response.body()!= null){

                    descuento6List = response.body();
                    // clean data
                    descuento6Repo.deleteAll();

                    for (Descuento6 d6 : descuento6List){
                        descuento6Repo.create(d6);
                    }

                    progressBar_descuentos_app.setProgress(35);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (35%)");

                    getDescuento7();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_6: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_6: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento6>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento7(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento7>> call = apiService.ObtenerDescuento7(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento7>>() {
            @Override
            public void onResponse(Call<List<Descuento7>> call, Response<List<Descuento7>> response) {

                if (response.body()!= null){

                    descuento7List = response.body();
                    // clean data
                    descuento7Repo.deleteAll();

                    for (Descuento7 d7 : descuento7List){
                        descuento7Repo.create(d7);
                    }

                    progressBar_descuentos_app.setProgress(40);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (40%)");

                    getDescuento8();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_7: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_7: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento7>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento8(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento8>> call = apiService.ObtenerDescuento8(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento8>>() {
            @Override
            public void onResponse(Call<List<Descuento8>> call, Response<List<Descuento8>> response) {

                if (response.body()!= null){

                    descuento8List = response.body();
                    // clean data
                    descuento8Repo.deleteAll();

                    for (Descuento8 d8 : descuento8List){
                        descuento8Repo.create(d8);
                    }

                    progressBar_descuentos_app.setProgress(45);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (45%)");

                    getDescuento9();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_8: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_8: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento8>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento9(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento9>> call = apiService.ObtenerDescuento9(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento9>>() {
            @Override
            public void onResponse(Call<List<Descuento9>> call, Response<List<Descuento9>> response) {

                if (response.body()!= null){

                    descuento9List = response.body();
                    // clean data
                    descuento9Repo.deleteAll();

                    for (Descuento9 d9 : descuento9List){
                        descuento9Repo.create(d9);
                    }

                    progressBar_descuentos_app.setProgress(50);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (50%)");
                    getDescuento10();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_9: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_9: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento9>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento10(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento10>> call = apiService.ObtenerDescuento10(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento10>>() {
            @Override
            public void onResponse(Call<List<Descuento10>> call, Response<List<Descuento10>> response) {

                if (response.body()!= null){

                    descuento10List = response.body();
                    // clean data
                    descuento10Repo.deleteAll();

                    for (Descuento10 d10 : descuento10List){
                        descuento10Repo.create(d10);
                    }

                    progressBar_descuentos_app.setProgress(55);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (55%)");

                    getDescuento11();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_10: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_10: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento10>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento11(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento11>> call = apiService.ObtenerDescuento11(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento11>>() {
            @Override
            public void onResponse(Call<List<Descuento11>> call, Response<List<Descuento11>> response) {

                if (response.body()!= null){

                    descuento11List = response.body();
                    // clean data
                    descuento11Repo.deleteAll();

                    for (Descuento11 d11 : descuento11List){
                        descuento11Repo.create(d11);
                    }

                    progressBar_descuentos_app.setProgress(60);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (60%)");

                    getDescuento12();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_11: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_11: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento11>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento12(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento12>> call = apiService.ObtenerDescuento12(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento12>>() {
            @Override
            public void onResponse(Call<List<Descuento12>> call, Response<List<Descuento12>> response) {

                if (response.body()!= null){

                    descuento12List = response.body();
                    // clean data
                    descuento12Repo.deleteAll();

                    for (Descuento12 d12 : descuento12List){
                        descuento12Repo.create(d12);
                    }

                    progressBar_descuentos_app.setProgress(65);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (65%)");
                    getDescuento13();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_12: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_12: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento12>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento13(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento13>> call = apiService.ObtenerDescuento13(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento13>>() {
            @Override
            public void onResponse(Call<List<Descuento13>> call, Response<List<Descuento13>> response) {

                if (response.body()!= null){

                    descuento13List = response.body();
                    // clean data
                    descuento13Repo.deleteAll();

                    for (Descuento13 d13 : descuento13List){
                        descuento13Repo.create(d13);
                    }

                    progressBar_descuentos_app.setProgress(70);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (70%)");
                    getDescuento14();
                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_13: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_13: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento13>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento14(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento14>> call = apiService.ObtenerDescuento14(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento14>>() {
            @Override
            public void onResponse(Call<List<Descuento14>> call, Response<List<Descuento14>> response) {

                if (response.body()!= null){

                    descuento14List = response.body();
                    // clean data
                    descuento14Repo.deleteAll();

                    for (Descuento14 d14 : descuento14List){
                        descuento14Repo.create(d14);
                    }

                    progressBar_descuentos_app.setProgress(75);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (75%)");

                    getDescuento15();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_14: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_14: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento14>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento15(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento15>> call = apiService.ObtenerDescuento15(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento15>>() {
            @Override
            public void onResponse(Call<List<Descuento15>> call, Response<List<Descuento15>> response) {

                if (response.body()!= null){

                    descuento15List = response.body();
                    // clean data
                    descuento15Repo.deleteAll();

                    for (Descuento15 d15 : descuento15List){
                        descuento15Repo.create(d15);
                    }

                    progressBar_descuentos_app.setProgress(80);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (80%)");

                    getDescuento16();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_15: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_15: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento15>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento16(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento16>> call = apiService.ObtenerDescuento16(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento16>>() {
            @Override
            public void onResponse(Call<List<Descuento16>> call, Response<List<Descuento16>> response) {

                if (response.body()!= null){

                    descuento16List = response.body();
                    // clean data
                    descuento16Repo.deleteAll();

                    for (Descuento16 d16 : descuento16List){
                        descuento16Repo.create(d16);
                    }
                    progressBar_descuentos_app.setProgress(85);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (85%)");

                    getDescuento18();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_16: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_16: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento16>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento18(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento18>> call = apiService.ObtenerDescuento18(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento18>>() {
            @Override
            public void onResponse(Call<List<Descuento18>> call, Response<List<Descuento18>> response) {

                if (response.body()!= null){

                    descuento18List = response.body();
                    // clean data
                    descuento18Repo.deleteAll();

                    for (Descuento18 d18 : descuento18List){
                        descuento18Repo.create(d18);
                    }

                    progressBar_descuentos_app.setProgress(90);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (90%)");

                    getDescuento19();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_18: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_18: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento18>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento19(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento19>> call = apiService.ObtenerDescuento19(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento19>>() {
            @Override
            public void onResponse(Call<List<Descuento19>> call, Response<List<Descuento19>> response) {

                if (response.body()!= null){

                    descuento19List = response.body();
                    // clean data
                    descuento19Repo.deleteAll();

                    for (Descuento19 d19 : descuento19List){
                        descuento19Repo.create(d19);
                    }

                    progressBar_descuentos_app.setProgress(94);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (94%)");

                    getDescuento20();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_19: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_19: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento19>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento20(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento20>> call = apiService.ObtenerDescuento20(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento20>>() {
            @Override
            public void onResponse(Call<List<Descuento20>> call, Response<List<Descuento20>> response) {

                if (response.body()!= null){

                    descuento20List = response.body();
                    // clean data
                    descuento20Repo.deleteAll();

                    for (Descuento20 d20 : descuento20List){
                        descuento20Repo.create(d20);
                    }

                    progressBar_descuentos_app.setProgress(96);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (96%)");

                    getDescuento21();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_20: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_20: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento20>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento21(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento21>> call = apiService.ObtenerDescuento21(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento21>>() {
            @Override
            public void onResponse(Call<List<Descuento21>> call, Response<List<Descuento21>> response) {

                if (response.body()!= null){

                    descuento21List = response.body();
                    // clean data
                    descuento21Repo.deleteAll();

                    for (Descuento21 d21 : descuento21List){
                        descuento21Repo.create(d21);
                    }
                    progressBar_descuentos_app.setProgress(98);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (98%)");

                    getDescuento22();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_21: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_21: ", ex.getMessage());
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Descuento21>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento22(){

        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
        Call<List<Descuento22>> call = apiService.ObtenerDescuento22(usuario.getApi_key(), String.valueOf(usuario.getId_vendedor()));
        call.enqueue(new Callback<List<Descuento22>>() {
            @Override
            public void onResponse(Call<List<Descuento22>> call, Response<List<Descuento22>> response) {

                if (response.body()!= null){

                    descuento22List = response.body();
                    // clean data
                    descuento22Repo.deleteAll();

                    for (Descuento22 d22 : descuento22List){
                        descuento22Repo.create(d22);
                    }

                    progressBar_descuentos_app.setProgress(100);
                    txt_descuentos.setText(getResources().getString(R.string.carga_descuentos) + " (100%)");

                    createRuta();


                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(getContext(), R.string.error_descarga_productos, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();

                            Log.i("Descuento_22: ", response.errorBody().string());

                        }catch (IOException ex){

                            Log.i("Descuento_22: ", ex.getMessage());
                        }

                    }
                }

                barProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<Descuento22>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void createRuta(){

        Ruta ruta = new Ruta();
        ruta.setId_vendedor(usuario.getId_vendedor());
        ruta.setFecha_hora_inicio(new Date());
        ruta.setActive(true);
        rutaRepo.create(ruta);

        btn_iniciar_ruta.setEnabled(false);

        Toast toast = Toast.makeText(getContext(), R.string.messages_descarga_ruta_completada, Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();

    }




}
