package com.api.repositories;

import com.api.models.InstructorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorInterface extends JpaRepository<InstructorModel,Long> {

}
