package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;

import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepo implements ICrud {

    private DatabaseHelper helper;

    public FacturaRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Factura object = (Factura) item;
        try {
            index = helper.getFacturaDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Factura factura = null;
        try {
            factura = helper.getFacturaDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return factura;
    }

    @Override
    public List<?> findAll(){

        List<Factura> items = null;

        try {
            items =  helper.getFacturaDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Factura, Integer> deleteBuilder = helper.getFacturaDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Factura, Integer> deleteBuilder = helper.getFacturaDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_registro", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Factura factura = null;
        try {
            factura = helper.getFacturaDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return factura;
    }

    public void update(Object item){
        Factura object = (Factura) item;
        try{
            helper.getFacturaDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Factura> findByIdCliente(Integer id_cliente){

        List<Factura> items = new ArrayList<>();

        try {
            items =  helper.getFacturaDao().queryBuilder().where().eq("id_cliente",id_cliente).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public List<Factura> findByIdVendedor(Integer id_vendedor){

        List<Factura> items = null;

        try {
            items =  helper.getFacturaDao().queryBuilder().where().eq("id_vendedor", id_vendedor).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public void deleteByIdVendedor(Integer id_vendedor){
        DeleteBuilder<Factura, Integer> deleteBuilder = helper.getFacturaDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_vendedor", id_vendedor);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
