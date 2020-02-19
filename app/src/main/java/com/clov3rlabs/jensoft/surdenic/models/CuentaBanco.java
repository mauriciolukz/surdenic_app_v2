package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 18/9/2018.
 */

@DatabaseTable(tableName = "CuentaBanco")
public class CuentaBanco {

    @DatabaseField(columnName = "id", generatedId = true)
    private Integer id;

    @DatabaseField(columnName = "cuenta_banco")
    private String cuenta_banco;

    @DatabaseField(columnName = "nombre_banco")
    private String nombre_banco;

    @DatabaseField(columnName = "moneda_cuenta")
    private String moneda_cuenta;

    @DatabaseField(columnName = "cta_deposito")
    private String cta_deposito;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuenta_banco() {
        return cuenta_banco;
    }

    public void setCuenta_banco(String cuenta_banco) {
        this.cuenta_banco = cuenta_banco;
    }

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public String getMoneda_cuenta() {
        return moneda_cuenta;
    }

    public void setMoneda_cuenta(String moneda_cuenta) {
        this.moneda_cuenta = moneda_cuenta;
    }

    public String getCta_deposito() {
        return cta_deposito;
    }

    public void setCta_deposito(String cta_deposito) {
        this.cta_deposito = cta_deposito;
    }

    @Override
    public String toString() {
        return cuenta_banco + " - " +nombre_banco;
    }

}
