package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.FuerzaVenta;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 22/8/2018.
 */

public class FuerzaVentaRepo implements ICrud {

    private DatabaseHelper helper;

    public FuerzaVentaRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        FuerzaVenta object = (FuerzaVenta) item;
        try {
            index = helper.getFuerzaVentaDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        FuerzaVenta fuerzaVenta = null;
        try {
            fuerzaVenta = helper.getFuerzaVentaDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fuerzaVenta;
    }

    @Override
    public List<?> findAll(){

        List<FuerzaVenta> items = null;

        try {
            items =  helper.getFuerzaVentaDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<FuerzaVenta, Integer> deleteBuilder = helper.getFuerzaVentaDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<FuerzaVenta, Integer> deleteBuilder = helper.getFuerzaVentaDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_fuerza", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        FuerzaVenta fuerzaVenta = null;
        try {
            fuerzaVenta = helper.getFuerzaVentaDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fuerzaVenta;
    }

    public void update(Object item){
        FuerzaVenta object = (FuerzaVenta) item;
        try{
            helper.getFuerzaVentaDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


}
