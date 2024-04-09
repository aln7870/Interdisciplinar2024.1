package com.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record InstructorRecordDto(@NotBlank String nome,String telefone,
String horarioDisponivel,String status) {
}
