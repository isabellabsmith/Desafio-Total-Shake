package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PedidoController {
    PedidoRepository repository;

    @GetMapping("/pedido")
    public List<Pedido> getAllPedidos() {
        return (List<Pedido>) repository.findAll();
    }

    @GetMapping("/pedido/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/pedido")
    public Pedido savePedido(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }
}
