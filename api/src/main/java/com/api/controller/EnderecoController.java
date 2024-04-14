package com.api.controller;

import com.api.dtos.EnderecoRecordDto;
import com.api.models.EnderecoModel;
import com.api.repositories.EnderecoInterface;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/endereco")
@RestController
public class EnderecoController {

    @Autowired
    EnderecoInterface enderecoInterface;

    @PostMapping
    public ResponseEntity<EnderecoModel> saveEndereco(@RequestBody @Valid EnderecoRecordDto enderecoRecordDto){
        var enderecoModel = new EnderecoModel();
        //transforming string to char😎👍
        char status = enderecoRecordDto.status().charAt(0);
        //sending to sql
        enderecoModel.setStatus(status);
        //BeanUtils get the rest of Dtos and convert in alunoModel;
        BeanUtils.copyProperties(enderecoRecordDto, enderecoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoInterface.save(enderecoModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllEndereco(){
        List<EnderecoModel> endereco = enderecoInterface.findAll();
        if (endereco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nenhum endereco registrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @GetMapping("/{codEndereco}")
    public ResponseEntity<Object> getOneEndereco(@PathVariable(value = "codEndereco")Long codEndereco){
        Optional<EnderecoModel> endereco = enderecoInterface.findById(codEndereco);
        if (endereco.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(endereco.get());
    }


    @PutMapping("/{codEndereco}")
    public ResponseEntity<Object> updateEndereco(@PathVariable(value = "codEndereco") Long codEndereco, @RequestBody @Valid EnderecoRecordDto enderecoRecordDto){
        Optional<EnderecoModel> endereco = enderecoInterface.findById(codEndereco);
        if (endereco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado.");
        }
        var enderecoModel = endereco.get();
        BeanUtils.copyProperties(enderecoRecordDto, enderecoModel);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoInterface.save(enderecoModel));
    }

    @DeleteMapping("/{codEndereco}")
    public  ResponseEntity<Object> deleteEndereco(@PathVariable(value = "codEndereco")Long codEndereco){
        Optional<EnderecoModel> endereco = enderecoInterface.findById(codEndereco);
        if (endereco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado.");
        }
        enderecoInterface.delete(endereco.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereco deletado.");
    }


}
