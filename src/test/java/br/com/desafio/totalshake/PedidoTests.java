package br.com.desafio.totalshake;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PedidoTests {

    @Autowired
    PedidoRepository repository;

    @Test
    void createPedido() {
        Pedido pedido = new Pedido();
        pedido.setId(1234688L);
        pedido.setStatus(Status.REALIZADO);
        pedido.setDataHora(LocalDateTime.now());

        List<ItemPedido> itensPedido = new ArrayList<>();
        itensPedido.add(new ItemPedido(5,"novo item", pedido));
        itensPedido.add(new ItemPedido(6,"novo item 2", pedido));
        pedido.setItensPedidoList(itensPedido);

        repository.save(pedido);
    }
}