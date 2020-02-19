package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "Pedido")
public class Pedido {

    @DatabaseField(columnName = "id_pedido", generatedId = true)
    private Integer id_pedido;

    @DatabaseField(columnName = "id_vendedor")
    private Integer id_vendedor;

    @DatabaseField(columnName = "id_ruta")
    private Integer id_ruta;

    @DatabaseField(columnName = "id_municipio")
    private int id_municipio;

    @DatabaseField(columnName = "id_departamento")
    private int id_departamento;

    @DatabaseField(columnName = "id_cliente")
    private Integer id_cliente;

    @DatabaseField(columnName = "id_precio")
    private Integer id_precio;

    @DatabaseField(columnName = "factor_incremento")
    private Double factor_incremento;

    @DatabaseField(columnName = "fecha_venta")
    private String fecha_venta;

    @DatabaseField(columnName = "fecha_vencimiento")
    private String fecha_vencimiento;

    @DatabaseField(columnName = "tipo_pago")
    private String tipo_pago;

    @DatabaseField(columnName = "subtotal_venta")
    private Double subtotal_venta;

    @DatabaseField(columnName = "descuento_venta")
    private Double descuento_venta;

    @DatabaseField(columnName = "iva_venta")
    private Double iva_venta;

    @DatabaseField(columnName = "total_factura_venta")
    private Double total_factura_venta;

    @DatabaseField(columnName = "tasa_cambio")
    private Double tasa_cambio;

    @DatabaseField(columnName = "valor_dolares")
    private Double valor_dolares;

    @DatabaseField(columnName = "negociacion_especial")
    private String negociacion_especial;

    @DatabaseField(columnName = "tipo_observacion")
    private String tipo_observacion;

    @DatabaseField(columnName = "send")
    private Boolean send;

    /**/
    @DatabaseField(columnName = "tipo_documento")
    private String tipo_documento;
    @DatabaseField(columnName = "contacto_vendedor")
    private String contacto_vendedor;
    @DatabaseField(columnName = "contacto_cliente")
    private String contacto_cliente;
    @DatabaseField(columnName = "direccion_empresa")
    private String direccion_empresa;
    @DatabaseField(columnName = "pendiente_autorizacion")
    private String pendiente_autorizacion;
    @DatabaseField(columnName = "es_pc")
    private String es_pc;
    @DatabaseField(columnName = "total_iva")
    private Double total_iva;
    @DatabaseField(columnName = "total_sin_iva")
    private Double total_sin_iva;
    @DatabaseField(columnName = "total_fisico")
    private Double total_fisico;
    @DatabaseField(columnName = "utilidad_venta")
    private Double utilidad_venta;
    @DatabaseField(columnName = "valor_dolares_despues")
    private String valor_dolares_despues;
    @DatabaseField(columnName = "total_iva_despues")
    private Double total_iva_despues;
    @DatabaseField(columnName = "total_fisico_despues")
    private Double total_fisico_despues;
    @DatabaseField(columnName = "utilidad_venta_despues")
    private Double utilidad_venta_despues;
    @DatabaseField(columnName = "total_sin_iva_despues")
    private Double total_sin_iva_despues;
    @DatabaseField(columnName = "monto_autorizado")
    private Double monto_autorizado;
    @DatabaseField(columnName = "autoriza")
    private String autoriza;

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Integer id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_precio() {
        return id_precio;
    }

    public void setId_precio(Integer id_precio) {
        this.id_precio = id_precio;
    }

    public Double getFactor_incremento() {
        return factor_incremento;
    }

