package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Configuracion;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 22/8/2018.
 */

public class ConfiguracionRepo implements ICrud {

    private DatabaseHelper helper;

    public ConfiguracionRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Configuracion object = (Configuracion) item;
        try {
            index = helper.getConfiguracionDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Configuracion configuracion = null;
        try {
            configuracion = helper.getConfiguracionDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }
        return configuracion;
    }

    @Override
    public List<?> findAll(){

        List<Configuracion> items = null;

        try {
            items =  helper.getConfiguracionDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Configuracion, Integer> deleteBuilder = helper.getConfiguracionDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Configuracion, Integer> deleteBuilder = helper.getConfiguracionDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }
    }

    public Object findFirst(){
        Configuracion configuracion = null;
        try {
            configuracion = helper.getConfiguracionDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }
        return configuracion;
    }

    public void update(Object item){
        Configuracion object = (Configuracion) item;
        try{
            helper.getConfiguracionDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }

    }

    public Configuracion findByIdVendedor(Integer id_vendedor){

        Configuracion configuracion = null;

        try {
            configuracion =  helper.getConfiguracionDao().queryBuilder().where().eq("id_vendedor", id_vendedor).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return configuracion;

    }

    public void deleteByIdVendedor(Integer id_vendedor){
        DeleteBuilder<Configuracion, Integer> deleteBuilder = helper.getConfiguracionDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id_vendedor", id_vendedor);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
        	ex.printStackTrace();
        }
    }


}
