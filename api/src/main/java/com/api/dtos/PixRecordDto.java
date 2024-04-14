package com.api.dtos;

import java.math.BigDecimal;

public record PixRecordDto(String chavePix, BigDecimal valor, String dataTransacao, String status){
}
