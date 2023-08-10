package br.com.willanche.willanche.repositories;

import br.com.willanche.willanche.entities.ItemPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido,Long> {
}
