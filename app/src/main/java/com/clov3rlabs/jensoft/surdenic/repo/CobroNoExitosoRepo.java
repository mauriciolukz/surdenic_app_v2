package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.CobroNoExitoso;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 18/8/2018.
 */

public class CobroNoExitosoRepo implements ICrud {

    private DatabaseHelper helper;

    public CobroNoExitosoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        CobroNoExitoso object = (CobroNoExitoso) item;
        try {
            index = helper.getCobroNoExitosoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        CobroNoExitoso cobroNoExitoso = null;
        try {
            cobroNoExitoso = helper.getCobroNoExitosoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cobroNoExitoso;
    }

    @Override
    public List<?> findAll(){

        List<CobroNoExitoso> items = null;

        try {
            items =  helper.getCobroNoExitosoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<CobroNoExitoso, Integer> deleteBuilder = helper.getCobroNoExitosoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<CobroNoExitoso, Integer> deleteBuilder = helper.getCobroNoExitosoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        CobroNoExitoso cobroNoExitoso = null;
        try {
            cobroNoExitoso = helper.getCobroNoExitosoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cobroNoExitoso;
    }

    public void update(Object item){
        CobroNoExitoso object = (CobroNoExitoso) item;
        try{
            helper.getCobroNoExitosoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<CobroNoExitoso> findByIdVendedor(Integer id_vendedor){

        List<CobroNoExitoso> items = null;

        try {
            items =  helper.getCobroNoExitosoDao().queryBuilder().where().eq("id_vendedor", id_vendedor).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }


    public List<CobroNoExitoso> getToSendByIdVendedor(Integer id_vendedor){

        List<CobroNoExitoso> items = null;

        try {
            items =  helper.getCobroNoExitosoDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("send", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public List<CobroNoExitoso> getSentByIdVendedor(Integer id_vendedor){

        List<CobroNoExitoso> items = null;

        try {
            items =  helper.getCobroNoExitosoDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("send", true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public CobroNoExitoso findByIdVendedorAndIdCliente(Integer id_vendedor, Integer id_cliente){

        CobroNoExitoso cobroNoExitosa = null;

        try {
            cobroNoExitosa =  helper.getCobroNoExitosoDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("id_cliente", id_cliente).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cobroNoExitosa;

    }


    public void deleteByIdVendedor(Integer id_vendedor){
        DeleteBuilder<CobroNoExitoso, Integer> deleteBuilder = helper.getCobroNoExitosoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_vendedor", id_vendedor);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
