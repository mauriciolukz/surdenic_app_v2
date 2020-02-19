package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento12;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 10/12/2018.
 */
public class Descuento12Repo implements ICrud {

    private DatabaseHelper helper;
	private DetallePedidoRepo detallePedidoRepo;

    public Descuento12Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
        detallePedidoRepo = new DetallePedidoRepo(context);
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento12 object = (Descuento12) item;
        try {
            index = helper.getDescuento12Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento12 descuento12 = null;
        try {
            descuento12 = helper.getDescuento12Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento12;
    }

    @Override
    public List<?> findAll(){

        List<Descuento12> items = null;

        try {
            items =  helper.getDescuento12Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento12, Integer> deleteBuilder = helper.getDescuento12Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento12, Integer> deleteBuilder = helper.getDescuento12Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento12 descuento12 = null;
        try {
            descuento12 = helper.getDescuento12Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento12;
    }

    public void update(Object item){
        Descuento12 object = (Descuento12) item;
        try{
            helper.getDescuento12Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public double obtenerDescuento12(DetallePedido detallePedido, List<DetallePedido> detallePedidoList,ProductoRepo productoRepo){
        /* Agrupar la lista de detalle a traves de code_promo_2 y obtener sumatoria subtotalCantidad */
        Integer sum_cantidad_venta = 0;
        String referencia;
        Descuento12 descuento12;
        //Integer random = 11 + (int)(Math.random() * (1000 - 5));
        DetallePedido bono;

        if (!detallePedidoList.isEmpty()) {
            for (DetallePedido item : detallePedidoList) {
                String column_group = item.getCode_promo_2();
                if (column_group.equalsIgnoreCase(detallePedido.getCode_promo_2()))
                sum_cantidad_venta += item.getCantidad_venta();
                //item.setReferencia_bonificado(detallePedido.getReferencia_bonificado());
            }
        }
        /* fin agrupacion*/

        List<Descuento12> descuento12List = null;
        try{
            //buscar regla
            descuento12List = helper.getDescuento12Dao().queryBuilder()
                    .where().raw(" code_promo = '"+ detallePedido.getCode_promo_2() +"' AND ("+ sum_cantidad_venta.toString() +" / regla_por_cada) > 0")
                    .query();

            if (!descuento12List.isEmpty()) {
                descuento12 = descuento12List.get(0);
                Producto producto = (Producto) productoRepo.findByIdProducto(descuento12.getId_producto());

                bono = helper.getDetallePedidoDao().queryBuilder()
                        .where().eq("id_pedido", detallePedido.getId_pedido())
                        //.and().eq("id_producto", descuento12.getId_producto())
                        .and().eq("referencia_bonificado_3", detallePedido.getReferencia_bonificado_3()).and().eq("es_bonificado", "S")
                        .queryForFirst();

                if (bono == null){

                    //detallePedido.setReferencia_bonificado(referencia);
                    //helper.getDetallePedidoDao().update(detallePedido);

                    bono = new DetallePedido();
                    bono.setId_pedido(detallePedido.getId_pedido());
                    //bono.setReferencia_bonificado(detallePedido.getReferencia_bonificado());
                    bono.setReferencia_bonificado_3(detallePedido.getReferencia_bonificado_3());
                    bono.setEs_bonificado_3("S");
                    bono.setId_producto(descuento12.getId_producto());
                    bono.setNom_producto(producto.getNombre_producto());
                    bono.setCaja_vendida(0.00);
                    bono.setCantidad_pedida(0);
                    bono.setCantidad_venta((sum_cantidad_venta / descuento12.getRegla_por_cada()) * descuento12.getCantidad_bonificar());
                    bono.setId_proveedor(descuento12.getId_proveedor());
                    bono.setId_familia(descuento12.getId_familia());
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

                return descuento12.getDescuento_subtotal();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return 0.00;
    }

}
