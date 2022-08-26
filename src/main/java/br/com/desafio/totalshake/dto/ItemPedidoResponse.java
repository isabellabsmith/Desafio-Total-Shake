package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemPedidoResponse {
    private Long id;
    private String descricao;
    private Integer quantidade;
    public ItemPedidoResponse(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.descricao = itemPedido.getDescricao();
        this.quantidade = itemPedido.getQuantidade();
    }

    public ItemPedidoResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
