package com.api.repositories;

import com.api.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoInterface extends JpaRepository<EnderecoModel,Long> {
}
