package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento8;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */

public class Descuento8Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento8Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento8 object = (Descuento8) item;
        try {
            index = helper.getDescuento8Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento8 descuento8 = null;
        try {
            descuento8 = helper.getDescuento8Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento8;
    }

    @Override
    public List<?> findAll(){

        List<Descuento8> items = null;

        try {
            items =  helper.getDescuento8Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento8, Integer> deleteBuilder = helper.getDescuento8Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento8, Integer> deleteBuilder = helper.getDescuento8Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento8 descuento8 = null;
        try {
            descuento8 = helper.getDescuento8Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento8;
    }

    public void update(Object item){
        Descuento8 object = (Descuento8) item;
        try{
            helper.getDescuento8Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento8(Integer id_cliente, List<DetallePedido> detallePedidoList){
        /* obtener sumatoria subtotalVenta */
        Double sum_subtotal_venta = 0.0;
        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                sum_subtotal_venta += item.getSubtotal_venta();
            }
        }
        /* fin agrupacion*/
    
        List<Descuento8> descuento8List = null;
        try{
            //buscar regla
            descuento8List = helper.getDescuento8Dao().queryBuilder()
                    .where().eq("id_cliente", id_cliente)
                    .and().le("monto_desde", sum_subtotal_venta)
                    .and().ge("monto_hasta", sum_subtotal_venta)
                    .query();
            if (!descuento8List.isEmpty())
                return descuento8List.get(0).getDescuento_subtotal();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0.00;
    }

}

