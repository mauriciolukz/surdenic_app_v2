package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 22/8/2018.
 */

@DatabaseTable(tableName = "CanalDistribucion")
public class CanalDistribucion {

    @DatabaseField(columnName = "id_canal_distribucion", id=true)
    private Integer id_canal_distribucion;

    @DatabaseField(columnName = "nombre_canal")
    private String nombre_canal;

    public Integer getId_canal_distribucion() {
        return id_canal_distribucion;
    }

    public void setId_canal_distribucion(Integer id_canal_distribucion) {
        this.id_canal_distribucion = id_canal_distribucion;
    }

    public String getNombre_canal() {
        return nombre_canal;
    }

    public void setNombre_canal(String nombre_canal) {
        this.nombre_canal = nombre_canal;
    }
}
