package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.RazonCobroNoExitoso;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 23/8/2018.
 */

public class RazonCobroNoExitosoRepo implements ICrud {

    private DatabaseHelper helper;

    public RazonCobroNoExitosoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        RazonCobroNoExitoso object = (RazonCobroNoExitoso) item;
        try {
            index = helper.getRazonCobroNoExitosoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        RazonCobroNoExitoso razonCobroNoExitoso = null;
        try {
            razonCobroNoExitoso = helper.getRazonCobroNoExitosoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return razonCobroNoExitoso;
    }

    @Override
    public List<?> findAll(){

        List<RazonCobroNoExitoso> items = null;

        try {
            items =  helper.getRazonCobroNoExitosoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<RazonCobroNoExitoso, Integer> deleteBuilder = helper.getRazonCobroNoExitosoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<RazonCobroNoExitoso, Integer> deleteBuilder = helper.getRazonCobroNoExitosoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        RazonCobroNoExitoso razonCobroNoExitoso = null;
        try {
            razonCobroNoExitoso = helper.getRazonCobroNoExitosoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return razonCobroNoExitoso;
    }

    public void update(Object item){
        RazonCobroNoExitoso object = (RazonCobroNoExitoso) item;
        try{
            helper.getRazonCobroNoExitosoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
