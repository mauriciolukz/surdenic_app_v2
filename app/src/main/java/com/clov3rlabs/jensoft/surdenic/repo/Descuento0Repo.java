package com.clov3rlabs.jensoft.surdenic.repo;

import android.app.Application;
import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento0;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento0Repo implements ICrud {

    private DatabaseHelper helper;
	private DetallePedidoRepo detallePedidoRepo;

    public Descuento0Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
        detallePedidoRepo = new DetallePedidoRepo(context);
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento0 object = (Descuento0) item;
        try {
            index = helper.getDescuento0Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento0 descuento1 = null;
        try {
            descuento1 = helper.getDescuento0Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento1;
    }

    @Override
    public List<?> findAll(){

        List<Descuento0> items = null;

        try {
            items =  helper.getDescuento0Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento0, Integer> deleteBuilder = helper.getDescuento0Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento0, Integer> deleteBuilder = helper.getDescuento0Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento0 descuento1 = null;
        try {
            descuento1 = helper.getDescuento0Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento1;
    }

    public void update(Object item){
        Descuento0 object = (Descuento0) item;
        try{
            helper.getDescuento0Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public double obtenerDescuento0(String id_producto, Integer cantidad){
        Descuento0 descuento0 =  null;
        List<Descuento0> descuento0List = null;
        try{
            descuento0List = helper.getDescuento0Dao().queryBuilder().where().eq("id_producto_origen", id_producto).query();

            if (!descuento0List.isEmpty()){

                for (Descuento0 des: descuento0List) {
                    if ((cantidad >= des.getRegla_cantidad_desde()) && (cantidad <= des.getRegla_cantidad_hasta())){
                        descuento0 = des;
                        break;
                    }
                }

            }
            
            if (descuento0 != null){
                return descuento0.getDescuento_subtotal();
            }else{
                return 0.00;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return 0.00;
    }
    
    public void agregarBonificacion(DetallePedido detallePedido,ProductoRepo productoRepo){
    	Descuento0 descuento0 = null;
    	DetallePedido bono = null;
    	List<Descuento0> descuento0List = null;
    	Integer random = 11 + (int)(Math.random() * (1000 - 5));
    	
        try{
            descuento0List = helper.getDescuento0Dao().queryBuilder()
		            .where().eq("id_producto_origen", detallePedido.getId_producto())
		            .and().le("regla_cantidad_desde", detallePedido.getCantidad_venta())
		            .and().ge("regla_cantidad_hasta", detallePedido.getCantidad_venta())
		            .query();
            if (!descuento0List.isEmpty()){

	            descuento0 = descuento0List.get(0);
	            String referencia = detallePedido.getId_producto() + detallePedido.getId_familia() + descuento0.getId_producto_destino() + random.toString();

                Producto producto = (Producto) productoRepo.findByIdProducto(descuento0.getId_producto_destino());

	            bono = helper.getDetallePedidoDao().queryBuilder()
			            .where().eq("id_pedido", detallePedido.getId_pedido())
			            .and().eq("id_producto", descuento0.getId_producto_destino())
			            .queryForFirst();
	            if (bono == null){
	            
		            detallePedido.setReferencia_bonificado(referencia);
		            helper.getDetallePedidoDao().update(detallePedido);
		            
		            bono = new DetallePedido();
		            bono.setId_pedido(detallePedido.getId_pedido());
		            bono.setReferencia_bonificado(referencia);
		            bono.setReferencia_bonificado_2(referencia);
		            bono.setEs_bonificado_2("S");
		            bono.setId_producto(descuento0.getId_producto_destino());
                    bono.setNom_producto(producto.getNombre_producto());
                    bono.setCaja_vendida(0.00);
		            bono.setCantidad_pedida(0);
		            bono.setCantidad_venta(descuento0.getRegla_bonificar());
		            bono.setId_proveedor(descuento0.getId_proveedor());
		            bono.setId_familia(descuento0.getId_familia_destino());
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

