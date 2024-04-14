package com.api.dtos;

import java.math.BigDecimal;

public record PagamentoRecordDto(String tipoPagamento, BigDecimal valor, String dataVencimento, String dataPagamento, String status) {
}
