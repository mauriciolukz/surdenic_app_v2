package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.CanalDistribucion;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 22/8/2018.
 */

public class CanalDistribucionRepo implements ICrud {

    private DatabaseHelper helper;

    public CanalDistribucionRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        CanalDistribucion object = (CanalDistribucion) item;
        try {
            index = helper.getCanalDistribucionDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        CanalDistribucion canalDistribucion = null;
        try {
            canalDistribucion = helper.getCanalDistribucionDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canalDistribucion;
    }

    @Override
    public List<?> findAll(){

        List<CanalDistribucion> items = null;

        try {
            items =  helper.getCanalDistribucionDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<CanalDistribucion, Integer> deleteBuilder = helper.getCanalDistribucionDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<CanalDistribucion, Integer> deleteBuilder = helper.getCanalDistribucionDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_canal_distribucion", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        CanalDistribucion canalDistribucion = null;
        try {
            canalDistribucion = helper.getCanalDistribucionDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canalDistribucion;
    }

    public void update(Object item){
        CanalDistribucion object = (CanalDistribucion) item;
        try{
            helper.getCanalDistribucionDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
