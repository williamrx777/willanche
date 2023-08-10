package br.com.willanche.willanche.controllers;

import br.com.willanche.willanche.entities.Cliente;
import br.com.willanche.willanche.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public Iterable<Cliente> listar(){
        return repository.findAll();
    }

    @PostMapping
    public Cliente postar(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @PutMapping
    public Cliente atualizar(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }


}
