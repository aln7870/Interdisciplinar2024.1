package com.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record AlunoRecordDto(@NotBlank String nome, String sobrenome, @NotNull Date dataDeNascimento, String status) {
}
