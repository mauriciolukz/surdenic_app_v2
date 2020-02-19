package com.clov3rlabs.jensoft.surdenic.repo;

import android.content.Context;
import android.util.Log;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;


import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class UsuarioRepo implements ICrud {

    private DatabaseHelper helper;

    public UsuarioRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        Usuario object = (Usuario) item;
        try {
            index = helper.getUsuarioDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        Usuario usuario = null;
        try {
            usuario = helper.getUsuarioDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<?> findAll(){

        List<Usuario> items = null;

        try {
            items =  helper.getUsuarioDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<Usuario, Integer> deleteBuilder = helper.getUsuarioDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<Usuario, Integer> deleteBuilder = helper.getUsuarioDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        Usuario usuario = null;
        try {
            usuario = helper.getUsuarioDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void update(Object item){
        Usuario object = (Usuario) item;
        try{
            helper.getUsuarioDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public boolean autenticar(String nom_usuario, String pass_usuario)
    {

        Usuario usuario;
        boolean exist = false;

        try {
            usuario = helper.getUsuarioDao().queryBuilder().where().eq("user_name", nom_usuario).and().eq("password", pass_usuario).queryForFirst();
            if (usuario != null)
                exist = true;


        }catch (SQLException e){
            Log.e("Autenticando", e.getMessage());
            return false;
        }

        return exist;
    }

    public Usuario getByUserName(String nom_usuario){
        Usuario usuario;
        boolean exist = false;

        try {
            usuario = helper.getUsuarioDao().queryBuilder().where().eq("user_name", nom_usuario).queryForFirst();

        }catch (SQLException e){
            Log.e("Get usuario", e.getMessage());
            return null;
        }

        return usuario;
    }



}
