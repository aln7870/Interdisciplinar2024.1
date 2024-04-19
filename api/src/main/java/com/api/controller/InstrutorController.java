package com.api.controller;


import com.api.dtos.InstrutorRecordDto;
import com.api.models.InstrutorModel;
import com.api.repositories.InstrutorInterface;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/instrutores")
@RestController
public class InstrutorController {

    @Autowired
    InstrutorInterface instrutorInterface;

    @PostMapping
    public ResponseEntity<InstrutorModel> saveInstrutor(@RequestBody @Valid InstrutorRecordDto instrutorRecordDto){
        var instrutorModel = new InstrutorModel();
        //transforming string to char😎👍
        char status = instrutorRecordDto.status().charAt(0);
        //sending to sql
        instrutorModel.setStatus(status);
        //transforming String to Date sql
        Date dataNasc = Date.valueOf(instrutorRecordDto.dataNasc());
        //sending to sql;
        instrutorModel.setDataNasc(dataNasc);
        //BeanUtils get the rest of Dtos and convert in alunoModel;
        BeanUtils.copyProperties(instrutorRecordDto, instrutorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(instrutorInterface.save(instrutorModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllInstrutores(){
        List<InstrutorModel> instrutores = instrutorInterface.findAll();
        if (instrutores.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum instrutor registrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(instrutores);
    }

    @GetMapping("/{codIntrutor}")
    public ResponseEntity<Object> getOneInstrutor(@PathVariable(value = "codInstrutor")Integer codInstrutor){
        Optional<InstrutorModel> instrutor = instrutorInterface.findById(codInstrutor);
        if (instrutor.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum instrutor encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(instrutor.get());
    }


    @PutMapping("/{codInstrutor}")
    public ResponseEntity<Object> updateInstrutor(@PathVariable(value = "codInstrutor") Integer codInstrutor, @RequestBody @Valid InstrutorRecordDto instrutorRecordDto){
        Optional<InstrutorModel> instrutor = instrutorInterface.findById(codInstrutor);
        if (instrutor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instrutor não encontrado.");
        }
        var instrutorModel = instrutor.get();
        BeanUtils.copyProperties(instrutorRecordDto, instrutorModel);
        return ResponseEntity.status(HttpStatus.OK).body(instrutorInterface.save(instrutorModel));
    }

    @DeleteMapping("/{codInstrutor}")
    public  ResponseEntity<Object> deleteInstrutor(@PathVariable(value = "codInstrutor")Integer codInstrutor){
        Optional<InstrutorModel> instrutor = instrutorInterface.findById(codInstrutor);
        if (instrutor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum instrutor encontrado.");
        }
        instrutorInterface.delete(instrutor.get());
        return ResponseEntity.status(HttpStatus.OK).body("Instrutor deletado.");
    }


}
