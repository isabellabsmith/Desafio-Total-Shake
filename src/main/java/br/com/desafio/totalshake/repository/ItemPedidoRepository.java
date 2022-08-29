package br.com.desafio.totalshake.repository;

import br.com.desafio.totalshake.model.ItemPedido;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long> {
    Optional<ItemPedido> findById(Long id);
}