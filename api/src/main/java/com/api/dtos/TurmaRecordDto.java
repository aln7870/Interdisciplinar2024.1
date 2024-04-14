package com.api.dtos;

public record TurmaRecordDto(String nomeTurma, String descricao, long limiteAlunos,
String local, String dataInicio, String dataTermino, String status) {
}
