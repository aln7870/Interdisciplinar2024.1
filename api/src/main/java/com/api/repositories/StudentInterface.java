package com.api.repositories;

import com.api.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInterface extends JpaRepository<StudentModel, Long> {
}
