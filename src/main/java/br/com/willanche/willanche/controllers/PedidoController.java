package br.com.willanche.willanche.controllers;

import br.com.willanche.willanche.entities.Pedido;
import br.com.willanche.willanche.repositories.ItemPedidoRepository;
import br.com.willanche.willanche.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public Iterable<Pedido> listar(){
        return repository.findAll();
    }

    @PostMapping
    public Pedido postar(@RequestBody Pedido pedido){
        return repository.save(pedido);
    }

    @PutMapping
    public Pedido atualizar(@RequestBody Pedido pedido){
        return repository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }

}
