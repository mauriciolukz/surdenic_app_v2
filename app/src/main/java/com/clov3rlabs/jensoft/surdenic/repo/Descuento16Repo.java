package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento16;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento16Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento16Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento16 object = (Descuento16) item;
        try {
            index = helper.getDescuento16Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento16 descuento16 = null;
        try {
            descuento16 = helper.getDescuento16Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento16;
    }

    @Override
    public List<?> findAll(){

        List<Descuento16> items = null;

        try {
            items =  helper.getDescuento16Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento16, Integer> deleteBuilder = helper.getDescuento16Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento16, Integer> deleteBuilder = helper.getDescuento16Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento16 descuento16 = null;
        try {
            descuento16 = helper.getDescuento16Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento16;
    }

    public void update(Object item){
        Descuento16 object = (Descuento16) item;
        try{
            helper.getDescuento16Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento16(String id_proveedor, Integer id_ruta, List<DetallePedido> detallePedidoList){
        /* Agrupar la lista de detalle a traves de proveedor y obtener sumatoria subtotalVenta */
        Double sum_subtotal_venta = 0.0;
        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                String column_group = item.getId_proveedor();
                if (column_group.equalsIgnoreCase(id_proveedor))
                    sum_subtotal_venta += item.getSubtotal_venta();
            }
        }
        /* fin agrupacion*/
    
        List<Descuento16> descuento16List = null;
        try{
            //buscar regla
            descuento16List = helper.getDescuento16Dao().queryBuilder()
                    .where().eq("id_proveedor", id_proveedor)
                    .and().eq("id_ruta", id_ruta)
                    .and().le("monto_desde", sum_subtotal_venta)
                    .and().ge("monto_hasta", sum_subtotal_venta)
                    .query();
            if (!descuento16List.isEmpty())
                return descuento16List.get(0).getDescuento_subtotal();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0.00;
    }

}
