package br.com.desafio.totalshake.model;

import br.com.desafio.totalshake.dto.PedidoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @JoinColumn(name = "item_pedido_id")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private LocalDateTime dataHora;
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pedido")
    @JoinColumn(name = "item_pedido_id")
    private List<ItemPedido> itensPedidoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido(LocalDateTime dataHora, Status status, List<ItemPedido> itens) {
        this.dataHora = dataHora;
        this.status = status;
        this.itensPedidoList = itens;
    }

    public void updatePedido(PedidoRequest pedidoRequest) {
        this.dataHora = LocalDateTime.parse(pedidoRequest.getDataHora());
        this.status = Status.valueOf(pedidoRequest.getStatus());
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ItemPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItemPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }

    public ItemPedido addItemPedido ( ItemPedido itemPedido ) {
        getItensPedidoList().add( itemPedido );
        itemPedido.setPedido( this );

        return itemPedido;
    }

    public ItemPedido removeItemPedido ( ItemPedido itemPedido ) {
        getItensPedidoList().remove( itemPedido );
        itemPedido.setPedido( null );

        return itemPedido;
    }
}
