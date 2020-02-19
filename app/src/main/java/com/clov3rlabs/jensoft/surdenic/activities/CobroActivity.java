package com.clov3rlabs.jensoft.surdenic.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Cobro;
import com.clov3rlabs.jensoft.surdenic.models.Configuracion;
import com.clov3rlabs.jensoft.surdenic.models.CuentaBanco;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.models.TasaCambio;
import com.clov3rlabs.jensoft.surdenic.models.TipoPago;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.repo.ClienteRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CobroRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ConfiguracionRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CuentaBancoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.FacturaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.TasaCambioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.TipoPagoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CobroActivity extends AppCompatActivity {

    private Integer id_factura;
    private FacturaRepo facturaRepo = new FacturaRepo(this);
    private Factura factura;

    private ClienteRepo clienteRepo = new ClienteRepo(this);
    private Cliente cliente;

    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(this);

    private TipoPago tipoPago;
    private TipoPagoRepo tipoPagoRepo = new TipoPagoRepo(this);
    private List<TipoPago> tipoPagoList;
    private ArrayAdapter tipoPagoAdapter;

    private CuentaBanco cuentaBanco;
    private CuentaBancoRepo cuentaBancoRepo = new CuentaBancoRepo(this);
    private List<CuentaBanco> cuentaBancoList;
    private ArrayAdapter cuentaBancoAdapter;

    private ConfiguracionRepo configuracionRepo = new ConfiguracionRepo(this);
    private Configuracion configuracion;

    private Cobro cobro;
    private CobroRepo cobroRepo = new CobroRepo(this);

    private TasaCambio tasaCambio;
    private TasaCambioRepo tasaCambioRepo = new TasaCambioRepo(this);

    private double tc;
    private String currentDateandTime;
    private boolean flagNumCheque = false;
    private boolean flagFechaCobroCheque = false;
    private boolean flagFechaEmision = false;

    private Boolean updatedMode = false;

    @BindView(R.id.txt_fecha_emision) TextView title_fecha_emision;
    @BindView(R.id.title_cobro_info) TextView title_cobro_info;
    @BindView(R.id.cobro_cliente_contacto) TextView cobro_cliente_contacto;
    @BindView(R.id.cobro_cliente_cedula) TextView cobro_cliente_cedula;
    @BindView(R.id.cobro_cliente_tipo) TextView cobro_cliente_tipo;
    @BindView(R.id.cliente_codigo) TextView cliente_codigo;
    @BindView(R.id.cobro_factura_num) TextView cobro_factura_num;
    @BindView(R.id.cobro_tipo_documento) TextView cobro_tipo_documento;
    @BindView(R.id.cobro_monto_factura) TextView cobro_monto_factura;
    @BindView(R.id.title_cheque_no) TextView title_cheque_no;

    @BindView(R.id.cobro_forma_pago) Spinner cobro_forma_pago;
    @BindView(R.id.cobro_monto_nio) EditText cobro_monto_nio;
    @BindView(R.id.cobro_monto_usd) EditText cobro_monto_usd;
    @BindView(R.id.cobro_monto_usd_nio) EditText cobro_monto_usd_nio;
    @BindView(R.id.cobro_monto_abonado) EditText cobro_monto_abonado;
    @BindView(R.id.cobro_saldo_actual) EditText cobro_saldo_actual;
    @BindView(R.id.cobro_numero_recibo) EditText cobro_numero_recibo;

    @BindView(R.id.cobro_cuenta_deposito) Spinner cobro_cuenta_deposito;

    @BindView(R.id.cobro_banco_emite) EditText cobro_banco_emite;
    @BindView(R.id.cobro_numero_cheque) EditText cobro_numero_cheque;
    @BindView(R.id.cobro_fecha_emison_cheque) EditText cobro_fecha_emison_cheque;
    @BindView(R.id.cobro_fecha_cobro_cheque) EditText cobro_fecha_cobro_cheque;

    @BindView(R.id.radio_retencion_ir_si) RadioButton radio_retencion_ir_si;
    @BindView(R.id.radio_retencion_ir_no) RadioButton radio_retencion_ir_no;
    @BindView(R.id.cobro_no_retencion_IR) EditText cobro_no_retencion_IR;
    @BindView(R.id.cobro_valor_retencion_IR) EditText cobro_valor_retencion_IR;


    @BindView(R.id.radio_retencion_imi_si) RadioButton radio_retencion_imi_si;
    @BindView(R.id.radio_retencion_imi_no) RadioButton radio_retencion_imi_no;
    @BindView(R.id.cobro_no_retencion_IMI) EditText cobro_no_retencion_IMI;
    @BindView(R.id.cobro_valor_retencion_IMI) EditText cobro_valor_retencion_IMI;

    @BindView(R.id.cobro_efectivo_recibido) EditText cobro_efectivo_recibido;

    @BindView(R.id.button_guardar_cobro) Button button_guardar;

    Double montoNIO;
    Double montoUSDNIO;
    Double montoAbonado;
    Double saldoActual;
    Double montoIR;
    Double montoIMI;
    Double montoRetenciones;
    Double montoRecibido;
    String retencionIR = "N";
    String retencionIMI = "N";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usuario = (Usuario)usuarioRepo.findFirst();

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            id_factura = extra.getInt("id_factura");
        }

        if (id_factura != 0){
            factura = (Factura) facturaRepo.findById(id_factura);
            cliente = (Cliente) clienteRepo.findById(factura.getId_cliente());
        }


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        currentDateandTime = sdf.format(new Date());

        //cobro = cobroRepo.getByClienteAndVendedor(cliente.getId_cliente(), usuario.getId_vendedor());
        cobro = cobroRepo.getByNumeroFactura(factura.getNum_factura());

        configuracion = configuracionRepo.findByIdVendedor(usuario.getId_vendedor());
        tasaCambio = tasaCambioRepo.getBydate(currentDateandTime);

        if (tasaCambio!= null){
            tc = tasaCambio.getTasa_cambio_dia();
        }else{
            tc = configuracion.getTasa_cambio();
        }


        setContentView(R.layout.activity_cobro);
        ButterKnife.bind(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_cobro);
        //mToolbar.setTitle(getResources().getString(R.string.titulo_cliente));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // set default values
        cobro_cliente_contacto.setText(cliente.getContacto_cliente());
        cobro_cliente_cedula.setText(cliente.getCedula_identidad());
        cobro_cliente_tipo.setText(getNombreTipoCliente(cliente.getTipo_cliente()));
        cliente_codigo.setText(cliente.getId_cliente().toString());
        cobro_factura_num.setText(factura.getNum_factura());
        cobro_tipo_documento.setText(cliente.getTipo_documento());
        cobro_monto_factura.setText("C$ " + String.format("%.2f", factura.getMonto_pc()));

        //cobro_monto_nio.setText(R.string.default_cero_value);
        //cobro_monto_usd_nio.setText(R.string.default_cero_value);
        //cobro_monto_abonado.setText(R.string.default_cero_value);
        cobro_saldo_actual.setText(String.format("%.2f", factura.getMonto_pc()));
        //cobro_efectivo_recibido.setText(R.string.default_cero_value);


        // Subrayando titulos
        title_cobro_info.setPaintFlags(title_cobro_info.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        tipoPagoList = (List<TipoPago>) tipoPagoRepo.findAll();
        cuentaBancoList = (List<CuentaBanco>) cuentaBancoRepo.findAll();

        if (cobro != null){
            showMessage(getString(R.string.cobro_existente));
            updatedMode = true;
            loadDatosCobro();
            button_guardar.setText(getString(R.string.boton_actualizar));
        }else{
            updatedMode = false;
            configureTipoPagoAdapter(tipoPagoList);
        }

        cobro_fecha_emison_cheque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DatePickerFragment newFragment = new DatePickerFragment();

                DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // +1 because january is zero
                        final String selectedDate = year  + "-" + twoDigits(month+1) + "-" + twoDigits(day);
                        cobro_fecha_emison_cheque.setText(selectedDate);
                    }
                });
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });

        cobro_fecha_cobro_cheque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // +1 because january is zero
                        final String selectedDate = year  + "-" + twoDigits(month+1) + "-" + twoDigits(day);
                        cobro_fecha_cobro_cheque.setText(selectedDate);
                    }
                });
                newFragment.show(getFragmentManager(), "datePicker");

            }
        });



        cobro_forma_pago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {
                tipoPago = (TipoPago) cobro_forma_pago.getSelectedItem();

                if (tipoPago.getId_tipo().equals(1)){
                    cuentaBanco = null;
                    cobro_cuenta_deposito.setEnabled(false);
                    cobro_cuenta_deposito.setAdapter(null);

                    cobro_banco_emite.setText("");
                    cobro_numero_cheque.setText("");
                    cobro_fecha_emison_cheque.setText("");
                    cobro_fecha_cobro_cheque.setText("");

                    cobro_numero_cheque.setEnabled(false);
                    flagFechaCobroCheque = false;
                    flagNumCheque =  false;
                    cobro_fecha_emison_cheque.setEnabled(false);
                    cobro_fecha_cobro_cheque.setEnabled(false);
                    flagFechaEmision = false;

                }else{

                    cuentaBanco = null;
                    cobro_cuenta_deposito.setEnabled(true);
                    cobro_cuenta_deposito.setAdapter(null);

                    if ((tipoPago.getId_tipo().equals(2)) || (tipoPago.getId_tipo().equals(3))){ // cuentas tipo cheque
                        cuentaBancoList = cuentaBancoRepo.findCuentasCheque();
                        cobro_fecha_cobro_cheque.setEnabled(true);
                        flagFechaCobroCheque = true;
                        title_fecha_emision.setText(R.string.cobro_fecha_emision);
                        title_cheque_no.setText("No.Cheque");
                    }else{
                        cuentaBancoList = cuentaBancoRepo.findCuentasDeposito();
                        title_cheque_no.setText("No.Deposito");
                        cobro_fecha_cobro_cheque.setEnabled(false);
                        flagFechaCobroCheque = true;
                        title_fecha_emision.setText(R.string.cobro_fecha_deposito);
                        cobro_fecha_cobro_cheque.setText("");

                    }

                    if (updatedMode){
                        CuentaBanco cuentaBanco = cuentaBancoRepo.findByCuenta(cobro.getCta_deposito());
                        configureBancoCuenta(cuentaBancoList, cuentaBanco);
                    }else{
                        configureBancoCuenta(cuentaBancoList);
                    }




                    cobro_numero_cheque.setEnabled(true);
                    flagNumCheque = true;
                    cobro_fecha_emison_cheque.setEnabled(true);
                    flagFechaEmision = true;
                    //cobro_fecha_cobro_cheque.setEnabled(true);

                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }


        });

        cobro_cuenta_deposito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {
                cuentaBanco = (CuentaBanco) cobro_cuenta_deposito.getSelectedItem();

                cobro_banco_emite.setText(cuentaBanco.getNombre_banco());

            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });

        cobro_monto_nio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!cobro_monto_usd_nio.getText().toString().isEmpty()){
                    montoUSDNIO = Double.valueOf(cobro_monto_usd_nio.getText().toString());
                }else{
                    montoUSDNIO = 0.00;
                }

                if (!cobro_valor_retencion_IR.getText().toString().isEmpty()){
                    montoIR = Double.valueOf(cobro_valor_retencion_IR.getText().toString());
                }else{
                    montoIR = 0.00;
                }

                if (!cobro_valor_retencion_IMI.getText().toString().isEmpty()){
                    montoIMI = Double.valueOf(cobro_valor_retencion_IMI.getText().toString());
                }else{
                    montoIMI = 0.00;
                }

                montoRetenciones = montoIR + montoIMI;

                if (charSequence.length() > 0){
                    montoAbonado = Double.valueOf(cobro_monto_nio.getText().toString()) + montoUSDNIO;
                }else{
                    montoAbonado = 0.00 + montoUSDNIO;
                }

                cobro_monto_abonado.setText(String.format("%.2f", montoAbonado));
                saldoActual = factura.getMonto_pc() - montoAbonado;
                cobro_saldo_actual.setText(String.format("%.2f", saldoActual));
                montoRecibido = montoAbonado - montoRetenciones;
                cobro_efectivo_recibido.setText(String.format("%.2f", montoRecibido));


            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        cobro_monto_usd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if (!cobro_monto_nio.getText().toString().isEmpty()){
                    montoNIO = Double.valueOf(cobro_monto_nio.getText().toString());
                }else{
                    montoNIO = 0.00;
                }

                if (!cobro_valor_retencion_IR.getText().toString().isEmpty()){
                    montoIR = Double.valueOf(cobro_valor_retencion_IR.getText().toString());
                }else{
                    montoIR = 0.00;
                }

                if (!cobro_valor_retencion_IMI.getText().toString().isEmpty()){
                    montoIMI = Double.valueOf(cobro_valor_retencion_IMI.getText().toString());
                }else{
                    montoIMI = 0.00;
                }

                montoRetenciones = montoIR + montoIMI;

                if (charSequence.length() > 0){
                    montoUSDNIO = Double.valueOf(cobro_monto_usd.getText().toString()) * tc;
                }else{
                    montoUSDNIO = 0.00 * tc;
                }

                cobro_monto_usd_nio.setText(String.format("%.2f", montoUSDNIO));
                montoAbonado = montoNIO + montoUSDNIO;

                cobro_monto_abonado.setText(String.format("%.2f", montoAbonado));
                saldoActual = factura.getMonto_pc() - montoAbonado;
                cobro_saldo_actual.setText(String.format("%.2f", saldoActual));
                montoRecibido = montoAbonado - montoRetenciones;
                cobro_efectivo_recibido.setText(String.format("%.2f", montoRecibido));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cobro_valor_retencion_IMI.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!cobro_valor_retencion_IR.getText().toString().isEmpty()){
                    montoIR = Double.valueOf(cobro_valor_retencion_IR.getText().toString());
                }else{
                    montoIR = 0.00;
                }

                if (!cobro_monto_abonado.getText().toString().isEmpty()){
                    montoAbonado = Double.valueOf(cobro_monto_abonado.getText().toString());
                }else{
                    montoAbonado = 0.00;
                }


                if (charSequence.length() > 0){
                    montoRetenciones = Double.valueOf(cobro_valor_retencion_IMI.getText().toString()) + montoIR;

                }else{
                    montoRetenciones = 0.00 + montoIR;
                }

                montoRecibido = montoAbonado - montoRetenciones;
                cobro_efectivo_recibido.setText(String.format("%.2f", montoRecibido));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cobro_valor_retencion_IR.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!cobro_valor_retencion_IMI.getText().toString().isEmpty()){
                    montoIMI = Double.valueOf(cobro_valor_retencion_IMI.getText().toString());
                }else{
                    montoIMI = 0.00;
                }

                if (!cobro_monto_abonado.getText().toString().isEmpty()){
                    montoAbonado = Double.valueOf(cobro_monto_abonado.getText().toString());
                }else{
                    montoAbonado = 0.00;
                }


                if (charSequence.length() > 0){
                    montoRetenciones = Double.valueOf(cobro_valor_retencion_IR.getText().toString()) + montoIMI;

                }else{
                    montoRetenciones = 0.00 + montoIMI;
                }

                montoRecibido = montoAbonado - montoRetenciones;
                cobro_efectivo_recibido.setText(String.format("%.2f", montoRecibido));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    public void onRadioButtonIRClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.radio_retencion_ir_si:

                if (checked)
                    retencionIR = "S";
                    cobro_no_retencion_IR.setEnabled(true);
                    cobro_valor_retencion_IR.setEnabled(true);
                break;
            case R.id.radio_retencion_ir_no:

                if (checked){
                    retencionIR = "N";
                    cobro_no_retencion_IR.setEnabled(false);
                    cobro_valor_retencion_IR.setEnabled(false);
                    //

                    cobro_no_retencion_IR.setText("");
                    cobro_valor_retencion_IR.setText("");

                }
                break;

        }

    }

    public void onRadioButtonIMIClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.radio_retencion_imi_si:

                if (checked)
                    retencionIMI = "S";
                    cobro_no_retencion_IMI.setEnabled(true);
                    cobro_valor_retencion_IMI.setEnabled(true);
                break;
            case R.id.radio_retencion_imi_no:

                if (checked){
                    retencionIMI = "N";
                    cobro_no_retencion_IMI.setEnabled(false);
                    cobro_valor_retencion_IMI.setEnabled(false);

                    //
                    cobro_no_retencion_IMI.setText("");
                    cobro_valor_retencion_IMI.setText("");
                }


                break;

        }

    }


    private void configureTipoPagoAdapter(List<TipoPago> data) {
        tipoPagoAdapter = new ArrayAdapter(this, R.layout.spinner_style, data);
        tipoPagoAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cobro_forma_pago.setAdapter(tipoPagoAdapter);

    }

    private void configureTipoPagoAdapter(List<TipoPago> data, TipoPago tipoPago) {
        tipoPagoAdapter = new ArrayAdapter(this, R.layout.spinner_style, data);
        tipoPagoAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cobro_forma_pago.setAdapter(tipoPagoAdapter);

        if (tipoPago != null){

            cobro_forma_pago.setSelection(getPositionTipoPago(tipoPago));
        }

    }


    private int getPositionTipoPago(TipoPago selected){
        int tipo_pago_position = 0;

        for (int x = 0; x < tipoPagoAdapter.getCount(); x++){
            TipoPago aux = (TipoPago) tipoPagoAdapter.getItem(x);
            if (aux.getId_tipo() == selected.getId_tipo()){
                tipo_pago_position = x;
                break;
            }
        }

        return tipo_pago_position;

    }


    private void configureBancoCuenta(List<CuentaBanco> data){
        cuentaBancoAdapter = new ArrayAdapter(this, R.layout.spinner_style, data);
        cuentaBancoAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cobro_cuenta_deposito.setAdapter(cuentaBancoAdapter);

    }

    private void configureBancoCuenta(List<CuentaBanco> data, CuentaBanco cuentaBanco){
        cuentaBancoAdapter = new ArrayAdapter(this, R.layout.spinner_style, data);
        cuentaBancoAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cobro_cuenta_deposito.setAdapter(cuentaBancoAdapter);

        if (cuentaBanco != null){
            cobro_cuenta_deposito.setSelection(getPositionBancoCuenta(cuentaBanco));
        }

    }


    private int getPositionBancoCuenta(CuentaBanco selected){
        int cuenta_banco_position = 0;

        for (int x = 0; x < cuentaBancoAdapter.getCount(); x++){
            CuentaBanco aux = (CuentaBanco) cuentaBancoAdapter.getItem(x);
            if (aux.getId() == selected.getId()){
                cuenta_banco_position = x;
                break;
            }
        }

        return cuenta_banco_position;

    }

    private String getNombreTipoCliente(String tipo){
        if (tipo.toLowerCase().equals("c")){
            return getResources().getString(R.string.cliente_tipo_c);
        }else{
            return getResources().getString(R.string.cliente_tipo_p);
        }
    }


    private String esPC(String tipo){
        if (tipo.equals("c")){
            return getResources().getString(R.string.es_pc_S);
        }else{
            return getResources().getString(R.string.es_pc_N);
        }
    }

    private void loadDatosCobro(){

        TipoPago tipoPago = (TipoPago) tipoPagoRepo.findById(cobro.getForma_pago());

        configureTipoPagoAdapter(tipoPagoList, tipoPago);
        cobro_monto_nio.setText(cobro.getMonto_nio().toString());
        cobro_monto_usd.setText(cobro.getMonto_usd().toString());
        cobro_monto_usd_nio.setText(cobro.getMonto_usd_nio().toString());

        cobro_monto_abonado.setText(cobro.getMonto_abonado().toString());
        cobro_saldo_actual.setText(cobro.getSaldo_actual().toString());

        cobro_numero_recibo.setText(cobro.getNumero_recibo());
        cobro_numero_cheque.setText(cobro.getNumero_cheque());
        cobro_fecha_emison_cheque.setText(cobro.getFecha_emision_ck());
        cobro_fecha_cobro_cheque.setText(cobro.getFecha_cobro_ck());



        if (cobro.getRet_ir().equals("S")){
            retencionIR = "S";
            radio_retencion_ir_si.setChecked(true);
            cobro_no_retencion_IR.setEnabled(true);
            cobro_no_retencion_IR.setText(cobro.getNum_ret_ir());
            cobro_valor_retencion_IR.setEnabled(true);
            cobro_valor_retencion_IR.setText(cobro.getValor_ret_ir().toString());
        }else{
            retencionIR = "N";
            cobro_no_retencion_IR.setEnabled(false);
            cobro_valor_retencion_IR.setEnabled(false);
        }



        if (cobro.getRet_imi().equals("S")){
            retencionIMI = "S";
            radio_retencion_imi_si.setChecked(true);
            cobro_no_retencion_IMI.setEnabled(true);
            cobro_no_retencion_IMI.setText(cobro.getNum_ret_imi());
            cobro_valor_retencion_IMI.setEnabled(true);
            cobro_valor_retencion_IMI.setText(cobro.getValor_ret_imi().toString());
        }else{
            retencionIMI = "N";
            cobro_no_retencion_IMI.setEnabled(false);
            cobro_valor_retencion_IMI.setEnabled(false);
        }

        cobro_efectivo_recibido.setText(cobro.getEfectivo_recibido().toString());


    }


    @OnClick(R.id.button_guardar_cobro)
    void guardarCobro(){

        if (Double.parseDouble(cobro_saldo_actual.getText().toString()) < 0){
            showMessage(getString(R.string.cobro_num_saldo_erroneo));
            return;
        }

        if (cobro_monto_abonado.getText().toString().equals("") || cobro_monto_abonado.getText().toString().length() <= 0){
            showMessage(getString(R.string.cobro_num_abonado_vacio));
            return;
        }

        if (cobro_numero_recibo.getText().toString().equals("") || cobro_numero_recibo.getText().toString().length() < 1){
            showMessage(getString(R.string.cobro_num_recibo_vacio));
            return;
        }

        if ((cobro_numero_cheque.getText().toString().equals("") || cobro_numero_cheque.getText().toString().length() < 1) && flagNumCheque == true){
            showMessage(getString(R.string.cobro_num_doc_vacio));
            return;
        }

        if ((cobro_fecha_cobro_cheque.getText().toString().equals("") || cobro_fecha_cobro_cheque.getText().toString().length() < 1) && flagFechaCobroCheque == true){
            showMessage(getString(R.string.cobro_num_fecha_vacio));
            return;
        }

        if ((cobro_fecha_emison_cheque.getText().toString().trim().equals("") || cobro_fecha_emison_cheque.getText().toString().length() < 1) && flagFechaCobroCheque == true){
            showMessage(getString(R.string.cobro_num_fecha_emision_vacio));
            return;
        }


        if (radio_retencion_ir_si.isChecked()){

            if (cobro_no_retencion_IR.getText().toString().trim().equals("")){
                showMessage(getString(R.string.cobro_no_retencion_IR_vacio));
                return;
            }

            if (cobro_valor_retencion_IR.getText().toString().trim().equals("")){
                showMessage(getString(R.string.cobro_valor_retencion_IR_vacio));
                return;
            }

        }

        if (radio_retencion_imi_si.isChecked()){

            if (cobro_no_retencion_IMI.getText().toString().trim().equals("")){
                showMessage(getString(R.string.cobro_no_retencion_IMI_vacio));
                return;
            }

            if (cobro_valor_retencion_IMI.getText().toString().trim().equals("")){
                showMessage(getString(R.string.cobro_valor_retencion_IMI_vacio));
                return;
            }

        }




        if (updatedMode){ // Update

            cobro.setForma_pago(tipoPago.getId_tipo());

            if (!cobro_numero_recibo.getText().toString().isEmpty())
                cobro.setNumero_recibo(cobro_numero_recibo.getText().toString());

            if (cuentaBanco != null)
                cobro.setCta_deposito(cuentaBanco.getCuenta_banco());

            if (!cobro_banco_emite.getText().toString().isEmpty())
                cobro.setBanco_emite(cobro_banco_emite.getText().toString());

            if (!cobro_numero_cheque.getText().toString().isEmpty())
                cobro.setNumero_cheque(cobro_numero_cheque.getText().toString());

            if (!cobro_fecha_emison_cheque.getText().toString().isEmpty())
                cobro.setFecha_emision_ck(cobro_fecha_emison_cheque.getText().toString());

            if (!cobro_fecha_cobro_cheque.getText().toString().isEmpty())
                cobro.setFecha_cobro_ck(cobro_fecha_cobro_cheque.getText().toString());


            cobro.setMonto_nio(Double.valueOf(cobro_monto_nio.getText().toString()));

            if (!cobro_monto_usd.getText().toString().isEmpty()){
                cobro.setMonto_usd(Double.valueOf(cobro_monto_usd.getText().toString()));
                cobro.setMonto_usd_nio(Double.valueOf(cobro_monto_usd_nio.getText().toString()));
            }
            else{
                cobro.setMonto_usd(0.00);
                cobro.setMonto_usd_nio(0.00);
            }


            cobro.setTasa_cambio(tc);


            cobro.setMonto_abonado(Double.valueOf(cobro_monto_abonado.getText().toString()));
            cobro.setSaldo_actual(Double.valueOf(cobro_saldo_actual.getText().toString()));

            cobro.setRet_ir(retencionIR);

            if (!cobro_no_retencion_IR.getText().toString().isEmpty())
                cobro.setNum_ret_ir(cobro_no_retencion_IR.getText().toString());


            if (!cobro_valor_retencion_IR.getText().toString().isEmpty()){
                cobro.setValor_ret_ir(Double.valueOf(cobro_valor_retencion_IR.getText().toString()));
            }else{
                cobro.setValor_ret_ir(0.00);
            }

            cobro.setRet_imi(retencionIMI);

            if (!cobro_no_retencion_IMI.getText().toString().isEmpty())
                cobro.setNum_ret_imi(cobro_no_retencion_IMI.getText().toString());


            if (!cobro_valor_retencion_IMI.getText().toString().isEmpty()){
                cobro.setValor_ret_imi(Double.valueOf(cobro_valor_retencion_IMI.getText().toString()));
            }else{
                cobro.setValor_ret_imi(0.00);
            }

            cobro.setEfectivo_recibido(Double.valueOf(cobro_efectivo_recibido.getText().toString()));
            cobro.setSend(false);
            //NUEVOS
            cobro.setTipo_cliente(cliente.getTipo_cliente());
            cobro.setMonto_total_credito(factura.getTotal_facturado());
            cobro.setNotas_creditos(factura.getMonto_nc());
            cobro.setNotas_debitos(factura.getMonto_nd());
            cobro.setAbonos_creditos(factura.getMonto_abonado());

            cobroRepo.update(cobro);
            showMessage(getString(R.string.actualizo_cobro));

            finish();

        }else{ // Nuevo

            cobro = new Cobro();
            cobro.setId_cliente(cliente.getId_cliente());
            cobro.setId_vendedor(cliente.getId_vendedor());
            cobro.setId_ruta(factura.getId_ruta());
            cobro.setNumero_factura(factura.getNum_factura());
            cobro.setMonto_pc(factura.getMonto_pc());
            cobro.setTipo_documento(cliente.getTipo_documento());
            cobro.setEs_pc(esPC(cliente.getTipo_cliente()));
            cobro.setFecha_factura(factura.getFecha_factura());
            cobro.setFecha_cobro_realizado(currentDateandTime);
            cobro.setForma_pago(tipoPago.getId_tipo());

            if (!cobro_numero_recibo.getText().toString().isEmpty())
                cobro.setNumero_recibo(cobro_numero_recibo.getText().toString());

            if (cuentaBanco != null)
                cobro.setCta_deposito(cuentaBanco.getCuenta_banco());

            if (!cobro_banco_emite.getText().toString().isEmpty())
                cobro.setBanco_emite(cobro_banco_emite.getText().toString());

            if (!cobro_numero_cheque.getText().toString().isEmpty())
                cobro.setNumero_cheque(cobro_numero_cheque.getText().toString());

            if (!cobro_fecha_emison_cheque.getText().toString().isEmpty())
                cobro.setFecha_emision_ck(cobro_fecha_emison_cheque.getText().toString());

            if (!cobro_fecha_cobro_cheque.getText().toString().isEmpty())
                cobro.setFecha_cobro_ck(cobro_fecha_cobro_cheque.getText().toString());

            if (!cobro_monto_nio.getText().toString().isEmpty()){
                cobro.setMonto_nio(Double.valueOf(cobro_monto_nio.getText().toString()));
            }else{
                cobro.setMonto_nio(0.00);
            }


            if (!cobro_monto_usd.getText().toString().isEmpty()){
                cobro.setMonto_usd(Double.valueOf(cobro_monto_usd.getText().toString()));
                cobro.setMonto_usd_nio(Double.valueOf(cobro_monto_usd_nio.getText().toString()));
            }
            else{
                cobro.setMonto_usd(0.00);
                cobro.setMonto_usd_nio(0.00);
            }


            cobro.setTasa_cambio(tc);


            cobro.setMonto_abonado(Double.valueOf(cobro_monto_abonado.getText().toString()));
            cobro.setSaldo_actual(Double.valueOf(cobro_saldo_actual.getText().toString()));

            cobro.setRet_ir(retencionIR);

            if (!cobro_no_retencion_IR.getText().toString().isEmpty())
                cobro.setNum_ret_ir(cobro_no_retencion_IR.getText().toString());


            if (!cobro_valor_retencion_IR.getText().toString().isEmpty()){
                cobro.setValor_ret_ir(Double.valueOf(cobro_valor_retencion_IR.getText().toString()));
            }else{
                cobro.setValor_ret_ir(0.00);
            }

            cobro.setRet_imi(retencionIMI);

            if (!cobro_no_retencion_IMI.getText().toString().isEmpty())
                cobro.setNum_ret_imi(cobro_no_retencion_IMI.getText().toString());


            if (!cobro_valor_retencion_IMI.getText().toString().isEmpty()){
                cobro.setValor_ret_imi(Double.valueOf(cobro_valor_retencion_IMI.getText().toString()));
            }else{
                cobro.setValor_ret_imi(0.00);
            }

            cobro.setEfectivo_recibido(Double.valueOf(cobro_efectivo_recibido.getText().toString()));
            cobro.setSend(false);

            cobro.setTipo_cliente(cliente.getTipo_cliente());
            cobro.setMonto_total_credito(factura.getTotal_facturado());
            cobro.setNotas_creditos(factura.getMonto_nc());
            cobro.setNotas_debitos(factura.getMonto_nd());
            cobro.setAbonos_creditos(factura.getMonto_abonado());

            if (cobroRepo.create(cobro) > 0 ){
                showMessage(getString(R.string.registro_cobro));

                finish();

            }else{
                Toast.makeText(getApplicationContext(), R.string.error_guardar_registro, Toast.LENGTH_SHORT).show();
            }
        }






    }

    private void showMessage(String message){

        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0, 1, menu.NONE, getString(R.string.sub_menu_elimina_pedido));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1){
            // delete dialog
            if (cobro != null){
                deleteCobro();
            }else{
                showMessage(getString(R.string.cobro_no_existe));
            }

        }
        return super.onOptionsItemSelected(item);
    }


    private void deleteCobro(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_eliminar_cobro));
        alertDialogBuilder.setIcon(R.drawable.ic_ask);
        alertDialogBuilder.setMessage(getResources().getString(R.string.messages_eliminar_cobro));


        alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cobroRepo.deleteById(cobro.getId());

                showMessage(getString(R.string.elimina_registro_cobro));

                finish();


            }

        });


        alertDialogBuilder.setNegativeButton(R.string.messages_send_data_negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public static class DatePickerFragment extends DialogFragment{

        private DatePickerDialog.OnDateSetListener listener;

        public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener listener) {
            DatePickerFragment fragment = new DatePickerFragment();
            fragment.setListener(listener);
            return fragment;
        }

        public void setListener(DatePickerDialog.OnDateSetListener listener) {
            this.listener = listener;
        }

        @Override
        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), listener, year, month, day);
        }
    }

    private String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }

}

