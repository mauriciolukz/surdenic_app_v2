package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Usuario")
public class Usuario {

    @DatabaseField(columnName = "id_vendedor", id=true)
    private int id_vendedor;

    @DatabaseField(columnName = "contacto_vendedor")
    private String contacto_vendedor;

    @DatabaseField(columnName = "api_key")
    private String api_key;

    @DatabaseField(columnName = "ruta_trabajo")
    private int ruta_trabajo;

    @DatabaseField(columnName = "fecha_login")
    private Date fecha_login;

    @DatabaseField(columnName = "user_name")
    private String user_name;

    @DatabaseField(columnName = "password")
    private String password;

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getContacto_vendedor() {
        return contacto_vendedor;
    }

    public void setContacto_vendedor(String contacto_vendedor) {
        this.contacto_vendedor = contacto_vendedor;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public int getRuta_trabajo() {
        return ruta_trabajo;
    }

    public void setRuta_trabajo(int ruta_trabajo) {
        this.ruta_trabajo = ruta_trabajo;
    }

    public Date getFecha_login() {
        return fecha_login;
    }

    public void setFecha_login(Date fecha_login) {
        this.fecha_login = fecha_login;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