    public void setFactor_incremento(Double factor_incremento) {
        this.factor_incremento = factor_incremento;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Double getSubtotal_venta() {
        return subtotal_venta;
    }

    public void setSubtotal_venta(Double subtotal_venta) {
        this.subtotal_venta = subtotal_venta;
    }

    public Double getDescuento_venta() {
        return descuento_venta;
    }

    public void setDescuento_venta(Double descuento_venta) {
        this.descuento_venta = descuento_venta;
    }

    public Double getIva_venta() {
        return iva_venta;
    }

    public void setIva_venta(Double iva_venta) {
        this.iva_venta = iva_venta;
    }

    public Double getTotal_factura_venta() {
        return total_factura_venta;
    }

    public void setTotal_factura_venta(Double total_factura_venta) {
        this.total_factura_venta = total_factura_venta;
    }

    public Double getTasa_cambio() {
        return tasa_cambio;
    }

    public void setTasa_cambio(Double tasa_cambio) {
        this.tasa_cambio = tasa_cambio;
    }

    public Double getValor_dolares() {
        return valor_dolares;
    }

    public void setValor_dolares(Double valor_dolares) {
        this.valor_dolares = valor_dolares;
    }

    public String getNegociacion_especial() {
        return negociacion_especial;
    }

    public void setNegociacion_especial(String negociacion_especial) {
        this.negociacion_especial = negociacion_especial;
    }

    public String getTipo_observacion() {
        return tipo_observacion;
    }

    public void setTipo_observacion(String tipo_observacion) {
        this.tipo_observacion = tipo_observacion;
    }

    public Boolean getSend() {
        return send;
    }

    public void setSend(Boolean send) {
        this.send = send;
    }


    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Integer getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Integer id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getContacto_vendedor() {
        return contacto_vendedor;
    }

    public void setContacto_vendedor(String contacto_vendedor) {
        this.contacto_vendedor = contacto_vendedor;
    }

    public String getContacto_cliente() {
        return contacto_cliente;
    }

    public void setContacto_cliente(String contacto_cliente) {
        this.contacto_cliente = contacto_cliente;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public String getPendiente_autorizacion() {
        return pendiente_autorizacion;
    }

    public void setPendiente_autorizacion(String pendiente_autorizacion) {
        this.pendiente_autorizacion = pendiente_autorizacion;
    }

    public String getEs_pc() {
        return es_pc;
    }

    public void setEs_pc(String es_pc) {
        this.es_pc = es_pc;
    }


    public String getValor_dolares_despues() {
        return valor_dolares_despues;
    }

    public void setValor_dolares_despues(String valor_dolares_despues) {
        this.valor_dolares_despues = valor_dolares_despues;
    }


    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public Double getTotal_fisico() {
        return total_fisico;
    }

    public void setTotal_fisico(Double total_fisico) {
        this.total_fisico = total_fisico;
    }

    public Double getTotal_iva_despues() {
        return total_iva_despues;
    }

    public void setTotal_iva_despues(Double total_iva_despues) {
        this.total_iva_despues = total_iva_despues;
    }

    public Double getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(Double total_iva) {
        this.total_iva = total_iva;
    }

    public Double getUtilidad_venta() {
        return utilidad_venta;
    }

    public void setUtilidad_venta(Double utilidad_venta) {
        this.utilidad_venta = utilidad_venta;
    }

    public Double getTotal_sin_iva() {
        return total_sin_iva;
    }

    public void setTotal_sin_iva(Double total_sin_iva) {
        this.total_sin_iva = total_sin_iva;
    }


    public Double getMonto_autorizado() {
        return monto_autorizado;
    }

    public void setMonto_autorizado(Double monto_autorizado) {
        this.monto_autorizado = monto_autorizado;
    }

    public Double getTotal_fisico_despues() {
        return total_fisico_despues;
    }

    public void setTotal_fisico_despues(Double total_fisico_despues) {
        this.total_fisico_despues = total_fisico_despues;
    }

    public Double getUtilidad_venta_despues() {
        return utilidad_venta_despues;
    }

    public void setUtilidad_venta_despues(Double utilidad_venta_despues) {
        this.utilidad_venta_despues = utilidad_venta_despues;
    }

    public Double getTotal_sin_iva_despues() {
        return total_sin_iva_despues;
    }

    public void setTotal_sin_iva_despues(Double total_sin_iva_despues) {
        this.total_sin_iva_despues = total_sin_iva_despues;
    }
}

