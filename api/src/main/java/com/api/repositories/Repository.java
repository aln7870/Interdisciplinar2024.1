package com.api.repositories;

import com.api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<UserModel, UUID> {
}
