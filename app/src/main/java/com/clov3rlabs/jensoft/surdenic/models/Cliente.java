package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Cliente")
public class Cliente {

    @DatabaseField(columnName = "id_cliente", id=true)
    private Integer id_cliente;

    @DatabaseField(columnName = "fecha_alta")
    private String fecha_alta;

    @DatabaseField(columnName = "cedula_identidad")
    private String cedula_identidad;

    @DatabaseField(columnName = "contacto_cliente")
    private String contacto_cliente;

    @DatabaseField(columnName = "nombre_empresa")
    private String nombre_empresa;

    @DatabaseField(columnName = "direccion_empresa")
    private String direccion_empresa;

    @DatabaseField(columnName = "telefono")
    private String telefono;

    @DatabaseField(columnName = "tipo_cliente")
    private String tipo_cliente;

    @DatabaseField(columnName = "limite_credito")
    private double limite_credito;

    @DatabaseField(columnName = "dias_credito")
    private Integer dias_credito;

    @DatabaseField(columnName = "balance_actual")
    private double balance_actual;

    @DatabaseField(columnName = "estado_cliente")
    private String estado_cliente;

    @DatabaseField(columnName = "id_vendedor")
    private Integer id_vendedor;

    @DatabaseField(columnName = "id_ruta_consumo")
    private Integer id_ruta_consumo;

    @DatabaseField(columnName = "id_fuerza")
    private Integer id_fuerza;

    @DatabaseField(columnName = "id_canal_distribucion")
    private Integer id_canal_distribucion;

    @DatabaseField(columnName = "id_departamento")
    private Integer id_departamento;

    @DatabaseField(columnName = "id_municipio")
    private Integer id_municipio;

    @DatabaseField(columnName = "id_barrio")
    private Integer id_barrio;

    @DatabaseField(columnName = "factor_incremento")
    private double factor_incremento;

    @DatabaseField(columnName = "negocio_activo")
    private String negocio_activo;

    @DatabaseField(columnName = "nota_cliente")
    private String nota_cliente;

    @DatabaseField(columnName = "tipo_documento")
    private String tipo_documento;

    @DatabaseField(columnName = "dia_visita")
    private String dia_visita;

    @DatabaseField(columnName = "sincronizado")
    private Boolean IsSync;

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getCedula_identidad() {
        return cedula_identidad;
    }

    public void setCedula_identidad(String cedula_identidad) {
        this.cedula_identidad = cedula_identidad;
    }

    public String getContacto_cliente() {
        return contacto_cliente;
    }

    public void setContacto_cliente(String contacto_cliente) {
        this.contacto_cliente = contacto_cliente;
    }

    public String getNombre_empresa() {
        if (nombre_empresa == null || nombre_empresa.isEmpty())
            return "N/A";
        else
            return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDireccion_empresa() {
        if (direccion_empresa == null || direccion_empresa.isEmpty())
            return "N/A";
        else
            return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(double limite_credito) {
        this.limite_credito = limite_credito;
    }

    public Integer getDias_credito() {
        return dias_credito;
    }

    public void setDias_credito(Integer dias_credito) {
        this.dias_credito = dias_credito;
    }

    public double getBalance_actual() {
        return balance_actual;
    }

    public void setBalance_actual(double balance_actual) {
        this.balance_actual = balance_actual;
    }

    public String getEstado_cliente() {
        return estado_cliente;
    }

    public void setEstado_cliente(String estado_cliente) {
        this.estado_cliente = estado_cliente;
    }

    public Integer getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Integer id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public Integer getId_ruta_consumo() {
        return id_ruta_consumo;
    }

    public void setId_ruta_consumo(Integer id_ruta_consumo) {
        this.id_ruta_consumo = id_ruta_consumo;
    }

    public Integer getId_fuerza() {
        return id_fuerza;
    }

    public void setId_fuerza(Integer id_fuerza) {
        this.id_fuerza = id_fuerza;
    }

    public Integer getId_canal_distribucion() {
        return id_canal_distribucion;
    }

    public void setId_canal_distribucion(Integer id_canal_distribucion) {
        this.id_canal_distribucion = id_canal_distribucion;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public Integer getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(Integer id_barrio) {
        this.id_barrio = id_barrio;
    }

    public double getFactor_incremento() {
        return factor_incremento;
    }

    public void setFactor_incremento(double factor_incremento) {
        this.factor_incremento = factor_incremento;
    }

    public String getNegocio_activo() {
        return negocio_activo;
    }

    public void setNegocio_activo(String negocio_activo) {
        this.negocio_activo = negocio_activo;
    }

    public String getNota_cliente() {
        return nota_cliente;
    }

    public void setNota_cliente(String nota_cliente) {
        this.nota_cliente = nota_cliente;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDia_visita() {
        return dia_visita;
    }

    public void setDia_visita(String dia_visita) {
        this.dia_visita = dia_visita;
    }

    @Override
    public String toString() {

        return  this.getId_cliente().toString() + " " + this.contacto_cliente ;

    }

    public Boolean getSync() {
        return IsSync;
    }

    public void setSync(Boolean sync) {
        IsSync = sync;
    }
}
