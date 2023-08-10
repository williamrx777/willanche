package br.com.willanche.willanche.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "item_pedidos")
@Getter
@Setter
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer item;
    private Integer quantidade;
    private BigDecimal preco;
    @OneToOne
    @JoinColumn(name = "pedido_id",referencedColumnName = "id")
    private Pedido pedido;
}
