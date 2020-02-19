package com.clov3rlabs.jensoft.surdenic.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.adapters.FacturaClienteAdapter;
import com.clov3rlabs.jensoft.surdenic.models.Barrio;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Departamento;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.models.Municipio;
import com.clov3rlabs.jensoft.surdenic.models.Pedido;
import com.clov3rlabs.jensoft.surdenic.models.RazonVisitaNoExitosa;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosa;
import com.clov3rlabs.jensoft.surdenic.repo.BarrioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ClienteRepo;
import com.clov3rlabs.jensoft.surdenic.repo.DepartamentoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.FacturaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.MunicipioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.PedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.RazonVisitaNoExitosaRepo;
import com.clov3rlabs.jensoft.surdenic.repo.VisitaNoExitosaRepo;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClienteActivity extends AppCompatActivity {

    private Integer cliente_id = 0;
    private ClienteRepo clienteRepo = new ClienteRepo(this);
    private Cliente cliente;

    private DepartamentoRepo departamentoRepo = new DepartamentoRepo(this);
    private Departamento departamento;
    private MunicipioRepo municipioRepo = new MunicipioRepo(this);
    private Municipio municipio = new Municipio();
    private BarrioRepo barrioRepo = new BarrioRepo(this);
    private Barrio barrio = new Barrio();
    Menu menuGlobal;



    @BindView(R.id.cliente_contacto) TextView cliente_contacto;
    @BindView(R.id.cliente_cedula) TextView cliente_cedula;
    @BindView(R.id.cliente_tipo) TextView cliente_tipo;
    @BindView(R.id.cliente_empresa) TextView cliente_empresa;
    @BindView(R.id.cliente_direccion) TextView cliente_direccion;
    @BindView(R.id.cliente_barrio) TextView cliente_barrio;
    @BindView(R.id.cliente_departamento) TextView cliente_departamento;
    @BindView(R.id.cliente_municipio) TextView cliente_municipio;
    @BindView(R.id.cliente_limite_credito) TextView cliente_limite_credito;
    @BindView(R.id.cliente_dias_credito) TextView cliente_dias_credito;
    @BindView(R.id.cliente_balance_actual) TextView cliente_balance_actual;
    @BindView(R.id.cliente_factor_incremento) TextView cliente_factor_incremento;
    @BindView(R.id.cliente_codigo) TextView cliente_codigo;

    // --
    @BindView(R.id.title_contact_info) TextView title_contact_info;
    @BindView(R.id.title_cuenta_info) TextView title_cuenta_info;
    @BindView(R.id.title_facturas_info) TextView title_facturas_info;

    private ArrayAdapter razonVisitaNoExitosaAdapter;

    private List<Factura> facturaList;
    private FacturaRepo facturaRepo = new FacturaRepo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            cliente_id = extra.getInt("cliente_id");
        }

        if (cliente_id != 0){
            cliente = (Cliente) clienteRepo.findById(cliente_id);
            departamento = (Departamento) departamentoRepo.findById(cliente.getId_departamento());
            municipio = (Municipio) municipioRepo.findById(cliente.getId_municipio());
            barrio = (Barrio) barrioRepo.findById(cliente.getId_barrio());
        }

        setContentView(R.layout.activity_cliente);
        ButterKnife.bind(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_cliente);
        //mToolbar.setTitle(getResources().getString(R.string.titulo_cliente));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        cliente_contacto.setText(cliente.getContacto_cliente());
        cliente_cedula.setText(getString(R.string.cliente_cedula) + " " + cliente.getCedula_identidad());
        cliente_codigo.setText(cliente.getId_cliente().toString());
        cliente_tipo.setText(getNombreTipoCliente(cliente.getTipo_cliente()));



        cliente_empresa.setText(cliente.getNombre_empresa());

        cliente_direccion.setText(cliente.getDireccion_empresa());
        cliente_departamento.setText(departamento.getNombre_departamento());
        cliente_municipio.setText(municipio.getNombre_municipio());
        cliente_barrio.setText(barrio.getNombre_barrio());

        //


        cliente_limite_credito.setText(String.format("%.2f", cliente.getLimite_credito()));
        cliente_dias_credito.setText(String.valueOf(cliente.getDias_credito()));
        cliente_balance_actual.setText(String.format("%.2f", cliente.getBalance_actual()));
        cliente_factor_incremento.setText(String.format("%.2f", cliente.getFactor_incremento()));

        // Subrayando titulos
        title_contact_info.setPaintFlags(title_contact_info.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        title_cuenta_info.setPaintFlags(title_cuenta_info.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        title_facturas_info.setPaintFlags(title_facturas_info.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        facturaList = facturaRepo.findByIdCliente(cliente_id);

        if (!facturaList.isEmpty()){
            FacturaClienteAdapter facturaClienteAdapter = new FacturaClienteAdapter(this, R.layout.factura_list_item, facturaList);

            ListView listView = (ListView) findViewById(R.id.list_facturas);
            listView.setAdapter(facturaClienteAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Factura factura = facturaList.get(position);
                    Intent i = new Intent(view.getContext(), FacturaActivity.class);
                    i.putExtra("id_factura", factura.getId_registro());

                    startActivity(i);

                }
            });



            ViewGroup.LayoutParams mParam = listView.getLayoutParams();
            mParam.height = facturaList.size() * 100;
            listView.setLayoutParams(mParam);


        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void loadRazonVisitaNoExitosa(Spinner spinner_razones_visita_no_exitosa, VisitaNoExitosa visita){

        String razon_visita_no_exiotsa [] = getResources().getStringArray(R.array.razon_visita_no_exitosa);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, razon_visita_no_exiotsa );

        spinner_razones_visita_no_exitosa.setAdapter(arrayAdapter);

        if (visita != null){
            int spinnerPosition = arrayAdapter.getPosition(visita.getRazon_visita_no_exitoso());
            spinner_razones_visita_no_exitosa.setSelection(spinnerPosition);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1){
            // show dialog
            createVisitaNoExitosaDialogo();

        }else{
            Intent i = new Intent( ClienteActivity.this, PedidoActivity.class);
            i.putExtra("id_cliente", cliente.getId_cliente());

            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0, 1, menu.NONE, getString(R.string.sub_menu_visita_no_exitosa));
        menu.add(0, 2, menu.NONE, getString(R.string.sub_menu_pedido));
        menuGlobal = menu;
        disabledVisitaNoExitosa(menuGlobal);

        return true;
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        disabledVisitaNoExitosa(menuGlobal);
    }

    public void disabledVisitaNoExitosa(Menu menu){
        PedidoRepo flagCliente  = new PedidoRepo(this);
        Pedido pedido =  flagCliente.getByClienteAndVendedor(cliente.getId_cliente(),cliente.getId_vendedor());

        if (pedido != null){
            if (pedido.getSubtotal_venta() > 0.00){
                menu.findItem(1).setEnabled(false);
            }
        }else{
            menu.findItem(1).setEnabled(true);
        }
    }


    public void createVisitaNoExitosaDialogo() {

        // validando si existe
        final VisitaNoExitosaRepo visitaNoExitosaRepo = new VisitaNoExitosaRepo(getApplicationContext());

        final VisitaNoExitosa visitaNoExitosa = visitaNoExitosaRepo.findByIdVendedorAndIdCliente(cliente.getId_vendedor(), cliente.getId_cliente());

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_visita_no_exitosa, null);

        loadRazonVisitaNoExitosa((Spinner)v.findViewById(R.id.cliente_razon_visita_no_exitosa), visitaNoExitosa);

        final Spinner  cliente_razon_visita_no_exitosa = (Spinner) v.findViewById(R.id.cliente_razon_visita_no_exitosa);
        final EditText cliente_nota_exitosa = (EditText) v.findViewById(R.id.cliente_nota_exitosa);
        Button guardar_visita_no_exitosa = (Button) v.findViewById(R.id.button_guardar_visita_no_exitosa);
        Button eliminar_visita_no_exitoso = (Button) v.findViewById(R.id.button_eliminar_visita_no_exitosa);

        if (visitaNoExitosa != null){
            cliente_nota_exitosa.setText(visitaNoExitosa.getObservaciones_visita());
            guardar_visita_no_exitosa.setText(getString(R.string.boton_actualizar));
            eliminar_visita_no_exitoso.setEnabled(true);
        }


        builder.setView(v);



        final AlertDialog dialog = builder.create();

        guardar_visita_no_exitosa.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (cliente_nota_exitosa.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(),"Breve descripcion no puede ser vacia",Toast.LENGTH_LONG).show();
                            return;
                        }

                        if (visitaNoExitosa != null){ // Updated

                            visitaNoExitosa.setObservaciones_visita(cliente_nota_exitosa.getText().toString());
                            visitaNoExitosa.setRazon_visita_no_exitoso((String)cliente_razon_visita_no_exitosa.getSelectedItem());

                            visitaNoExitosaRepo.update(visitaNoExitosa);
                            Toast.makeText(getApplicationContext(), R.string.actualiza_registro_visita_no_exitosa, Toast.LENGTH_SHORT).show();

                        }else{ // Created

                            VisitaNoExitosa visitaNoExitosa = new VisitaNoExitosa();

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String currentDateandTime = sdf.format(new Date());

                            visitaNoExitosa.setId_cliente(cliente_id);
                            visitaNoExitosa.setId_vendedor(cliente.getId_vendedor());
                            visitaNoExitosa.setId_ruta_trabajo(cliente.getId_ruta_consumo());

                            visitaNoExitosa.setObservaciones_visita(cliente_nota_exitosa.getText().toString());
                            visitaNoExitosa.setFecha_registro(currentDateandTime);
                            visitaNoExitosa.setRazon_visita_no_exitoso((String)cliente_razon_visita_no_exitosa.getSelectedItem());
                            visitaNoExitosa.setSend(false);

                            if (visitaNoExitosaRepo.create(visitaNoExitosa) > 0){
                                Toast.makeText(getApplicationContext(), R.string.registro_visita_no_exitosa, Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(getApplicationContext(), R.string.error_guardar_registro, Toast.LENGTH_SHORT).show();
                            }

                        }

                        dialog.cancel();

                    }
                }
        );

        eliminar_visita_no_exitoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitaNoExitosaRepo.deleteById(visitaNoExitosa.getId());
                Toast.makeText(getApplicationContext(), R.string.elimina_registro_visita_no_exitosa, Toast.LENGTH_SHORT).show();

                dialog.cancel();

            }
        });


        dialog.show();
    }

    private String getNombreTipoCliente(String tipo){
        if (tipo.toLowerCase().equals("c")){
            return getResources().getString(R.string.cliente_tipo_c);
        }else{
            return getResources().getString(R.string.cliente_tipo_p);
        }
    }
}
