package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Departamento;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 22/8/2018.
 */

public class DepartamentoRepo implements ICrud {

    private DatabaseHelper helper;

    public DepartamentoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Departamento object = (Departamento) item;
        try {
            index = helper.getDepartamentoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Departamento departamento = null;
        try {
            departamento = helper.getDepartamentoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamento;
    }

    @Override
    public List<?> findAll(){

        List<Departamento> items = null;

        try {
            items =  helper.getDepartamentoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Departamento, Integer> deleteBuilder = helper.getDepartamentoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Departamento, Integer> deleteBuilder = helper.getDepartamentoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_departamento", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Departamento departamento = null;
        try {
            departamento = helper.getDepartamentoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamento;
    }

    public void update(Object item){
        Departamento object = (Departamento) item;
        try{
            helper.getDepartamentoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
