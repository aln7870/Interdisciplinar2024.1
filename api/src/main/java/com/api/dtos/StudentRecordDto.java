package com.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record StudentRecordDto(@NotBlank String nome, @NotBlank String dataInicio, String observacoes, String status,
                               String nivelCondicionamento, String objetivoTreino, String avaliacaoFisica,
                               Long codUsuario) {
}
