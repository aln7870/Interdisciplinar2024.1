package com.api.repositories;

import com.api.models.HorarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioInterface extends JpaRepository<HorarioModel,Long> {
}
