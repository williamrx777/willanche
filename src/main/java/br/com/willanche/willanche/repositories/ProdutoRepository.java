package br.com.willanche.willanche.repositories;

import br.com.willanche.willanche.entities.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto,Long> {
}
