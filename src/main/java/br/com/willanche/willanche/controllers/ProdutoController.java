package br.com.willanche.willanche.controllers;

import br.com.willanche.willanche.dtos.ProdutoDTO;
import br.com.willanche.willanche.entities.Produto;
import br.com.willanche.willanche.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity listar(){
       var listar = repository.findAll();
       return ResponseEntity.status(HttpStatus.OK).body(listar);
    }

    @PostMapping
    public ResponseEntity postar(@RequestBody @Valid ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity pegarProduto(@PathVariable Long id){
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(produto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid ProdutoDTO produtoDTO, @PathVariable Long id){
        Optional<Produto> produto0 = repository.findById(id);
        if (produto0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");
        }else{
            var produto = produto0.get();
            BeanUtils.copyProperties(produtoDTO, produto);
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");
        }else {
            repository.delete(produto.get());
            return ResponseEntity.status(HttpStatus.OK).body("produto deletado com sucesso.");
        }
    }

}
