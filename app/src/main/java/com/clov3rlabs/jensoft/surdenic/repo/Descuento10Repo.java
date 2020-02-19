package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento10;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */

public class Descuento10Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento10Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento10 object = (Descuento10) item;
        try {
            index = helper.getDescuento10Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento10 descuento10 = null;
        try {
            descuento10 = helper.getDescuento10Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento10;
    }

    @Override
    public List<?> findAll(){

        List<Descuento10> items = null;

        try {
            items =  helper.getDescuento10Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento10, Integer> deleteBuilder = helper.getDescuento10Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento10, Integer> deleteBuilder = helper.getDescuento10Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento10 descuento10 = null;
        try {
            descuento10 = helper.getDescuento10Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento10;
    }

    public void update(Object item){
        Descuento10 object = (Descuento10) item;
        try{
            helper.getDescuento10Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento10(String code_promo_4, List<DetallePedido> detallePedidoList){
	    /* Agrupar la lista de detalle a traves de code_promo_4 y obtener sumatoria subtotalVenta */
	    Double sum_subtotal_venta = 0.0;
	    if (!detallePedidoList.isEmpty()) {
		    for (DetallePedido item : detallePedidoList) {
			    String column_group = item.getCode_promo_4();
			    if ((column_group != null) && (code_promo_4 != null) && (column_group.equalsIgnoreCase(code_promo_4)))
				    sum_subtotal_venta += item.getSubtotal_venta();
		    }
	    }
	    /* fin agrupacion*/
	
	    List<Descuento10> descuento10List = null;
	    try{
		    //buscar regla
		    descuento10List = helper.getDescuento10Dao().queryBuilder()
				    .where().eq("code_promo", code_promo_4)
				    .and().le("monto_desde", sum_subtotal_venta)
				    .and().ge("monto_hasta", sum_subtotal_venta)
				    .query();
		    if (!descuento10List.isEmpty())
			    return descuento10List.get(0).getDescuento_code();
	    }
	    catch(SQLException e){
		    e.printStackTrace();
	    }
	    
    	return 0.00;
    }

}
