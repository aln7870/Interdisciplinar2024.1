package com.api.repositories;

import com.api.models.PixModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pixInterface extends JpaRepository<PixModel, Long> {
}
