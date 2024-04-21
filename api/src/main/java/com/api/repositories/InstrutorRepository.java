package com.api.repositories;

import com.api.models.InstrutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<InstrutorModel,Integer> {
}
