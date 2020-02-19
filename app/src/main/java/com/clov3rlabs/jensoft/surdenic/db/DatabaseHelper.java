package com.clov3rlabs.jensoft.surdenic.db;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.clov3rlabs.jensoft.surdenic.models.Barrio;
import com.clov3rlabs.jensoft.surdenic.models.CanalDistribucion;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Cobro;
import com.clov3rlabs.jensoft.surdenic.models.CobroNoExitoso;
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
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.models.FuerzaVenta;
import com.clov3rlabs.jensoft.surdenic.models.MaestroPrecio;
import com.clov3rlabs.jensoft.surdenic.models.Municipio;
import com.clov3rlabs.jensoft.surdenic.models.Pedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.models.RazonCobroNoExitoso;
import com.clov3rlabs.jensoft.surdenic.models.RazonVisitaNoExitosa;
import com.clov3rlabs.jensoft.surdenic.models.Ruta;
import com.clov3rlabs.jensoft.surdenic.models.RutaTrabajo;
import com.clov3rlabs.jensoft.surdenic.models.TasaCambio;
import com.clov3rlabs.jensoft.surdenic.models.TipoPago;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosa;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import static android.content.ContentValues.TAG;

/**
 * Created by rsaavedra on 23/7/2018.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application
    private static final String DATABASE_NAME = "surdenic.sqlite";

    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the SimpleData table
    private Dao<Usuario, Integer> usuarioDao = null;
    private Dao<Ruta, Integer> rutaDao = null;
    private Dao<Cliente, Integer> clienteDao = null;
    private Dao<Factura, Integer> facturaDao = null;
    private Dao<CobroNoExitoso, Integer> cobroNoExitosoDao = null;
    private Dao<VisitaNoExitosa, Integer> visitaNoExitosaDao = null;
    private Dao<Configuracion, Integer> configuracionDao = null;
    private Dao<Departamento, Integer> departamentoDao = null;
    private Dao<Municipio, Integer> municipioDao = null;
    private Dao<CanalDistribucion, Integer> canalDistribucionDao = null;
    private Dao<RutaTrabajo, Integer> rutaTrabajoDao = null;
    private Dao<TipoPago, Integer> tipoPagoDao = null;
    private Dao<MaestroPrecio, Integer> maestroPrecioDao = null;
    private Dao<FuerzaVenta, Integer> fuerzaVentaDao = null;
    private Dao<RazonVisitaNoExitosa, Integer> razonVisitaNoExitosaDao = null;
    private Dao<RazonCobroNoExitoso, Integer> razonCobroNoExitosoDao = null;
    private Dao<Cobro, Integer> cobroDao = null;
    private Dao<Barrio, Integer> barrioDao = null;
    private Dao<CuentaBanco, Integer> cuentaBancoDao = null;
    private Dao<Producto, Integer> productoDao = null;
    private Dao<Pedido, Integer> pedidoDao = null;
    private Dao<DetallePedido, Integer> detallePedidoDao = null;
    private Dao<Descuento0, Integer> descuento0Dao = null;
    private Dao<Descuento1, Integer> descuento1Dao = null;
    private Dao<Descuento2, Integer> descuento2Dao = null;
    private Dao<Descuento3, Integer> descuento3Dao = null;
    private Dao<Descuento4, Integer> descuento4Dao = null;
    private Dao<Descuento5, Integer> descuento5Dao = null;
    private Dao<Descuento6, Integer> descuento6Dao = null;
    private Dao<Descuento7, Integer> descuento7Dao = null;
    private Dao<Descuento8, Integer> descuento8Dao = null;
    private Dao<Descuento9, Integer> descuento9Dao = null;
    private Dao<Descuento10, Integer> descuento10Dao = null;
    private Dao<Descuento11, Integer> descuento11Dao = null;
    private Dao<Descuento12, Integer> descuento12Dao = null;
    private Dao<Descuento13, Integer> descuento13Dao = null;
    private Dao<Descuento14, Integer> descuento14Dao = null;
    private Dao<Descuento15, Integer> descuento15Dao = null;
    private Dao<Descuento16, Integer> descuento16Dao = null;
    private Dao<Descuento18, Integer> descuento18Dao = null;
    private Dao<Descuento19, Integer> descuento19Dao = null;
    private Dao<Descuento20, Integer> descuento20Dao = null;
    private Dao<Descuento21, Integer> descuento21Dao = null;
    private Dao<Descuento22, Integer> descuento22Dao = null;
    private Dao<TasaCambio, Integer> tasaCambioDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource){
        try{
            Log.d(TAG, "Start onCreate Database");
            TableUtils.createTable(connectionSource, Usuario.class);
            TableUtils.createTable(connectionSource, Ruta.class);
            TableUtils.createTable(connectionSource, Cliente.class);
            TableUtils.createTable(connectionSource, Factura.class);
            TableUtils.createTable(connectionSource, CobroNoExitoso.class);
            TableUtils.createTable(connectionSource, VisitaNoExitosa.class);
            TableUtils.createTable(connectionSource, Configuracion.class);
            TableUtils.createTable(connectionSource, Departamento.class);
            TableUtils.createTable(connectionSource, Municipio.class);
            TableUtils.createTable(connectionSource, CanalDistribucion.class);
            TableUtils.createTable(connectionSource, RutaTrabajo.class);
            TableUtils.createTable(connectionSource, TipoPago.class);
            TableUtils.createTable(connectionSource, MaestroPrecio.class);
            TableUtils.createTable(connectionSource, FuerzaVenta.class);
            TableUtils.createTable(connectionSource, RazonVisitaNoExitosa.class);
            TableUtils.createTable(connectionSource, RazonCobroNoExitoso.class);
            TableUtils.createTable(connectionSource, Cobro.class);
            TableUtils.createTable(connectionSource, Barrio.class);
            TableUtils.createTable(connectionSource, CuentaBanco.class);
            TableUtils.createTable(connectionSource, Producto.class);
            TableUtils.createTable(connectionSource, Pedido.class);
            TableUtils.createTable(connectionSource, DetallePedido.class);
            TableUtils.createTable(connectionSource, Descuento0.class);
            TableUtils.createTable(connectionSource, Descuento1.class);
            TableUtils.createTable(connectionSource, Descuento2.class);
            TableUtils.createTable(connectionSource, Descuento3.class);
            TableUtils.createTable(connectionSource, Descuento4.class);
            TableUtils.createTable(connectionSource, Descuento5.class);
            TableUtils.createTable(connectionSource, Descuento6.class);
            TableUtils.createTable(connectionSource, Descuento7.class);
            TableUtils.createTable(connectionSource, Descuento8.class);
            TableUtils.createTable(connectionSource, Descuento9.class);
            TableUtils.createTable(connectionSource, Descuento10.class);
            TableUtils.createTable(connectionSource, Descuento11.class);
            TableUtils.createTable(connectionSource, Descuento12.class);
            TableUtils.createTable(connectionSource, Descuento13.class);
            TableUtils.createTable(connectionSource, Descuento14.class);
            TableUtils.createTable(connectionSource, Descuento15.class);
            TableUtils.createTable(connectionSource, Descuento16.class);
            TableUtils.createTable(connectionSource, Descuento18.class);
            TableUtils.createTable(connectionSource, Descuento19.class);
            TableUtils.createTable(connectionSource, Descuento20.class);
            TableUtils.createTable(connectionSource, Descuento21.class);
            TableUtils.createTable(connectionSource, Descuento22.class);
            TableUtils.createTable(connectionSource, TasaCambio.class);
        }catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,ConnectionSource connectionSource, int oldVersion, int newVersion){
        try{
            TableUtils.dropTable(connectionSource, Usuario.class, true);
            TableUtils.dropTable(connectionSource, Ruta.class, true);
            TableUtils.dropTable(connectionSource, Cliente.class, true);
            TableUtils.dropTable(connectionSource, Factura.class, true);
            TableUtils.dropTable(connectionSource, CobroNoExitoso.class, true);
            TableUtils.dropTable(connectionSource, VisitaNoExitosa.class, true);
            TableUtils.dropTable(connectionSource, Configuracion.class, true);
            TableUtils.dropTable(connectionSource, Departamento.class, true);
            TableUtils.dropTable(connectionSource, Municipio.class, true);
            TableUtils.dropTable(connectionSource, CanalDistribucion.class, true);
            TableUtils.dropTable(connectionSource, RutaTrabajo.class, true);
            TableUtils.dropTable(connectionSource, TipoPago.class, true);
            TableUtils.dropTable(connectionSource, MaestroPrecio.class, true);
            TableUtils.dropTable(connectionSource, FuerzaVenta.class, true);
            TableUtils.dropTable(connectionSource, RazonVisitaNoExitosa.class, true);
            TableUtils.dropTable(connectionSource, RazonCobroNoExitoso.class, true);
            TableUtils.dropTable(connectionSource, Cobro.class, true);
            TableUtils.dropTable(connectionSource, Barrio.class, true);
            TableUtils.dropTable(connectionSource, CuentaBanco.class, true);
            TableUtils.dropTable(connectionSource, Producto.class, true);
            TableUtils.dropTable(connectionSource, Pedido.class, true);
            TableUtils.dropTable(connectionSource, DetallePedido.class, true);
            TableUtils.dropTable(connectionSource, Descuento0.class, true);
            TableUtils.dropTable(connectionSource, Descuento1.class, true);
            TableUtils.dropTable(connectionSource, Descuento2.class, true);
            TableUtils.dropTable(connectionSource, Descuento3.class, true);
            TableUtils.dropTable(connectionSource, Descuento4.class, true);
            TableUtils.dropTable(connectionSource, Descuento5.class, true);
            TableUtils.dropTable(connectionSource, Descuento6.class, true);
            TableUtils.dropTable(connectionSource, Descuento7.class, true);
            TableUtils.dropTable(connectionSource, Descuento8.class, true);
            TableUtils.dropTable(connectionSource, Descuento9.class, true);
            TableUtils.dropTable(connectionSource, Descuento10.class, true);
            TableUtils.dropTable(connectionSource, Descuento11.class, true);
            TableUtils.dropTable(connectionSource, Descuento12.class, true);
            TableUtils.dropTable(connectionSource, Descuento13.class, true);
            TableUtils.dropTable(connectionSource, Descuento14.class, true);
            TableUtils.dropTable(connectionSource, Descuento15.class, true);
            TableUtils.dropTable(connectionSource, Descuento16.class, true);
            TableUtils.dropTable(connectionSource, Descuento18.class, true);
            TableUtils.dropTable(connectionSource, Descuento19.class, true);
            TableUtils.dropTable(connectionSource, Descuento20.class, true);
            TableUtils.dropTable(connectionSource, Descuento21.class, true);
            TableUtils.dropTable(connectionSource, Descuento22.class, true);
            TableUtils.dropTable(connectionSource, TasaCambio.class, true);
        }catch (SQLException e){
            Log.e(DatabaseHelper.class.getName(), "Can't drop database", e);
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        onCreate(db, connectionSource);

    }

    @Override
    public void close() {
        super.close();
    }

    public Dao<Usuario, Integer> getUsuarioDao(){
        if (null == usuarioDao){
            try{
                usuarioDao = getDao(Usuario.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return usuarioDao;
    }

    public Dao<Ruta, Integer> getRutaDao(){
        if (null == rutaDao){
            try{
                rutaDao = getDao(Ruta.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return rutaDao;
    }

    public Dao<Cliente, Integer> getClienteDao(){
        if (null == clienteDao){
            try{
                clienteDao = getDao(Cliente.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return clienteDao;
    }

    public Dao<Factura, Integer> getFacturaDao(){
        if (null == facturaDao){
            try{
                facturaDao = getDao(Factura.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return facturaDao;
    }

    public Dao<CobroNoExitoso, Integer> getCobroNoExitosoDao(){
        if (null == cobroNoExitosoDao){
            try{
                cobroNoExitosoDao = getDao(CobroNoExitoso.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return cobroNoExitosoDao;
    }

    public Dao<VisitaNoExitosa, Integer> getVisitaNoExitosaDao(){
        if (null == visitaNoExitosaDao){
            try{
                visitaNoExitosaDao = getDao(VisitaNoExitosa.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return visitaNoExitosaDao;
    }

    public Dao<Configuracion, Integer> getConfiguracionDao(){
        if (null == configuracionDao){
            try{
                configuracionDao = getDao(Configuracion.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return configuracionDao;
    }

    public Dao<Departamento, Integer> getDepartamentoDao(){
        if (null == departamentoDao){
            try{
                departamentoDao = getDao(Departamento.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return departamentoDao;
    }

    public Dao<Municipio, Integer> getMunicipioDao(){
        if (null == municipioDao){
            try{
                municipioDao = getDao(Municipio.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return municipioDao;
    }

    public Dao<CanalDistribucion, Integer> getCanalDistribucionDao(){
        if (null == canalDistribucionDao){
            try{
                canalDistribucionDao = getDao(CanalDistribucion.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return canalDistribucionDao;
    }

    public Dao<RutaTrabajo, Integer> getRutaTrabajoDao(){
        if (null == rutaTrabajoDao){
            try{
                rutaTrabajoDao = getDao(RutaTrabajo.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return rutaTrabajoDao;
    }

    public Dao<TipoPago, Integer> getTipoPagoDao(){
        if (null == tipoPagoDao){
            try{
                tipoPagoDao = getDao(TipoPago.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return tipoPagoDao;
    }

    public Dao<MaestroPrecio, Integer> getMaestroPrecioDao(){
        if (null == maestroPrecioDao){
            try{
                maestroPrecioDao = getDao(MaestroPrecio.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return maestroPrecioDao;
    }

    public Dao<FuerzaVenta, Integer> getFuerzaVentaDao(){
        if (null == fuerzaVentaDao){
            try{
                fuerzaVentaDao = getDao(FuerzaVenta.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return fuerzaVentaDao;
    }

    public Dao<RazonVisitaNoExitosa, Integer> getRazonVisitaNoExitosaDao(){
        if (null == razonVisitaNoExitosaDao){
            try{
                razonVisitaNoExitosaDao = getDao(RazonVisitaNoExitosa.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return razonVisitaNoExitosaDao;
    }


    public Dao<RazonCobroNoExitoso, Integer> getRazonCobroNoExitosoDao(){
        if (null == razonCobroNoExitosoDao){
            try{
                razonCobroNoExitosoDao = getDao(RazonCobroNoExitoso.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return razonCobroNoExitosoDao;
    }

    public Dao<Cobro, Integer> getCobroDao(){
        if (null == cobroDao){
            try{
                cobroDao = getDao(Cobro.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return cobroDao;
    }

    public Dao<Barrio, Integer> getBarrioDao(){
        if (null == barrioDao){
            try{
                barrioDao = getDao(Barrio.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return barrioDao;
    }

    public Dao<CuentaBanco, Integer> getCuentBancoDao(){
        if (null == cuentaBancoDao){
            try{
                cuentaBancoDao = getDao(CuentaBanco.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return cuentaBancoDao;
    }

    public Dao<Producto, Integer> getProductoDao(){
        if (null == productoDao){
            try{
                productoDao = getDao(Producto.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return productoDao;
    }

    public Dao<Pedido, Integer> getPedidoDao(){
        if (null == pedidoDao){
            try{
                pedidoDao = getDao(Pedido.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return pedidoDao;
    }

    public Dao<DetallePedido, Integer> getDetallePedidoDao(){
        if (null == detallePedidoDao){
            try{
                detallePedidoDao = getDao(DetallePedido.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return detallePedidoDao;
    }

    public Dao<Descuento0, Integer> getDescuento0Dao(){
        if (null == descuento0Dao){
            try{
                descuento0Dao = getDao(Descuento0.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento0Dao;
    }


    public Dao<Descuento1, Integer> getDescuento1Dao(){
        if (null == descuento1Dao){
            try{
                descuento1Dao = getDao(Descuento1.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento1Dao;
    }

    public Dao<Descuento2, Integer> getDescuento2Dao(){
        if (null == descuento2Dao){
            try{
                descuento2Dao = getDao(Descuento2.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento2Dao;
    }

    public Dao<Descuento3, Integer> getDescuento3Dao(){
        if (null == descuento3Dao){
            try{
                descuento3Dao = getDao(Descuento3.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento3Dao;
    }

    public Dao<Descuento4, Integer> getDescuento4Dao(){
        if (null == descuento4Dao){
            try{
                descuento4Dao = getDao(Descuento4.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento4Dao;
    }

    public Dao<Descuento5, Integer> getDescuento5Dao(){
        if (null == descuento5Dao){
            try{
                descuento5Dao = getDao(Descuento5.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento5Dao;
    }

    public Dao<Descuento6, Integer> getDescuento6Dao(){
        if (null == descuento6Dao){
            try{
                descuento6Dao = getDao(Descuento6.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento6Dao;
    }

    public Dao<Descuento7, Integer> getDescuento7Dao(){
        if (null == descuento7Dao){
            try{
                descuento7Dao = getDao(Descuento7.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento7Dao;
    }

    public Dao<Descuento8, Integer> getDescuento8Dao(){
        if (null == descuento8Dao){
            try{
                descuento8Dao = getDao(Descuento8.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento8Dao;
    }

    public Dao<Descuento9, Integer> getDescuento9Dao(){
        if (null == descuento9Dao){
            try{
                descuento9Dao = getDao(Descuento9.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento9Dao;
    }

    public Dao<Descuento10, Integer> getDescuento10Dao(){
        if (null == descuento10Dao){
            try{
                descuento10Dao = getDao(Descuento10.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento10Dao;
    }

    public Dao<Descuento11, Integer> getDescuento11Dao(){
        if (null == descuento11Dao){
            try{
                descuento11Dao = getDao(Descuento11.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento11Dao;
    }

    public Dao<Descuento12, Integer> getDescuento12Dao(){
        if (null == descuento12Dao){
            try{
                descuento12Dao = getDao(Descuento12.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento12Dao;
    }

    public Dao<Descuento13, Integer> getDescuento13Dao(){
        if (null == descuento13Dao){
            try{
                descuento13Dao = getDao(Descuento13.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento13Dao;
    }

    public Dao<Descuento14, Integer> getDescuento14Dao(){
        if (null == descuento14Dao){
            try{
                descuento14Dao = getDao(Descuento14.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento14Dao;
    }

    public Dao<Descuento15, Integer> getDescuento15Dao(){
        if (null == descuento15Dao){
            try{
                descuento15Dao = getDao(Descuento15.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento15Dao;
    }

    public Dao<Descuento16, Integer> getDescuento16Dao(){
        if (null == descuento16Dao){
            try{
                descuento16Dao = getDao(Descuento16.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento16Dao;
    }

    public Dao<Descuento18, Integer> getDescuento18Dao(){
        if (null == descuento18Dao){
            try{
                descuento18Dao = getDao(Descuento18.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento18Dao;
    }

    public Dao<Descuento19, Integer> getDescuento19Dao(){
        if (null == descuento19Dao){
            try{
                descuento19Dao = getDao(Descuento19.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento19Dao;
    }

    public Dao<Descuento20, Integer> getDescuento20Dao(){
        if (null == descuento20Dao){
            try{
                descuento20Dao = getDao(Descuento20.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento20Dao;
    }

    public Dao<Descuento21, Integer> getDescuento21Dao(){
        if (null == descuento21Dao){
            try{
                descuento21Dao = getDao(Descuento21.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento21Dao;
    }

    public Dao<Descuento22, Integer> getDescuento22Dao(){
        if (null == descuento22Dao){
            try{
                descuento22Dao = getDao(Descuento22.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return descuento22Dao;
    }

    public Dao<TasaCambio, Integer> getTasaCambioDao(){
        if (null == tasaCambioDao){
            try{
                tasaCambioDao = getDao(TasaCambio.class);
            }catch (java.sql.SQLException e){
                e.printStackTrace();
            }
        }
        return tasaCambioDao;
    }




}
