package br.com.willanche.willanche.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(@NotBlank String nome) {
}
