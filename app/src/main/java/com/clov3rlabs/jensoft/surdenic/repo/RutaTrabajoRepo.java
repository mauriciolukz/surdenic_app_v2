package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.RutaTrabajo;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 22/8/2018.
 */

public class RutaTrabajoRepo implements ICrud {

    private DatabaseHelper helper;

    public RutaTrabajoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        RutaTrabajo object = (RutaTrabajo) item;
        try {
            index = helper.getRutaTrabajoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        RutaTrabajo rutaTrabajo = null;
        try {
            rutaTrabajo = helper.getRutaTrabajoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutaTrabajo;
    }

    @Override
    public List<?> findAll(){

        List<RutaTrabajo> items = null;

        try {
            items =  helper.getRutaTrabajoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<RutaTrabajo, Integer> deleteBuilder = helper.getRutaTrabajoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<RutaTrabajo, Integer> deleteBuilder = helper.getRutaTrabajoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_ruta_consumo", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        RutaTrabajo rutaTrabajo = null;
        try {
            rutaTrabajo = helper.getRutaTrabajoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutaTrabajo;
    }

    public void update(Object item){
        RutaTrabajo object = (RutaTrabajo) item;
        try{
            helper.getRutaTrabajoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
