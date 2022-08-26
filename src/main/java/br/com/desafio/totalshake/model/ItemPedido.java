package br.com.desafio.totalshake.model;

import br.com.desafio.totalshake.dto.ItemPedidoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotBlank
    private Integer quantidade;
    @NotBlank
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public ItemPedido(Integer quantidade, String descricao, Pedido pedido) {
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public ItemPedidoResponse getItensResponse() {
        return new ItemPedidoResponse(this.getId(), this.getDescricao(), this.getQuantidade());
    }
}
