package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 5/12/2018.
 */

@DatabaseTable(tableName = "Descuento7")
public class Descuento7 {

    @DatabaseField(columnName = "id_descuento_cliente_proveedor", id=true)
    private String id_descuento_cliente_proveedor;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "monto_desde")
    private Double monto_desde;

    @DatabaseField(columnName = "monto_hasta")
    private Double monto_hasta;

    @DatabaseField(columnName = "descuento_subtotal")
    private Double descuento_subtotal;

    public String getId_descuento_cliente_proveedor() {
        return id_descuento_cliente_proveedor;
    }

    public void setId_descuento_cliente_proveedor(String id_descuento_cliente_proveedor) {
        this.id_descuento_cliente_proveedor = id_descuento_cliente_proveedor;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
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

    public Double getDescuento_subtotal() {
        return descuento_subtotal;
    }

    public void setDescuento_subtotal(Double descuento_subtotal) {
        this.descuento_subtotal = descuento_subtotal;
    }
}
