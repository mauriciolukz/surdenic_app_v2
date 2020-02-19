package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "TasaCambio")
public class TasaCambio {

    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField(columnName = "fecha_tasa")
    private String fecha_tasa;

    @DatabaseField(columnName = "tasa_cambio_dia")
    private double tasa_cambio_dia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_tasa() {
        return fecha_tasa;
    }

    public void setFecha_tasa(String fecha_tasa) {
        this.fecha_tasa = fecha_tasa;
    }

    public Double getTasa_cambio_dia() {
        return tasa_cambio_dia;
    }

    public void setTasa_cambio_dia(Double tasa_cambio_dia) {
        this.tasa_cambio_dia = tasa_cambio_dia;
    }
}
