package com.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

// records são por default são private and final
//NotBlank nao pode ser null sem string
//NotNull nao recebe valor null pra numerico
public record UserRecordDto(@NotBlank String name, @NotBlank String email,
@NotBlank String senha,@NotBlank String telefone, @NotBlank String dataNasc,
@NotNull String modalidade, @NotBlank String genero, @NotBlank String status) {

}