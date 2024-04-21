package com.api.repositories;

import com.api.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer> {
}
