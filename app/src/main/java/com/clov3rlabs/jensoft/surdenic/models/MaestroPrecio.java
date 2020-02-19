package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 22/8/2018.
 */

@DatabaseTable(tableName = "MaestroPrecio")
public class MaestroPrecio {

    @DatabaseField(columnName = "id_precio", id=true)
    private Integer id_precio;

    @DatabaseField(columnName = "nom_precio")
    private String nom_precio;

    @DatabaseField(columnName = "factor_precio")
    private double factor_precio;

    public Integer getId_precio() {
        return id_precio;
    }

    public void setId_precio(Integer id_precio) {
        this.id_precio = id_precio;
    }

    public String getNom_precio() {
        return nom_precio;
    }

    public void setNom_precio(String nom_precio) {
        this.nom_precio = nom_precio;
    }

    public double getFactor_precio() {
        return factor_precio;
    }

    public void setFactor_precio(double factor_precio) {
        this.factor_precio = factor_precio;
    }
}
