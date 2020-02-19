package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.TipoPago;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 22/8/2018.
 */

public class TipoPagoRepo implements ICrud {

    private DatabaseHelper helper;

    public TipoPagoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        TipoPago object = (TipoPago) item;
        try {
            index = helper.getTipoPagoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        TipoPago tipoPago = null;
        try {
            tipoPago = helper.getTipoPagoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoPago;
    }

    @Override
    public List<?> findAll(){

        List<TipoPago> items = null;

        try {
            items =  helper.getTipoPagoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<TipoPago, Integer> deleteBuilder = helper.getTipoPagoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<TipoPago, Integer> deleteBuilder = helper.getTipoPagoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_tipo", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        TipoPago tipoPago = null;
        try {
            tipoPago = helper.getTipoPagoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoPago;
    }

    public void update(Object item){
        TipoPago object = (TipoPago) item;
        try{
            helper.getTipoPagoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


}
