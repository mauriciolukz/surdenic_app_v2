package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 9/10/2018.
 */


public class ProductoRepo implements ICrud {

    private DatabaseHelper helper;

    public ProductoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Producto object = (Producto) item;
        try {
            index = helper.getProductoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Producto producto = null;
        try {
            producto = helper.getProductoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public List<?> findAll(){

        List<Producto> items = null;

        try {
            items =  helper.getProductoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Producto, Integer> deleteBuilder = helper.getProductoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Producto, Integer> deleteBuilder = helper.getProductoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_producto", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Producto producto = null;
        try {
            producto = helper.getProductoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    public void update(Object item){
        Producto object = (Producto) item;
        try{
            helper.getProductoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Producto findByIdProducto(String id_producto){
        Producto producto = null;
        try {
            producto = helper.getProductoDao().queryBuilder().where().eq("id_producto", id_producto).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }


    public List<Producto> findNOBonificados(){

        List<Producto> items = null;

        try {
            items =  helper.getProductoDao().queryBuilder().orderBy("id_proveedor", true).orderBy("id_familia", true).orderBy("id_producto", true).where().eq("bonificado", "N").query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }



}
