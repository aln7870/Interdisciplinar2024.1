package com.api.repositories;

import com.api.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {
}
