package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 8/12/2018.
 */

@DatabaseTable(tableName = "Descuento11")
public class Descuento11 {

    @DatabaseField(columnName = "id_promo", id=true)
    private String id_promo;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "code_promo")
    private String code_promo;

    @DatabaseField(columnName = "cantidad_desde")
    private Integer cantidad_desde;

    @DatabaseField(columnName = "cantidad_hasta")
    private Integer cantidad_hasta;

    @DatabaseField(columnName = "descuento_code")
    private Double descuento_code;

    @DatabaseField(columnName = "id_promo_m")
    private String id_promo_m;

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

    public Integer getCantidad_desde() {
        return cantidad_desde;
    }

    public void setCantidad_desde(Integer cantidad_desde) {
        this.cantidad_desde = cantidad_desde;
    }

    public Integer getCantidad_hasta() {
        return cantidad_hasta;
    }

    public void setCantidad_hasta(Integer cantidad_hasta) {
        this.cantidad_hasta = cantidad_hasta;
    }

    public Double getDescuento_code() {
        return descuento_code;
    }

    public void setDescuento_code(Double descuento_code) {
        this.descuento_code = descuento_code;
    }

    public String getId_promo_m() {
        return id_promo_m;
    }

    public void setId_promo_m(String id_promo_m) {
        this.id_promo_m = id_promo_m;
    }
}
