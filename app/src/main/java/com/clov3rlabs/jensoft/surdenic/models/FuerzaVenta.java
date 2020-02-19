package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 22/8/2018.
 */

@DatabaseTable(tableName = "FuerzaVenta")
public class FuerzaVenta {

    @DatabaseField(columnName = "id_fuerza", id=true)
    private Integer id_fuerza;

    @DatabaseField(columnName = "nombre_fuerza")
    private String nombre_fuerza;

    public Integer getId_fuera() {
        return id_fuerza;
    }

    public void setId_fuerza(Integer id_fuerzaa) {
        this.id_fuerza = id_fuerza;
    }

    public String getNombre_fuerza() {
        return nombre_fuerza;
    }

    public void setNombre_fuerza(String nombre_fuerza) {
        this.nombre_fuerza = nombre_fuerza;
    }
}
