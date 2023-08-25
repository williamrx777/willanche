package br.com.willanche.willanche.controllers;

import br.com.willanche.willanche.dtos.ItemPedidoDTO;
import br.com.willanche.willanche.entities.ItemPedido;
import br.com.willanche.willanche.repositories.ItemPedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.ReaderEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/itemPedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;
    @GetMapping
    public ResponseEntity listar(){
        var lista = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PostMapping
    public ResponseEntity postar(@RequestBody @Valid ItemPedidoDTO itemPedidoDTO){
        ItemPedido itemPedido = new ItemPedido();
        BeanUtils.copyProperties(itemPedidoDTO, itemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(itemPedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity pegaItemPedido(@PathVariable Long id){
        Optional<ItemPedido> itemPedido = repository.findById(id);
        if (itemPedido.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(itemPedido);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid ItemPedidoDTO itemPedidoDTO, @PathVariable Long id){
        Optional<ItemPedido> itemPedido0 = repository.findById(id);
        if (itemPedido0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido não encontrado");
        }else{
            var itemPedido = itemPedido0.get();
            BeanUtils.copyProperties(itemPedidoDTO, itemPedido);
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(itemPedido));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        Optional<ItemPedido> itemPedido = repository.findById(id);
        if (itemPedido.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido não encontrado");
        }else{
            repository.delete(itemPedido.get());
            return ResponseEntity.status(HttpStatus.OK).body("Item do pedido apagado com sucesso.");
        }
    }
}
