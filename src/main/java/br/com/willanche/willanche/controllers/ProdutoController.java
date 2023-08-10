package br.com.willanche.willanche.controllers;

import br.com.willanche.willanche.entities.Produto;
import br.com.willanche.willanche.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public Iterable<Produto> listar(){
        return repository.findAll();
    }

    @PostMapping
    public Produto postar(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @PutMapping
    public Produto atualizar(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }

}
