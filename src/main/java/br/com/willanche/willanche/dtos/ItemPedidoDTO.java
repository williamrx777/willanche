package br.com.willanche.willanche.dtos;

import br.com.willanche.willanche.entities.Pedido;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ItemPedidoDTO(@NotNull Integer item,@NotNull Integer quantidade,@NotNull BigDecimal preco, Pedido pedido) {
}
