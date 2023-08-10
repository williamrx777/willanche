package br.com.willanche.willanche.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String imagem;
    @OneToMany
    @JoinColumn(name = "item_pedidos_id")
    private List<ItemPedido> itemPedidos;

}
