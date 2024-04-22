package com.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record InstrutorRecordDto(@NotBlank String nome, @NotBlank String sobrenome, @NotNull Date dataNasc, String status) {
}
