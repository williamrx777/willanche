package br.com.willanche.willanche.dtos;

import br.com.willanche.willanche.entities.ItemPedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record ProdutoDTO(@NotBlank String nome, @NotNull BigDecimal preco,@NotBlank String imagem, List<ItemPedido> itemPedidos) {
}
