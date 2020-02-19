package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosa;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 18/8/2018.
 */

public class VisitaNoExitosaRepo implements ICrud {

    private DatabaseHelper helper;

    public VisitaNoExitosaRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        VisitaNoExitosa object = (VisitaNoExitosa) item;
        try {
            index = helper.getVisitaNoExitosaDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        VisitaNoExitosa visitaNoExitosa = null;
        try {
            visitaNoExitosa = helper.getVisitaNoExitosaDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitaNoExitosa;
    }

    @Override
    public List<?> findAll(){

        List<VisitaNoExitosa> items = null;

        try {
            items =  helper.getVisitaNoExitosaDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<VisitaNoExitosa, Integer> deleteBuilder = helper.getVisitaNoExitosaDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<VisitaNoExitosa, Integer> deleteBuilder = helper.getVisitaNoExitosaDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        VisitaNoExitosa visitaNoExitosa = null;
        try {
            visitaNoExitosa = helper.getVisitaNoExitosaDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitaNoExitosa;
    }

    public void update(Object item){
        VisitaNoExitosa object = (VisitaNoExitosa) item;
        try{
            helper.getVisitaNoExitosaDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public List<VisitaNoExitosa> findByIdVendedor(Integer id_vendedor){

        List<VisitaNoExitosa> items = null;

        try {
            items =  helper.getVisitaNoExitosaDao().queryBuilder().where().eq("id_vendedor", id_vendedor).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public List<VisitaNoExitosa> getToSendByIdVendedor(Integer id_vendedor){

        List<VisitaNoExitosa> items = null;

        try {
            items =  helper.getVisitaNoExitosaDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("send", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }


    public List<VisitaNoExitosa> getSentByIdVendedor(Integer id_vendedor){

        List<VisitaNoExitosa> items = null;

        try {
            items =  helper.getVisitaNoExitosaDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("send", true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public VisitaNoExitosa findByIdVendedorAndIdCliente(Integer id_vendedor, Integer id_cliente){

        VisitaNoExitosa visitaNoExitosa = null;

        try {
            visitaNoExitosa =  helper.getVisitaNoExitosaDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("id_cliente", id_cliente).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visitaNoExitosa;

    }


    public void deleteByIdVendedor(Integer id_vendedor){
        DeleteBuilder<VisitaNoExitosa, Integer> deleteBuilder = helper.getVisitaNoExitosaDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_vendedor", id_vendedor);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
