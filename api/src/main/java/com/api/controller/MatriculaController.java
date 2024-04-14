package com.api.controller;

import com.api.dtos.MatriculaRecordDto;
import com.api.models.MatriculaModel;
import com.api.repositories.MatriculaInterface;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/matricula")
@RestController
public class MatriculaController {
    @Autowired
    MatriculaInterface matriculaInterface;

    @PostMapping
    public ResponseEntity<MatriculaModel> saveMatricula(@RequestBody @Valid MatriculaRecordDto matriculaRecordDto){
        var matriculaModel = new MatriculaModel();

        //BeanUtils get the rest of Dtos and convert in alunoModel;
        BeanUtils.copyProperties(matriculaRecordDto, matriculaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaInterface.save(matriculaModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllMatricula(){
        List<MatriculaModel> matricula = matriculaInterface.findAll();
        if (matricula.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nenhuma matricula registrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(matricula);
    }

    @GetMapping("/{codMatricula}")
    public ResponseEntity<Object> getOneMatricula(@PathVariable(value = "codMatricula")Long codMatricula){
        Optional<MatriculaModel> matricula = matriculaInterface.findById(codMatricula);
        if (matricula.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("matricula não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(matricula.get());
    }


    @PutMapping("/{codMatricula}")
    public ResponseEntity<Object> updateMatricula(@PathVariable(value = "codMatricula") Long codMatricula, @RequestBody @Valid MatriculaRecordDto matriculaRecordDto){
        Optional<MatriculaModel> matricula = matriculaInterface.findById(codMatricula);
        if (matricula.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("matricula não encontrada.");
        }
        var matriculaModel = matricula.get();
        BeanUtils.copyProperties(matriculaRecordDto, matriculaModel);
        return ResponseEntity.status(HttpStatus.OK).body(matriculaInterface.save(matriculaModel));
    }

    @DeleteMapping("/{codMatricula}")
    public  ResponseEntity<Object> deleteMatricula(@PathVariable(value = "codMatricula")Long codMatricula){
        Optional<MatriculaModel> matricula = matriculaInterface.findById(codMatricula);
        if (matricula.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("matricula não encontrada.");
        }
        matriculaInterface.delete(matricula.get());
        return ResponseEntity.status(HttpStatus.OK).body("matricula deletada.");
    }


}
