package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class ClienteRepo implements ICrud {

    private DatabaseHelper helper;

    public ClienteRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Cliente object = (Cliente) item;
        try {
            index = helper.getClienteDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Cliente cliente = null;
        try {
            cliente = helper.getClienteDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<?> findAll(){

        List<Cliente> items = null;

        try {
            items =  helper.getClienteDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Cliente, Integer> deleteBuilder = helper.getClienteDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Cliente, Integer> deleteBuilder = helper.getClienteDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_cliente", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Cliente cliente = null;
        try {
             cliente = helper.getClienteDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void update(Object item){
        Cliente object = (Cliente) item;
        try{
            helper.getClienteDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Cliente> findByIdVendedor(Integer id_vendedor,String typo_visita){

        List<Cliente> items = null;

        try {
            items =  helper.getClienteDao().queryBuilder().where().eq("id_vendedor", id_vendedor).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public void deleteByIdVendedor(Integer id_vendedor){
        DeleteBuilder<Cliente, Integer> deleteBuilder = helper.getClienteDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_vendedor", id_vendedor);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
