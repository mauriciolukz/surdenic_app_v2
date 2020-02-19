package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 22/8/2018.
 */

@DatabaseTable(tableName = "Municipio")
public class Municipio {

    @DatabaseField(columnName = "id_municipio", id=true)
    private Integer id_municipio;

    @DatabaseField(columnName = "id_departamento")
    private Integer id_departamento;

    @DatabaseField(columnName = "nombre_municipio")
    private String nombre_municipio;

    @DatabaseField(columnName = "id_precio")
    private Integer id_precio;

    @DatabaseField(columnName = "nom_precio")
    private String nom_precio;

    @DatabaseField(columnName = "factor_precio")
    private double factor_precio;

    @DatabaseField(columnName = "tipo_documento")
    private String tipo_documento;

    @DatabaseField(columnName = "id_ruta_consumo")
    private Integer id_ruta_consumo;

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

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

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Integer getId_ruta_consumo() {
        return id_ruta_consumo;
    }

    public void setId_ruta_consumo(Integer id_ruta_consumo) {
        this.id_ruta_consumo = id_ruta_consumo;
    }
}
