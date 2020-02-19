package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.RazonVisitaNoExitosa;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 23/8/2018.
 */

public class RazonVisitaNoExitosaRepo implements ICrud {

    private DatabaseHelper helper;

    public RazonVisitaNoExitosaRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        RazonVisitaNoExitosa object = (RazonVisitaNoExitosa) item;
        try {
            index = helper.getRazonVisitaNoExitosaDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        RazonVisitaNoExitosa razonVisitaNoExitosa = null;
        try {
            razonVisitaNoExitosa = helper.getRazonVisitaNoExitosaDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return razonVisitaNoExitosa;
    }

    @Override
    public List<?> findAll(){

        List<RazonVisitaNoExitosa> items = null;

        try {
            items =  helper.getRazonVisitaNoExitosaDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<RazonVisitaNoExitosa, Integer> deleteBuilder = helper.getRazonVisitaNoExitosaDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<RazonVisitaNoExitosa, Integer> deleteBuilder = helper.getRazonVisitaNoExitosaDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        RazonVisitaNoExitosa razonVisitaNoExitosa = null;
        try {
            razonVisitaNoExitosa = helper.getRazonVisitaNoExitosaDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return razonVisitaNoExitosa;
    }

    public void update(Object item){
        RazonVisitaNoExitosa object = (RazonVisitaNoExitosa) item;
        try{
            helper.getRazonVisitaNoExitosaDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }



}
