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
import android.widget.ImageView;
import android.widget.TextView;

import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.activities.ClienteActivity;
import com.clov3rlabs.jensoft.surdenic.activities.FacturaActivity;
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.Cobro;
import com.clov3rlabs.jensoft.surdenic.models.CobroNoExitoso;
import com.clov3rlabs.jensoft.surdenic.models.Factura;
import com.clov3rlabs.jensoft.surdenic.repo.ClienteRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CobroNoExitosoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.CobroRepo;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FacturaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Factura> facturaList;
    private List<Factura> facturaListFiltered;
    private int lastPosition = -1;
    private FacturaFilter facturaFilter;
    private ClienteRepo clienteRepo;

    class MyViewHolder extends RecyclerView.ViewHolder {

        // Card
        @BindView(R.id.factura_card)
        CardView facura_card;

        @BindView(R.id.num_factura) TextView num_factura;
        @BindView(R.id.total_vendido) TextView total_vendido;
        @BindView(R.id.monto_pc) TextView monto_pc;
        @BindView(R.id.fecha_vence) TextView fecha_vence;
        @BindView(R.id.fact_nombre_cliente) TextView fact_nombre_cliente;
        @BindView(R.id.imageViewStatusFactura) ImageView imageViewStatusFactura;
        @BindView(R.id.imageViewStatusSync) ImageView imageViewStatusSync;
        @BindView(R.id.monto_abonado) TextView monto_abonado;
        @BindView(R.id.fact_codigo_cliente) TextView fact_codigo_cliente;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            // Set type face


        }
    }

    public FacturaAdapter(Context mContext, List<Factura> clienteList){
        this.mContext = mContext;
        this.facturaList = clienteList;
        this.facturaListFiltered = clienteList;
        clienteRepo = new ClienteRepo(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.factura_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holderMain, int position){

        final Factura factura = facturaListFiltered.get(position);
        Cliente cliente = (Cliente) clienteRepo.findById(factura.getId_cliente());
        MyViewHolder holder = (MyViewHolder) holderMain;
        String Idcliente = "";

        if (cliente != null)
            Idcliente = cliente.getId_cliente().toString();

        setAnimation(holder.itemView, position);

        holder.num_factura.setText(factura.getNum_factura());
        holder.fact_nombre_cliente.setText(factura.getContacto_cliente());
        holder.fact_codigo_cliente.setText("(" + Idcliente + ") -");
        holder.total_vendido.setText(mContext.getResources().getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getTotal_vendido()));
        holder.monto_pc.setText(mContext.getResources().getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getMonto_pc()));
        holder.fecha_vence.setText("Vence: " + factura.getFecha_vence());
        holder.monto_abonado.setText(mContext.getResources().getString(R.string.moneda_nacional) + " " + String.format("%.2f", factura.getMonto_abonado()));


        CobroRepo cobroRepo = new CobroRepo(mContext);
        Cobro cobro = cobroRepo.getByNumeroFactura(factura.getNum_factura());


        if (cobro != null){
            holder.imageViewStatusFactura.setImageResource(R.drawable.usergreen);
        }else if(cobro == null){
            holder.imageViewStatusFactura.setImageResource(R.drawable.useryellow);
        }

        final CobroNoExitosoRepo cobroNoExitosoRepo = new CobroNoExitosoRepo(mContext);

        final CobroNoExitoso cobroNoExitoso = cobroNoExitosoRepo.findByIdVendedorAndIdCliente(factura.getId_vendedor(), factura.getId_cliente());

        if (cobroNoExitoso != null){
            holder.imageViewStatusFactura.setImageResource(R.drawable.userred);
        }

        if (cobro != null){
            holder.imageViewStatusSync.setImageResource(cobro.getSend() ?  R.drawable.sync :  R.drawable.stopsinc);
        }


        holder.facura_card.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), FacturaActivity.class);
                i.putExtra("id_factura", factura.getId_registro());

                mContext.startActivity(i);

            }

        });



    }

    @Override
    public int getItemCount(){
        return facturaListFiltered.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    public Filter getFilter(){
        if (facturaFilter == null) {
            facturaFilter = new FacturaFilter();
        }
        return facturaFilter;
    }

    public class FacturaFilter extends Filter{


        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults filterResults  = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                List<Factura> tempList = new ArrayList<>();
                // search content in solicitude list
                for (Factura factura : facturaList) {

                    if (factura.toString().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(factura);
                    }

                    /*
                    if (factura.getNum_factura().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(factura);
                    }
                    */
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = facturaList.size();
                filterResults.values = facturaList;
            }


            return filterResults ;

        }

        @Override
        protected void publishResults(CharSequence constraint,FilterResults results) {
            facturaListFiltered = (ArrayList<Factura>) results.values;
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
