package br.com.willanche.willanche.controllers;

import br.com.willanche.willanche.dtos.PedidoDTO;
import br.com.willanche.willanche.entities.Pedido;
import br.com.willanche.willanche.repositories.ItemPedidoRepository;
import br.com.willanche.willanche.repositories.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity listar(){
       var lista = repository.findAll();
       return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PostMapping
    public ResponseEntity postar(@RequestBody @Valid PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(pedidoDTO, pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity pegarPedido(@PathVariable Long id){
        Optional<Pedido> pedido = repository.findById(id);
        if (pedido.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(pedido);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid PedidoDTO pedidoDTO, @PathVariable Long id){
        Optional<Pedido> pedido0 = repository.findById(id);
        if (pedido0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido não encontrado");
        }else{
            var pedido = pedido0.get();
            BeanUtils.copyProperties(pedidoDTO, pedido);
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(pedido));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        Optional<Pedido> pedido = repository.findById(id);
        if (pedido.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido não encontrado");
        }else{
            repository.delete(pedido.get());
            return ResponseEntity.status(HttpStatus.OK).body("pedido apagado com sucesso.");
        }
    }

}
