package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 8/12/2018.
 */

@DatabaseTable(tableName = "Descuento4")
public class Descuento4 {

    @DatabaseField(columnName = "id_cantidad_familia", id=true)
    private String id_cantidad_familia;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "id_familia")
    private String id_familia;

    @DatabaseField(columnName = "cantidad_desde")
    private Integer cantidad_desde;

    @DatabaseField(columnName = "cantidad_hasta")
    private Integer cantidad_hasta;

    @DatabaseField(columnName = "descuento_promo")
    private Double descuento_promo;

    public String getId_cantidad_familia() {
        return id_cantidad_familia;
    }

    public void setId_cantidad_familia(String id_cantidad_familia) {
        this.id_cantidad_familia = id_cantidad_familia;
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

    public Double getDescuento_promo() {
        return descuento_promo;
    }

    public void setDescuento_promo(Double descuento_promo) {
        this.descuento_promo = descuento_promo;
    }
}
