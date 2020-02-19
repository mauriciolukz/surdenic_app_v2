package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Descuento1;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 4/12/2018.
 */
public class Descuento1Repo implements ICrud {

    private DatabaseHelper helper;

    public Descuento1Repo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Descuento1 object = (Descuento1) item;
        try {
            index = helper.getDescuento1Dao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Descuento1 descuento1 = null;
        try {
            descuento1 = helper.getDescuento1Dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento1;
    }

    @Override
    public List<?> findAll(){

        List<Descuento1> items = null;

        try {
            items =  helper.getDescuento1Dao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Descuento1, Integer> deleteBuilder = helper.getDescuento1Dao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Descuento1, Integer> deleteBuilder = helper.getDescuento1Dao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Descuento1 descuento1 = null;
        try {
            descuento1 = helper.getDescuento1Dao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descuento1;
    }

    public void update(Object item){
        Descuento1 object = (Descuento1) item;
        try{
            helper.getDescuento1Dao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public double obtenerDescuento1(String id_producto, Integer cantidad){
        Descuento1 descuento1 =  null;
        List<Descuento1> descuento1List = null;
        try{
            descuento1List = helper.getDescuento1Dao().queryBuilder().where().eq("id_producto_origen", id_producto).query();

            if (!descuento1List.isEmpty()){

                for (Descuento1 des: descuento1List) {
                    if ((cantidad >= des.getRegla_cantidad_desde()) && (cantidad <= des.getRegla_cantidad_hasta())){
                        descuento1 = des;
                        break;
                    }
                }

            }
            
            if (descuento1 != null){
                return descuento1.getDescuento_promocion();
            }
            else{
                return 0.00;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return 0.00;
    }




}
