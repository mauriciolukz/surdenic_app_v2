package com.clov3rlabs.jensoft.surdenic.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.TextView;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.models.Producto;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductoMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Producto> productoList;
    private List<Producto> productoListFiltered;
    private int lastPosition = -1;
    private ProductoFilter productoFilter;

    class MyViewHolder extends RecyclerView.ViewHolder {

        // Card
        @BindView(R.id.producto_card)
        CardView producto_card;

        @BindView(R.id.codigo_producto) TextView codigo_producto;
        @BindView(R.id.nombre_producto) TextView nombre_producto;
        @BindView(R.id.empaque_producto) TextView empaque_producto;
        @BindView(R.id.precio_producto) TextView precio_producto;
        @BindView(R.id.saldo_actual) TextView saldo_actual;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            // Set type face


        }
    }

    public ProductoMainAdapter(Context mContext, List<Producto> productoList){
        this.mContext = mContext;
        this.productoList = productoList;
        this.productoListFiltered = productoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holderMain, int position){

        final Producto producto = productoListFiltered.get(position);

        MyViewHolder holder = (MyViewHolder) holderMain;

        setAnimation(holder.itemView, position);

        holder.codigo_producto.setText(producto.getId_producto());
        holder.nombre_producto.setText(producto.getNombre_producto());
        holder.empaque_producto.setText(producto.getEmpaque().toString());
        holder.precio_producto.setText(mContext.getResources().getString(R.string.moneda_nacional) + " " + String.format("%.2f", producto.getPrecio_venta()));
        holder.saldo_actual.setText(mContext.getResources().getString(R.string.producto_saldo_actual) + " " + producto.getSaldo_actual().toString());

//        holder.producto_card.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v){
//                Intent i = new Intent(v.getContext(), FacturaActivity.class);
//                i.putExtra("id_factura", factura.getId_registro());
//
//                mContext.startActivity(i);
//
//            }
//
//        });



    }

    @Override
    public int getItemCount(){
        return productoListFiltered.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    public Filter getFilter(){
        if (productoFilter == null) {
            productoFilter = new ProductoFilter();
        }
        return productoFilter;
    }

    public class ProductoFilter extends Filter{


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

                    /*
                    if (producto.getId_producto().toLowerCase().contains(constraint.toString().toLowerCase())) {
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

        @Override
        protected void publishResults(CharSequence constraint,FilterResults results) {
            productoListFiltered = (ArrayList<Producto>) results.values;
            notifyDataSetChanged();
        }

    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


}
