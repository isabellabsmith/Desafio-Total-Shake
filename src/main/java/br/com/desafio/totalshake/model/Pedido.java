package br.com.desafio.totalshake.model;

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

    @PrePersist
    void prePersist(){
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
