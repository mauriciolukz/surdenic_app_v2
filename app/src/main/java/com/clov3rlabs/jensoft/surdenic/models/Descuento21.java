package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 10/12/2018.
 */

@DatabaseTable(tableName = "Descuento21")
public class Descuento21 {

    @DatabaseField(columnName = "id_bonificacion", id=true)
    private String id_bonificacion;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "id_canal")
    private Integer id_canal;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "id_familia_origen")
    private String id_familia_origen;

    @DatabaseField(columnName = "id_producto_origen")
    private String id_producto_origen;

    @DatabaseField(columnName = "id_familia_destino")
    private String id_familia_destino;

    @DatabaseField(columnName = "id_producto_destino")
    private String id_producto_destino;

    @DatabaseField(columnName = "regla_cantidad_desde")
    private Integer regla_cantidad_desde;

    @DatabaseField(columnName = "regla_cantidad_hasta")
    private Integer regla_cantidad_hasta;

    @DatabaseField(columnName = "regla_bonificar")
    private Integer regla_bonificar;

    @DatabaseField(columnName = "descuento_subtotal")
    private Double descuento_subtotal;

    @DatabaseField(columnName = "periodo_trabajo")
    private String periodo_trabajo;


    public String getId_bonificacion() {
        return id_bonificacion;
    }

    public void setId_bonificacion(String id_bonificacion) {
        this.id_bonificacion = id_bonificacion;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Integer getId_canal() {
        return id_canal;
    }

    public void setId_canal(Integer id_canal) {
        this.id_canal = id_canal;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getId_familia_origen() {
        return id_familia_origen;
    }

    public void setId_familia_origen(String id_familia_origen) {
        this.id_familia_origen = id_familia_origen;
    }

    public String getId_producto_origen() {
        return id_producto_origen;
    }

    public void setId_producto_origen(String id_producto_origen) {
        this.id_producto_origen = id_producto_origen;
    }

    public String getId_familia_destino() {
        return id_familia_destino;
    }

    public void setId_familia_destino(String id_familia_destino) {
        this.id_familia_destino = id_familia_destino;
    }

    public String getId_producto_destino() {
        return id_producto_destino;
    }

    public void setId_producto_destino(String id_producto_destino) {
        this.id_producto_destino = id_producto_destino;
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

    public Integer getRegla_bonificar() {
        return regla_bonificar;
    }

    public void setRegla_bonificar(Integer regla_bonificar) {
        this.regla_bonificar = regla_bonificar;
    }

    public Double getDescuento_subtotal() {
        return descuento_subtotal;
    }

    public void setDescuento_subtotal(Double descuento_subtotal) {
        this.descuento_subtotal = descuento_subtotal;
    }

    public String getPeriodo_trabajo() {
        return periodo_trabajo;
    }

    public void setPeriodo_trabajo(String periodo_trabajo) {
        this.periodo_trabajo = periodo_trabajo;
    }
}
