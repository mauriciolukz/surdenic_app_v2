package com.clov3rlabs.jensoft.surdenic.activities;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.adapters.DetallePedidoAdapter;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Configuracion;
import com.clov3rlabs.jensoft.surdenic.models.Descuento15;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Municipio;
import com.clov3rlabs.jensoft.surdenic.models.Pedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.models.TasaCambio;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.repo.ClienteRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ConfiguracionRepo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento0Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento1Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento2Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento3Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento4Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento5Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento6Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento7Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento8Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento9Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento10Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento11Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento12Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento13Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento14Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento15Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento16Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento18Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento19Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento20Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento21Repo;
import com.clov3rlabs.jensoft.surdenic.repo.Descuento22Repo;
import com.clov3rlabs.jensoft.surdenic.repo.DetallePedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.MunicipioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.PedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.ProductoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.TasaCambioRepo;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;
import com.clov3rlabs.jensoft.surdenic.utils.MinMaxFilter;
import com.clov3rlabs.jensoft.surdenic.utils.Utility;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.support.v7.app.AlertDialog;

import javax.security.auth.login.LoginException;

public class PedidoActivity extends AppCompatActivity {

    private Integer id_cliente = 0;
    private ClienteRepo clienteRepo = new ClienteRepo(this);
    private Cliente cliente;

    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(this);

    private Pedido pedido;
    private PedidoRepo pedidoRepo = new PedidoRepo(this);

    private DetallePedido detallePedido;
    private List<DetallePedido> detallePedidoList;
    private DetallePedidoRepo detallePedidoRepo = new DetallePedidoRepo(this);
    
    //region Repositorios para dedscuento
	private Descuento0Repo descuento0Repo = new Descuento0Repo(this);
	private Descuento1Repo descuento1Repo = new Descuento1Repo(this);
	private Descuento2Repo descuento2Repo = new Descuento2Repo(this);
	private Descuento3Repo descuento3Repo = new Descuento3Repo(this);
	private Descuento4Repo descuento4Repo = new Descuento4Repo(this);
	private Descuento5Repo descuento5Repo = new Descuento5Repo(this);
	private Descuento6Repo descuento6Repo = new Descuento6Repo(this);
	private Descuento7Repo descuento7Repo = new Descuento7Repo(this);
	private Descuento8Repo descuento8Repo = new Descuento8Repo(this);
	private Descuento9Repo descuento9Repo = new Descuento9Repo(this);
	private Descuento10Repo descuento10Repo = new Descuento10Repo(this);
	private Descuento11Repo descuento11Repo = new Descuento11Repo(this);
	private Descuento12Repo descuento12Repo = new Descuento12Repo(this);
	private Descuento13Repo descuento13Repo = new Descuento13Repo(this);
	private Descuento14Repo descuento14Repo = new Descuento14Repo(this);
	private Descuento15Repo descuento15Repo = new Descuento15Repo(this);
	private Descuento16Repo descuento16Repo = new Descuento16Repo(this);
	private Descuento18Repo descuento18Repo = new Descuento18Repo(this);
	private Descuento19Repo descuento19Repo = new Descuento19Repo(this);
	private Descuento20Repo descuento20Repo = new Descuento20Repo(this);
	private Descuento21Repo descuento21Repo = new Descuento21Repo(this);
	private Descuento22Repo descuento22Repo = new Descuento22Repo(this);
	//endregion

    private Producto producto;
    private ProductoRepo productoRepo = new ProductoRepo(this);

    private ConfiguracionRepo configuracionRepo = new ConfiguracionRepo(this);
    private Configuracion configuracion;

    private TasaCambio tasaCambio;
    private TasaCambioRepo tasaCambioRepo = new TasaCambioRepo(this);

    private double tc;
    private String currentDateandTime;

    DetallePedidoAdapter detallePedidoAdapter;

    @BindView(R.id.pedido_cliente_contacto) TextView pedido_cliente_contacto;
    @BindView(R.id.pedido_cliente_cedula) TextView pedido_cliente_cedula;
    @BindView(R.id.pedido_cliente_tipo) TextView pedido_cliente_tipo;
    @BindView(R.id.pedido_codigo_cliente) TextView pedido_codigo_cliente;


    //--
    @BindView(R.id.title_pedido_datos) TextView title_pedido_datos;

    @BindView(R.id.pedido_subtotal_venta) TextView pedido_subtotal_venta;
    @BindView(R.id.pedido_descuento_venta) TextView pedido_descuento_venta;
    @BindView(R.id.pedido_iva_venta) TextView pedido_iva_venta;
    @BindView(R.id.pedido_total_factura_venta) TextView pedido_total_factura_venta;
    @BindView(R.id.pedido_tasa_cambio) TextView pedido_tasa_cambio;
    @BindView(R.id.pedido_valor_dolares) TextView pedido_valor_dolares;


    private static final int PRODUCT_ACTIVITY_REQUEST_CODE = 0;

    ListView lstDetallePedido;

