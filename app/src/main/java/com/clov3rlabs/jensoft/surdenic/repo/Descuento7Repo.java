package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento7;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class Descuento7Repo implements ICrud {


    private DatabaseHelper helper;

    public Descuento7Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento7 object = (Descuento7) item;
        try {
            index = helper.getDescuento7Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento7 descuento1 = null;
        try {
            descuento1 = helper.getDescuento7Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento1;
    }

    @Override
    public List<?> findAll(){

        List<Descuento7> items = null;

        try {
            items =  helper.getDescuento7Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento7, Integer> deleteBuilder = helper.getDescuento7Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento7, Integer> deleteBuilder = helper.getDescuento7Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento7 descuento7 = null;
        try {
            descuento7 = helper.getDescuento7Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento7;
    }

    public void update(Object item){
        Descuento7 object = (Descuento7) item;
        try{
            helper.getDescuento7Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento7(String id_proveedor, List<DetallePedido> detallePedidoList){
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
    
        List<Descuento7> descuento7List = null;
        try{
            //buscar regla
            descuento7List = helper.getDescuento7Dao().queryBuilder()
                    .where().eq("id_proveedor", id_proveedor)
                    .and().le("monto_desde", sum_subtotal_venta)
                    .and().ge("monto_hasta", sum_subtotal_venta)
                    .query();
            if (!descuento7List.isEmpty())
                return descuento7List.get(0).getDescuento_subtotal();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0.00;
    }

}
