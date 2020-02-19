package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento20;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */

public class Descuento20Repo implements ICrud {

    private DatabaseHelper helper;
	private DetallePedidoRepo detallePedidoRepo;

    public Descuento20Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
	    detallePedidoRepo = new DetallePedidoRepo(context);
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento20 object = (Descuento20) item;
        try {
            index = helper.getDescuento20Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento20 descuento20 = null;
        try {
            descuento20 = helper.getDescuento20Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento20;
    }

    @Override
    public List<?> findAll(){

        List<Descuento20> items = null;

        try {
            items =  helper.getDescuento20Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento20, Integer> deleteBuilder = helper.getDescuento20Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento20, Integer> deleteBuilder = helper.getDescuento20Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento20 descuento20 = null;
        try {
            descuento20 = helper.getDescuento20Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento20;
    }

    public void update(Object item){
        Descuento20 object = (Descuento20) item;
        try{
            helper.getDescuento20Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento20(DetallePedido detallePedido, Integer id_canal,ProductoRepo productoRepo){
        List<Descuento20> descuento20List = null;
        Descuento20 descuento20 = null;
	    DetallePedido bono = null;
	    String referencia;
	    Integer random = 11 + (int)(Math.random() * (1000 - 5));
        //Double descuento = 0.00;
        try{
            descuento20List = helper.getDescuento20Dao().queryBuilder()
                    .where().eq("id_producto_origen", detallePedido.getId_producto())
                    .and().eq("id_canal", id_canal)
                    .query();
            
            if (!descuento20List.isEmpty()){
                for(Descuento20 item : descuento20List){
                    if ( detallePedido.getCantidad_venta() / item.getRegla_por_cada() > 0) {
	                    descuento20 = item;
                        //descuento = item.getDescuento_subtotal();
	                    break;
                    }
                }
            }
            
            if (descuento20 != null){ //aplicar bonificacion
	            bono = helper.getDetallePedidoDao().queryBuilder()
			            .where().eq("id_pedido", detallePedido.getId_pedido())
			            .and().eq("id_producto", descuento20.getId_producto_destino())
			            .queryForFirst();
	            referencia = detallePedido.getId_producto() + detallePedido.getId_familia() + detallePedido.getId_pedido() + descuento20.getId_familia_destino() + random.toString();
                Producto producto = (Producto) productoRepo.findByIdProducto(descuento20.getId_producto_destino());
	            if (bono == null){
		            detallePedido.setReferencia_bonificado(referencia);
		            helper.getDetallePedidoDao().update(detallePedido);
		
		            bono = new DetallePedido();
		            bono.setId_pedido(detallePedido.getId_pedido());
		            bono.setReferencia_bonificado(referencia);
		            bono.setReferencia_bonificado_6(referencia);
		            bono.setEs_bonificado_6("S");
		            bono.setId_producto(descuento20.getId_producto_destino());
                    bono.setNom_producto(producto.getNombre_producto());
                    bono.setCaja_vendida(0.00);
		            bono.setCantidad_pedida(0);
		            bono.setCantidad_venta((detallePedido.getCantidad_venta() / descuento20.getRegla_por_cada()) * descuento20.getRegla_bonificar() );
		            bono.setId_proveedor(descuento20.getId_proveedor());
		            bono.setId_familia(descuento20.getId_familia_destino());
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
                    bono.setTipo_precio(0.00);
                    bono.setPorcentaje_iva_antes(0.00);
		
		            detallePedidoRepo.create(bono);
	            }
                return descuento20.getDescuento_subtotal();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return 0.00;
    }

}

