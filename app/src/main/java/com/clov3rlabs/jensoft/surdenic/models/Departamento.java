package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 22/8/2018.
 */


@DatabaseTable(tableName = "Departamento")
public class Departamento {

    @DatabaseField(columnName = "id_departamento", id=true)
    private Integer id_departamento;

    @DatabaseField(columnName = "nombre_departamento")
    private String nombre_departamento;

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }
}
