package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;

public class DetallePedido {

    @DatabaseField(columnName = "detalle_id_pedido", generatedId = true)
    private Integer detalle_id_pedido;

    @DatabaseField(columnName = "id_pedido")
    private Integer id_pedido;

    @DatabaseField(columnName = "id_precio")
    private Integer id_precio;

    @DatabaseField(columnName = "code_promo")
    private String code_promo;

    @DatabaseField(columnName = "code_promo_2")
    private String code_promo_2;

    @DatabaseField(columnName = "code_promo_3")
    private String code_promo_3;

    @DatabaseField(columnName = "code_promo_4")
    private String code_promo_4;

    @DatabaseField(columnName = "code_promo_combo")
    private String code_promo_combo;

    @DatabaseField(columnName = "id_canal")
    private Integer id_canal;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "id_familia")
    private String id_familia;

    @DatabaseField(columnName = "id_producto")
    private String id_producto;

    @DatabaseField(columnName = "cantidad_pedida")
    private Integer cantidad_pedida;

    @DatabaseField(columnName = "cantidad_venta")
    private Integer cantidad_venta;

    @DatabaseField(columnName = "caja_vendida")
    private Double caja_vendida;

    @DatabaseField(columnName = "precio_venta_antes_iva")
    private Double precio_venta_antes_iva;

    @DatabaseField(columnName = "precio_venta")
    private Double precio_venta;

    @DatabaseField(columnName = "precio_venta_desc")
    private Double precio_venta_desc;

    @DatabaseField(columnName = "subtotal_venta")
    private Double subtotal_venta;

    @DatabaseField(columnName = "subtotal_venta_desc")
    private Double subtotal_venta_desc;

    @DatabaseField(columnName = "porcentaje_descuento_venta")
    private Double porcentaje_descuento_venta;

    @DatabaseField(columnName = "descuento_total_venta")
    private Double descuento_total_venta;

    @DatabaseField(columnName = "subtotal_venta_aplicar_iva")
    private Double subtotal_venta_aplicar_iva;

    @DatabaseField(columnName = "porcentaje_iva_antes")
    private Double porcentaje_iva_antes;

    @DatabaseField(columnName = "total_iva_venta")
    private Double total_iva_venta;

    @DatabaseField(columnName = "total_factura_venta")
    private Double total_factura_venta;

    @DatabaseField(columnName = "des0")
    private Double des0;

    @DatabaseField(columnName = "des1")
    private Double des1;

    @DatabaseField(columnName = "des2")
    private Double des2;

    @DatabaseField(columnName = "des3")
    private Double des3;

    @DatabaseField(columnName = "des4")
    private Double des4;

    @DatabaseField(columnName = "des5")
    private Double des5;

    @DatabaseField(columnName = "des6")
    private Double des6;

    @DatabaseField(columnName = "des7")
    private Double des7;

    @DatabaseField(columnName = "des8")
    private Double des8;

    @DatabaseField(columnName = "des9")
    private Double des9;

    @DatabaseField(columnName = "des10")
    private Double des10;

    @DatabaseField(columnName = "des11")
    private Double des11;

    @DatabaseField(columnName = "des12")
    private Double des12;

    @DatabaseField(columnName = "des13")
    private Double des13;

    @DatabaseField(columnName = "des14")
    private Double des14;

    @DatabaseField(columnName = "des15")
    private Double des15;

    @DatabaseField(columnName = "des16")
    private Double des16;

    @DatabaseField(columnName = "des17")
    private Double des17;
    
    @DatabaseField(columnName = "des18")
    private Double des18;
    
    @DatabaseField(columnName = "des19")
    private Double des19;
    
    @DatabaseField(columnName = "des20")
    private Double des20;
    
    @DatabaseField(columnName = "des21")
    private Double des21;
    
    @DatabaseField(columnName = "des22")
    private Double des22;

    @DatabaseField(columnName = "es_bonificado")
    private String es_bonificado;

    @DatabaseField(columnName = "referencia_bonificado")
    private String referencia_bonificado;

    @DatabaseField(columnName = "es_bonificado_2")
    private String es_bonificado_2;

    @DatabaseField(columnName = "referencia_bonificado_2")
    private String referencia_bonificado_2;

    @DatabaseField(columnName = "es_bonificado_3")
    private String es_bonificado_3;

    @DatabaseField(columnName = "referencia_bonificado_3")
    private String referencia_bonificado_3;

    @DatabaseField(columnName = "es_bonificado_4")
    private String es_bonificado_4;

    @DatabaseField(columnName = "referencia_bonificado_4")
    private String referencia_bonificado_4;

    @DatabaseField(columnName = "es_bonificado_5")
    private String es_bonificado_5;

    @DatabaseField(columnName = "referencia_bonificado_5")
    private String referencia_bonificado_5;
    
    @DatabaseField(columnName = "es_bonificado_6")
    private String es_bonificado_6;
    
    @DatabaseField(columnName = "referencia_bonificado_6")
    private String referencia_bonificado_6;
	
	@DatabaseField(columnName = "es_bonificado_7")
	private String es_bonificado_7;
	
	@DatabaseField(columnName = "referencia_bonificado_7")
	private String referencia_bonificado_7;
	
	@DatabaseField(columnName = "es_bonificado_8")
	private String es_bonificado_8;
	
	@DatabaseField(columnName = "referencia_bonificado_8")
	private String referencia_bonificado_8;

    @DatabaseField(columnName = "nom_producto")
    private String nom_producto;

    @DatabaseField(columnName = "tipo_precio")
    private Double tipo_precio;

    @DatabaseField(columnName = "periodo_trabajo")
    private String periodo_trabajo;

    @DatabaseField(columnName = "precio_costo_fisico")
    private double precio_costo_fisico;

    @DatabaseField(columnName = "total_iva_antes")
    private double total_iva_antes;

    @DatabaseField(columnName = "subtotal_iva_antes")
    private double subtotal_iva_antes;

    @DatabaseField(columnName = "subtotal_fisico")
    private double subtotal_fisico;

    @DatabaseField(columnName = "utilidad_venta")
    private double utilidad_venta;


    public Integer getDetalle_id_pedido() {
        return detalle_id_pedido;
    }

    public void setDetalle_id_pedido(Integer detalle_id_pedido) {
        this.detalle_id_pedido = detalle_id_pedido;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_precio() {
        return id_precio;
    }

    public void setId_precio(Integer id_precio) {
        this.id_precio = id_precio;
    }

    public String getCode_promo() {
        return code_promo;
    }

    public void setCode_promo(String code_promo) {
        this.code_promo = code_promo;
    }

    public String getCode_promo_2() {
        return code_promo_2;
    }

    public void setCode_promo_2(String code_promo_2) {
        this.code_promo_2 = code_promo_2;
    }

    public String getCode_promo_3() {
        return code_promo_3;
    }

    public void setCode_promo_3(String code_promo_3) {
        this.code_promo_3 = code_promo_3;
    }

    public String getCode_promo_4() {
        return code_promo_4;
    }

    public void setCode_promo_4(String code_promo_4) {
        this.code_promo_4 = code_promo_4;
    }

    public String getCode_promo_combo() {
        return code_promo_combo;
    }

    public void setCode_promo_combo(String code_promo_combo) {
        this.code_promo_combo = code_promo_combo;
    }

    public Integer getId_canal() {
        return id_canal;
    }

    public void setId_canal(Integer id_canal) {
        this.id_canal = id_canal;
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

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad_pedida() {
        return cantidad_pedida;
    }

    public void setCantidad_pedida(Integer cantidad_pedida) {
        this.cantidad_pedida = cantidad_pedida;
    }

    public Integer getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(Integer cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public Double getCaja_vendida() {
        return caja_vendida;
    }

    public void setCaja_vendida(Double caja_vendida) {
        this.caja_vendida = caja_vendida;
    }

    public Double getPrecio_venta_antes_iva() {
        return precio_venta_antes_iva;
    }

    public void setPrecio_venta_antes_iva(Double precio_venta_antes_iva) {
        this.precio_venta_antes_iva = precio_venta_antes_iva;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Double getPrecio_venta_desc() {
        return precio_venta_desc;
    }

    public void setPrecio_venta_desc(Double precio_venta_desc) {
        this.precio_venta_desc = precio_venta_desc;
    }

    public Double getSubtotal_venta() {
        return subtotal_venta;
    }

    public void setSubtotal_venta(Double subtotal_venta) {
        this.subtotal_venta = subtotal_venta;
    }

    public Double getSubtotal_venta_desc() {
        return subtotal_venta_desc;
    }

    public void setSubtotal_venta_desc(Double subtotal_venta_desc) {
        this.subtotal_venta_desc = subtotal_venta_desc;
    }

    public Double getPorcentaje_descuento_venta() {
        return porcentaje_descuento_venta;
    }

    public void setPorcentaje_descuento_venta(Double porcentaje_descuento_venta) {
        this.porcentaje_descuento_venta = porcentaje_descuento_venta;
    }

    public Double getDescuento_total_venta() {
        return descuento_total_venta;
    }

    public void setDescuento_total_venta(Double descuento_total_venta) {
        this.descuento_total_venta = descuento_total_venta;
    }

    public Double getSubtotal_venta_aplicar_iva() {
        return subtotal_venta_aplicar_iva;
    }

    public void setSubtotal_venta_aplicar_iva(Double subtotal_venta_aplicar_iva) {
        this.subtotal_venta_aplicar_iva = subtotal_venta_aplicar_iva;
    }

    public Double getPorcentaje_iva_antes() {
        return porcentaje_iva_antes;
    }

    public void setPorcentaje_iva_antes(Double porcentaje_iva_antes) {
        this.porcentaje_iva_antes = porcentaje_iva_antes;
    }

    public Double getTotal_iva_venta() {
        return total_iva_venta;
    }

    public void setTotal_iva_venta(Double total_iva_venta) {
        this.total_iva_venta = total_iva_venta;
    }

    public Double getTotal_factura_venta() {
        return total_factura_venta;
    }

    public void setTotal_factura_venta(Double total_factura_venta) {
        this.total_factura_venta = total_factura_venta;
    }

    public Double getDes0() {
        return des0;
    }

    public void setDes0(Double des0) {
        this.des0 = des0;
    }

    public Double getDes1() {
        return des1;
    }

    public void setDes1(Double des1) {
        this.des1 = des1;
    }

    public Double getDes2() {
        return des2;
    }

    public void setDes2(Double des2) {
        this.des2 = des2;
    }

    public Double getDes3() {
        return des3;
    }

    public void setDes3(Double des3) {
        this.des3 = des3;
    }

    public Double getDes4() {
        return des4;
    }

    public void setDes4(Double des4) {
        this.des4 = des4;
    }

    public Double getDes5() {
        return des5;
    }

    public void setDes5(Double des5) {
        this.des5 = des5;
    }

    public Double getDes6() {
        return des6;
    }

    public void setDes6(Double des6) {
        this.des6 = des6;
    }

    public Double getDes7() {
        return des7;
    }

    public void setDes7(Double des7) {
        this.des7 = des7;
    }

    public Double getDes8() {
        return des8;
    }

    public void setDes8(Double des8) {
        this.des8 = des8;
    }

    public Double getDes9() {
        return des9;
    }

    public void setDes9(Double des9) {
        this.des9 = des9;
    }

    public Double getDes10() {
        return des10;
    }

    public void setDes10(Double des10) {
        this.des10 = des10;
    }

    public Double getDes11() {
        return des11;
    }

    public void setDes11(Double des11) {
        this.des11 = des11;
    }

    public Double getDes12() {
        return des12;
    }

    public void setDes12(Double des12) {
        this.des12 = des12;
    }

    public Double getDes13() {
        return des13;
    }

    public void setDes13(Double des13) {
        this.des13 = des13;
    }

    public Double getDes14() {
        return des14;
    }

    public void setDes14(Double des14) {
        this.des14 = des14;
    }

    public Double getDes15() {
        return des15;
    }

    public void setDes15(Double des15) {
        this.des15 = des15;
    }

    public Double getDes16() {
        return des16;
    }

    public void setDes16(Double des16) {
        this.des16 = des16;
    }

    public Double getDes17() {
        return des17;
    }
    
    public Double getDes18() {
        return des18;
    }
    
    public void setDes18(Double des18) {
        this.des18 = des18;
    }
    
    public Double getDes19() {
        return des19;
    }
    
    public void setDes19(Double des19) {
        this.des19 = des19;
    }
    
    public Double getDes20() {
        return des20;
    }
    
    public void setDes20(Double des20) {
        this.des20 = des20;
    }
    
    public Double getDes21() {
        return des21;
    }
    
    public void setDes21(Double des21) {
        this.des21 = des21;
    }
    
    public Double getDes22() {
        return des22;
    }
    
    public void setDes22(Double des22) {
        this.des22 = des22;
    }
    
    public void setDes17(Double des17) {
        this.des17 = des17;
    }

    public String getEs_bonificado() {
        return es_bonificado;
    }

    public void setEs_bonificado(String es_bonificado) {
        this.es_bonificado = es_bonificado;
    }

    public String getReferencia_bonificado() {
        return referencia_bonificado;
    }

    public void setReferencia_bonificado(String referencia_bonificado) {
        this.referencia_bonificado = referencia_bonificado;
    }

    public String getEs_bonificado_2() {
        return es_bonificado_2;
    }

    public void setEs_bonificado_2(String es_bonificado_2) {
        this.es_bonificado_2 = es_bonificado_2;
    }

    public String getReferencia_bonificado_2() {
        return referencia_bonificado_2;
    }

    public void setReferencia_bonificado_2(String referencia_bonificado_2) {
        this.referencia_bonificado_2 = referencia_bonificado_2;
    }

    public String getEs_bonificado_3() {
        return es_bonificado_3;
    }

    public void setEs_bonificado_3(String es_bonificado_3) {
        this.es_bonificado_3 = es_bonificado_3;
    }

    public String getReferencia_bonificado_3() {
        return referencia_bonificado_3;
    }

    public void setReferencia_bonificado_3(String referencia_bonificado_3) {
        this.referencia_bonificado_3 = referencia_bonificado_3;
    }

    public String getEs_bonificado_4() {
        return es_bonificado_4;
    }

    public void setEs_bonificado_4(String es_bonificado_4) {
        this.es_bonificado_4 = es_bonificado_4;
    }

    public String getReferencia_bonificado_4() {
        return referencia_bonificado_4;
    }

    public void setReferencia_bonificado_4(String referencia_bonificado_4) {
        this.referencia_bonificado_4 = referencia_bonificado_4;
    }

    public String getEs_bonificado_5() {
        return es_bonificado_5;
    }

    public void setEs_bonificado_5(String es_bonificado_5) {
        this.es_bonificado_5 = es_bonificado_5;
    }

    public String getReferencia_bonificado_5() {
        return referencia_bonificado_5;
    }

    public void setReferencia_bonificado_5(String referencia_bonificado_5) {
        this.referencia_bonificado_5 = referencia_bonificado_5;
    }
	
	public String getEs_bonificado_6() {
		return es_bonificado_6;
	}
	
	public void setEs_bonificado_6(String es_bonificado_6) {
		this.es_bonificado_6 = es_bonificado_6;
	}
	
	public String getReferencia_bonificado_6() {
		return referencia_bonificado_6;
	}
	
	public void setReferencia_bonificado_6(String referencia_bonificado_6) {
		this.referencia_bonificado_6 = referencia_bonificado_6;
	}
	
	public String getEs_bonificado_7() {
		return es_bonificado_7;
	}
	
	public void setEs_bonificado_7(String es_bonificado_7) {
		this.es_bonificado_7 = es_bonificado_7;
	}
	
	public String getReferencia_bonificado_7() {
		return referencia_bonificado_7;
	}
	
	public void setReferencia_bonificado_7(String referencia_bonificado_7) {
		this.referencia_bonificado_7 = referencia_bonificado_7;
	}
	
	
	public String getEs_bonificado_8() {
		return es_bonificado_8;
	}
	
	public void setEs_bonificado_8(String es_bonificado_8) {
		this.es_bonificado_8 = es_bonificado_8;
	}
	
	public String getReferencia_bonificado_8() {
		return referencia_bonificado_8;
	}
	
	public void setReferencia_bonificado_8(String referencia_bonificado_8) {
		this.referencia_bonificado_8 = referencia_bonificado_8;
	}


    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getPeriodo_trabajo() {
        return periodo_trabajo;
    }

    public void setPeriodo_trabajo(String periodo_trabajo) {
        this.periodo_trabajo = periodo_trabajo;
    }

    public double getPrecio_costo_fisico() {
        return precio_costo_fisico;
    }

    public void setPrecio_costo_fisico(double precio_costo_fisico) {
        this.precio_costo_fisico = precio_costo_fisico;
    }

    public double getTotal_iva_antes() {
        return total_iva_antes;
    }

    public void setTotal_iva_antes(double total_iva_antes) {
        this.total_iva_antes = total_iva_antes;
    }

    public double getSubtotal_iva_antes() {
        return subtotal_iva_antes;
    }

    public void setSubtotal_iva_antes(double subtotal_iva_antes) {
        this.subtotal_iva_antes = subtotal_iva_antes;
    }

    public double getSubtotal_fisico() {
        return subtotal_fisico;
    }

    public void setSubtotal_fisico(double subtotal_fisico) {
        this.subtotal_fisico = subtotal_fisico;
    }

    public double getUtilidad_venta() {
        return utilidad_venta;
    }

    public void setUtilidad_venta(double utilidad_venta) {
        this.utilidad_venta = utilidad_venta;
    }

    public Double getTipo_precio() {
        return tipo_precio;
    }

    public void setTipo_precio(Double tipo_precio) {
        this.tipo_precio = tipo_precio;
    }
}
