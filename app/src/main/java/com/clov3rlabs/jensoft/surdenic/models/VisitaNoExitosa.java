package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "VisitaNoExitoso")
public class VisitaNoExitosa {

    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField(columnName = "id_cliente")
    private Integer id_cliente;

    @DatabaseField(columnName = "id_vendedor")
    private Integer id_vendedor;

    @DatabaseField(columnName = "id_ruta_trabajo")
    private Integer id_ruta_trabajo;

    @DatabaseField(columnName = "fecha_registro")
    private String fecha_registro;

    @DatabaseField(columnName = "razon_visita_no_exitoso")
    private String razon_visita_no_exitoso;

    @DatabaseField(columnName = "observaciones_cobro")
    private String observaciones_visita;

    @DatabaseField(columnName = "send")
    private Boolean send;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Integer id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public Integer getId_ruta_trabajo() {
        return id_ruta_trabajo;
    }

    public void setId_ruta_trabajo(Integer id_ruta_trabajo) {
        this.id_ruta_trabajo = id_ruta_trabajo;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getRazon_visita_no_exitoso() {
        return razon_visita_no_exitoso;
    }

    public void setRazon_visita_no_exitoso(String razon_cobro_no_exitoso) {
        this.razon_visita_no_exitoso = razon_cobro_no_exitoso;
    }

    public String getObservaciones_visita() {
        return observaciones_visita;
    }

    public void setObservaciones_visita(String observaciones_visita) {
        this.observaciones_visita = observaciones_visita;
    }

    public Boolean getSend() {
        return send;
    }

    public void setSend(Boolean send) {
        this.send = send;
    }
}
