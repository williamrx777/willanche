package br.com.willanche.willanche.dtos;

import br.com.willanche.willanche.entities.Cliente;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record PedidoDTO(@NotNull LocalDate data, List<Cliente> clientes) {
}
