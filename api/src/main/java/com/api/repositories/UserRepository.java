package com.api.repositories;

import com.api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
