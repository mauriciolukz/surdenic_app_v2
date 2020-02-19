package com.clov3rlabs.jensoft.surdenic.activities;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Cobro;
import com.clov3rlabs.jensoft.surdenic.models.CobroNoExitoso;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.repo.ClienteRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CobroNoExitosoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CobroRepo;
import com.clov3rlabs.jensoft.surdenic.repo.FacturaRepo;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FacturaActivity extends AppCompatActivity {

    private Integer id_factura;
    private FacturaRepo facturaRepo = new FacturaRepo(this);
    private Factura factura;

    private ClienteRepo clienteRepo = new ClienteRepo(this);
    private Cliente cliente;

    private Menu menuGlobal;

    @BindView(R.id.factura_cliente_contacto) TextView factura_cliente_contacto;
    @BindView(R.id.factura_cliente_cedula) TextView factura_cliente_cedula;
    @BindView(R.id.factura_num) TextView factura_num;
    @BindView(R.id.factura_codigo_cliente) TextView factura_codigo_cliente;
    @BindView(R.id.factura_cliente_tipo) TextView factura_cliente_tipo;
    @BindView(R.id.factura_fecha) TextView factura_fecha;
    @BindView(R.id.factura_total_vendido) TextView factura_total_vendido;
    @BindView(R.id.factura_monto_abonado) TextView factura_monto_abonado;
    @BindView(R.id.factura_monto_pc) TextView factura_monto_pc;
    @BindView(R.id.factura_fecha_vence) TextView factura_fecha_vence;

    @BindView(R.id.factura_vendido) TextView factura_vendido;
    @BindView(R.id.nd_monto_abonado) TextView nd_monto_abonado;
    @BindView(R.id.nc_monto) TextView nc_monto;

    @BindView(R.id.title_factura_info) TextView title_factura_info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            id_factura = extra.getInt("id_factura");
        }

        if (id_factura != 0){
            factura = (Factura) facturaRepo.findById(id_factura);
            cliente = (Cliente) clienteRepo.findById(factura.getId_cliente());
        }

        setContentView(R.layout.activity_factura);
        ButterKnife.bind(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_factura);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        factura_cliente_contacto.setText(cliente.getContacto_cliente());
        factura_cliente_cedula.setText(cliente.getCedula_identidad());
        factura_cliente_tipo.setText(getNombreTipoCliente(cliente.getTipo_cliente()));
        factura_num.setText(factura.getNum_factura());
        factura_codigo_cliente.setText(cliente.getId_cliente().toString());
        factura_fecha.setText(factura.getFecha_factura());

        factura_total_vendido.setText(getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getTotal_vendido()));
        factura_monto_abonado.setText(getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getMonto_abonado()));
        factura_monto_pc.setText(getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getMonto_pc()));
        factura_fecha_vence.setText(factura.getFecha_vence());


        factura_vendido.setText(getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getTotal_facturado()));
        nd_monto_abonado.setText(getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getMonto_nd()));
        nc_monto.setText(getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getMonto_nc()));

        // Subrayando titulos
        title_factura_info.setPaintFlags(title_factura_info.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String getNombreTipoCliente(String tipo){
        if (tipo.toLowerCase().equals("c")){
            return getResources().getString(R.string.cliente_tipo_c);
        }else{
            return getResources().getString(R.string.cliente_tipo_p);
        }
    }


    private void loadRazonCobroNoExitoso(Spinner spinner_razones_cobro_no_exitoso, CobroNoExitoso cobro){

        String razon_visita_no_exiotsa [] = getResources().getStringArray(R.array.razon_cobro_no_exitoso);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, razon_visita_no_exiotsa );

        spinner_razones_cobro_no_exitoso.setAdapter(arrayAdapter);

        if (cobro != null){
            int spinnerPosition = arrayAdapter.getPosition(cobro.getRazon_cobro_no_exitoso());
            spinner_razones_cobro_no_exitoso.setSelection(spinnerPosition);
        }

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0, 1, menu.NONE, getString(R.string.sub_menu_cobro_no_exitosa));
        menu.add(0, 2, menu.NONE, getString(R.string.sub_menu_cobro));
        menuGlobal = menu;
        disableCobroNoExitoso(menuGlobal);
        return true;
    }

    private void disableCobroNoExitoso(Menu menu){

        CobroRepo cobroRepo = new CobroRepo(this);
        Cobro cobro = cobroRepo.getByNumeroFactura(factura.getNum_factura());


        if (cobro != null){
            menu.findItem(1).setEnabled(false);
        }else{
            menu.findItem(1).setEnabled(true);
        }


    }


    @Override
    protected void onRestart() {
        super.onRestart();
        disableCobroNoExitoso(menuGlobal);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1){
            // show dialog
            createCobroNoExitosoDialogo();

        }else{
            Intent i = new Intent( FacturaActivity.this, CobroActivity.class);
            i.putExtra("id_factura", factura.getId_registro());

            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public void createCobroNoExitosoDialogo() {

        // validando si existe
        final CobroNoExitosoRepo cobroNoExitosoRepo = new CobroNoExitosoRepo(getApplicationContext());

        final CobroNoExitoso cobroNoExitoso = cobroNoExitosoRepo.findByIdVendedorAndIdCliente(factura.getId_vendedor(), factura.getId_cliente());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_cobro_no_exitoso, null);

        final Spinner  factura_razon_cobro_no_exitoso = (Spinner) v.findViewById(R.id.factura_razon_cobro_no_exitoso);
        loadRazonCobroNoExitoso(factura_razon_cobro_no_exitoso, cobroNoExitoso);


        final EditText factura_nota_cobro_no_exitoso = (EditText) v.findViewById(R.id.factura_nota_cobro_no_exitoso);
        Button button_guardar_cobro_no_exitoso = (Button) v.findViewById(R.id.button_guardar_cobro_no_exitoso);
        Button button_eliminar_cobro_no_exitoso = (Button) v.findViewById(R.id.button_eliminar_cobro_no_exitosa);

        if (cobroNoExitoso != null){
            factura_nota_cobro_no_exitoso.setText(cobroNoExitoso.getObservaciones_cobro());
            button_guardar_cobro_no_exitoso.setText(getString(R.string.boton_actualizar));
            button_eliminar_cobro_no_exitoso.setEnabled(true);
        }



        builder.setView(v);



        final AlertDialog dialog = builder.create();

        button_guardar_cobro_no_exitoso.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (factura_nota_cobro_no_exitoso.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(),"Descripcion nota breve no puede ser vacia",Toast.LENGTH_LONG).show();
                            return;
                        }

                        if (cobroNoExitoso != null){ // updated
                            cobroNoExitoso.setObservaciones_cobro(factura_nota_cobro_no_exitoso.getText().toString());
                            cobroNoExitoso.setRazon_cobro_no_exitoso((String)factura_razon_cobro_no_exitoso.getSelectedItem());

                            cobroNoExitosoRepo.update(cobroNoExitoso);
                            Toast.makeText(getApplicationContext(), R.string.actualiza_registro_cobro_no_exitoso, Toast.LENGTH_SHORT).show();

                        }else{ // created

                            CobroNoExitoso cobroNoExitoso = new CobroNoExitoso();

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String currentDateandTime = sdf.format(new Date());

                            cobroNoExitoso.setId_cliente(factura.getId_cliente());
                            cobroNoExitoso.setTipo_cliente(cliente.getTipo_cliente());
                            cobroNoExitoso.setId_vendedor(factura.getId_vendedor());
                            cobroNoExitoso.setId_ruta_trabajo(factura.getId_ruta());
                            cobroNoExitoso.setNum_factura(factura.getNum_factura());
                            cobroNoExitoso.setTipo_documento(factura.getTipo_documento());
                            cobroNoExitoso.setFecha_factura(factura.getFecha_factura());
                            cobroNoExitoso.setMonto_pc(factura.getMonto_pc());
                            cobroNoExitoso.setFecha_registro(currentDateandTime);
                            cobroNoExitoso.setObservaciones_cobro(factura_nota_cobro_no_exitoso.getText().toString());
                            cobroNoExitoso.setRazon_cobro_no_exitoso((String)factura_razon_cobro_no_exitoso.getSelectedItem());
                            cobroNoExitoso.setSend(false);

                            if (cobroNoExitosoRepo.create(cobroNoExitoso) > 0){
                                Toast.makeText(getApplicationContext(), R.string.registro_cobro_no_exitoso, Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(getApplicationContext(), R.string.error_guardar_registro, Toast.LENGTH_SHORT).show();
                            }


                        }


                        dialog.dismiss();



                    }
                }
        );

        button_eliminar_cobro_no_exitoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cobroNoExitosoRepo.deleteById(cobroNoExitoso.getId());
                Toast.makeText(getApplicationContext(), R.string.elimina_registro_cobro_no_exitoso, Toast.LENGTH_SHORT).show();

                dialog.cancel();

            }
        });

        dialog.show();


    }
}
