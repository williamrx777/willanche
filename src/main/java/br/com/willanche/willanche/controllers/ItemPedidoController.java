package br.com.willanche.willanche.controllers;

import br.com.willanche.willanche.entities.ItemPedido;
import br.com.willanche.willanche.repositories.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/itemPedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;
    @GetMapping
    public Iterable<ItemPedido> listar(){
        return repository.findAll();
    }

    @PostMapping
    public ItemPedido postar(@RequestBody ItemPedido itemPedido){
        return repository.save(itemPedido);
    }

    @PutMapping
    public ItemPedido atualizar(@RequestBody ItemPedido itemPedido){
        return repository.save(itemPedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
