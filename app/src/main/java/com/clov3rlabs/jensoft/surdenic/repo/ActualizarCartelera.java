package com.clov3rlabs.jensoft.surdenic.repo;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.R;
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
import com.clov3rlabs.jensoft.surdenic.models.Ruta;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.rest.ApiClient;
import com.clov3rlabs.jensoft.surdenic.rest.ApiInterface;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActualizarCartelera {

    private Context mContext;

    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo;

    private List<Descuento0> descuento0List;
    private Descuento0Repo descuento0Repo;

    private List<Descuento1> descuento1List;
    private Descuento1Repo descuento1Repo;

    private List<Descuento2> descuento2List;
    private Descuento2Repo descuento2Repo;

    private List<Descuento3> descuento3List;
    private Descuento3Repo descuento3Repo;

    private List<Descuento4> descuento4List;
    private Descuento4Repo descuento4Repo;

    private List<Descuento5> descuento5List;
    private Descuento5Repo descuento5Repo;

    private List<Descuento6> descuento6List;
    private Descuento6Repo descuento6Repo;

    private List<Descuento7> descuento7List;
    private Descuento7Repo descuento7Repo;

    private List<Descuento8> descuento8List;
    private Descuento8Repo descuento8Repo;

    private List<Descuento9> descuento9List;
    private Descuento9Repo descuento9Repo;

    private List<Descuento10> descuento10List;
    private Descuento10Repo descuento10Repo;

    private List<Descuento11> descuento11List;
    private Descuento11Repo descuento11Repo;

    private List<Descuento12> descuento12List;
    private Descuento12Repo descuento12Repo;

    private List<Descuento13> descuento13List;
    private Descuento13Repo descuento13Repo;

    private List<Descuento14> descuento14List;
    private Descuento14Repo descuento14Repo;

    private List<Descuento15> descuento15List;
    private Descuento15Repo descuento15Repo;

    private List<Descuento16> descuento16List;
    private Descuento16Repo descuento16Repo;

    private List<Descuento18> descuento18List;
    private Descuento18Repo descuento18Repo;

    private List<Descuento19> descuento19List;
    private Descuento19Repo descuento19Repo;

    private List<Descuento20> descuento20List;
    private Descuento20Repo descuento20Repo;

    private List<Descuento21> descuento21List;
    private Descuento21Repo descuento21Repo;

    private List<Descuento22> descuento22List;
    private Descuento22Repo descuento22Repo;

    private RutaRepo rutaRepo;


    private ProgressBar progressBar_descuentos_app;
    private TextView txt_descuentos;
    private ProgressDialog barProgressDialog;
    private Button btn_iniciar_ruta;


    public ActualizarCartelera(Context mContext,ProgressBar p,TextView txt,ProgressDialog pd,Button b) {
        this.mContext = mContext;

        descuento0Repo = new Descuento0Repo(this.mContext);
        descuento1Repo = new Descuento1Repo(this.mContext);
        descuento2Repo = new Descuento2Repo(this.mContext);
        descuento3Repo = new Descuento3Repo(this.mContext);
        descuento4Repo = new Descuento4Repo(this.mContext);
        descuento5Repo = new Descuento5Repo(this.mContext);
        descuento6Repo = new Descuento6Repo(this.mContext);
        descuento7Repo = new Descuento7Repo(this.mContext);
        descuento8Repo = new Descuento8Repo(this.mContext);
        descuento9Repo = new Descuento9Repo(this.mContext);
        descuento10Repo = new Descuento10Repo(this.mContext);
        descuento11Repo = new Descuento11Repo(this.mContext);
        descuento12Repo = new Descuento12Repo(this.mContext);
        descuento13Repo = new Descuento13Repo(this.mContext);
        descuento14Repo = new Descuento14Repo(this.mContext);
        descuento15Repo = new Descuento15Repo(this.mContext);
        descuento16Repo = new Descuento16Repo(this.mContext);
        descuento18Repo = new Descuento18Repo(this.mContext);
        descuento19Repo = new Descuento19Repo(this.mContext);
        descuento20Repo = new Descuento20Repo(this.mContext);
        descuento21Repo = new Descuento21Repo(this.mContext);
        descuento22Repo = new Descuento22Repo(this.mContext);

        descuento0Repo.deleteAll();
        descuento1Repo.deleteAll();
        descuento2Repo.deleteAll();
        descuento3Repo.deleteAll();
        descuento4Repo.deleteAll();
        descuento5Repo.deleteAll();
        descuento6Repo.deleteAll();
        descuento7Repo.deleteAll();
        descuento8Repo.deleteAll();
        descuento9Repo.deleteAll();
        descuento10Repo.deleteAll();
        descuento11Repo.deleteAll();
        descuento12Repo.deleteAll();
        descuento13Repo.deleteAll();
        descuento14Repo.deleteAll();
        descuento15Repo.deleteAll();
        descuento16Repo.deleteAll();
        descuento18Repo.deleteAll();
        descuento19Repo.deleteAll();
        descuento20Repo.deleteAll();
        descuento21Repo.deleteAll();
        descuento22Repo.deleteAll();

        rutaRepo = new RutaRepo(this.mContext);
        usuarioRepo = new UsuarioRepo(this.mContext);
        usuario = (Usuario)usuarioRepo.findFirst();

        progressBar_descuentos_app = p;
        txt_descuentos = txt;
        barProgressDialog = pd;
        btn_iniciar_ruta = b;

    }

    public void getDescuento0(){

        if (progressBar_descuentos_app != null){
            progressBar_descuentos_app.setVisibility(View.VISIBLE);
            progressBar_descuentos_app.setProgress(1);
            txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (1%)");
        }

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(5);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (5%)");
                    }


                    getDescuento1();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento1(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(10);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (10%)");
                    }

                    getDescuento2();


                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento2(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(15);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (15%)");
                    }


                    getDescuento3();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento3(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(20);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (20%)");
                    }

                    getDescuento4();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento4(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(25);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (25%)");
                    }

                    getDescuento5();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento5(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(30);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (30%)");
                    }

                    getDescuento6();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento6(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(35);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (35%)");
                    }

                    getDescuento7();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento7(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(40);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (40%)");
                    }

                    getDescuento8();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento8(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(45);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (45%)");
                    }

                    getDescuento9();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento9(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(50);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (50%)");
                    }

                    getDescuento10();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento10(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(55);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (55%)");
                    }

                    getDescuento11();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento11(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(60);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (60%)");
                    }

                    getDescuento12();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento12(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(65);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (65%)");
                    }
                    getDescuento13();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento13(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(70);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (70%)");
                    }
                    getDescuento14();
                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento14(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(75);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (75%)");
                    }

                    getDescuento15();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento15(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(80);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (80%)");
                    }

                    getDescuento16();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento16(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(85);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (85%)");
                    }

                    getDescuento18();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento18(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(90);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (90%)");
                    }

                    getDescuento19();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento19(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(94);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (94%)");
                    }

                    getDescuento20();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento20(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(96);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (96%)");
                    }

                    getDescuento21();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }

    private void getDescuento21(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(98);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (98%)");
                    }

                    getDescuento22();

                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

            }


        });

    }


    private void getDescuento22(){

        ApiInterface apiService = ApiClient.getClient(mContext).create(ApiInterface.class);
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

                    if (progressBar_descuentos_app != null){
                        progressBar_descuentos_app.setProgress(100);
                        txt_descuentos.setText(mContext.getResources().getString(R.string.carga_descuentos) + " (100%)");
                        createRuta();
                    }else{
                        Toast toast = Toast.makeText(mContext, R.string.messages_descarga_ruta_completada, Toast.LENGTH_SHORT);
                        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                        if( v != null) v.setGravity(Gravity.CENTER);
                        toast.show();
                    }


                }else{
                    if (response.errorBody() != null) {
                        try{
                            Toast toast = Toast.makeText(mContext, R.string.error_descarga_productos, Toast.LENGTH_SHORT);
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
                Toast.makeText(mContext.getApplicationContext(), R.string.connection_failed, Toast.LENGTH_LONG).show();

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

        Toast toast = Toast.makeText(mContext, R.string.messages_descarga_ruta_completada, Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();



    }

}
