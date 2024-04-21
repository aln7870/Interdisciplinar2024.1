package com.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(@NotBlank String nome,@NotBlank String senha) {
}
