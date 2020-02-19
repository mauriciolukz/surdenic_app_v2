package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento4;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento4Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento4Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento4 object = (Descuento4) item;
        try {
            index = helper.getDescuento4Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento4 descuento4 = null;
        try {
            descuento4 = helper.getDescuento4Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento4;
    }

    @Override
    public List<?> findAll(){

        List<Descuento4> items = null;

        try {
            items =  helper.getDescuento4Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento4, Integer> deleteBuilder = helper.getDescuento4Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento4, Integer> deleteBuilder = helper.getDescuento4Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento4 descuento4 = null;
        try {
            descuento4 = helper.getDescuento4Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento4;
    }

    public void update(Object item){
        Descuento4 object = (Descuento4) item;
        try{
            helper.getDescuento4Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento4(String id_familia, List<DetallePedido> detallePedidoList){
        /* Agrupar la lista de detalle a traves de familia y obtener sumatoria subtotalCantidad */
        Double sum_cantidad_venta = 0.0;
        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                String column_group = item.getId_familia();
                if (column_group.equalsIgnoreCase(id_familia))
                    sum_cantidad_venta += item.getCantidad_venta();
            }
        }
        /* fin agrupacion*/
        List<Descuento4> descuento4List = null;
        try{
            //buscar regla
            descuento4List = helper.getDescuento4Dao().queryBuilder()
                    .where().eq("id_familia", id_familia)
                    .and().le("cantidad_desde", sum_cantidad_venta)
                    .and().ge("cantidad_hasta", sum_cantidad_venta)
                    .query();
            if (!descuento4List.isEmpty())
                return descuento4List.get(0).getDescuento_promo();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0.00;
    }

}

