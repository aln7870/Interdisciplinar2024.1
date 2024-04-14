package com.api.repositories;

import com.api.models.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoInterface extends JpaRepository<PagamentoModel, Long> {
}
