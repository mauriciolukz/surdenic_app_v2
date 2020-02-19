package com.clov3rlabs.jensoft.surdenic.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.models.Factura;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by rsaavedra on 12/09/2018.
 */

public class FacturaClienteAdapter extends ArrayAdapter<Factura> {

    private List<Factura> facturas;
    private Context mContext;
    private LayoutInflater mInflater;


    public FacturaClienteAdapter(Context context, int viewResourceId, List<Factura> facturas){
        super(context, viewResourceId);
        this.mContext = context;
        this.facturas = facturas;
        mInflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }


    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder viewHolder;
        Factura factura = this.getItem(position);


        if (convertView == null){
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.factura_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.num_factura = (TextView)convertView.findViewById(R.id.item_num_factura);
            viewHolder.monto_factura = (TextView)convertView.findViewById(R.id.item_monto_factura);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.num_factura.setText(factura.getNum_factura());
        viewHolder.monto_factura.setText(String.format("%.2f", factura.getTotal_vendido()));

        return convertView;

    }

    static class ViewHolder {
        TextView num_factura;
        TextView monto_factura;
    }

    public Factura getItem(int position){
        return this.facturas.get(position);
    }

    public int getCount(){
        return facturas.size();
    }

    public long getItemId(int position) {
        return this.facturas.get(position).getId_registro();
    }


}
