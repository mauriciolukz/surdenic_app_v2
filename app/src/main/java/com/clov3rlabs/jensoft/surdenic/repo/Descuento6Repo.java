package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento6;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */

public class Descuento6Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento6Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento6 object = (Descuento6) item;
        try {
            index = helper.getDescuento6Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento6 descuento6 = null;
        try {
            descuento6 = helper.getDescuento6Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento6;
    }

    @Override
    public List<?> findAll(){

        List<Descuento6> items = null;

        try {
            items =  helper.getDescuento6Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento6, Integer> deleteBuilder = helper.getDescuento6Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento6, Integer> deleteBuilder = helper.getDescuento6Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento6 descuento6 = null;
        try {
            descuento6 = helper.getDescuento6Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento6;
    }

    public void update(Object item){
        Descuento6 object = (Descuento6) item;
        try{
            helper.getDescuento6Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento6(String id_proveedor,int id_cliente, List<DetallePedido> detallePedidoList){
        /* Agrupar la lista de detalle a traves de proveedor y obtener sumatoria subtotalCantidad */
        Double sum_cantidad_venta = 0.0;
        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                String column_group = item.getId_proveedor();
                if (column_group.equalsIgnoreCase(id_proveedor))
                    sum_cantidad_venta += item.getCantidad_venta();
            }
        }
        /* fin agrupacion*/
    
        List<Descuento6> descuento6List = null;
        try{
            //buscar regla
            descuento6List = helper.getDescuento6Dao().queryBuilder()
                    .where().eq("id_proveedor", id_proveedor)
                    .and().eq("id_cliente", id_cliente)
                    .and().le("cantidad_desde", sum_cantidad_venta)
                    .and().ge("cantidad_hasta", sum_cantidad_venta)
                    .query();
            if (!descuento6List.isEmpty())
                return descuento6List.get(0).getDescuento_subtotal();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0.00;
    }

}
