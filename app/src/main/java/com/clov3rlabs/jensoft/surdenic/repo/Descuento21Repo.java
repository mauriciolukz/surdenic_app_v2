package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento21;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento21Repo implements ICrud {

    private DatabaseHelper helper;
	private DetallePedidoRepo detallePedidoRepo;

    public Descuento21Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
	    detallePedidoRepo = new DetallePedidoRepo(context);
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento21 object = (Descuento21) item;
        try {
            index = helper.getDescuento21Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento21 descuento21 = null;
        try {
            descuento21 = helper.getDescuento21Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento21;
    }

    @Override
    public List<?> findAll(){

        List<Descuento21> items = null;

        try {
            items =  helper.getDescuento21Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento21, Integer> deleteBuilder = helper.getDescuento21Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento21, Integer> deleteBuilder = helper.getDescuento21Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento21 descuento21 = null;
        try {
            descuento21 = helper.getDescuento21Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento21;
    }

    public void update(Object item){
        Descuento21 object = (Descuento21) item;
        try{
            helper.getDescuento21Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento21(String id_producto, Integer id_canal, int cantidad_venta){
        List<Descuento21> descuento21List = null;
        try {
            descuento21List = helper.getDescuento21Dao().queryBuilder()
                    .where().eq("id_producto_origen", id_producto)
                    .and().eq("id_canal", id_canal)
                    .and().le("regla_cantidad_desde", cantidad_venta)
                    .and().ge("regla_cantidad_hasta", cantidad_venta)
                    .query();
            if (!descuento21List.isEmpty()){
                return descuento21List.get(0).getDescuento_subtotal();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return 0.00;
    }
    
    public void agregarBonificacion(DetallePedido detallePedido, Integer id_canal,ProductoRepo productoRepo){
	    List<Descuento21> descuento21List = null;
	    Descuento21 descuento21;
	    String referencia;
	    DetallePedido bono = null;
	    Integer random = 11 + (int)(Math.random() * (1000 - 5));
	    try {
		    descuento21List = helper.getDescuento21Dao().queryBuilder()
				    .where().eq("id_producto_origen", detallePedido.getId_producto())
				    .and().eq("id_canal", id_canal)
				    .and().le("regla_cantidad_desde", detallePedido.getCantidad_venta())
				    .and().ge("regla_cantidad_hasta", detallePedido.getCantidad_venta())
				    .query();
		    if (!descuento21List.isEmpty()){
			    descuento21 = descuento21List.get(0);
			    bono = helper.getDetallePedidoDao().queryBuilder()
					    .where().eq("id_pedido", detallePedido.getId_pedido())
					    .and().eq("id_producto", descuento21.getId_producto_destino())
					    .queryForFirst();
			    referencia = detallePedido.getId_producto() + detallePedido.getId_familia() + detallePedido.getId_pedido() + descuento21.getId_producto_destino() + random.toString();
                Producto producto = (Producto) productoRepo.findByIdProducto(descuento21.getId_producto_destino());
			    if (bono == null){
				    detallePedido.setReferencia_bonificado(referencia);
				    helper.getDetallePedidoDao().update(detallePedido);
				
				    bono = new DetallePedido();
				    bono.setId_pedido(detallePedido.getId_pedido());
                    bono.setReferencia_bonificado(referencia);
				    bono.setReferencia_bonificado_7(referencia);
				    bono.setEs_bonificado_7("S");
				    bono.setId_producto(descuento21.getId_producto_destino());
                    bono.setNom_producto(producto.getNombre_producto());
                    bono.setCaja_vendida(0.00);
				    bono.setCantidad_pedida(0);
				    bono.setCantidad_venta(descuento21.getRegla_bonificar() );
				    bono.setId_proveedor(descuento21.getId_proveedor());
				    bono.setId_familia(descuento21.getId_familia_destino());
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
	    }
    }

}

