package com.api.controller;

import com.api.dtos.InstructorRecordDto;
import com.api.dtos.UserRecordDto;
import com.api.models.InstructorModel;
import com.api.models.UserModel;
import com.api.repositories.InstructorInterface;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/instructors")
@RestController
public class InstrutorController {

    @Autowired
    InstructorInterface instructorInterface;

    @PostMapping
    public ResponseEntity<InstructorModel> saveInstructor(@RequestBody @Valid InstructorRecordDto instructorRecordDto){
        var instructorModel = new InstructorModel();
        //conversao de string para char
        char status = instructorRecordDto.status().charAt(0);
        //enviando char para o objeto
        instructorModel.setStatus(status);
        //BeanUtil = userRecordDto e converte em instructorModel
        BeanUtils.copyProperties(instructorRecordDto, instructorModel);
        //body utiliza o crud para salvar os dados
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorInterface.save(instructorModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllInstructors(){
        List<InstructorModel> instructors = instructorInterface.findAll();
        if (instructors.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no registered instructor.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(instructors);
    }

    @GetMapping("/{idInstructor}")
    public ResponseEntity<Object> getOneInstructor(@PathVariable(value = "idInstructor")Long idInstructor){
        Optional<InstructorModel> instructor0 = instructorInterface.findById(idInstructor);
        if (instructor0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(instructor0.get());
    }

    @PutMapping("/{idInstructor}")
    public ResponseEntity<Object> updateInstructor(@PathVariable(value = "idInstructor") Long idInstructor, @RequestBody @Valid InstructorRecordDto instructorRecordDto){
        Optional<InstructorModel> instructor0 = instructorInterface.findById(idInstructor);
        if (instructor0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found.");
        }
        var instructorModel = instructor0.get();
        BeanUtils.copyProperties(instructorRecordDto, instructorModel);
        return ResponseEntity.status(HttpStatus.OK).body(instructorInterface.save(instructorModel));
    }

    @DeleteMapping("/{idInstructor}")
    public  ResponseEntity<Object> deleteInstructor(@PathVariable(value = "idInstructor")Long idInstructor){
        Optional<InstructorModel> instructor0 = instructorInterface.findById(idInstructor);
        if (instructor0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found.");
        }
        instructorInterface.delete(instructor0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Instructor deleted.");
    }



}
