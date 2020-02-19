package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Ruta;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class RutaRepo implements ICrud {

    private DatabaseHelper helper;

    public RutaRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Ruta object = (Ruta) item;
        try {
            index = helper.getRutaDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Ruta ruta = null;
        try {
            ruta = helper.getRutaDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ruta;
    }

    @Override
    public List<?> findAll(){

        List<Ruta> items = null;

        try {
            items =  helper.getRutaDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Ruta, Integer> deleteBuilder = helper.getRutaDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Ruta, Integer> deleteBuilder = helper.getRutaDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Ruta ruta = null;
        try {
            ruta = helper.getRutaDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ruta;
    }

    public Object findByIdVendedor(Integer id_vendedor){
        List<Ruta> ruta = null;
        try {
            ruta = helper.getRutaDao().queryForEq("id_vendedor", id_vendedor);
            if (ruta.isEmpty() || ruta == null){
                return null;

            }else{
                return ruta.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ruta;
    }


    public void update(Object item){
        Ruta object = (Ruta) item;
        try{
            helper.getRutaDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Ruta getRutaActiva(Integer id_vendedor){
        Ruta ruta = null;
        try {
            ruta = helper.getRutaDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("active", true).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ruta;
    }

    public void deleteByIdVendedor(Integer id_vendedor){
        DeleteBuilder<Ruta, Integer> deleteBuilder = helper.getRutaDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_vendedor", id_vendedor);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