    MunicipioRepo municipioRepo;
    Municipio municipio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usuario = (Usuario)usuarioRepo.findFirst();

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            id_cliente = extra.getInt("id_cliente");
        }

        if (id_cliente != 0){
            cliente = (Cliente) clienteRepo.findById(id_cliente);
        }


        setContentView(R.layout.activity_pedido);

        ButterKnife.bind(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_pedido);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        pedido_cliente_contacto.setText(cliente.getContacto_cliente());
        pedido_cliente_cedula.setText(getString(R.string.cliente_cedula) + " " + cliente.getCedula_identidad());
        pedido_cliente_tipo.setText(getNombreTipoCliente(cliente.getTipo_cliente()));
        pedido_codigo_cliente.setText(cliente.getId_cliente().toString());

        // Subrayando titulos
        title_pedido_datos.setPaintFlags(title_pedido_datos.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        currentDateandTime = sdf.format(new Date());

        pedido = pedidoRepo.getByClienteAndVendedor(cliente.getId_cliente(), usuario.getId_vendedor());

        configuracion = configuracionRepo.findByIdVendedor(usuario.getId_vendedor());
        tasaCambio = tasaCambioRepo.getBydate(currentDateandTime);

        if (tasaCambio!= null){
            tc = tasaCambio.getTasa_cambio_dia();
        }else{
            tc = configuracion.getTasa_cambio();
        }


        if (pedido != null){ // cargar
            showMessage(getString(R.string.pedido_existente));
        }else{  // crear pedido
            pedido = createPedidoDefault();
            if (pedido != null){
                showMessage(getString(R.string.pedido_creado_exito));
            }else{
                showMessage(getString(R.string.pedido_error));
            }
        }

        getEncabezadoPedido();

        detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
        lstDetallePedido = (ListView) findViewById(R.id.list_detalle_pedido);


        if (!detallePedidoList.isEmpty()){

            detallePedidoAdapter = new DetallePedidoAdapter(this, R.layout.detalle_pedido_row, detallePedidoList);

            lstDetallePedido.setAdapter(detallePedidoAdapter);
            ViewGroup.LayoutParams mParamSpecies = lstDetallePedido.getLayoutParams();
            mParamSpecies.height = (detallePedidoList.size()) * 80;
            lstDetallePedido.setLayoutParams(mParamSpecies);
        }

        lstDetallePedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                updateDetallePedido(i);


            }
        });

        lstDetallePedido.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                deleteDetallePedido(i);
                return true;
            }
        });




        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void updateDetallePedido(int list_position){

        final DetallePedido detallePedido = detallePedidoList.get(list_position);
        producto = (Producto) productoRepo.findByIdProducto(detallePedido.getId_producto());

        if ((producto.getBonificado() != null) && (!producto.getBonificado().isEmpty()) && (producto.getBonificado().equals("S"))){
            showMessage(getString(R.string.no_abrir_bonificado));
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(PedidoActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_cantidad_producto, null);

        builder.setView(v);

        Button button_guardar_cobro_no_exitoso = (Button) v.findViewById(R.id.button_guardar_cantidad);
        button_guardar_cobro_no_exitoso.setText(getString(R.string.boton_actualizar));

        //button_guardar_cobro_no_exitoso.setEnabled(false);

        final EditText txtCantidad = (EditText) v.findViewById(R.id.cantidad_producto_busqueda);
        txtCantidad.setFilters(new InputFilter[]{ new MinMaxFilter("1", "100000")});

        TextView codigo_producto_seleccionado = (TextView) v.findViewById(R.id.codigo_producto_seleccionado);
        TextView nombre_producto_seleccionado = (TextView) v.findViewById(R.id.nombre_producto_seleccionado);
        TextView precio_producto_seleccionado = (TextView) v.findViewById(R.id.precio_producto_seleccionado);
        TextView cantidad_pedidad_producto_seleccionado = (TextView) v.findViewById(R.id.cantidad_pedidad_producto_seleccionado);
        TextView cantidad_venta_producto_seleccionado = (TextView) v.findViewById(R.id.cantidad_venta_producto_seleccionado);
        //TextView subtotal_venta_producto_seleccionado = (TextView) v.findViewById(R.id.subtotal_venta_producto_seleccionado);
        TextView subtotal_venta_desc_producto_seleccionado = (TextView) v.findViewById(R.id.subtotal_venta_desc_producto_seleccionado);
        TextView descuento_total_venta_producto_seleccionado = (TextView) v.findViewById(R.id.descuento_total_venta_producto_seleccionado);
        TextView total_iva_venta_producto_seleccionado = (TextView) v.findViewById(R.id.total_iva_venta_producto_seleccionado);
        TextView total_facturado_producto_seleccionado = (TextView) v.findViewById(R.id.total_facturado_producto_seleccionado);
        TextView total_facturado_producto_seleccionado_1 = (TextView) v.findViewById(R.id.total_facturado_producto_seleccionado_1);
        TextView porcentaje_desc_producto_seleccionado = (TextView) v.findViewById(R.id.porcentaje_desc_producto_seleccionado);


        txtCantidad.setText(detallePedido.getCantidad_pedida().toString());
        codigo_producto_seleccionado.setText(producto.getId_producto());
        nombre_producto_seleccionado.setText(producto.getNombre_producto());
        precio_producto_seleccionado.setText(getString(R.string.moneda_nacional) + " " + Utility.formatMonyNotCoin(detallePedido.getPrecio_venta_desc()));
        cantidad_pedidad_producto_seleccionado.setText(detallePedido.getCantidad_pedida().toString());
        cantidad_venta_producto_seleccionado.setText(detallePedido.getCantidad_venta().toString());
        //subtotal_venta_producto_seleccionado.setText(String.format("%.2f", detallePedido.getSubtotal_venta()));
        subtotal_venta_desc_producto_seleccionado.setText(Utility.formatMonyNotCoin(detallePedido.getSubtotal_venta_desc()));
        descuento_total_venta_producto_seleccionado.setText(Utility.formatMonyNotCoin( detallePedido.getDescuento_total_venta()));
        total_iva_venta_producto_seleccionado.setText(Utility.formatMonyNotCoin(detallePedido.getTotal_iva_venta()));
        total_facturado_producto_seleccionado.setText(Utility.formatMonyNotCoin(detallePedido.getTotal_factura_venta()));
        porcentaje_desc_producto_seleccionado.setText(Utility.formatMonyNotCoin(detallePedido.getPorcentaje_descuento_venta()));
        total_facturado_producto_seleccionado_1.setText(Utility.formatMonyNotCoin(detallePedido.getTotal_factura_venta()));

        final AlertDialog dialog = builder.create();

        button_guardar_cobro_no_exitoso.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String cantidad = txtCantidad.getText().toString();
                        txtCantidad.setError(null);
                        Double nivelPrecio = nivelPrecio();

                        if (TextUtils.isEmpty(cantidad)){
                            txtCantidad.setError(getString(R.string.error_field_required));

                        }else{
                            String id_producto = detallePedido.getId_producto();
                            Integer cantidad_solicitada = Integer.valueOf(cantidad);

                            producto = (Producto) productoRepo.findByIdProducto(detallePedido.getId_producto());

                            Double precio_venta_desc;
                            Double porcentaje_descuento_venta;


                            Integer cantidad_venta = 0;
                            Integer cantidad_pedida = 0;
                            Double subTotalVenta, subTotalVentaDesc;
                            Double descuentoTotalVenta;
                            Double totalIVAVenta;
                            Double totalFacturaVenta;
                            Double total_iva_antes;

                            // Calculando descuentos
                            precio_venta_desc = detallePedido.getPrecio_venta();
                            porcentaje_descuento_venta = 0.00;

                            // Calculando cantidad venta y cantidad pedida
                            //if ((cantidad_solicitada < producto.getSaldo_actual()) || (cantidad_solicitada == producto.getSaldo_actual())){
                                cantidad_venta = cantidad_solicitada;

                                if (producto.getBonificado().equals("N")){
                                    cantidad_pedida =  cantidad_solicitada;
                                }

                            /*}else {
                                if (cantidad_solicitada > producto.getSaldo_actual()){
                                    cantidad_pedida = cantidad_solicitada;
                                    cantidad_venta = producto.getSaldo_actual();
                                }
                            }*/

                            //

                            subTotalVenta = cantidad_venta * detallePedido.getPrecio_venta();
                            subTotalVentaDesc = cantidad_venta * (detallePedido.getPrecio_venta() / ((producto.getPorcentaje_iva_antes() / 100) + 1));
                            descuentoTotalVenta = subTotalVentaDesc * porcentaje_descuento_venta;
                            totalIVAVenta = (subTotalVentaDesc - descuentoTotalVenta) * (producto.getPorcentaje_iva_antes()/100);
                            totalFacturaVenta = subTotalVentaDesc - descuentoTotalVenta + totalIVAVenta;
                            total_iva_antes = subTotalVenta * (producto.getPorcentaje_iva_antes() / 100);


                            detallePedido.setId_precio(pedido.getId_precio());
                            detallePedido.setCantidad_pedida(cantidad_pedida);
                            detallePedido.setCantidad_venta(cantidad_venta);
                            detallePedido.setCaja_vendida(Double.parseDouble(String.valueOf(cantidad_venta / producto.getEmpaque())));
                            producto.setPrecio_venta(detallePedido.getPrecio_venta());
                            detallePedido.setPrecio_venta_antes_iva(detallePedido.getPrecio_venta() / ((producto.getPorcentaje_iva_antes() / 100) + 1));
                            detallePedido.setPrecio_venta(producto.getPrecioVentaPedido(pedido.getId_precio()));
                            detallePedido.setPrecio_venta_desc(precio_venta_desc);
                            detallePedido.setSubtotal_venta(subTotalVenta);
                            detallePedido.setSubtotal_venta_desc(subTotalVentaDesc);

                            detallePedido.setPorcentaje_descuento_venta(porcentaje_descuento_venta);

                            detallePedido.setDescuento_total_venta(descuentoTotalVenta);
                            detallePedido.setSubtotal_venta_aplicar_iva(0.00);
                            if (producto.getPorcentaje_iva_antes() != null){
                                detallePedido.setPorcentaje_iva_antes(producto.getPorcentaje_iva_antes());
                            }
                            else {
                                detallePedido.setPorcentaje_iva_antes(0.00);
                            }

                            detallePedido.setTotal_iva_venta(totalIVAVenta);
                            detallePedido.setTotal_factura_venta(totalFacturaVenta);

                            //nuevo
                            detallePedido.setTotal_iva_antes(total_iva_antes);
                            detallePedido.setSubtotal_iva_antes(subTotalVenta - total_iva_antes);
                            detallePedido.setSubtotal_fisico(producto.getPrecio_costo() * cantidad_venta);
                            detallePedido.setUtilidad_venta((subTotalVenta - total_iva_antes) - (producto.getPrecio_costo() * cantidad_venta));

                            if (detallePedidoRepo.update(detallePedido) > 0 ){

                                showMessage(getString(R.string.detalle_pedido_producto_exito));

                                detallePedidoRepo.deleteBonificacodsByIdPedido(detallePedido.getId_pedido());

                                //
                                detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
                                buscarDescuentos(detallePedidoList);
                                detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
                                calcularEncabezado();
                                configureAdapter();

                            }else{
                                showMessage(getString(R.string.detalle_pedido_producto_error));
                            }
                            
                            detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
                            calcularEncabezado();
                            configureAdapter();

                            //hide keyboard
                            InputMethodManager imm = (InputMethodManager)getSystemService(
                                    INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(txtCantidad.getWindowToken(), 0);

                            dialog.dismiss();

                        }

                    }
                }
        );


        dialog.show();

    }

    private void deleteDetallePedido(int list_position){

        final DetallePedido detallePedido = detallePedidoList.get(list_position);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_elimina_item_pedido));
        alertDialogBuilder.setIcon(R.drawable.ic_ask);
        alertDialogBuilder.setMessage(getResources().getString(R.string.messages_eliminar_item_pedido) + " " + detallePedido.getId_producto() + "?");


        alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Producto prod =  productoRepo.findByIdProducto(detallePedido.getId_producto());

                if ((prod.getBonificado() != null) && (!prod.getBonificado().isEmpty()) && (prod.getBonificado().equals("S"))){
                    showMessage(getString(R.string.no_elimina_bonificado));


                }else{
                    detallePedidoRepo.deleteBonificacodsByIdPedido(detallePedido.getId_pedido());

                    if ((detallePedido.getReferencia_bonificado() != null) && (!detallePedido.getReferencia_bonificado().isEmpty())) {
                        detallePedidoRepo.deleteBonificacodsByIdPedidoAndReferencia(detallePedido.getReferencia_bonificado());
                    }
                    detallePedidoRepo.deleteById(detallePedido.getDetalle_id_pedido());

                    detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
                    buscarDescuentos(detallePedidoList);

                    detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());

                    configureAdapter();
                    calcularEncabezado();


                    showMessage(getString(R.string.eliminado_producto));
                }



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

    private Pedido createPedidoDefault(){

        Pedido defaultPedido = new Pedido();

        defaultPedido.setId_vendedor(usuario.getId_vendedor());
        defaultPedido.setId_cliente(cliente.getId_cliente());

        municipioRepo = new MunicipioRepo(getApplicationContext());
        municipio = (Municipio) municipioRepo.findById(cliente.getId_municipio());

        defaultPedido.setId_precio(municipio.getId_precio());
        defaultPedido.setId_municipio(municipio.getId_municipio());
        defaultPedido.setId_departamento(municipio.getId_departamento());
        defaultPedido.setId_ruta(cliente.getId_ruta_consumo());
        defaultPedido.setFactor_incremento(0.00);
        defaultPedido.setFecha_venta(currentDateandTime);
        defaultPedido.setFecha_vencimiento("");
        defaultPedido.setTipo_pago(cliente.getTipo_cliente());
        defaultPedido.setSubtotal_venta(0.00);
        defaultPedido.setDescuento_venta(0.00);
        defaultPedido.setIva_venta(0.00);
        defaultPedido.setTotal_factura_venta(0.00);
        defaultPedido.setTasa_cambio(tc);
        defaultPedido.setValor_dolares(0.00);
        defaultPedido.setNegociacion_especial("N");
        defaultPedido.setTipo_observacion("");
        defaultPedido.setSend(false);
        defaultPedido.setContacto_cliente(cliente.getContacto_cliente());
        defaultPedido.setContacto_vendedor(usuario.getContacto_vendedor());
        defaultPedido.setDireccion_empresa(cliente.getDireccion_empresa());
        defaultPedido.setEs_pc((cliente.getTipo_cliente().equals("C"))? "N": "");
        defaultPedido.setTipo_documento(municipio.getTipo_documento());




        if (pedidoRepo.create(defaultPedido) > 0){
            return defaultPedido;
        }else{
            return null;
        }



    }

    private void showMessage(String message){

        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
            toast.show();
    }

    private String getNombreTipoCliente(String tipo){
        if (tipo.toLowerCase().equals("c")){
            return getResources().getString(R.string.cliente_tipo_c);
        }else{
            return getResources().getString(R.string.cliente_tipo_p);
        }
    }

    @OnClick(R.id.button_agregar_producto)
    void agregarProducto(){
        Intent i = new Intent( PedidoActivity.this, ProductoActivity.class);
        //i.putExtra("id_factura", factura.getId_registro());
        startActivityForResult(i, PRODUCT_ACTIVITY_REQUEST_CODE);
        //startActivity(i);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PRODUCT_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String id_producto = data.getStringExtra(Intent.EXTRA_TEXT);
                Integer cantidad_solicitada = Integer.valueOf(data.getStringExtra("cantidad"));

                insertDetailOrder(id_producto,cantidad_solicitada);

            }

        }

    }

    private void insertDetailOrder(String product,Integer qty){

        String id_producto = product;
        Integer cantidad_solicitada = qty;

        producto = (Producto) productoRepo.findByIdProducto(id_producto);

        Double precio_venta_desc;
        Double porcentaje_descuento_venta;
        Double nivelPrecio = nivelPrecio();


        Integer cantidad_venta = 0;
        Integer cantidad_pedida = 0;
        Double subTotalVenta, subTotalVentaDesc;
        Double descuentoTotalVenta;
        Double totalIVAVenta;
        Double totalFacturaVenta;
        Double total_iva_antes;
        String bonificado =  producto.getBonificado().toString();
        String referencia;

        // Calculando descuentos
        precio_venta_desc = producto.getPrecio_venta();
        porcentaje_descuento_venta = 0.00;

        // Calculando cantidad venta y cantidad pedida
        //if ((cantidad_solicitada < producto.getSaldo_actual()) || (cantidad_solicitada == producto.getSaldo_actual())){
            cantidad_venta = cantidad_solicitada;

            if (producto.getBonificado().equals("N")){
                cantidad_pedida =  cantidad_solicitada;
            }

        /*}else {
            if (cantidad_solicitada > producto.getSaldo_actual()){
                cantidad_pedida = cantidad_solicitada;
                cantidad_venta = producto.getSaldo_actual();
            }
        }*/

        //

        Integer random = 11 + (int)(Math.random() * (1000 - 5));
        subTotalVenta = cantidad_venta * nivelPrecio;
        subTotalVentaDesc = cantidad_venta * (nivelPrecio / ((producto.getPorcentaje_iva_antes() / 100) + 1));
        descuentoTotalVenta = subTotalVentaDesc * porcentaje_descuento_venta;
        totalIVAVenta = (subTotalVentaDesc - descuentoTotalVenta) * (producto.getPorcentaje_iva_antes()/100);
        totalFacturaVenta = subTotalVentaDesc - descuentoTotalVenta + totalIVAVenta;
        total_iva_antes = subTotalVenta * (producto.getPorcentaje_iva_antes() / 100);
        referencia = producto.getId_producto() + producto.getId_familia() + pedido.getId_pedido() + producto.getId_producto() + random.toString();

        detallePedido = new DetallePedido();

        detallePedido.setId_pedido(pedido.getId_pedido());

        detallePedido.setId_precio(pedido.getId_precio());

        detallePedido.setCode_promo(producto.getCode_promo());
        detallePedido.setCode_promo_2(producto.getCode_promo_2());
        detallePedido.setCode_promo_3(producto.getCode_promo_3());
        detallePedido.setCode_promo_4(producto.getCode_promo_4());
        detallePedido.setCode_promo_combo(producto.getCode_promo_combo());
        detallePedido.setId_canal(cliente.getId_canal_distribucion());
        detallePedido.setId_proveedor(producto.getId_proveedor());
        detallePedido.setId_familia(producto.getId_familia());
        detallePedido.setId_producto(producto.getId_producto());
        detallePedido.setNom_producto(producto.getNombre_producto());
        detallePedido.setCantidad_pedida(cantidad_pedida);
        detallePedido.setCantidad_venta(cantidad_venta);
        detallePedido.setCaja_vendida(Double.parseDouble(String.valueOf(cantidad_venta / producto.getEmpaque())));
        producto.setPrecio_venta(nivelPrecio());
        detallePedido.setPrecio_venta_antes_iva(producto.getPrecio_venta() / ((producto.getPorcentaje_iva_antes() / 100) + 1));
        detallePedido.setPrecio_venta(producto.getPrecioVentaPedido(pedido.getId_precio()));
        detallePedido.setPrecio_venta_desc(precio_venta_desc);
        detallePedido.setSubtotal_venta(subTotalVenta);
        detallePedido.setSubtotal_venta_desc(subTotalVentaDesc);
        //nuevo
        detallePedido.setPrecio_costo_fisico(producto.getPrecio_costo());
        detallePedido.setTotal_iva_antes(total_iva_antes);
        detallePedido.setSubtotal_iva_antes(subTotalVenta - total_iva_antes);
        detallePedido.setSubtotal_fisico(producto.getPrecio_costo() * cantidad_venta);
        detallePedido.setUtilidad_venta((subTotalVenta - total_iva_antes) - (producto.getPrecio_costo() * cantidad_venta));
        detallePedido.setTipo_precio(pedido.getFactor_incremento());
        detallePedido.setPeriodo_trabajo(configuracion.getPeriodo_trabajo());


        detallePedido.setPorcentaje_descuento_venta(porcentaje_descuento_venta);

        detallePedido.setDescuento_total_venta(descuentoTotalVenta);
        detallePedido.setSubtotal_venta_aplicar_iva(0.00);
        if (producto.getPorcentaje_iva_antes() != null){
            detallePedido.setPorcentaje_iva_antes(producto.getPorcentaje_iva_antes());
        }
        else {
            detallePedido.setPorcentaje_iva_antes(0.00);
        }

        detallePedido.setTotal_iva_venta(totalIVAVenta);
        detallePedido.setTotal_factura_venta(totalFacturaVenta);
        detallePedido.setDes0(0.00);
        detallePedido.setDes1(0.00);
        detallePedido.setDes2(0.00);
        detallePedido.setDes3(0.00);
        detallePedido.setDes4(0.00);
        detallePedido.setDes5(0.00);
        detallePedido.setDes6(0.00);
        detallePedido.setDes7(0.00);
        detallePedido.setDes8(0.00);
        detallePedido.setDes9(0.00);
        detallePedido.setDes10(0.00);
        detallePedido.setDes11(0.00);
        detallePedido.setDes12(0.00);
        detallePedido.setDes13(0.00);
        detallePedido.setDes14(0.00);
        detallePedido.setDes15(0.00);
        detallePedido.setDes16(0.00);
        detallePedido.setDes17(0.00);
        detallePedido.setDes18(0.00);
        detallePedido.setDes19(0.00);
        detallePedido.setDes20(0.00);
        detallePedido.setDes21(0.00);
        detallePedido.setDes22(0.00);
        detallePedido.setEs_bonificado(bonificado);


        DetallePedido detallePedidoListforCode = detallePedidoRepo.getByPedidoForCodeProm(pedido.getId_pedido(),producto.getCode_promo_2());
        if (detallePedidoListforCode != null){
            detallePedido.setReferencia_bonificado_3(detallePedidoListforCode.getReferencia_bonificado());
        }else{
            detallePedido.setReferencia_bonificado_3(referencia);
        }

        detallePedido.setReferencia_bonificado(referencia);
        detallePedido.setEs_bonificado_2(bonificado);
        detallePedido.setReferencia_bonificado_2("");
        detallePedido.setEs_bonificado_3(bonificado);
        detallePedido.setEs_bonificado_4(bonificado);
        detallePedido.setReferencia_bonificado_4("");
        detallePedido.setEs_bonificado_5(bonificado);
        detallePedido.setReferencia_bonificado_5(id_producto + producto.getId_familia() + pedido.getId_pedido() + producto.getId_familia() + Math.round(100));
        detallePedido.setEs_bonificado_6(bonificado);
        detallePedido.setReferencia_bonificado_6("");

        if (detallePedidoRepo.create(detallePedido) > 0 ){

            showMessage(getString(R.string.detalle_pedido_producto_exito));

            detallePedidoRepo.deleteBonificacodsByIdPedido(detallePedido.getId_pedido());

            //
            detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
            buscarDescuentos(detallePedidoList);
            detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
            calcularEncabezado();
            configureAdapter();
            //RECALCULAR

        }else{
            showMessage(getString(R.string.detalle_pedido_producto_error));
        }
    }

    private double nivelPrecio(){
        municipioRepo = new MunicipioRepo(getApplicationContext());
        municipio = (Municipio) municipioRepo.findById(cliente.getId_municipio());
        double precioVenta = 0.00;

        switch(municipio.getId_precio()) {
            case 0:
                precioVenta = producto.getPrecio_venta();
                break;
            case 1:
                precioVenta = producto.getPrecio_venta_t1();
                break;
            case 2:
                precioVenta = producto.getPrecio_venta_t2();
                break;
            case 3:
                precioVenta = producto.getPrecio_venta_t3();
                break;
            case 4:
                precioVenta = producto.getPrecio_venta_t4();
                break;
            case 5:
                precioVenta = producto.getPrecio_venta_t5();
                break;
            case 6:
                precioVenta = producto.getPrecio_venta_t6();
                break;
            case 7:
                precioVenta = producto.getPrecio_venta_t7();
                break;
            case 8:
                precioVenta = producto.getPrecio_venta_t8();
                break;
            case 9:
                precioVenta = producto.getPrecio_venta_t9();
                break;
            default:
                precioVenta =producto.getPrecio_venta();
        }

        return precioVenta;
    }
    /*
    private void buscarCombosPares(String Code_promo_combo,List<DetallePedido> detallePedidoList) {

        int twoNumber = 0;
        int combo1int = 0;
        int combo2int = 0;

        List<Descuento15> descuento15List = descuento15Repo.buscarCombosPares(Code_promo_combo);

        List<DetallePedido> combo1 = null, combo2 = null;

        if (descuento15List == null) return;
        if (descuento15List.size() == 0) return;

        combo1 = detallePedidoRepo.getByPedidoForItem(pedido.getId_pedido(),descuento15List.get(0).getId_producto_1());

        combo2 = detallePedidoRepo.getByPedidoForItem(pedido.getId_pedido(),descuento15List.get(0).getId_producto_2());

        //Log.d("verificar", "buscarCombosPares: " + Integer.toString(combo1.size()) + " " + Integer.toString(combo2.size()));

        if (combo1.size() > 0 && combo2.size() > 0){

            //Este for hacer sum con ormlite
            for (DetallePedido item : detallePedidoList) {

                if(item.getId_producto().equals(descuento15List.get(0).getId_producto_1())){
                    combo1int += item.getCantidad_pedida();
                }

                if(item.getId_producto().equals(descuento15List.get(0).getId_producto_2())){
                    combo2int += item.getCantidad_pedida();
                }

            }


            Log.d("verificar", "buscarCombosPares: " + Integer.toString(combo1int) + " " + Integer.toString(descuento15List.get(0).getCantidad_regla_1()) + " " + Integer.toString(combo2int) + " " + Integer.toString(descuento15List.get(0).getCantidad_regla_2()));

            if (combo1int >= descuento15List.get(0).getCantidad_regla_1() && combo2int >= descuento15List.get(0).getCantidad_regla_2()){
                insertDetailOrder(descuento15List.get(0).getId_producto_3(),descuento15List.get(0).getCantidad_boni());
            }
        }


    }*/

    private void buscarDescuentos(List<DetallePedido> detallePedidoList){
    	if (!detallePedidoList.isEmpty()) {
		    for (DetallePedido item : detallePedidoList) {
			    item.setDes0( descuento0Repo.obtenerDescuento0(item.getId_producto(), item.getCantidad_pedida()) );
			    item.setDes1( descuento1Repo.obtenerDescuento1(item.getId_producto(), item.getCantidad_pedida()) );
			    item.setDes2( descuento2Repo.obtenerrDescuento2(item.getId_producto(), item.getCantidad_pedida()) );
			    item.setDes3( descuento3Repo.obtenerDescuento3(item.getId_familia(), detallePedidoList) );
			    item.setDes4( descuento4Repo.obtenerDescuento4(item.getId_familia(), detallePedidoList) );
			    item.setDes5( descuento5Repo.obtenerDescuento5(item.getId_proveedor(),pedido.getId_cliente(), detallePedidoList) );
			    item.setDes6( descuento6Repo.obtenerDescuento6(item.getId_proveedor(),pedido.getId_cliente(), detallePedidoList));
			    item.setDes7( descuento7Repo.obtenerDescuento7(item.getId_proveedor(), detallePedidoList));
			    item.setDes8( descuento8Repo.obtenerDescuento8(cliente.getId_cliente(), detallePedidoList) );
			    item.setDes9( descuento9Repo.obtenerDescuento9(detallePedidoList) );
			    item.setDes10(descuento10Repo.obtenerDescuento10(item.getCode_promo_4(), detallePedidoList));
			    item.setDes11(descuento11Repo.obtenerDescuento11(item.getCode_promo_3(), detallePedidoList));
			    item.setDes12(descuento12Repo.obtenerDescuento12(item, detallePedidoList,new ProductoRepo(this)));
			    item.setDes13(descuento13Repo.obtenerDescuento13(item, detallePedidoList,new ProductoRepo(this)));
			    item.setDes14(descuento14Repo.obtenerDescuento14(item.getId_proveedor(), detallePedidoList, item));
			    item.setDes15(descuento15Repo.obtenerDescuento15(item.getCode_promo_combo()));
			    item.setDes16(descuento16Repo.obtenerDescuento16(item.getId_proveedor(),cliente.getId_ruta_consumo(), detallePedidoList));
			    item.setDes18(descuento18Repo.obtenerDescuento18(item.getId_proveedor(), cliente.getId_canal_distribucion(), detallePedidoList));
			    item.setDes19(descuento19Repo.obtenerDescuento19(item.getId_producto(), cliente.getId_canal_distribucion(), detallePedidoList));
			    item.setDes20(descuento20Repo.obtenerDescuento20(item, cliente.getId_canal_distribucion(),new ProductoRepo(this)));
			    item.setDes21(descuento21Repo.obtenerDescuento21(item.getId_producto(), cliente.getId_canal_distribucion(), item.getCantidad_venta()));
			    item.setDes22(descuento22Repo.obtenerDescuento22(item, cliente.getId_cliente(),new ProductoRepo(this)));
			    Double total_descuento = item.getDes0() + item.getDes1() + item.getDes2() + item.getDes3() + item.getDes4() +
					    item.getDes5() + item.getDes6() + item.getDes7() + item.getDes8() + item.getDes9() + item.getDes10() +
                        item.getDes11() + item.getDes12() + item.getDes13() + item.getDes14() + item.getDes15() + item.getDes16() +
                        item.getDes18() + item.getDes19() + item.getDes20() + item.getDes21() + item.getDes22();
			    item.setPorcentaje_descuento_venta(total_descuento);
			    item.setDescuento_total_venta(item.getSubtotal_venta_desc() * total_descuento / 100);

			    // new calculos
                try{
                    Double test = item.getPrecio_venta() / ((total_descuento/100) + 1);
                    item.setPrecio_venta_desc(item.getPrecio_venta() / ((total_descuento/100) + 1));
                    item.setSubtotal_venta_aplicar_iva(item.getSubtotal_venta_desc() - item.getDescuento_total_venta());
                    item.setTotal_iva_venta(item.getSubtotal_venta_aplicar_iva() * (item.getPorcentaje_iva_antes()/100));
                    item.setTotal_factura_venta(item.getSubtotal_venta_aplicar_iva() + item.getTotal_iva_venta());
                }catch (Exception e){

                }


			    detallePedidoRepo.update(item);
			    
			    if (item.getDes0() >= 0.00){
			    	descuento0Repo.agregarBonificacion(item,new ProductoRepo(this));
			    }
			    
			    if (item.getDes2() >= 0.00){
			    	descuento2Repo.agregarBonificacion(item,new ProductoRepo(this));
			    }
			    
			    if (item.getDes15()>= 0.00){
			        descuento15Repo.agregarBonificacion(item,detallePedidoList,new ProductoRepo(this));
                }

			    if (item.getDes21() >= 0.00)
			        descuento21Repo.agregarBonificacion(item, cliente.getId_canal_distribucion(),new ProductoRepo(this));
		    }

		    //RECALCULAR
	    }
	    
	    detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
    }

    private void calcularEncabezado(){

        Double subTotal = 0.00;
        Double descuentoVenta = 0.00;
        Double ivaVenta = 0.00;
        Double totalFacturaVenta = 0.00;
        Double total_iva = 0.00,Total_fisico = 0.00,Utilidad_venta = 0.00,Total_iva_despues = 0.00,Total_fisico_despues = 0.00,Utilidad_venta_despues = 0.00,Total_sin_iva_despues = 0.00,Total_sin_iva = 0.00;


        /*
        Double montoIVA = 0.00;
        Double totalFactura = 0.00;
        Double montoUnitario = 0.00;
        Double montoUnitarioIVA = 0.00;
        Double montoFacturaUnitario = 0.00;
        */

        for (DetallePedido detalle: detallePedidoList) {
            //montoUnitario = (detalle.getCantidad_pedida() * detalle.getPrecio_venta_antes_iva());

            subTotal+= detalle.getSubtotal_venta_desc(); //getSubtotal_venta();
            descuentoVenta+= detalle.getDescuento_total_venta();
            ivaVenta+= detalle.getTotal_iva_venta();
            totalFacturaVenta+= detalle.getTotal_factura_venta();

            total_iva += detalle.getTotal_iva_antes();
            Total_sin_iva += detalle.getTotal_factura_venta() - detalle.getTotal_iva_antes();
            Total_fisico += detalle.getSubtotal_fisico();
            Utilidad_venta += detalle.getUtilidad_venta();
            Total_iva_despues += detalle.getTotal_iva_venta();
            Total_fisico_despues += detalle.getSubtotal_fisico();
            Utilidad_venta_despues += detalle.getUtilidad_venta();
            Total_sin_iva_despues += detalle.getSubtotal_iva_antes();

           // montoUnitarioIVA = montoUnitario * (detalle.getPrecio_venta_antes_iva() / 100);
           // montoIVA+= detalle.getTotal_iva_venta();
           // montoFacturaUnitario = (detalle.getCantidad_pedida() * detalle.getPrecio_venta());
            //totalFactura+= montoFacturaUnitario;
        }

        Double valorDolares = 0.00;

        if((tc != 0))
            valorDolares = totalFacturaVenta/tc;

        pedido_subtotal_venta.setText(getString(R.string.moneda_nacional) + " "  + Utility.formatMonyNotCoin(subTotal));

        pedido_descuento_venta.setText(getString(R.string.moneda_nacional) + " "  + Utility.formatMonyNotCoin( descuentoVenta));
        pedido_total_factura_venta.setText(getString(R.string.moneda_nacional) + " "  + Utility.formatMonyNotCoin( totalFacturaVenta));

        pedido_iva_venta.setText(getString(R.string.moneda_nacional) + " "  + Utility.formatMonyNotCoin( ivaVenta));

        pedido_valor_dolares.setText(getString(R.string.moneda_dolar) + " "  + Utility.formatMonyNotCoin( valorDolares));

        // actualizar

        pedido.setSubtotal_venta(subTotal);
        pedido.setDescuento_venta(descuentoVenta);
        pedido.setIva_venta(ivaVenta);
        pedido.setTotal_factura_venta(totalFacturaVenta);
        pedido.setValor_dolares(valorDolares);


        pedido.setTotal_iva(total_iva);
        pedido.setTotal_sin_iva(Total_sin_iva);
        pedido.setTotal_fisico(Total_fisico);
        pedido.setUtilidad_venta(Utilidad_venta);
        pedido.setTotal_iva_despues(Total_iva_despues);
        pedido.setTotal_fisico_despues(Total_fisico_despues);
        pedido.setUtilidad_venta_despues(Utilidad_venta_despues);
        pedido.setTotal_sin_iva_despues(Total_sin_iva_despues);



        if (cliente.getTipo_cliente().equals("C") && pedido.getNegociacion_especial().equals("N")) {
            pedido.setPendiente_autorizacion("1");
            pedido.setMonto_autorizado(totalFacturaVenta);
            pedido.setAutoriza("A");
        }else if(cliente.getTipo_cliente().equals("C") && pedido.getNegociacion_especial().equals("S"))   {
            pedido.setPendiente_autorizacion("0");
            pedido.setMonto_autorizado(totalFacturaVenta);
            pedido.setAutoriza("A");
        }

        if(cliente.getTipo_cliente().equals("P")){
            pedido.setPendiente_autorizacion("0");
            pedido.setMonto_autorizado(0.00);
            pedido.setAutoriza("");
        }

        pedidoRepo.update(pedido);

    }

    private void getEncabezadoPedido(){
        pedido_subtotal_venta.setText(getString(R.string.moneda_nacional) + " "  + Utility.formatMonyNotCoin( pedido.getSubtotal_venta()));
        pedido_descuento_venta.setText(getString(R.string.moneda_nacional) + " "  + Utility.formatMonyNotCoin( pedido.getDescuento_venta()));
        pedido_iva_venta.setText(getString(R.string.moneda_nacional) + " "  + Utility.formatMonyNotCoin( pedido.getIva_venta()));
        pedido_total_factura_venta.setText(getString(R.string.moneda_nacional) + " "  +Utility.formatMonyNotCoin( pedido.getTotal_factura_venta()));
        pedido_tasa_cambio.setText(getString(R.string.moneda_nacional) + " "  + Utility.formatMonyNotCoin( pedido.getTasa_cambio()));
        pedido_valor_dolares.setText(getString(R.string.moneda_dolar) + " "  + Utility.formatMonyNotCoin( pedido.getValor_dolares()));

    }


    private void configureAdapter(){

        lstDetallePedido.setAdapter(null);


        if (!detallePedidoList.isEmpty()){

            detallePedidoAdapter = new DetallePedidoAdapter(this, R.layout.detalle_pedido_row, detallePedidoList);

            lstDetallePedido.setAdapter(detallePedidoAdapter);

            ViewGroup.LayoutParams mParamSpecies = lstDetallePedido.getLayoutParams();
            mParamSpecies.height = (detallePedidoList.size()) * 80;
            lstDetallePedido.setLayoutParams(mParamSpecies);


        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0, 1, menu.NONE, getString(R.string.sub_menu_negociacion_pedido));
        menu.add(0, 2, menu.NONE, getString(R.string.sub_menu_elimina_pedido));
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1){
            // negociacion especial

            createNegociacionEspecial();

        }else{
            if (id ==2){
                // delete dialog
                deletePedido();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void createNegociacionEspecial(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_negociacion_especial, null);

        final CheckBox pedido_negociacion_especial_checkbox = (CheckBox) v.findViewById(R.id.pedido_negociacion_especial_checkbox);
        final EditText pedido_tipo_observacion = (EditText) v.findViewById(R.id.pedido_tipo_observacion);
        Button button_guardar_negociacion = (Button) v.findViewById(R.id.button_guardar_negociacion);

        builder.setView(v);

        final AlertDialog dialog = builder.create();

        if (pedido.getNegociacion_especial().toLowerCase().equals("s")){
            pedido_negociacion_especial_checkbox.setChecked(true);
            pedido_tipo_observacion.setEnabled(true);
            pedido_tipo_observacion.setText(pedido.getTipo_observacion());
        }else{
            pedido_negociacion_especial_checkbox.setChecked(false);
            pedido_tipo_observacion.setEnabled(false);
            pedido_tipo_observacion.setText("");
        }

        pedido_negociacion_especial_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();

                if (checked){
                    pedido_tipo_observacion.setEnabled(true);
                }else{
                    pedido_tipo_observacion.setEnabled(false);
                    pedido_tipo_observacion.setText("");
                }

            }
        });

        button_guardar_negociacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pedido_negociacion_especial_checkbox.isChecked()){
                    if (pedido_tipo_observacion.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"La observacion no puede estar vacia",Toast.LENGTH_LONG).show();
                        return;
                    }
                    pedido.setNegociacion_especial("S");
                    pedido.setTipo_observacion(pedido_tipo_observacion.getText().toString());
                }else{
                    pedido.setNegociacion_especial("N");
                    pedido.setTipo_observacion("");
                }

                pedidoRepo.update(pedido);
                calcularEncabezado();
                dialog.cancel();
            }
        });


        dialog.show();

    }


    private void deletePedido(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getResources().getString(R.string.alert_dilog_title_eliminar_pedido));
        alertDialogBuilder.setIcon(R.drawable.ic_ask);
        alertDialogBuilder.setMessage(getResources().getString(R.string.messages_eliminar_pedido));


        alertDialogBuilder.setPositiveButton(R.string.messages_send_data_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                detallePedidoRepo.deleteByIdPedido(pedido.getId_pedido());
                pedidoRepo.deleteById(pedido.getId_pedido());

                showMessage(getString(R.string.elimina_registro_pedido));

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

//    public void onCheckboxClicked(View view) {
//
//    }

}



