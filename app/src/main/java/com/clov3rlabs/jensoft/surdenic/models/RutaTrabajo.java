package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 22/8/2018.
 */

@DatabaseTable(tableName = "RutaTrabajo")
public class RutaTrabajo {

    @DatabaseField(columnName = "id_ruta_consumo", id=true)
    private Integer id_ruta_consumo;

    @DatabaseField(columnName = "nombre_ruta_consumo")
    private String nombre_ruta_consumo;

    @DatabaseField(columnName = "id_departamento")
    private Integer id_departamento;

    @DatabaseField(columnName = "id_ciudad")
    private Integer id_ciudad;

    public Integer getId_ruta_consumo() {
        return id_ruta_consumo;
    }

    public void setId_ruta_consumo(Integer id_ruta_consumo) {
        this.id_ruta_consumo = id_ruta_consumo;
    }

    public String getNombre_ruta_consumo() {
        return nombre_ruta_consumo;
    }

    public void setNombre_ruta_consumo(String nombre_ruta_consumo) {
        this.nombre_ruta_consumo = nombre_ruta_consumo;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}
