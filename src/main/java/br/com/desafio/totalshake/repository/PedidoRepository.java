package br.com.desafio.totalshake.repository;

import br.com.desafio.totalshake.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
    @Override
    Optional<Pedido> findById(Integer integer);
}
