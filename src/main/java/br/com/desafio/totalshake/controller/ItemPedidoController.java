package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.ItemPedidoRequest;
import br.com.desafio.totalshake.dto.ItemPedidoResponse;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class ItemPedidoController {
    ItemPedidoRepository itemPedidoRepository;
    PedidoRepository pedidoRepository;

    @GetMapping(path = "/item/{id}")
    @ResponseBody
    public ResponseEntity<ItemPedidoResponse> getItem(@PathVariable Long id) {
        Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(id);
        if(!itemPedido.isEmpty()) {
            return ResponseEntity.ok().body(itemPedido.get().getItensResponse());
        } else return ResponseEntity.ok().body(new ItemPedidoResponse());
    }

    @PostMapping(path = "/item")
    public void postItem(@RequestBody ItemPedidoRequest itemPedidoRequest) {
        Long idPedido = itemPedidoRequest.getIdPedido();
        Optional<Pedido> pedido = pedidoRepository.findById(Math.toIntExact(idPedido));
        if(!pedido.isEmpty()) {
            pedido.get().addItemPedido(new ItemPedido(itemPedidoRequest.getQuantidade(), itemPedidoRequest.getDescricao(), itemPedidoRequest.getPedido()));
            pedidoRepository.save(pedido.get());
        }
    }

    @PutMapping(path = "/item")
    @ResponseBody
    public ResponseEntity<ItemPedidoResponse> updatePedido(@RequestBody ItemPedidoRequest itemPedidoRequest) {
        Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(itemPedidoRequest.getId());
        if(!itemPedido.isEmpty()) {
            itemPedido.get().setQuantidade(itemPedidoRequest.getQuantidade());
            itemPedido.get().setDescricao(itemPedidoRequest.getDescricao());
            itemPedidoRepository.save(itemPedido.get());
        }
        return ResponseEntity.ok().body(new ItemPedidoResponse(itemPedido.get()));
    }

    @DeleteMapping(path = "/item/{id}")
    @ResponseBody
    public void deletePedido(@PathVariable Long id){
        itemPedidoRepository.deleteById(id);
    }
}
