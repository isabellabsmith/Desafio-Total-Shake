package br.com.desafio.totalshake.model;

import br.com.desafio.totalshake.dto.PedidoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pedido implements Serializable {
    @Id
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    private Long id;
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "pedido", orphanRemoval = true, cascade = CascadeType.ALL)
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
        this.dataHora = pedidoRequest.getDataHora();
        this.status = pedidoRequest.getStatus();
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

    public void setItensPedidoList(List<ItemPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }

    public List<ItemPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public ItemPedido addItemPedido ( ItemPedido itemPedido ) {
        itensPedidoList.add(itemPedido);
        return itemPedido;
    }

    public ItemPedido removeItemPedido ( ItemPedido itemPedido ) {
        itensPedidoList.remove(itemPedido);
        return itemPedido;
    }
}
