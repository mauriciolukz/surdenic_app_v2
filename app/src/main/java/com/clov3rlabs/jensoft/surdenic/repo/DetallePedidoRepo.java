package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;
import android.util.Log;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class DetallePedidoRepo implements ICrud {

    private DatabaseHelper helper;

    public DetallePedidoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        DetallePedido object = (DetallePedido) item;
        try {
            index = helper.getDetallePedidoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        DetallePedido detallePedido = null;
        try {
            detallePedido = helper.getDetallePedidoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detallePedido;
    }

    @Override
    public List<?> findAll(){

        List<DetallePedido> items = null;

        try {
            items =  helper.getDetallePedidoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<DetallePedido, Integer> deleteBuilder = helper.getDetallePedidoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<DetallePedido, Integer> deleteBuilder = helper.getDetallePedidoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("detalle_id_pedido", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        DetallePedido detallePedido = null;
        try {
            detallePedido = helper.getDetallePedidoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detallePedido;
    }

    public int update(Object item){
        int index = -1;
        DetallePedido object = (DetallePedido) item;
        try{
            index = helper.getDetallePedidoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return index;

    }

    public List<DetallePedido> getByPedido(Integer id_pedido){
        List<DetallePedido> detallePedidoList = null;
        boolean exist = false;

        try {
            detallePedidoList = helper.getDetallePedidoDao().queryBuilder().where().eq("id_pedido", id_pedido).query();

        }catch (SQLException e){
            Log.e("Get detalle pedido", e.getMessage());
        }

        return detallePedidoList;
    }

    public List<DetallePedido> getByPedidoGroup(Integer id_pedido){
        List<DetallePedido> detallePedidoList = null;
        boolean exist = false;

        try {
            detallePedidoList = helper.getDetallePedidoDao().queryBuilder().groupBy("code_promo_2").where().eq("id_pedido", id_pedido).query();

        }catch (SQLException e){
            Log.e("Get detalle pedido", e.getMessage());
        }

        return detallePedidoList;
    }

    public List<DetallePedido> getByPedidoForItem(Integer id_pedido,String item){
        List<DetallePedido> detallePedidoList = null;
        boolean exist = false;

        try {
            detallePedidoList = helper.getDetallePedidoDao().queryBuilder().where().eq("id_pedido", id_pedido).and().eq("id_producto",item).query();

        }catch (SQLException e){
            Log.e("Get detalle pedido", e.getMessage());
        }

        return detallePedidoList;
    }

    public DetallePedido getByPedidoForCodeProm(Integer id_pedido,String code_promo){
        DetallePedido detallePedidoList = null;
        boolean exist = false;

        try {
            detallePedidoList = helper.getDetallePedidoDao().queryBuilder().where().eq("id_pedido", id_pedido).and().eq("code_promo_2",code_promo).queryForFirst();

        }catch (SQLException e){
            Log.e("Get detalle pedido", e.getMessage());
        }

        return detallePedidoList;
    }

    public void deleteByIdPedidoByItem(Integer id_pedido,String item){
        DeleteBuilder<DetallePedido, Integer> deleteBuilder = helper.getDetallePedidoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_pedido", id_pedido).and().eq("id_producto",item);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteByIdPedido(Integer id_pedido){
        DeleteBuilder<DetallePedido, Integer> deleteBuilder = helper.getDetallePedidoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_pedido", id_pedido);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBonificacodsByIdPedidoAndReferencia (String referencia){
        DeleteBuilder<DetallePedido, Integer> deleteBuilder = helper.getDetallePedidoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("referencia_bonificado", referencia);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBonificacodsByIdPedidoAndReferencia (Integer id_pedido,String referencia){
        DeleteBuilder<DetallePedido, Integer> deleteBuilder = helper.getDetallePedidoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("referencia_bonificado", referencia).and().eq("id_pedido",id_pedido);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteBonificacodsByIdPedido (Integer id_pedido){
        DeleteBuilder<DetallePedido, Integer> deleteBuilder = helper.getDetallePedidoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_pedido", id_pedido).and().eq("es_bonificado", "S");
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DetallePedido> getToSendByIdPedido(Integer id_pedido){

        List<DetallePedido> items = null;

        try {
            items =  helper.getDetallePedidoDao().queryBuilder().where().eq("id_pedido", id_pedido).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }



}
