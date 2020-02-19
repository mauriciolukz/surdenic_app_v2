package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Factura")
public class Factura {

    @DatabaseField(columnName = "id_registro", id=true)
    private Integer id_registro;

    @DatabaseField(columnName = "id_cliente")
    private Integer id_cliente;

    @DatabaseField(columnName = "contacto_cliente")
    private String contacto_cliente;

    @DatabaseField(columnName = "id_vendedor")
    private Integer id_vendedor;

    @DatabaseField(columnName = "contacto_vendedor")
    private String contacto_vendedor;

    @DatabaseField(columnName = "id_ruta")
    private Integer id_ruta;

    @DatabaseField(columnName = "num_factura")
    private String num_factura;

    @DatabaseField(columnName = "tipo_documento")
    private String tipo_documento;

    @DatabaseField(columnName = "fecha_factura")
    private String fecha_factura;

    @DatabaseField(columnName = "fecha_vence")
    private String fecha_vence;

    @DatabaseField(columnName = "total_facturado")
    private Double total_facturado;

    @DatabaseField(columnName = "monto_nd")
    private Double monto_nd;

    @DatabaseField(columnName = "monto_nc")
    private Double monto_nc;

    @DatabaseField(columnName = "total_vendido")
    private Double total_vendido;

    @DatabaseField(columnName = "monto_abonado")
    private Double monto_abonado;

    @DatabaseField(columnName = "monto_pc")
    private Double monto_pc;


    public Integer getId_registro() {
        return id_registro;
    }

    public void setId_registro(Integer id_registro) {
        this.id_registro = id_registro;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getContacto_cliente() {
        return contacto_cliente;
    }

    public void setContacto_cliente(String contacto_cliente) {
        this.contacto_cliente = contacto_cliente;
    }

    public Integer getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Integer id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getContacto_vendedor() {
        return contacto_vendedor;
    }

    public void setContacto_vendedor(String contacto_vendedor) {
        this.contacto_vendedor = contacto_vendedor;
    }

    public Integer getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Integer id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(String num_factura) {
        this.num_factura = num_factura;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getFecha_vence() {
        return fecha_vence;
    }

    public void setFecha_vence(String fecha_vence) {
        this.fecha_vence = fecha_vence;
    }

    public Double getTotal_vendido() {
        return total_vendido;
    }

    public void setTotal_vendido(Double total_vendido) {
        this.total_vendido = total_vendido;
    }

    public Double getMonto_abonado() {
        return monto_abonado;
    }

    public void setMonto_abonado(Double monto_abonado) {
        this.monto_abonado = monto_abonado;
    }

    public Double getMonto_pc() {
        return monto_pc;
    }

    public void setMonto_pc(Double monto_pc) {
        this.monto_pc = monto_pc;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Double getTotal_facturado() {
        return total_facturado;
    }

    public void setTotal_facturado(Double total_facturado) {
        this.total_facturado = total_facturado;
    }

    public Double getMonto_nd() {
        return monto_nd;
    }

    public void setMonto_nd(Double monto_nd) {
        this.monto_nd = monto_nd;
    }

    public Double getMonto_nc() {
        return monto_nc;
    }

    public void setMonto_nc(Double monto_nc) {
        this.monto_nc = monto_nc;
    }

    @Override
    public String toString() {

        return  this.getNum_factura() + " " + this.contacto_cliente ;

    }
}
