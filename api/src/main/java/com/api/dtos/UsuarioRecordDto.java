package com.api.dtos;

import jakarta.validation.constraints.NotBlank;

// records são por default são private and final
//NotBlank nao pode ser null sem string
//NotNull nao recebe valor null pra numerico
public record UsuarioRecordDto(@NotBlank String nome, @NotBlank String email, @NotBlank String senha, @NotBlank String telefone, @NotBlank String dataNasc, @NotBlank String genero, @NotBlank String status) {

}