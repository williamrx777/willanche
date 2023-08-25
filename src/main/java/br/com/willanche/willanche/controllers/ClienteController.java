package br.com.willanche.willanche.controllers;

import br.com.willanche.willanche.dtos.ClienteDTO;
import br.com.willanche.willanche.entities.Cliente;
import br.com.willanche.willanche.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ResponseEntity listar(){
        var lista = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PostMapping
    public ResponseEntity postar(@RequestBody @Valid ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity pegaCliente(@PathVariable Long id){
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid ClienteDTO clienteDTO, @PathVariable Long id){
        Optional<Cliente> cliente0 = repository.findById(id);
        if (cliente0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }else{
            var cliente = cliente0.get();
            BeanUtils.copyProperties(clienteDTO, cliente);
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }else{
            repository.delete(cliente.get());
            return ResponseEntity.status(HttpStatus.OK).body("Cliente apagado com sucesso.");
        }
    }


}
