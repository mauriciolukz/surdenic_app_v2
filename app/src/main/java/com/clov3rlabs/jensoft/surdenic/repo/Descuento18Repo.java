package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento18;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento18Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento18Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento18 object = (Descuento18) item;
        try {
            index = helper.getDescuento18Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento18 descuento18 = null;
        try {
            descuento18 = helper.getDescuento18Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento18;
    }

    @Override
    public List<?> findAll(){

        List<Descuento18> items = null;

        try {
            items =  helper.getDescuento18Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento18, Integer> deleteBuilder = helper.getDescuento18Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento18, Integer> deleteBuilder = helper.getDescuento18Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento18 descuento18 = null;
        try {
            descuento18 = helper.getDescuento18Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento18;
    }

    public void update(Object item){
        Descuento18 object = (Descuento18) item;
        try{
            helper.getDescuento18Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento18(String id_proveedor, Integer id_canal, List<DetallePedido> detallePedidoList){
        /* Agrupar la lista de detalle a traves de proveedor y obtener sumatoria subtotalVenta */
        Double sum_subtotal_venta = 0.0;
        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                String column_group = item.getId_proveedor();
                if (column_group.equalsIgnoreCase(id_proveedor))
                    //sum_subtotal_venta += item.getDescuento_total_venta();
                    sum_subtotal_venta += item.getSubtotal_venta();
            }
        }
        /* fin agrupacion*/
    
        List<Descuento18> descuento18List = null;
        try{
            //buscar regla
            descuento18List = helper.getDescuento18Dao().queryBuilder()
                    .where().eq("id_proveedor", id_proveedor)
                    .and().eq("id_canal", id_canal)
                    .and().le("monto_desde", sum_subtotal_venta)
                    .and().ge("monto_hasta", sum_subtotal_venta)
                    .query();
            if (!descuento18List.isEmpty())
                return descuento18List.get(0).getDescuento_subtotal();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    
        return 0.00;
    }

}
