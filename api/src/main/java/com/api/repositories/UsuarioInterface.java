package com.api.repositories;

import com.api.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioInterface extends JpaRepository<UsuarioModel, Integer> {

}
