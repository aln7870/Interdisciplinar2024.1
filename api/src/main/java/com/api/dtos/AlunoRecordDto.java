package com.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record AlunoRecordDto(@NotBlank String nome, String sobrenome, @NotBlank String dataNasc, String status) {
}
