package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;
import android.util.Log;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento0;
import com.clov3rlabs.jensoft.surdenic.models.Descuento2;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */

public class Descuento2Repo implements ICrud {

    private DatabaseHelper helper;
    private DetallePedidoRepo detallePedidoRepo;

    public Descuento2Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
        detallePedidoRepo = new DetallePedidoRepo(context);
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento2 object = (Descuento2) item;
        try {
            index = helper.getDescuento2Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento2 descuento2 = null;
        try {
            descuento2 = helper.getDescuento2Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento2;
    }

    @Override
    public List<?> findAll(){

        List<Descuento2> items = null;

        try {
            items =  helper.getDescuento2Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento2, Integer> deleteBuilder = helper.getDescuento2Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento2, Integer> deleteBuilder = helper.getDescuento2Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento2 descuento2 = null;
        try {
            descuento2 = helper.getDescuento2Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento2;
    }

    public void update(Object item){
        Descuento2 object = (Descuento2) item;
        try{
            helper.getDescuento2Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public double obtenerrDescuento2(String id_producto, Integer cantidad){
        Descuento2 descuento2 =  null;
        double descuento = 0.00;
        List<Descuento2> descuento12ist = null;
        try{
            descuento12ist = helper.getDescuento2Dao().queryBuilder().where().eq("id_producto_origen", id_producto).query();

            if (!descuento12ist.isEmpty()){

                for (Descuento2 des: descuento12ist) {
                    if ((cantidad / des.getRegla_por_cada()) > 0){
                        descuento2 = des;
                        break;
                    }
                }

            }

            if (descuento2 != null)
                descuento = descuento2.getDescuento_subtotal(); //descuento = (cantidad / descuento2.getRegla_por_cada()) * descuento2.getRegla_bonificar();

            return descuento;


        }catch(SQLException e){
            e.printStackTrace();
        }

        return 0.00;
    }
    
    public void agregarBonificacion(DetallePedido detallePedido,ProductoRepo productoRepo){
	    Descuento2 descuento2 = null;
	    DetallePedido bono = null;
	    List<Descuento2> descuento2List = null;
	    Integer random = 11 + (int)(Math.random() * (1000 - 5));
	    
	    try{
	    	descuento2List = helper.getDescuento2Dao().queryBuilder()
				    .where().raw("id_producto_origen = '"+ detallePedido.getId_producto() + "' AND ("+ detallePedido.getCantidad_venta() + " / regla_por_cada) > 0")
				    .query();
	    	
	    	if (!descuento2List.isEmpty()){
			    descuento2 = descuento2List.get(0);
			    String referencia = detallePedido.getId_producto() + detallePedido.getId_familia() + descuento2.getId_producto_destino() + random.toString();
                Producto producto = (Producto) productoRepo.findByIdProducto(descuento2.getId_producto_destino());
                /*
                bono = helper.getDetallePedidoDao().queryBuilder()
                        .where().eq("id_pedido", detallePedido.getId_pedido())
                        .and().eq("id_producto", descuento2.getId_producto_destino())
                        .queryForFirst();*/

                bono = helper.getDetallePedidoDao().queryBuilder()
                        .where().eq("id_pedido", detallePedido.getId_pedido())
                        .and().eq("referencia_bonificado", detallePedido.getReferencia_bonificado()).and().eq("es_bonificado", "S")
                        .queryForFirst();
			    
			    if (bono == null){
			    	
			    	//detallePedido.setReferencia_bonificado(referencia);
				    //helper.getDetallePedidoDao().update(detallePedido);
				
				    bono = new DetallePedido();
				    bono.setId_pedido(detallePedido.getId_pedido());
				    bono.setReferencia_bonificado(referencia);
                    //bono.setReferencia_bonificado_2(referencia);
				    bono.setEs_bonificado_2("S");
				    bono.setId_producto(descuento2.getId_producto_destino());
                    bono.setNom_producto(producto.getNombre_producto());
                    bono.setCaja_vendida(0.00);
				    bono.setCantidad_pedida(0);
				    bono.setCantidad_venta((detallePedido.getCantidad_venta() / descuento2.getRegla_por_cada()) * descuento2.getRegla_bonificar());
				    bono.setId_proveedor(descuento2.getId_proveedor());
				    bono.setId_familia(descuento2.getId_familia_destino());
				    bono.setEs_bonificado("S");
				    bono.setSubtotal_venta(0.0);
				    bono.setSubtotal_venta_desc(0.0);
				    bono.setSubtotal_venta_aplicar_iva(0.0);
				    bono.setTotal_factura_venta(0.0);
				    bono.setTotal_iva_venta(0.0);
				    bono.setDescuento_total_venta(0.0);
				    bono.setPrecio_venta(0.0);
				    bono.setPrecio_venta_desc(0.0);
				    bono.setPrecio_venta_antes_iva(0.0);
                    bono.setPorcentaje_iva_antes(0.00);
				    bono.setCode_promo("0");
				    bono.setCode_promo_2("0");
				    bono.setCode_promo_3("0");
				    bono.setCode_promo_4("0");
				    bono.setCode_promo_combo("0");

                    bono.setDes0(0.00);
                    bono.setDes1(0.00);
                    bono.setDes2(0.00);
                    bono.setDes3(0.00);
                    bono.setDes4(0.00);
                    bono.setDes5(0.00);
                    bono.setDes6(0.00);
                    bono.setDes7(0.00);
                    bono.setDes8(0.00);
                    bono.setDes9(0.00);
                    bono.setDes10(0.00);
                    bono.setDes11(0.00);
                    bono.setDes12(0.00);
                    bono.setDes13(0.00);
                    bono.setDes14(0.00);
                    bono.setDes15(0.00);
                    bono.setDes16(0.00);
                    bono.setDes17(0.00);
                    bono.setDes18(0.00);
                    bono.setDes19(0.00);
                    bono.setDes20(0.00);
                    bono.setDes21(0.00);
                    bono.setDes22(0.00);
                    bono.setPorcentaje_descuento_venta(0.00);
                    bono.setPeriodo_trabajo(detallePedido.getPeriodo_trabajo());
				    
				    detallePedidoRepo.create(bono);
			    }
		    }
	    }catch (SQLException ex){
	    	ex.printStackTrace();
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
    }

}


