package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento11;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */

public class Descuento11Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento11Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento11 object = (Descuento11) item;
        try {
            index = helper.getDescuento11Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento11 descuento11 = null;
        try {
            descuento11 = helper.getDescuento11Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento11;
    }

    @Override
    public List<?> findAll(){

        List<Descuento11> items = null;

        try {
            items =  helper.getDescuento11Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento11, Integer> deleteBuilder = helper.getDescuento11Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento11, Integer> deleteBuilder = helper.getDescuento11Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento11 descuento11 = null;
        try {
            descuento11 = helper.getDescuento11Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento11;
    }

    public void update(Object item){
        Descuento11 object = (Descuento11) item;
        try{
            helper.getDescuento11Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento11(String code_promo_3, List<DetallePedido> detallePedidoList){
	    /* Agrupar la lista de detalle a traves de code_promo_3 y obtener sumatoria subtotalCantidad */
	    Double sum_cantidad_venta = 0.0;
	    if (!detallePedidoList.isEmpty()) {
		    for (DetallePedido item : detallePedidoList) {
			    String column_group = item.getCode_promo_3();
			    if (column_group.equalsIgnoreCase(code_promo_3))
				    sum_cantidad_venta += item.getCantidad_venta();
		    }
	    }
	    /* fin agrupacion*/
	
	    List<Descuento11> descuento11List = null;
	    try{
		    //buscar regla
		    descuento11List = helper.getDescuento11Dao().queryBuilder()
				    .where().eq("code_promo", code_promo_3)
				    .and().le("cantidad_desde", sum_cantidad_venta)
				    .and().ge("cantidad_hasta", sum_cantidad_venta)
				    .query();
		    if (!descuento11List.isEmpty())
			    return descuento11List.get(0).getDescuento_code();
	    }
	    catch(SQLException e){
		    e.printStackTrace();
	    }
        
        return 0.00;
    }

}

