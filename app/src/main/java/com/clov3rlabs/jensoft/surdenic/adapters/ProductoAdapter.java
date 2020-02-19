package com.clov3rlabs.jensoft.surdenic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.models.Producto;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {

    private List<Producto> productoList;
    private List<Producto> productosFiltered;
    private int lastPosition = -1;
    private ProductoFilter productoFilter;

    private Context mContext;
    private LayoutInflater mInflater;

    public ProductoAdapter(Context context, int viewResourceId, List<Producto> productos){
        super(context, viewResourceId);
        this.mContext = context;
        this.productoList = productos;
        this.productosFiltered = productos;
        mInflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder viewHolder;
        Producto producto = this.getItem(position);

        if (convertView == null){
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.producto_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nombre_producto = (TextView)convertView.findViewById(R.id.item_nombre_producto);
            viewHolder.codigo_producto = (TextView) convertView.findViewById(R.id.item_codigo_producto);
            viewHolder.precio_producto = (TextView) convertView.findViewById(R.id.item_precio_producto);
            viewHolder.existencia_producto = (TextView) convertView.findViewById(R.id.item_existencia_producto);
            viewHolder.empaque_producto = (TextView) convertView.findViewById(R.id.item_empaque_producto);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nombre_producto.setText(producto.getNombre_producto());
        viewHolder.codigo_producto.setText(producto.getId_producto().toString());
        viewHolder.precio_producto.setText(getContext().getString(R.string.moneda_nacional) + " " + String.format("%.2f", producto.getPrecio_venta()));
        viewHolder.existencia_producto.setText(producto.getSaldo_actual().toString());
        viewHolder.empaque_producto.setText(producto.getEmpaque().toString());


        return convertView;

    }

    static class ViewHolder {
        TextView codigo_producto;
        TextView nombre_producto;
        TextView precio_producto;
        TextView existencia_producto;
        TextView empaque_producto;
    }

    public Producto getItem(int position){
        return this.productosFiltered.get(position);
    }

    public int getCount(){
        return productosFiltered.size();
    }

    public long getItemId(int position) {
        return Integer.valueOf(this.productosFiltered.get(position).getId_producto());
    }

    public Filter getFilter(){
        if (productoFilter == null) {
            productoFilter = new ProductoFilter();
        }
        return productoFilter;
    }

    public class ProductoFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults filterResults  = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                List<Producto> tempList = new ArrayList<>();
                // search content in solicitude list
                for (Producto producto : productoList) {

                    if (producto.toString().toLowerCase().contains(constraint.toString().toLowerCase())){
                        tempList.add(producto);
                    }

                    /*if (producto.getNombre_producto().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(producto);
                    }
                    */

                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = productoList.size();
                filterResults.values = productoList;
            }


            return filterResults ;

        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,FilterResults results) {
            productosFiltered = (ArrayList<Producto>) results.values;
            notifyDataSetChanged();
        }

    }


}
