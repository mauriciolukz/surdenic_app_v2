package com.clov3rlabs.jensoft.surdenic.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


import com.clov3rlabs.jensoft.surdenic.models.Barrio;
import com.clov3rlabs.jensoft.surdenic.models.CanalDistribucion;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Cobro;
import com.clov3rlabs.jensoft.surdenic.models.CobroNoExitosoRequest;
import com.clov3rlabs.jensoft.surdenic.models.CobroRequest;
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
import com.clov3rlabs.jensoft.surdenic.models.EnvioResponse;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.models.FuerzaVenta;
import com.clov3rlabs.jensoft.surdenic.models.MaestroPrecio;
import com.clov3rlabs.jensoft.surdenic.models.Municipio;
import com.clov3rlabs.jensoft.surdenic.models.PedidosRequest;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.models.RutaTrabajo;
import com.clov3rlabs.jensoft.surdenic.models.TasaCambio;
import com.clov3rlabs.jensoft.surdenic.models.TipoPago;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosa;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosaRequest;

import java.util.List;

/**
 * Created by rsaavedra on 23/7/2018.
 */

public interface ApiInterface {

    @GET("api/seguridad/login")
    Call<Usuario> Login(@Query("nom_user") String nom_user,
                             @Query("pass_user") String pass_user);

    @GET("api/clientes/por_vendedor/{id}")
    Call<List<Cliente>> Clientes(@Header("Authorization") String api_key,
                                  @Path("id") String id);

    @GET("api/facturas_pc_creditos/descargar_por_vendedor/{id}")
    Call<List<Factura>> Facturas(@Header("Authorization") String api_key,
                                 @Path("id") String id);

    // Catalogos

    @GET("api/catalogos/departamentos/{id}")
    Call<List<Departamento>> Departamentos(@Header("Authorization") String api_key,
                                            @Path("id") String id);

    @GET("api/catalogos/municipios/{id}")
    Call<List<Municipio>> Municipios(@Header("Authorization") String api_key,
                                     @Path("id") String id);

    @GET("api/catalogos/canales/{id}")
    Call<List<CanalDistribucion>> CanalesDistribucion(@Header("Authorization") String api_key,
                                                      @Path("id") String id);

