package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.Pedido;

import java.util.List;

public class PedidoResponse {
    private Long id;
    private String dataHora;
    private String status;
    private List<ItemPedidoResponse> itemList;


    public PedidoResponse() {};

    public PedidoResponse(Pedido pedido) {
        this.id = pedido.getId();
        this.dataHora = String.valueOf(pedido.getDataHora());
        this.status = String.valueOf(pedido.getStatus());
        this.itemList = pedido.getItensPedidoList().stream().map(itemPedido -> itemPedido.getItensResponse()).toList();
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemPedidoResponse> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemPedidoResponse> itemList) {
        this.itemList = itemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
