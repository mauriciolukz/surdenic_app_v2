package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;
import android.util.Log;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Cobro;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 24/8/2018.
 */

public class CobroRepo implements ICrud {

    private DatabaseHelper helper;

    public CobroRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Cobro object = (Cobro) item;
        try {
            index = helper.getCobroDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Cobro cobro = null;
        try {
            cobro = helper.getCobroDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cobro;
    }

    @Override
    public List<?> findAll(){

        List<Cobro> items = null;

        try {
            items =  helper.getCobroDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Cobro, Integer> deleteBuilder = helper.getCobroDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Cobro, Integer> deleteBuilder = helper.getCobroDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Cobro cobro = null;
        try {
            cobro = helper.getCobroDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cobro;
    }

    public void update(Object item){
        Cobro object = (Cobro) item;
        try{
            helper.getCobroDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Cobro> findByIdVendedor(Integer id_vendedor){

        List<Cobro> items = null;

        try {
            items =  helper.getCobroDao().queryBuilder().where().eq("id_vendedor", id_vendedor).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public List<Cobro> getToSendByIdVendedor(Integer id_vendedor){

        List<Cobro> items = null;

        try {
            items =  helper.getCobroDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("send", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public List<Cobro> getSentByIdVendedor(Integer id_vendedor){

        List<Cobro> items = null;

        try {
            items =  helper.getCobroDao().queryBuilder().where().eq("id_vendedor", id_vendedor).and().eq("send", true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public Cobro getByClienteAndVendedor(Integer id_cliente, Integer id_vendedor){
        Cobro cobro;
        boolean exist = false;

        try {
            cobro = helper.getCobroDao().queryBuilder().where().eq("id_cliente", id_cliente).and().eq("id_vendedor", id_vendedor).queryForFirst();

        }catch (SQLException e){
            Log.e("Get cobro", e.getMessage());
            return null;
        }

        return cobro;
    }


    public Cobro getByNumeroFactura(String numeroFactura){
        Cobro cobro;
        boolean exist = false;

        try {
            cobro = helper.getCobroDao().queryBuilder().where().eq("numero_factura", numeroFactura).queryForFirst();

        }catch (SQLException e){
            Log.e("Get cobro", e.getMessage());
            return null;
        }

        return cobro;
    }

    public void deleteByIdVendedor(Integer id_vendedor){
        DeleteBuilder<Cobro, Integer> deleteBuilder = helper.getCobroDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_vendedor", id_vendedor);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
