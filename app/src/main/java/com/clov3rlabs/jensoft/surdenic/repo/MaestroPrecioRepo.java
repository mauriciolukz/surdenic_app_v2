package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.MaestroPrecio;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 22/8/2018.
 */


public class MaestroPrecioRepo implements ICrud {


    private DatabaseHelper helper;

    public MaestroPrecioRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        MaestroPrecio object = (MaestroPrecio) item;
        try {
            index = helper.getMaestroPrecioDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        MaestroPrecio maestroPrecio = null;
        try {
            maestroPrecio = helper.getMaestroPrecioDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maestroPrecio;
    }

    @Override
    public List<?> findAll(){

        List<MaestroPrecio> items = null;

        try {
            items =  helper.getMaestroPrecioDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<MaestroPrecio, Integer> deleteBuilder = helper.getMaestroPrecioDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<MaestroPrecio, Integer> deleteBuilder = helper.getMaestroPrecioDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_precio", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        MaestroPrecio maestroPrecio = null;
        try {
            maestroPrecio = helper.getMaestroPrecioDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maestroPrecio;
    }

    public void update(Object item){
        MaestroPrecio object = (MaestroPrecio) item;
        try{
            helper.getMaestroPrecioDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
