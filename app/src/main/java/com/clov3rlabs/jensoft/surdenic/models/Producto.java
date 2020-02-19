package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Producto")
public class Producto {

    @DatabaseField(columnName = "id_producto", id=true)
    private String id_producto;

    @DatabaseField(columnName = "id_proveedor")
    private String id_proveedor;

    @DatabaseField(columnName = "id_familia")
    private String id_familia;

    @DatabaseField(columnName = "nombre_producto")
    private String nombre_producto;

    @DatabaseField(columnName = "saldo_actual")
    private Integer saldo_actual;

    @DatabaseField(columnName = "empaque")
    private Integer empaque;

    @DatabaseField(columnName = "precio_costo")
    private Double precio_costo;

    @DatabaseField(columnName = "precio_venta_antes_iva")
    private Double precio_venta_antes_iva;

    @DatabaseField(columnName = "porcentaje_iva_antes")
    private Double porcentaje_iva_antes;

    @DatabaseField(columnName = "precio_venta")
    private Double precio_venta;

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

    @DatabaseField(columnName = "bonificado")
    private String bonificado;

    @DatabaseField(columnName = "precio_venta_t1")
    private Double precio_venta_t1;

    @DatabaseField(columnName = "precio_venta_t2")
    private Double precio_venta_t2;

    @DatabaseField(columnName = "precio_venta_t3")
    private Double precio_venta_t3;

    @DatabaseField(columnName = "precio_venta_t4")
    private Double precio_venta_t4;

    @DatabaseField(columnName = "precio_venta_t5")
    private Double precio_venta_t5;

    @DatabaseField(columnName = "precio_venta_t6")
    private Double precio_venta_t6;

    @DatabaseField(columnName = "precio_venta_t7")
    private Double precio_venta_t7;

    @DatabaseField(columnName = "precio_venta_t8")
    private Double precio_venta_t8;

    @DatabaseField(columnName = "precio_venta_t9")
    private Double precio_venta_t9;


    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
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

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Integer getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(Integer saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public Double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(Double precio_costo) {
        this.precio_costo = precio_costo;
    }

    public Double getPrecio_venta_antes_iva() {
        return precio_venta_antes_iva;
    }

    public void setPrecio_venta_antes_iva(Double precio_venta_antes_iva) {
        this.precio_venta_antes_iva = precio_venta_antes_iva;
    }

    public Double getPorcentaje_iva_antes() {
        return porcentaje_iva_antes;
    }

    public void setPorcentaje_iva_antes(Double porcentaje_iva_antes) {
        this.porcentaje_iva_antes = porcentaje_iva_antes;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
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

    public String getBonificado() {
        return bonificado;
    }

    public void setBonificado(String bonificado) {
        this.bonificado = bonificado;
    }

    public Double getPrecio_venta_t1() {
        return precio_venta_t1;
    }

    public void setPrecio_venta_t1(Double precio_venta_t1) {
        this.precio_venta_t1 = precio_venta_t1;
    }

    public Double getPrecio_venta_t2() {
        return precio_venta_t2;
    }

    public void setPrecio_venta_t2(Double precio_venta_t2) {
        this.precio_venta_t2 = precio_venta_t2;
    }

    public Double getPrecio_venta_t3() {
        return precio_venta_t3;
    }

    public void setPrecio_venta_t3(Double precio_venta_t3) {
        this.precio_venta_t3 = precio_venta_t3;
    }

    public Double getPrecio_venta_t4() {
        return precio_venta_t4;
    }

    public void setPrecio_venta_t4(Double precio_venta_t4) {
        this.precio_venta_t4 = precio_venta_t4;
    }

    public Double getPrecio_venta_t5() {
        return precio_venta_t5;
    }

    public void setPrecio_venta_t5(Double precio_venta_t5) {
        this.precio_venta_t5 = precio_venta_t5;
    }

    public Double getPrecio_venta_t6() {
        return precio_venta_t6;
    }

    public void setPrecio_venta_t6(Double precio_venta_t6) {
        this.precio_venta_t6 = precio_venta_t6;
    }

    public Double getPrecio_venta_t7() {
        return precio_venta_t7;
    }

    public void setPrecio_venta_t7(Double precio_venta_t7) {
        this.precio_venta_t7 = precio_venta_t7;
    }

    public Double getPrecio_venta_t8() {
        return precio_venta_t8;
    }

    public void setPrecio_venta_t8(Double precio_venta_t8) {
        this.precio_venta_t8 = precio_venta_t8;
    }

    public Double getPrecio_venta_t9() {
        return precio_venta_t9;
    }

    public void setPrecio_venta_t9(Double precio_venta_t9) {
        this.precio_venta_t9 = precio_venta_t9;
    }

    @Override
    public String toString() {

        return  this.id_producto + " " + this.nombre_producto ;

    }

    public Integer getEmpaque() {
        return empaque;
    }

    public void setEmpaque(Integer empaque) {
        this.empaque = empaque;
    }

    public Double getPrecioVentaPedido(Integer id_precio){
        Double precio_venta = 0.0;
        switch (id_precio){
            case 0:
                precio_venta = this.getPrecio_venta();
                break;
            case 1:
                precio_venta = this.getPrecio_venta_t1();
                break;
            case 2:
                precio_venta = this.getPrecio_venta_t2();
                break;
            case 3:
                precio_venta = this.getPrecio_venta_t3();
                break;
            case 4:
                precio_venta = this.getPrecio_venta_t4();
                break;
            case 5:
                precio_venta = this.getPrecio_venta_t5();
                break;
            case 6:
                precio_venta = this.getPrecio_venta_t6();
                break;
            case 7:
                precio_venta = this.getPrecio_venta_t7();
                break;
            case 8:
                precio_venta = this.getPrecio_venta_t8();
                break;
            case 9:
                precio_venta = this.getPrecio_venta_t9();
                break;
        }



        return precio_venta;
    }
}
