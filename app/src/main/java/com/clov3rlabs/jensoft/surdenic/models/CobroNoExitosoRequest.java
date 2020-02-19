package com.clov3rlabs.jensoft.surdenic.models;

public class CobroNoExitosoRequest {

    private Integer id_cliente;

    private String tipo_cliente;

    private Integer id_vendedor;

    private Integer id_ruta_trabajo;

    private String num_factura;

    private String tipo_documento;

    private String fecha_factura;

    private Double monto_pc;

    private String fecha_registro;

    private String razon_cobro_no_exitoso;

    private String observaciones_cobro;

    public Integer getId_cliente() {
        return id_cliente;
    }

    private Double monto_total_credito;

    private Double notas_debitos;

    private Double notas_creditos;

    private Double abonos_creditos;

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

    public String getRazon_cobro_no_exitoso() {
        return razon_cobro_no_exitoso;
    }

    public void setRazon_cobro_no_exitoso(String razon_cobro_no_exitoso) {
        this.razon_cobro_no_exitoso = razon_cobro_no_exitoso;
    }

    public String getObservaciones_cobro() {
        return observaciones_cobro;
    }

    public void setObservaciones_cobro(String observaciones_cobro) {
        this.observaciones_cobro = observaciones_cobro;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(String num_factura) {
        this.num_factura = num_factura;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public Double getMonto_pc() {
        return monto_pc;
    }

    public void setMonto_pc(Double monto_pc) {
        this.monto_pc = monto_pc;
    }


    public Double getNotas_debitos() {
        return notas_debitos;
    }

    public void setNotas_debitos(Double notas_debitos) {
        this.notas_debitos = notas_debitos;
    }

    public Double getNotas_creditos() {
        return notas_creditos;
    }

    public void setNotas_creditos(Double notas_creditos) {
        this.notas_creditos = notas_creditos;
    }

    public Double getMonto_total_credito() {
        return monto_total_credito;
    }

    public void setMonto_total_credito(Double monto_total_credito) {
        this.monto_total_credito = monto_total_credito;
    }

    public Double getAbonos_creditos() {
        return abonos_creditos;
    }

    public void setAbonos_creditos(Double abonos_creditos) {
        this.abonos_creditos = abonos_creditos;
    }
}
