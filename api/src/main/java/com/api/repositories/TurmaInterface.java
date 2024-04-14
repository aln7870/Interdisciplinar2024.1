package com.api.repositories;

import com.api.models.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaInterface extends JpaRepository<TurmaModel, Long> {
}
