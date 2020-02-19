package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Municipio;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 22/8/2018.
 */

public class MunicipioRepo implements ICrud {

    private DatabaseHelper helper;

    public MunicipioRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Municipio object = (Municipio) item;
        try {
            index = helper.getMunicipioDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Municipio municipio = null;
        try {
            municipio = helper.getMunicipioDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return municipio;
    }

    @Override
    public List<?> findAll(){

        List<Municipio> items = null;

        try {
            items =  helper.getMunicipioDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Municipio, Integer> deleteBuilder = helper.getMunicipioDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Municipio, Integer> deleteBuilder = helper.getMunicipioDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_municipio", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Municipio municipio = null;
        try {
            municipio = helper.getMunicipioDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return municipio;
    }

    public void update(Object item){
        Municipio object = (Municipio) item;
        try{
            helper.getMunicipioDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
