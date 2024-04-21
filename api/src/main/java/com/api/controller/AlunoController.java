package com.api.controller;

import com.api.dtos.AlunoRecordDto;
import com.api.models.AlunoModel;
import com.api.repositories.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
@RestController
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping
    public ResponseEntity<AlunoModel> saveAluno(@RequestBody @Valid AlunoRecordDto alunoRecordDto){
        var alunoModel = new AlunoModel();
        char status = alunoRecordDto.status().charAt(0);
        alunoModel.setStatus(status);
        //BeanUtils get the rest of Dtos and convert in alunoModel;
        BeanUtils.copyProperties(alunoRecordDto, alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(alunoModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllAluno(){
        List<AlunoModel> alunos = alunoRepository.findAll();
        if (alunos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum aluno registrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<Object> getOneAluno(@PathVariable(value = "idAluno")Integer idAluno){
        Optional<AlunoModel> student = alunoRepository.findById(idAluno);
        if (student.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum aluno encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student.get());
    }


    @PutMapping("/{idAluno}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value = "idAluno") Integer idAluno, @RequestBody @Valid AlunoRecordDto alunoRecordDto){
        Optional<AlunoModel> aluno = alunoRepository.findById(idAluno);
        if (aluno.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno not found.");
        }
        var alunoModel = aluno.get();
        BeanUtils.copyProperties(alunoRecordDto, alunoModel);
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(alunoModel));
    }


    @DeleteMapping("/{idAluno}")
    public  ResponseEntity<Object> deleteAluno(@PathVariable(value = "idAluno")Integer idAluno){
        Optional<AlunoModel> aluno = alunoRepository.findById(idAluno);
        if (aluno.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Aluno encontrado.");
        }
        alunoRepository.delete(aluno.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado.");
    }


}
