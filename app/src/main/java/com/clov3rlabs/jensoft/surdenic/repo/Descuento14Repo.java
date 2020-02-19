package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento14;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento14Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento14Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento14 object = (Descuento14) item;
        try {
            index = helper.getDescuento14Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento14 descuento14 = null;
        try {
            descuento14 = helper.getDescuento14Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento14;
    }

    @Override
    public List<?> findAll(){

        List<Descuento14> items = null;

        try {
            items =  helper.getDescuento14Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento14, Integer> deleteBuilder = helper.getDescuento14Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento14, Integer> deleteBuilder = helper.getDescuento14Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento14 descuento14 = null;
        try {
            descuento14 = helper.getDescuento14Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento14;
    }

    public void update(Object item){
        Descuento14 object = (Descuento14) item;
        try{
            helper.getDescuento14Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento14(String id_proveedor, List<DetallePedido> detallePedidoList,  DetallePedido itemSelected){
        String id_familia = null;
        try{
            List<Descuento14> buscarFamilia =  helper.getDescuento14Dao().queryBuilder().where().eq("id_proveedor", id_proveedor).query();
            
            if (!buscarFamilia.isEmpty()){
                id_familia = buscarFamilia.get(0).getId_familia();
    
                List<Descuento14> descuento14List = null;
                Double sum_subtotal_venta = 0.0;
                
                if (!detallePedidoList.isEmpty() && ( id_familia != null && !id_familia.isEmpty())){
                    for (DetallePedido item : detallePedidoList) {
                        if (item.getId_proveedor().equalsIgnoreCase(id_proveedor) && (!item.getId_familia().equalsIgnoreCase(id_familia)) ) // && (!item .getId_familia().equals("18"))) // exclude familia 18
                            sum_subtotal_venta += item.getSubtotal_venta();
//                        if (item.getDetalle_id_pedido().equals(idItem)){
//                            if (item.getId_proveedor().equalsIgnoreCase(id_proveedor) && (!item.getId_familia().equalsIgnoreCase(id_familia)) ) // && (!item .getId_familia().equals("18"))) // exclude familia 18
//                                sum_subtotal_venta += item.getSubtotal_venta();
//                        }

                    }

                    if (itemSelected.getId_proveedor().equalsIgnoreCase(id_proveedor) && (!itemSelected.getId_familia().equalsIgnoreCase(id_familia))){

                        if (sum_subtotal_venta > 0.00){
                            descuento14List = helper.getDescuento14Dao().queryBuilder()
                                    .where().eq("id_proveedor", id_proveedor)
                                    .and().le("monto_desde", sum_subtotal_venta)
                                    .and().ge("monto_hasta", sum_subtotal_venta)
                                    .query();

                            if (!descuento14List.isEmpty()){
                                return descuento14List.get(0).getDescuento_subtotal();
                            }
                        }
                    }


                }
            }

        }catch (SQLException ex1){
            ex1.printStackTrace();
        }
        
        return 0.00;
    }

}
