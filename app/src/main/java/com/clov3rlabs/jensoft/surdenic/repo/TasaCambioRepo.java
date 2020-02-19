package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.TasaCambio;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 19/1/2019.
 */

public class TasaCambioRepo implements ICrud {

    private DatabaseHelper helper;

    public TasaCambioRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        TasaCambio object = (TasaCambio) item;
        try {
            index = helper.getTasaCambioDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        TasaCambio tasaCambio = null;
        try {
            tasaCambio = helper.getTasaCambioDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasaCambio;
    }

    @Override
    public List<?> findAll(){

        List<TasaCambio> items = null;

        try {
            items =  helper.getTasaCambioDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<TasaCambio, Integer> deleteBuilder = helper.getTasaCambioDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<TasaCambio, Integer> deleteBuilder = helper.getTasaCambioDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        TasaCambio tasaCambio = null;
        try {
            tasaCambio = helper.getTasaCambioDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasaCambio;
    }

    public void update(Object item){
        TasaCambio object = (TasaCambio) item;
        try{
            helper.getTasaCambioDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public TasaCambio getBydate(String date){
        TasaCambio tasaCambio = null;

        try{
            tasaCambio = helper.getTasaCambioDao().queryBuilder().where().eq("fecha_tasa", date).queryForFirst();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return tasaCambio;
    }


}
