package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;
import android.util.Log;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Pedido;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class PedidoRepo implements ICrud {

    private DatabaseHelper helper;

    public PedidoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Pedido object = (Pedido) item;
        try {
            index = helper.getPedidoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Pedido pedido = null;
        try {
            pedido = helper.getPedidoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public List<?> findAll(){

        List<Pedido> items = null;

        try {
            items =  helper.getPedidoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Pedido, Integer> deleteBuilder = helper.getPedidoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Pedido, Integer> deleteBuilder = helper.getPedidoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_pedido", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Pedido pedido = null;
        try {
            pedido = helper.getPedidoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    public void update(Object item){
        Pedido object = (Pedido) item;
        try{
            helper.getPedidoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Pedido getByClienteAndVendedor(Integer id_cliente, Integer id_vendedor){
        Pedido pedido;
        boolean exist = false;

        try {
            pedido = helper.getPedidoDao().queryBuilder().where().eq("id_cliente", id_cliente).and().eq("id_vendedor", id_vendedor).queryForFirst();

        }catch (SQLException e){
            Log.e("Get pedido", e.getMessage());
            return null;
        }

        return pedido;
    }

    public List<Pedido> getPedidosByIdVendedor(Integer id_vendedor){

        List<Pedido> items = null;

        try {
            items =  helper.getPedidoDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().ne("subtotal_venta",0.00).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public void deleteByIdVendedor(Integer id_vendedor){
        DeleteBuilder<Pedido, Integer> deleteBuilder = helper.getPedidoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_vendedor", id_vendedor);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Pedido> getToSendByIdVendedor(Integer id_vendedor){

        List<Pedido> items = null;

        try {
            items =  helper.getPedidoDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("send", false).and().ne("subtotal_venta",0.00).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public List<Pedido> getSentByIdVendedor(Integer id_vendedor){

        List<Pedido> items = null;

        try {
            items =  helper.getPedidoDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("send", true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }


}
