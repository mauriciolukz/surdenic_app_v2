package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 8/12/2018.
 */

@DatabaseTable(tableName = "Descuento3")
public class Descuento3 {

    @DatabaseField(columnName = "id_multi_promocion", id=true)
    private String id_multi_promocion;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "id_familia")
    private String id_familia;

    @DatabaseField(columnName = "monto_desde")
    private Double monto_desde;

    @DatabaseField(columnName = "monto_hasta")
    private Double monto_hasta;

    @DatabaseField(columnName = "descuento_promo")
    private Double descuento_promo;

    public String getId_multi_promocion() {
        return id_multi_promocion;
    }

    public void setId_multi_promocion(String id_multi_promocion) {
        this.id_multi_promocion = id_multi_promocion;
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

    public Double getMonto_desde() {
        return monto_desde;
    }

    public void setMonto_desde(Double monto_desde) {
        this.monto_desde = monto_desde;
    }

    public Double getMonto_hasta() {
        return monto_hasta;
    }

    public void setMonto_hasta(Double monto_hasta) {
        this.monto_hasta = monto_hasta;
    }

    public Double getDescuento_promo() {
        return descuento_promo;
    }

    public void setDescuento_promo(Double descuento_promo) {
        this.descuento_promo = descuento_promo;
    }
}
