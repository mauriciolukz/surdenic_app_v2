package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento15;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento15Repo implements ICrud {

    private DatabaseHelper helper;
	private DetallePedidoRepo detallePedidoRepo;

    public Descuento15Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
        detallePedidoRepo = new DetallePedidoRepo(context);
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento15 object = (Descuento15) item;
        try {
            index = helper.getDescuento15Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento15 descuento15 = null;
        try {
            descuento15 = helper.getDescuento15Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento15;
    }

    @Override
    public List<?> findAll(){

        List<Descuento15> items = null;

        try {
            items =  helper.getDescuento15Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento15, Integer> deleteBuilder = helper.getDescuento15Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento15, Integer> deleteBuilder = helper.getDescuento15Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento15 descuento15 = null;
        try {
            descuento15 = helper.getDescuento15Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento15;
    }

    public void update(Object item){
        Descuento15 object = (Descuento15) item;
        try{
            helper.getDescuento15Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public double obtenerDescuento15(String code_promo){
        List<Descuento15> descuento15List = null;
        
        try{
            descuento15List = helper.getDescuento15Dao().queryBuilder()
                    .where().eq("code_promo", code_promo)
                    .query();
            if (!descuento15List.isEmpty()){
                return descuento15List.get(0).getDescuento_promo();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return 0.00;
    }

    public List<Descuento15> buscarCombosPares(String code_promo){
        List<Descuento15> descuento15List = null;

        try{
            descuento15List = helper.getDescuento15Dao().queryBuilder()
                    .where().eq("code_promo", code_promo)
                    .query();
            if (!descuento15List.isEmpty()){
                return descuento15List;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    
    public void agregarBonificacion(DetallePedido detallePedido,List<DetallePedido> detallePedidos,ProductoRepo productoRepo){
	    List<Descuento15> descuento15List = null;
	    Descuento15 descuento15;
	    DetallePedido bono = null;
	    Integer random = 11 + (int)(Math.random() * (1000 - 5));
	    String referencia;
        int combo1int = 0;
        int combo2int = 0;
        List<DetallePedido> combo1 = null, combo2 = null;

	    try{
		    descuento15List = helper.getDescuento15Dao().queryBuilder()
				    .where().eq("code_promo", detallePedido.getCode_promo_combo())
				    .query();
		    if (!descuento15List.isEmpty()){
			    descuento15 = descuento15List.get(0);
			    referencia = detallePedido.getId_producto() + detallePedido.getId_familia() + detallePedido.getId_pedido() + descuento15.getId_producto_3() + random.toString();
                Producto producto = (Producto) productoRepo.findByIdProducto(descuento15.getId_producto_3());

			    bono = helper.getDetallePedidoDao().queryBuilder()
					    .where().eq("id_pedido", detallePedido.getId_pedido())
					    .and().eq("id_producto", descuento15.getId_producto_3())
					    .queryForFirst();
			    if (bono == null){

                    combo1 = detallePedidoRepo.getByPedidoForItem(detallePedido.getId_pedido(),descuento15.getId_producto_1());
                    combo2 = detallePedidoRepo.getByPedidoForItem(detallePedido.getId_pedido(),descuento15.getId_producto_2());

                    if (combo1.size() > 0 && combo2.size() > 0) {

                        for (DetallePedido item : detallePedidos) {

                            if(item.getId_producto().equals(descuento15List.get(0).getId_producto_1())){
                                combo1int += item.getCantidad_pedida();
                            }

                            if(item.getId_producto().equals(descuento15List.get(0).getId_producto_2())){
                                combo2int += item.getCantidad_pedida();
                            }

                        }

                        if (combo1int >= descuento15List.get(0).getCantidad_regla_1() && combo2int >= descuento15List.get(0).getCantidad_regla_2()) {

                            detallePedido.setReferencia_bonificado(referencia);
                            helper.getDetallePedidoDao().update(detallePedido);

                            bono = new DetallePedido();
                            bono.setId_pedido(detallePedido.getId_pedido());
                            bono.setReferencia_bonificado(referencia);
                            bono.setReferencia_bonificado_5(referencia);
                            bono.setEs_bonificado_5("S");
                            bono.setId_producto(descuento15.getId_producto_3());
                            bono.setNom_producto(producto.getNombre_producto());
                            bono.setCaja_vendida(0.00);
                            bono.setCantidad_pedida(0);
                            bono.setCantidad_venta(descuento15.getCantidad_boni());
                            bono.setId_proveedor(descuento15.getId_proveedor());
                            bono.setId_familia(descuento15.getId_familia_3());
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
                            bono.setPorcentaje_descuento_venta(0.00);

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

			    }
		    }
	    }catch (SQLException ex){
		    ex.printStackTrace();
	    }catch (Exception e){
		    e.printStackTrace();
	    }
    }

}

