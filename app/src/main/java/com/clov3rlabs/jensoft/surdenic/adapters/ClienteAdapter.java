package com.clov3rlabs.jensoft.surdenic.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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
import com.clov3rlabs.jensoft.surdenic.models.Cliente;
import com.clov3rlabs.jensoft.surdenic.models.DetallePedido;
import com.clov3rlabs.jensoft.surdenic.models.Pedido;
import com.clov3rlabs.jensoft.surdenic.models.VisitaNoExitosa;
import com.clov3rlabs.jensoft.surdenic.repo.DetallePedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.PedidoRepo;
import com.clov3rlabs.jensoft.surdenic.repo.VisitaNoExitosaRepo;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClienteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Cliente> clienteList;
    private List<Cliente> clienteListFiltered;
    private int lastPosition = -1;
    private ClienteFilter clienteFilter;

    class MyViewHolder extends RecyclerView.ViewHolder {

        // Card
        @BindView(R.id.cliente_card) CardView cliente_card;

        @BindView(R.id.nombre_cliente) TextView nombre_cliente;
        @BindView(R.id.codigo_cliente) TextView codigo_cliente;
        @BindView(R.id.tipo_cliente) TextView tipo_cliente;
        //@BindView(R.id.tipo_documento) TextView tipo_documento;
        //@BindView(R.id.negocio_cliente) TextView negocio_cliente;
        @BindView(R.id.direccion_cliente) TextView direccion_cliente;
        @BindView(R.id.telefono_cliente) TextView telefono_cliente;
        @BindView(R.id.imageViewSinc) ImageView imageViewSinc;
        @BindView(R.id.imageViewStatusUser) ImageView imageViewStatusUser;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            // Set type face


        }
    }

    public ClienteAdapter(Context mContext, List<Cliente> clienteList){
        this.mContext = mContext;
        this.clienteList = clienteList;
        this.clienteListFiltered = clienteList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cliente_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holderMain, int position){

        final Cliente cliente = clienteListFiltered.get(position);

        MyViewHolder holder = (MyViewHolder) holderMain;

        setAnimation(holder.itemView, position);

        holder.nombre_cliente.setText(cliente.getContacto_cliente());
        holder.codigo_cliente.setText(cliente.getId_cliente().toString());
        holder.tipo_cliente.setText("Tipo: " + getNombreTipoCliente(cliente.getTipo_cliente()));
        //holder.negocio_cliente.setText(cliente.getNombre_empresa());
        holder.direccion_cliente.setText(cliente.getDireccion_empresa());
        holder.telefono_cliente.setText(cliente.getTelefono());

        PedidoRepo flagCliente  = new PedidoRepo(mContext);
        Pedido pedido =  flagCliente.getByClienteAndVendedor(cliente.getId_cliente(),cliente.getId_vendedor());

        if (pedido != null){
            holder.imageViewSinc.setImageResource((pedido.getSend()) ?  R.drawable.sync :  R.drawable.stopsinc);

            List<DetallePedido> detallePedidoList = null;
            DetallePedidoRepo detallePedidoRepo = new DetallePedidoRepo(mContext);
            detallePedidoList = detallePedidoRepo.getByPedido(pedido.getId_pedido());
            if (detallePedidoList.size() > 0)
                holder.imageViewStatusUser.setImageResource(R.drawable.usergreen);
        }

        final VisitaNoExitosaRepo visitaNoExitosaRepo = new VisitaNoExitosaRepo(mContext);
        final VisitaNoExitosa visitaNoExitosa = visitaNoExitosaRepo.findByIdVendedorAndIdCliente(cliente.getId_vendedor(), cliente.getId_cliente());

        if (visitaNoExitosa != null){
            holder.imageViewStatusUser.setImageResource(R.drawable.userred);
        }

        if (pedido == null && visitaNoExitosa == null){
            holder.imageViewStatusUser.setImageResource(R.drawable.useryellow);
        }




        holder.cliente_card.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), ClienteActivity.class);
                i.putExtra("cliente_id", cliente.getId_cliente());

                mContext.startActivity(i);

            }

        });

    }

    @Override
    public int getItemCount(){
        return clienteListFiltered.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }


    public Filter getFilter(){
        if (clienteFilter == null) {
            clienteFilter = new ClienteFilter();
        }
        return clienteFilter;
    }

    public class ClienteFilter extends Filter{


        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults filterResults  = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                List<Cliente> tempList = new ArrayList<>();
                // search content in solicitude list
                for (Cliente cliente : clienteList) {
                    if (cliente.toString().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(cliente);
                    }

                    /*
                    if (cliente.getContacto_cliente().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(cliente);
                    }
                    */
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = clienteList.size();
                filterResults.values = clienteList;
            }


            return filterResults ;

        }

        @Override
        protected void publishResults(CharSequence constraint,FilterResults results) {
            clienteListFiltered = (ArrayList<Cliente>) results.values;
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

    private String getNombreTipoCliente(String tipo){
        if (tipo.toLowerCase().equals("c")){
            return mContext.getResources().getString(R.string.cliente_tipo_c);
        }else{
            return mContext.getResources().getString(R.string.cliente_tipo_p);
        }
    }

}
