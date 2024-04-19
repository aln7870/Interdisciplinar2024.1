package com.api.repositories;

import com.api.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoInterface extends JpaRepository<AlunoModel, Integer> {
}
