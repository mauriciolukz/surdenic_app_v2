package com.clov3rlabs.jensoft.surdenic.models;

import java.util.List;

public class PedidosRequest {

    private List<PedidoRequest> pedidos;

    public List<PedidoRequest> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoRequest> pedidos) {
        this.pedidos = pedidos;
    }
}
