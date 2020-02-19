package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Barrio;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class BarrioRepo implements ICrud {

    private DatabaseHelper helper;

    public BarrioRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Barrio object = (Barrio) item;
        try {
            index = helper.getBarrioDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Barrio barrio = null;
        try {
            barrio = helper.getBarrioDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barrio;
    }

    @Override
    public List<?> findAll(){

        List<Barrio> items = null;

        try {
            items =  helper.getBarrioDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Barrio, Integer> deleteBuilder = helper.getBarrioDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Barrio, Integer> deleteBuilder = helper.getBarrioDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_barrio", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Barrio barrio = null;
        try {
            barrio = helper.getBarrioDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barrio;
    }

    public void update(Object item){
        Barrio object = (Barrio) item;
        try{
            helper.getBarrioDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
