package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 23/8/2018.
 */


@DatabaseTable(tableName = "RazonVisitaNoExitosa")
public class RazonVisitaNoExitosa {

    @DatabaseField(columnName = "id")
    private Integer id;

    @DatabaseField(columnName = "descripcion")
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
