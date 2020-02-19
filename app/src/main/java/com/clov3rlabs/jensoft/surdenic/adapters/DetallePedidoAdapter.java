package com.clov3rlabs.jensoft.surdenic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Producto;
import com.clov3rlabs.jensoft.surdenic.repo.ProductoRepo;
import com.clov3rlabs.jensoft.surdenic.utils.Utility;

import java.util.List;

public class DetallePedidoAdapter extends ArrayAdapter<DetallePedido> {

    private List<DetallePedido> detallePedidoList;
    private Context mContext;
    private LayoutInflater mInflater;

    public DetallePedidoAdapter(Context context, int viewResourceId, List<DetallePedido> detallePedidoList){
        super(context, viewResourceId);
        this.mContext = context;
        this.detallePedidoList = detallePedidoList;
        mInflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder viewHolder;
        DetallePedido detallePedido = this.getItem(position);

        ProductoRepo productoRepo = new ProductoRepo(getContext());
        Producto producto;
        producto = productoRepo.findByIdProducto(detallePedido.getId_producto());


        if (convertView == null){
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.detalle_pedido_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nombre_producto = (TextView)convertView.findViewById(R.id.detalle_pedido_nombre_producto);
            viewHolder.cantidad = (TextView)convertView.findViewById(R.id.detalle_pedido_cantidad);
            viewHolder.precio = (TextView)convertView.findViewById(R.id.detalle_pedido_precio_prducto);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nombre_producto.setText(producto.getId_producto() + " - " + producto.getNombre_producto());
        viewHolder.nombre_producto.setTextSize(12);
        //viewHolder.cantidad.setText(detallePedido.getCantidad_pedida().toString());
        viewHolder.cantidad.setText(detallePedido.getCantidad_venta().toString());
        viewHolder.cantidad.setTextSize(12);
        //viewHolder.precio.setText(String.format("%.2f", detallePedido.getTotal_factura_venta()));
        viewHolder.precio.setText(Utility.formatMonyNotCoin(detallePedido.getTotal_factura_venta()));
        viewHolder.precio.setTextSize(12);

        return convertView;

    }

    static class ViewHolder {
        TextView nombre_producto;
        TextView cantidad;
        TextView precio;
    }

    public DetallePedido getItem(int position){
        return this.detallePedidoList.get(position);
    }

    public int getCount(){
        return detallePedidoList.size();
    }

    public long getItemId(int position) {
        return this.detallePedidoList.get(position).getDetalle_id_pedido();
    }







}