    @GET("api/catalogos/fuerza_ventas/{id}")
    Call<List<FuerzaVenta>> FuerzaVentas(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/catalogos/rutas_de_trabajo/{id}")
    Call<List<RutaTrabajo>> RutasTrabajo(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/catalogos/tipos_pagos/{id}")
    Call<List<TipoPago>> TiposPagos(@Header("Authorization") String api_key,
                                    @Path("id") String id);

    @GET("api/catalogos/maestro_precios/{id}")
    Call<List<MaestroPrecio>> MaestroPrecios(@Header("Authorization") String api_key,
                                             @Path("id") String id);

    @GET("api/catalogos/barrios/{id}")
    Call<List<Barrio>> Barrios(@Header("Authorization") String api_key,
                                      @Path("id") String id);

    @GET("api/catalogos/bancos/{id}")
    Call<List<CuentaBanco>> CuentasBancos(@Header("Authorization") String api_key,
                                             @Path("id") String id);
    @GET("api/catalogos/productos/{id}")
    Call<List<Producto>> Productos(@Header("Authorization") String api_key,
                                   @Path("id") String id);

    // fin: Catalogos


    @GET("api/config/descargar/{id}")
    Call<Configuracion> DatosConfiguracion(@Header("Authorization") String api_key,
                                            @Path("id") String id);

    @GET("api/config/descargar/tasa_cambio/{id}")
    Call<List<TasaCambio>> ObtenerTasaCambio(@Header("Authorization") String api_key,
                                             @Path("id") String id);


    @POST("api/clientes/agregar_visita_no_exitosa/{id}")
    Call<EnvioResponse> EnviarVisitasNoExitosas(@Header("Authorization") String api_key, @Body List<VisitaNoExitosaRequest> visitasNoExitosas,
                                                @Path("id") String id);

    @POST("api/clientes/agregar_cobro_no_exitoso/{id}")
    Call<EnvioResponse> EnviarCobrosNoExitosos(@Header("Authorization") String api_key, @Body List<CobroNoExitosoRequest> cobrosNoExitosos,
                                               @Path("id") String id);

    @POST("api/facturas_pc_creditos/enviar_cobros/{id}")
    Call<EnvioResponse> EnviarCobros(@Header("Authorization") String api_key, @Body List<CobroRequest> cobrosExitosos,
                                     @Path("id") String id);

    @POST("api/pedidos/enviar_pedidos/{id}")
    Call<EnvioResponse> EnviarPedidos(@Header("Authorization") String api_key, @Body PedidosRequest pedidos,
                                      @Path("id") String id);

    // Descuentos

    @GET("api/cartelera/descuentos_des0/{id}")
    Call<List<Descuento0>> ObtenerDescuento0(@Header("Authorization") String api_key,
                                      @Path("id") String id);

    @GET("api/cartelera/descuentos_des1/{id}")
    Call<List<Descuento1>> ObtenerDescuento1(@Header("Authorization") String api_key,
                                @Path("id") String id);

    @GET("api/cartelera/descuentos_des2/{id}")
    Call<List<Descuento2>> ObtenerDescuento2(@Header("Authorization") String api_key,
                                       @Path("id") String id);

    @GET("api/cartelera/descuentos_des3/{id}")
    Call<List<Descuento3>> ObtenerDescuento3(@Header("Authorization") String api_key,
                                       @Path("id") String id);

    @GET("api/cartelera/descuentos_des4/{id}")
    Call<List<Descuento4>> ObtenerDescuento4(@Header("Authorization") String api_key,
                                       @Path("id") String id);

    @GET("api/cartelera/descuentos_des5/{id}")
    Call<List<Descuento5>> ObtenerDescuento5(@Header("Authorization") String api_key,
                                       @Path("id") String id);

    @GET("api/cartelera/descuentos_des6/{id}")
    Call<List<Descuento6>> ObtenerDescuento6(@Header("Authorization") String api_key,
                                       @Path("id") String id);

    @GET("api/cartelera/descuentos_des7/{id}")
    Call<List<Descuento7>> ObtenerDescuento7(@Header("Authorization") String api_key,
                                       @Path("id") String id);

    @GET("api/cartelera/descuentos_des8/{id}")
    Call<List<Descuento8>> ObtenerDescuento8(@Header("Authorization") String api_key,
                                       @Path("id") String id);

    @GET("api/cartelera/descuentos_des9/{id}")
    Call<List<Descuento9>> ObtenerDescuento9(@Header("Authorization") String api_key,
                                       @Path("id") String id);

    @GET("api/cartelera/descuentos_des10/{id}")
    Call<List<Descuento10>> ObtenerDescuento10(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des11/{id}")
    Call<List<Descuento11>> ObtenerDescuento11(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des12/{id}")
    Call<List<Descuento12>> ObtenerDescuento12(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des13/{id}")
    Call<List<Descuento13>> ObtenerDescuento13(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des14/{id}")
    Call<List<Descuento14>> ObtenerDescuento14(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des15/{id}")
    Call<List<Descuento15>> ObtenerDescuento15(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des16/{id}")
    Call<List<Descuento16>> ObtenerDescuento16(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des18/{id}")
    Call<List<Descuento18>> ObtenerDescuento18(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des19/{id}")
    Call<List<Descuento19>> ObtenerDescuento19(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des20/{id}")
    Call<List<Descuento20>> ObtenerDescuento20(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des21/{id}")
    Call<List<Descuento21>> ObtenerDescuento21(@Header("Authorization") String api_key,
                                         @Path("id") String id);

    @GET("api/cartelera/descuentos_des22/{id}")
    Call<List<Descuento22>> ObtenerDescuento22(@Header("Authorization") String api_key,
                                         @Path("id") String id);
    // fin: descuentos


}

