package com.clov3rlabs.jensoft.surdenic.repo;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.db.DatabaseHelper;
import com.clov3rlabs.jensoft.surdenic.db.DatabaseManager;
import com.clov3rlabs.jensoft.surdenic.models.CuentaBanco;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rsaavedra on 18/9/2018.
 */

public class CuentaBancoRepo implements ICrud {

    private DatabaseHelper helper;

    public CuentaBancoRepo(Context context)
    {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item){
        int index = -1;

        CuentaBanco object = (CuentaBanco) item;
        try {
            index = helper.getCuentBancoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(Integer id){
        CuentaBanco cobro = null;
        try {
            cobro = helper.getCuentBancoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cobro;
    }

    @Override
    public List<?> findAll(){

        List<CuentaBanco> items = null;

        try {
            items =  helper.getCuentBancoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    @Override
    public void deleteAll(){
        DeleteBuilder<CuentaBanco, Integer> deleteBuilder = helper.getCuentBancoDao().deleteBuilder();
        try{
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){
        DeleteBuilder<CuentaBanco, Integer> deleteBuilder = helper.getCuentBancoDao().deleteBuilder();
        try{
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object findFirst(){
        CuentaBanco cuentaBanco = null;
        try {
            cuentaBanco = helper.getCuentBancoDao().queryBuilder().queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuentaBanco;
    }

    public void update(Object item){
        CuentaBanco object = (CuentaBanco) item;
        try{
            helper.getCuentBancoDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<CuentaBanco> findCuentasCheque(){

        List<CuentaBanco> items = null;
        try {
            items =  helper.getCuentBancoDao().queryBuilder().where().eq("cta_deposito", "N").query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public List<CuentaBanco> findCuentasDeposito(){

        List<CuentaBanco> items = null;
        try {
            items =  helper.getCuentBancoDao().queryBuilder().where().eq("cta_deposito", "S").query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    public CuentaBanco findByCuenta(String cuenta){
        CuentaBanco cuentaBanco = null;
        try {
            cuentaBanco = helper.getCuentBancoDao().queryBuilder().where().eq("cuenta_banco", cuenta).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuentaBanco;
    }


}
