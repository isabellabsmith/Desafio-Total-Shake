package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ItemPedidoRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer quantidade;
    private String descricao;
    private Long idPedido;

    private static Pedido pedido;

    public Long getIdPedido() {
        return idPedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ItemPedido toItemPedido(ItemPedidoRequest itemPedidoRequest) {
        return new ItemPedido(itemPedidoRequest.getId(),itemPedidoRequest.getQuantidade(), itemPedidoRequest.getDescricao(), itemPedidoRequest.getPedido());
    }

    public Pedido getPedido() {
        return pedido;
    }

    public static void setPedido(Pedido pedido) {
        ItemPedidoRequest.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = serialVersionUID;
    }
}
