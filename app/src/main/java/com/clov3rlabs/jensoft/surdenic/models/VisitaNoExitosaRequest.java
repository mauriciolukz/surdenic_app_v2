package com.clov3rlabs.jensoft.surdenic.models;

public class VisitaNoExitosaRequest{

    private Integer id_cliente;

    private Integer id_vendedor;

    private Integer id_ruta_trabajo;

    private String fecha_registro;

    private String razon_visita_no_exitosa;

    private String observaciones_visita;

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

    public String getRazon_visita_no_exitosa() {
        return razon_visita_no_exitosa;
    }

    public void setRazon_visita_no_exitosa(String razon_visita_no_exitosa) {
        this.razon_visita_no_exitosa = razon_visita_no_exitosa;
    }

    public String getObservaciones_visita() {
        return observaciones_visita;
    }

    public void setObservaciones_visita(String observaciones_visita) {
        this.observaciones_visita = observaciones_visita;
    }
}