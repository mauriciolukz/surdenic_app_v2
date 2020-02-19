package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 4/12/2018.
 */

@DatabaseTable(tableName = "Descuento1")
public class Descuento1 {

    @DatabaseField(columnName = "id_descuento", id=true)
    private String id_descuento;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "id_familia")
    private String id_familia;

    @DatabaseField(columnName = "id_producto_origen")
    private String id_producto_origen;

    @DatabaseField(columnName = "regla_cantidad_desde")
    private Integer regla_cantidad_desde;

    @DatabaseField(columnName = "regla_cantidad_hasta")
    private Integer regla_cantidad_hasta;

    @DatabaseField(columnName = "descuento_promocion")
    private Double descuento_promocion;

    @DatabaseField(columnName = "periodo_trabajo")
    private String periodo_trabajo;

    public String getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(String id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getId_familia() {
        return id_familia;
    }

    public void setId_familia(String id_familia) {
        this.id_familia = id_familia;
    }

    public String getId_producto_origen() {
        return id_producto_origen;
    }

    public void setId_producto_origen(String id_producto_origen) {
        this.id_producto_origen = id_producto_origen;
    }

    public Integer getRegla_cantidad_desde() {
        return regla_cantidad_desde;
    }

    public void setRegla_cantidad_desde(Integer regla_cantidad_desde) {
        this.regla_cantidad_desde = regla_cantidad_desde;
    }

    public Integer getRegla_cantidad_hasta() {
        return regla_cantidad_hasta;
    }

    public void setRegla_cantidad_hasta(Integer regla_cantidad_hasta) {
        this.regla_cantidad_hasta = regla_cantidad_hasta;
    }

    public Double getDescuento_promocion() {
        return descuento_promocion;
    }

    public void setDescuento_promocion(Double descuento_promocion) {
        this.descuento_promocion = descuento_promocion;
    }

    public String getPeriodo_trabajo() {
        return periodo_trabajo;
    }

    public void setPeriodo_trabajo(String periodo_trabajo) {
        this.periodo_trabajo = periodo_trabajo;
    }
}
