package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 10/12/2018.
 */

@DatabaseTable(tableName = "Descuento13")
public class Descuento13 {

    @DatabaseField(columnName = "id_bonif_desc", id=true)
    private String id_bonif_desc;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "code_promo")
    private String code_promo;

    @DatabaseField(columnName = "regla_desde")
    private Integer regla_desde;

    @DatabaseField(columnName = "regla_hasta")
    private Integer regla_hasta;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "id_familia")
    private String id_familia;

    @DatabaseField(columnName = "id_producto")
    private String id_producto;

    @DatabaseField(columnName = "cantidad_bonificar")
    private Double cantidad_bonificar;

    @DatabaseField(columnName = "descuento_subtotal")
    private Double descuento_subtotal;

    @DatabaseField(columnName = "periodo_trabajo")
    private String periodo_trabajo;

    @DatabaseField(columnName = "combos_boni_rangos")
    private String combos_boni_rangos;

    public String getId_bonif_desc() {
        return id_bonif_desc;
    }

    public void setId_bonif_desc(String id_bonif_desc) {
        this.id_bonif_desc = id_bonif_desc;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getCode_promo() {
        return code_promo;
    }

    public void setCode_promo(String code_promo) {
        this.code_promo = code_promo;
    }

    public Integer getRegla_desde() {
        return regla_desde;
    }

    public void setRegla_desde(Integer regla_desde) {
        this.regla_desde = regla_desde;
    }

    public Integer getRegla_hasta() {
        return regla_hasta;
    }

    public void setRegla_hasta(Integer regla_hasta) {
        this.regla_hasta = regla_hasta;
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

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public Double getCantidad_bonificar() {
        return cantidad_bonificar;
    }

    public void setCantidad_bonificar(Double cantidad_bonificar) {
        this.cantidad_bonificar = cantidad_bonificar;
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

    public String getCombos_boni_rangos() {
        return combos_boni_rangos;
    }

    public void setCombos_boni_rangos(String combos_boni_rangos) {
        this.combos_boni_rangos = combos_boni_rangos;
    }
}
