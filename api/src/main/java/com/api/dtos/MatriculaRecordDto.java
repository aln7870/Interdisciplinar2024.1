package com.api.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record MatriculaRecordDto(@NotBlank String dataDeMatricula, String duracaoDeMatricula, BigDecimal valorContrato, String status) {
}
