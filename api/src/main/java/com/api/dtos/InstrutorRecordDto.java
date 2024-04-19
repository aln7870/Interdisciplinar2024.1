package com.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record InstrutorRecordDto(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String dataNasc, String status) {
}
