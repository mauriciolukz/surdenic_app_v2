package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento19;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento19Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento19Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento19 object = (Descuento19) item;
        try {
            index = helper.getDescuento19Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento19 descuento19 = null;
        try {
            descuento19 = helper.getDescuento19Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento19;
    }

    @Override
    public List<?> findAll(){

        List<Descuento19> items = null;

        try {
            items =  helper.getDescuento19Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento19, Integer> deleteBuilder = helper.getDescuento19Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento19, Integer> deleteBuilder = helper.getDescuento19Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento19 descuento19 = null;
        try {
            descuento19 = helper.getDescuento19Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento19;
    }

    public void update(Object item){
        Descuento19 object = (Descuento19) item;
        try{
            helper.getDescuento19Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento19(String id_producto, Integer id_canal, List<DetallePedido> detallePedidoList){
        /* Agrupar la lista de detalle a traves de producto y obtener sumatoria subtotalVenta */
        Double sum_cantidad_venta = 0.0;
        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                String column_group = item.getId_producto();
                if (column_group.equalsIgnoreCase(id_producto))
                    sum_cantidad_venta += item.getCantidad_venta();
            }
        }
        /* fin agrupacion*/
    
        List<Descuento19> descuento19List = null;
        try{
            //buscar regla
            descuento19List = helper.getDescuento19Dao().queryBuilder()
                    .where().eq("id_producto", id_producto)
                    .and().eq("id_canal", id_canal)
                    .and().le("cantidad_desde", sum_cantidad_venta)
                    .and().ge("cantidad_hasta", sum_cantidad_venta)
                    .query();
            if (!descuento19List.isEmpty())
                return descuento19List.get(0).getDescuento_subtotal();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0.00;
    }

}
