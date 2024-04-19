package com.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRecordDto(@NotBlank String rua, @NotNull Integer numero, String complemento, String bairro, String cidade, Integer cep, String status) {
}
