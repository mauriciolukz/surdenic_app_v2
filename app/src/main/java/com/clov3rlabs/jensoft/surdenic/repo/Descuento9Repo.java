package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento9;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class Descuento9Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento9Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento9 object = (Descuento9) item;
        try {
            index = helper.getDescuento9Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento9 descuento9 = null;
        try {
            descuento9 = helper.getDescuento9Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento9;
    }

    @Override
    public List<?> findAll(){

        List<Descuento9> items = null;

        try {
            items =  helper.getDescuento9Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento9, Integer> deleteBuilder = helper.getDescuento9Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento9, Integer> deleteBuilder = helper.getDescuento9Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento9 descuento9 = null;
        try {
            descuento9 = helper.getDescuento9Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento9;
    }

    public void update(Object item){
        Descuento9 object = (Descuento9) item;
        try{
            helper.getDescuento9Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento9(List<DetallePedido> detallePedidoList){
        /* obtener sumatoria subtotalVenta */
        Double sum_subtotal_venta = 0.0;
        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                sum_subtotal_venta += item.getSubtotal_venta();
            }
        }
        /* fin agrupacion*/
    
        List<Descuento9> descuento9List = null;
        try{
            //buscar regla
            descuento9List = helper.getDescuento9Dao().queryBuilder()
                    .where().le("monto_desde", sum_subtotal_venta)
                    .and().ge("monto_hasta", sum_subtotal_venta)
                    .query();
            if (!descuento9List.isEmpty())
                return descuento9List.get(0).getDescuento_subtotal();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0.00;
    }


}
