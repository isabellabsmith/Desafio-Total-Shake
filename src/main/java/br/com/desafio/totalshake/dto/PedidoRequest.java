package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.PrePersist;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class PedidoRequest {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime dataHora;
    private Status status;
    private List<ItemPedidoRequest> itensPedidoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = serialVersionUID;
    }

    public CharSequence getDataHora() {
        return dataHora;
    }

    @PrePersist
    void prePersist(){
        this.dataHora = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ItemPedidoRequest> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItemPedidoRequest> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }
}
