package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 10/12/2018.
 */

@DatabaseTable(tableName = "Descuento15")
public class Descuento15 {

    @DatabaseField(columnName = "id_promo", id=true)
    private String id_promo;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "code_promo")
    private String code_promo;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "id_familia_1")
    private String id_familia_1;

    @DatabaseField(columnName = "id_producto_1")
    private String id_producto_1;

    @DatabaseField(columnName = "cantidad_regla_1")
    private Integer cantidad_regla_1;

    @DatabaseField(columnName = "id_familia_2")
    private String id_familia_2;

    @DatabaseField(columnName = "id_producto_2")
    private String id_producto_2;

    @DatabaseField(columnName = "cantidad_regla_2")
    private Integer cantidad_regla_2;

    @DatabaseField(columnName = "descuento_promo")
    private Double descuento_promo;

    @DatabaseField(columnName = "id_familia_3")
    private String id_familia_3;

    @DatabaseField(columnName = "id_producto_3")
    private String id_producto_3;

    @DatabaseField(columnName = "cantidad_boni")
    private Integer cantidad_boni;

    public String getId_promo() {
        return id_promo;
    }

    public void setId_promo(String id_promo) {
        this.id_promo = id_promo;
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

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getId_familia_1() {
        return id_familia_1;
    }

    public void setId_familia_1(String id_familia_1) {
        this.id_familia_1 = id_familia_1;
    }

    public String getId_producto_1() {
        return id_producto_1;
    }

    public void setId_producto_1(String id_producto_1) {
        this.id_producto_1 = id_producto_1;
    }

    public Integer getCantidad_regla_1() {
        return cantidad_regla_1;
    }

    public void setCantidad_regla_1(Integer cantidad_regla_1) {
        this.cantidad_regla_1 = cantidad_regla_1;
    }

    public String getId_familia_2() {
        return id_familia_2;
    }

    public void setId_familia_2(String id_familia_2) {
        this.id_familia_2 = id_familia_2;
    }

    public String getId_producto_2() {
        return id_producto_2;
    }

    public void setId_producto_2(String id_producto_2) {
        this.id_producto_2 = id_producto_2;
    }

    public Integer getCantidad_regla_2() {
        return cantidad_regla_2;
    }

    public void setCantidad_regla_2(Integer cantidad_regla_2) {
        this.cantidad_regla_2 = cantidad_regla_2;
    }

    public Double getDescuento_promo() {
        return descuento_promo;
    }

    public void setDescuento_promo(Double descuento_promo) {
        this.descuento_promo = descuento_promo;
    }

    public String getId_familia_3() {
        return id_familia_3;
    }

    public void setId_familia_3(String id_familia_3) {
        this.id_familia_3 = id_familia_3;
    }

    public String getId_producto_3() {
        return id_producto_3;
    }

    public void setId_producto_3(String id_producto_3) {
        this.id_producto_3 = id_producto_3;
    }

    public Integer getCantidad_boni() {
        return cantidad_boni;
    }

    public void setCantidad_boni(Integer cantidad_boni) {
        this.cantidad_boni = cantidad_boni;
    }
}
