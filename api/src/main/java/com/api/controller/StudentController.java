package com.api.controller;

import com.api.dtos.StudentRecordDto;
import com.api.models.StudentModel;
import com.api.models.UserModel;
import com.api.repositories.StudentInterface;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/alunos")
@RestController
public class StudentController {

    @Autowired
    StudentInterface studentInterface;

    @PostMapping
    public ResponseEntity<StudentModel> saveAluno(@RequestBody @Valid StudentRecordDto alunoRecordDto){
        var alunoModel = new StudentModel();
        //transforming string to char😎👍
        char status = alunoRecordDto.status().charAt(0);
        //sending to sql
        alunoModel.setStatus(status);
        //transforming String to Date sql
        Date dataInicio = Date.valueOf(alunoRecordDto.dataInicio());
        //sending to sql;
        alunoModel.setDataInicio(dataInicio);
        //BeanUtils get the rest of Dtos and convert in alunoModel;
        BeanUtils.copyProperties(alunoRecordDto, alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentInterface.save(alunoModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllStudent(){
        List<StudentModel> students = studentInterface.findAll();
        if (students.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no registered students.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{idStudent}")
    public ResponseEntity<Object> getOneStudent(@PathVariable(value = "idStudent")Long idStudent){
        Optional<StudentModel> student = studentInterface.findById(idStudent);
        if (student.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student.get());
    }


    @PutMapping("/{idStudent}")
    public ResponseEntity<Object> updateStudent(@PathVariable(value = "idStudent") Long idStudent, @RequestBody @Valid StudentRecordDto studentRecordDto){
        Optional<StudentModel> student = studentInterface.findById(idStudent);
        if (student.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        var studentModel = student.get();
        BeanUtils.copyProperties(studentRecordDto, studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(studentInterface.save(studentModel));
    }

    @DeleteMapping("/{idStudent}")
    public  ResponseEntity<Object> deleteStudent(@PathVariable(value = "idStudent")Long idStudent){
        Optional<StudentModel> student = studentInterface.findById(idStudent);
        if (student.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        studentInterface.delete(student.get());
        return ResponseEntity.status(HttpStatus.OK).body("Student deleted.");
    }


}
