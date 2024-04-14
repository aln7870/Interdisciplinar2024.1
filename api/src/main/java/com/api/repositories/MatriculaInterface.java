package com.api.repositories;

import com.api.models.MatriculaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaInterface extends JpaRepository<MatriculaModel,Long> {
}
