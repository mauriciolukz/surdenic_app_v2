package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento5;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento5Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento5Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento5 object = (Descuento5) item;
        try {
            index = helper.getDescuento5Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento5 descuento5 = null;
        try {
            descuento5 = helper.getDescuento5Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento5;
    }

    @Override
    public List<?> findAll(){

        List<Descuento5> items = null;

        try {
            items =  helper.getDescuento5Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento5, Integer> deleteBuilder = helper.getDescuento5Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento5, Integer> deleteBuilder = helper.getDescuento5Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento5 descuento5 = null;
        try {
            descuento5 = helper.getDescuento5Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento5;
    }

    public void update(Object item){
        Descuento5 object = (Descuento5) item;
        try{
            helper.getDescuento5Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento5(String id_proveedor,int id_cliente, List<DetallePedido> detallePedidoList){
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
    
        List<Descuento5> descuento5List = null;
        try{
            //buscar regla
            descuento5List = helper.getDescuento5Dao().queryBuilder()
                    .where().eq("id_proveedor", id_proveedor)
                    .and().eq("id_cliente", id_cliente)
                    .and().le("monto_desde", sum_subtotal_venta)
                    .and().ge("monto_hasta", sum_subtotal_venta)
                    .query();
            if (!descuento5List.isEmpty())
                return descuento5List.get(0).getDescuento_subtotal();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return  0.00;
    }

}

