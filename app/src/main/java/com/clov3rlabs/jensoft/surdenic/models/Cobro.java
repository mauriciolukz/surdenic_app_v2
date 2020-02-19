package com.clov3rlabs.jensoft.surdenic.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 24/8/2018.
 */

@DatabaseTable(tableName = "Cobro")
public class Cobro {

    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField(columnName = "id_cliente")
    private Integer id_cliente;

    @DatabaseField(columnName = "id_vendedor")
    private Integer id_vendedor;

    @DatabaseField(columnName = "id_ruta")
    private Integer id_ruta;

    @DatabaseField(columnName = "numero_factura")
    private String numero_factura;

    @DatabaseField(columnName = "monto_pc")
    private Double monto_pc;

    @DatabaseField(columnName = "fecha_factura")
    private String fecha_factura;

    @DatabaseField(columnName = "fecha_cobro_realizado")
    private String fecha_cobro_realizado;

    @DatabaseField(columnName = "monto_abonado")
    private Double monto_abonado;

    @DatabaseField(columnName = "forma_pago")
    private Integer forma_pago;

    @DatabaseField(columnName = "numero_recibo")
    private String numero_recibo;

    @DatabaseField(columnName = "cta_deposito")
    private String cta_deposito;

    @DatabaseField(columnName = "banco_emite")
    private String banco_emite;

    @DatabaseField(columnName = "numero_cheque")
    private String numero_cheque;

    @DatabaseField(columnName = "fecha_emision_ck")
    private String fecha_emision_ck;

    @DatabaseField(columnName = "fecha_cobro_ck")
    private String fecha_cobro_ck;

    @DatabaseField(columnName = "tipo_documento")
    private String tipo_documento;

    @DatabaseField(columnName = "monto_nio")
    private Double monto_nio;

    @DatabaseField(columnName = "monto_usd")
    private Double monto_usd;

    @DatabaseField(columnName = "tasa_cambio")
    private Double tasa_cambio;

    @DatabaseField(columnName = "monto_usd_nio")
    private Double monto_usd_nio;

    @DatabaseField(columnName = "saldo_actual")
    private Double saldo_actual;

    @DatabaseField(columnName = "es_pc")
    private String es_pc;

    @DatabaseField(columnName = "ret_ir")
    private String ret_ir;

    @DatabaseField(columnName = "num_ret_ir")
    private String num_ret_ir;

    @DatabaseField(columnName = "valor_ret_ir")
    private Double valor_ret_ir;

    @DatabaseField(columnName = "ret_imi")
    private String ret_imi;

    @DatabaseField(columnName = "num_ret_imi")
    private String num_ret_imi;

    @DatabaseField(columnName = "valor_ret_imi")
    private Double valor_ret_imi;

    @DatabaseField(columnName = "efectivo_recibido")
    private Double efectivo_recibido;

    @DatabaseField(columnName = "send")
    private Boolean send;

    @DatabaseField(columnName = "tipo_cliente")
    private String tipo_cliente;

    @DatabaseField(columnName = "monto_total_credito")
    private Double monto_total_credito;

    @DatabaseField(columnName = "notas_debitos")
    private Double notas_debitos;

    @DatabaseField(columnName = "notas_creditos")
    private Double notas_creditos;

    @DatabaseField(columnName = "abonos_creditos")
    private Double abonos_creditos;

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

    public Integer getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Integer id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Double getMonto_pc() {
        return monto_pc;
    }

    public void setMonto_pc(Double monto_pc) {
        this.monto_pc = monto_pc;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getFecha_cobro_realizado() {
        return fecha_cobro_realizado;
    }

    public void setFecha_cobro_realizado(String fecha_cobro_realizado) {
        this.fecha_cobro_realizado = fecha_cobro_realizado;
    }

    public Double getMonto_abonado() {
        return monto_abonado;
    }

    public void setMonto_abonado(Double monto_abonado) {
        this.monto_abonado = monto_abonado;
    }

    public Integer getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(Integer forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getNumero_recibo() {
        return numero_recibo;
    }

    public void setNumero_recibo(String numero_recibo) {
        this.numero_recibo = numero_recibo;
    }

    public String getBanco_emite() {
        return banco_emite;
    }

    public void setBanco_emite(String banco_emite) {
        this.banco_emite = banco_emite;
    }

    public String getNumero_cheque() {
        return numero_cheque;
    }

    public void setNumero_cheque(String numero_cheque) {
        this.numero_cheque = numero_cheque;
    }

    public String getFecha_emision_ck() {
        return fecha_emision_ck;
    }

    public void setFecha_emision_ck(String fecha_emision_ck) {
        this.fecha_emision_ck = fecha_emision_ck;
    }

    public String getFecha_cobro_ck() {
        return fecha_cobro_ck;
    }

    public void setFecha_cobro_ck(String fecha_cobro_ck) {
        this.fecha_cobro_ck = fecha_cobro_ck;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Double getMonto_nio() {
        return monto_nio;
    }

    public void setMonto_nio(Double monto_nio) {
        this.monto_nio = monto_nio;
    }

    public Double getMonto_usd() {
        return monto_usd;
    }

    public void setMonto_usd(Double monto_usd) {
        this.monto_usd = monto_usd;
    }

    public Double getTasa_cambio() {
        return tasa_cambio;
    }

    public void setTasa_cambio(Double tasa_cambio) {
        this.tasa_cambio = tasa_cambio;
    }

    public Double getMonto_usd_nio() {
        return monto_usd_nio;
    }

    public void setMonto_usd_nio(Double monto_usd_nio) {
        this.monto_usd_nio = monto_usd_nio;
    }

    public String getEs_pc() {
        return es_pc;
    }

    public void setEs_pc(String es_pc) {
        this.es_pc = es_pc;
    }

    public String getRet_ir() {
        return ret_ir;
    }

    public void setRet_ir(String ret_ir) {
        this.ret_ir = ret_ir;
    }

    public String getNum_ret_ir() {
        return num_ret_ir;
    }

    public void setNum_ret_ir(String num_ret_ir) {
        this.num_ret_ir = num_ret_ir;
    }

    public Double getValor_ret_ir() {
        return valor_ret_ir;
    }

    public void setValor_ret_ir(Double valor_ret_ir) {
        this.valor_ret_ir = valor_ret_ir;
    }

    public String getRet_imi() {
        return ret_imi;
    }

    public void setRet_imi(String ret_imi) {
        this.ret_imi = ret_imi;
    }

    public String getNum_ret_imi() {
        return num_ret_imi;
    }

    public void setNum_ret_imi(String num_ret_imi) {
        this.num_ret_imi = num_ret_imi;
    }

    public Double getValor_ret_imi() {
        return valor_ret_imi;
    }

    public void setValor_ret_imi(Double valor_ret_imi) {
        this.valor_ret_imi = valor_ret_imi;
    }

    public Double getEfectivo_recibido() {
        return efectivo_recibido;
    }

    public void setEfectivo_recibido(Double efectivo_recibido) {
        this.efectivo_recibido = efectivo_recibido;
    }

    public Double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(Double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public String getCta_deposito() {
        return cta_deposito;
    }

    public void setCta_deposito(String cta_deposito) {
        this.cta_deposito = cta_deposito;
    }

    public Boolean getSend() {
        return send;
    }

    public void setSend(Boolean send) {
        this.send = send;
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

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
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
