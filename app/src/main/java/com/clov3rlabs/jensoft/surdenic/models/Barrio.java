package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 13/9/2018.
 */

@DatabaseTable(tableName = "Barrio")
public class Barrio {

    @DatabaseField(columnName = "id_barrio", id=true)
    private Integer id_barrio;

    @DatabaseField(columnName = "nombre_barrio")
    private String nombre_barrio;

    @DatabaseField(columnName = "id_departamento")
    private Integer id_departamento;

    @DatabaseField(columnName = "id_municipio")
    private Integer id_municipio;

    public Integer getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(Integer id_barrio) {
        this.id_barrio = id_barrio;
    }

    public String getNombre_barrio() {
        return nombre_barrio;
    }

    public void setNombre_barrio(String nombre_barrio) {
        this.nombre_barrio = nombre_barrio;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }
}
