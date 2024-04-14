package com.api.dtos;

public record EnderecoRecordDto(String rua, long numero, String complemento,
String bairro, String cidade, long cep,String status) {
}
