package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento12;
import com.clov3rlabs.jensoft.surdenic.models.Descuento13;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */

public class Descuento13Repo implements ICrud {

    private DatabaseHelper helper;
	private DetallePedidoRepo detallePedidoRepo;

    public Descuento13Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
	    detallePedidoRepo = new DetallePedidoRepo(context);
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento13 object = (Descuento13) item;
        try {
            index = helper.getDescuento13Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento13 descuento13 = null;
        try {
            descuento13 = helper.getDescuento13Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento13;
    }

    @Override
    public List<?> findAll(){

        List<Descuento13> items = null;

        try {
            items =  helper.getDescuento13Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento13, Integer> deleteBuilder = helper.getDescuento13Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento13, Integer> deleteBuilder = helper.getDescuento13Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento13 descuento13 = null;
        try {
            descuento13 = helper.getDescuento13Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento13;
    }

    public void update(Object item){
        Descuento13 object = (Descuento13) item;
        try{
            helper.getDescuento13Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento13(DetallePedido detallePedido, List<DetallePedido> detallePedidoList,ProductoRepo productoRepo){
        /* Agrupar la lista de detalle a traves de code_promo_1 y obtener sumatoria subtotalCantidad */
        Double sum_cantidad_venta = 0.0;
        String referencia;
        Descuento13 descuento13;
        Integer random = 11 + (int)(Math.random() * (1000 - 5));
        DetallePedido bono;
        
        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                String column_group = item.getCode_promo();
                if (column_group.equalsIgnoreCase( detallePedido.getCode_promo()))
                    sum_cantidad_venta += item.getCantidad_venta();
            }
        }
        /* fin agrupacion*/
    
        List<Descuento13> descuento13List = null;
        try{
            //buscar regla
            descuento13List = helper.getDescuento13Dao().queryBuilder()
                    .where().eq("code_promo", detallePedido.getCode_promo())
                    .and().le("regla_desde", sum_cantidad_venta)
                    .and().ge("regla_hasta", sum_cantidad_venta)
                    .query();
            if (!descuento13List.isEmpty()) {
	            descuento13 = descuento13List.get(0);
	            referencia = detallePedido.getId_producto() + detallePedido.getId_familia() + detallePedido.getId_pedido() + descuento13.getId_producto() + random.toString();
                Producto producto = (Producto) productoRepo.findByIdProducto(descuento13.getId_producto());

	            bono = helper.getDetallePedidoDao().queryBuilder()
			            .where().eq("id_pedido", detallePedido.getId_pedido())
			            .and().eq("id_producto", descuento13.getId_producto())
			            .queryForFirst();
	
	            if (bono == null){
		            detallePedido.setReferencia_bonificado(referencia);
		            helper.getDetallePedidoDao().update(detallePedido);
		
		            bono = new DetallePedido();
		            bono.setId_pedido(detallePedido.getId_pedido());
		            bono.setReferencia_bonificado(referencia);
                    bono.setReferencia_bonificado_4(referencia);
		            bono.setEs_bonificado_4("S");
		            bono.setId_producto(descuento13.getId_producto());
                    bono.setNom_producto(producto.getNombre_producto());
                    bono.setCaja_vendida(0.00);
		            bono.setCantidad_pedida(0);
		            bono.setCantidad_venta(descuento13.getCantidad_bonificar().intValue());
		            bono.setId_proveedor(descuento13.getId_proveedor());
		            bono.setId_familia(descuento13.getId_familia());
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
	            
	            return descuento13List.get(0).getDescuento_subtotal();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0.00;
    }
    

}
