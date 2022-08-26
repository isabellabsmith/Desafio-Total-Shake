package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.ItemPedidoRequest;
import br.com.desafio.totalshake.dto.PedidoRequest;
import br.com.desafio.totalshake.dto.PedidoResponse;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import br.com.desafio.totalshake.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PedidoController {
    PedidoRepository pedidoRepository;

    @GetMapping(path = "/pedido")
    @ResponseBody
    public PedidoResponse getPedido(@RequestParam Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(Math.toIntExact(id));
        if(!pedido.isEmpty()) {
            return new PedidoResponse(pedido.get());
        } else {
            return new PedidoResponse();
        }
    }

    @PostMapping(path = "/pedido/", consumes = "application/json")
    public void addPedido(@RequestBody PedidoRequest pedidoRequest) {

        Status status = Status.valueOf(pedidoRequest.getStatus());
        LocalDateTime localDateTime = LocalDateTime.parse(pedidoRequest.getDataHora());
        List<ItemPedidoRequest> itemPedidoRequests = pedidoRequest.getItensPedidoList();

        Pedido pedido = new Pedido(localDateTime, status, Collections.emptyList());

        ItemPedidoRequest.setPedido(pedido);
        List<ItemPedido> itemPedidos = itemPedidoRequests.stream().map(item -> item.toItemPedido(item)).toList();

        pedido.setItensPedidoList(itemPedidos);

        pedidoRepository.save(pedido);

    }

    @PutMapping(path = "/pedido", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<PedidoResponse> updatePedido(@RequestBody PedidoRequest pedido){
        Optional<Pedido> pedidoToUpdate = pedidoRepository.findById(Math.toIntExact(pedido.getId()));

        if(!pedidoToUpdate.isEmpty()) {
            pedidoToUpdate.get().updatePedido(pedido);
            pedidoRepository.save(pedidoToUpdate.get());
        }

        return ResponseEntity.ok().body(new PedidoResponse(pedidoToUpdate.get()));
    }

    @DeleteMapping(path = "/pedido")
    @ResponseBody
    public void deletePedido(@RequestParam Long id) {
        pedidoRepository.deleteById(Math.toIntExact(id));
    }
}
