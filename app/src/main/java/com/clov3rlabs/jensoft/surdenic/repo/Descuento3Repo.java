package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;
import android.support.annotation.NonNull;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento3;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by rsaavedra on 10/12/2018.
 */

public class Descuento3Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento3Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento3 object = (Descuento3) item;
        try {
            index = helper.getDescuento3Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento3 descuento3 = null;
        try {
            descuento3 = helper.getDescuento3Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento3;
    }

    @Override
    public List<?> findAll(){

        List<Descuento3> items = null;

        try {
            items =  helper.getDescuento3Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento3, Integer> deleteBuilder = helper.getDescuento3Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento3, Integer> deleteBuilder = helper.getDescuento3Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento3 descuento3 = null;
        try {
            descuento3 = helper.getDescuento3Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento3;
    }

    public void update(Object item){
        Descuento3 object = (Descuento3) item;
        try{
            helper.getDescuento3Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    ///
    public double obtenerDescuento3( String id_familia, List<DetallePedido> detallePedidosList){
        /* Agrupar la lista de detalle a traves de familia y obtener sumatoria subtotalventa */
        Double sum_subtotal_venta = 0.0;
        if (!detallePedidosList.isEmpty()) {
            for (DetallePedido item : detallePedidosList) {
                String column_group = item.getId_familia();
                if (column_group.equalsIgnoreCase(id_familia))
                    sum_subtotal_venta += item.getSubtotal_venta();
            }
        }
        /* fin agrupacion*/
        List<Descuento3> descuento3List = null;
        try{
            //buscar regla
            descuento3List = helper.getDescuento3Dao().queryBuilder()
                    .where().eq("id_familia", id_familia)
                    .and().le("monto_desde", sum_subtotal_venta)
                    .and().ge("monto_hasta", sum_subtotal_venta)
                    .query();
            if (!descuento3List.isEmpty())
                return descuento3List.get(0).getDescuento_promo();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return  0.00;
    }

}
