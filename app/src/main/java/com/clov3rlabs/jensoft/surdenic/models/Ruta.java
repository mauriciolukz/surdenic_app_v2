package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


/**
 * Created by rsaavedra on 25/8/2018.
 */

@DatabaseTable(tableName = "Ruta")
public class Ruta {

    @DatabaseField(columnName = "id", id=true)
    private Integer id;

    @DatabaseField(columnName = "id_vendedor")
    private Integer id_vendedor;

    @DatabaseField(columnName = "fecha_hora_inicio")
    private Date fecha_hora_inicio;

    @DatabaseField(columnName = "active")
    private Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Integer id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public Date getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(Date fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
