package com.clov3rlabs.jensoft.surdenic.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by rsaavedra on 22/8/2018.
 */


@DatabaseTable(tableName = "Configuracion")
public class Configuracion {

    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField(columnName = "ret_ir")
    private double ret_ir;

    @DatabaseField(columnName = "ret_imi")
    private double ret_imi;

    @DatabaseField(columnName = "tasa_cambio")
    private double tasa_cambio;

    @DatabaseField(columnName = "periodo_trabajo")
    private String periodo_trabajo;

    @DatabaseField(columnName = "id_vendedor")
    private Integer id_vendedor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRet_ir() {
        return ret_ir;
    }

    public void setRet_ir(double ret_ir) {
        this.ret_ir = ret_ir;
    }

    public double getRet_imi() {
        return ret_imi;
    }

    public void setRet_imi(double ret_imi) {
        this.ret_imi = ret_imi;
    }

    public double getTasa_cambio() {
        return tasa_cambio;
    }

    public void setTasa_cambio(double tasa_cambio) {
        this.tasa_cambio = tasa_cambio;
    }

    public String getPeriodo_trabajo() {
        return periodo_trabajo;
    }

    public void setPeriodo_trabajo(String periodo_trabajo) {
        this.periodo_trabajo = periodo_trabajo;
    }

    public Integer getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Integer id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
}
