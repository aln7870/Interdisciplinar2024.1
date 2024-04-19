package com.api.controller;

import com.api.dtos.AlunoRecordDto;
import com.api.models.AlunoModel;
import com.api.repositories.AlunoInterface;
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
public class AlunoController {

    @Autowired
    AlunoInterface alunoInterface;

    @PostMapping
    public ResponseEntity<AlunoModel> saveAluno(@RequestBody @Valid AlunoRecordDto alunoRecordDto){
        var alunoModel = new AlunoModel();
        //transforming string to char😎👍
        char status = alunoRecordDto.status().charAt(0);
        //sending to sql
        alunoModel.setStatus(status);
        //transforming String to Date sql
        Date dataNasc = Date.valueOf(alunoRecordDto.dataNasc());
        //sending to sql;
        alunoModel.setDataDeNascimento(dataNasc);
        //BeanUtils get the rest of Dtos and convert in alunoModel;
        BeanUtils.copyProperties(alunoRecordDto, alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoInterface.save(alunoModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllAluno(){
        List<AlunoModel> alunos = alunoInterface.findAll();
        if (alunos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum aluno registrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<Object> getOneAluno(@PathVariable(value = "idAluno")Integer idAluno){
        Optional<AlunoModel> student = alunoInterface.findById(idAluno);
        if (student.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum aluno encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student.get());
    }


    @PutMapping("/{idAluno}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value = "idStudent") Integer idAluno, @RequestBody @Valid AlunoRecordDto alunoRecordDto){
        Optional<AlunoModel> aluno = alunoInterface.findById(idAluno);
        if (aluno.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        var alunoModel = aluno.get();
        BeanUtils.copyProperties(alunoRecordDto, alunoModel);
        return ResponseEntity.status(HttpStatus.OK).body(alunoInterface.save(alunoModel));
    }

    @DeleteMapping("/{idAluno}")
    public  ResponseEntity<Object> deleteAluno(@PathVariable(value = "idAluno")Integer idAluno){
        Optional<AlunoModel> aluno = alunoInterface.findById(idAluno);
        if (aluno.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Aluno encontrado.");
        }
        alunoInterface.delete(aluno.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado.");
    }


}
