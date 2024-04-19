package com.api.repositories;

import com.api.models.InstrutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorInterface extends JpaRepository<InstrutorModel,Integer> {
}
