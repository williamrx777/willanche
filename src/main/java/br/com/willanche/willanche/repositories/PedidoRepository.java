package br.com.willanche.willanche.repositories;

import br.com.willanche.willanche.entities.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido,Long> {
}
