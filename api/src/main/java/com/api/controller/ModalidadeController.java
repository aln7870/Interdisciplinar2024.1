package com.api.controller;

import com.api.dtos.AlunoRecordDto;
import com.api.dtos.ModalidadeRecordDto;
import com.api.models.AlunoModel;
import com.api.models.ModalidadeModel;
import com.api.repositories.AlunoInterface;
import com.api.repositories.ModalidadeInterface;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/modalidades")
@RestController
public class ModalidadeController {

    @Autowired
    ModalidadeInterface modalidadeInterface;

    @PostMapping
    public ResponseEntity<ModalidadeModel> saveModalidade(@RequestBody @Valid ModalidadeRecordDto modalidadeRecordDto){
        var modalidadeModel = new ModalidadeModel();
        //transforming string to char😎👍
        char status = modalidadeRecordDto.status().charAt(0);
        //sending to sql
        modalidadeModel.setStatus(status);
        //BeanUtils get the rest of Dtos and convert in alunoModel;
        BeanUtils.copyProperties(modalidadeRecordDto, modalidadeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(modalidadeInterface.save(modalidadeModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllModalidades(){
        List<ModalidadeModel> modalidade = modalidadeInterface.findAll();
        if (modalidade.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma modalidade registrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(modalidade);
    }

    @GetMapping("/{codModalidade}")
    public ResponseEntity<Object> getOneModalidade(@PathVariable(value = "codModalidade")Integer codModalidade){
        Optional<ModalidadeModel> modalidade = modalidadeInterface.findById(codModalidade);
        if (modalidade.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma modalidade encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(modalidade.get());
    }


    @PutMapping("/{codModalidade}")
    public ResponseEntity<Object> updateModalidade(@PathVariable(value = "codModalidade") Integer codModalidade, @RequestBody @Valid ModalidadeRecordDto modalidadeRecordDto){
        Optional<ModalidadeModel> modalidade = modalidadeInterface.findById(codModalidade);
        if (modalidade.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        var modalidadeModel = modalidade.get();
        BeanUtils.copyProperties(modalidade, modalidadeModel);
        return ResponseEntity.status(HttpStatus.OK).body(modalidadeInterface.save(modalidadeModel));
    }

    @DeleteMapping("/{codModalidade}")
    public  ResponseEntity<Object> deleteModalidade(@PathVariable(value = "codModalidade")Integer codModalidade){
        Optional<ModalidadeModel> modalidade = modalidadeInterface.findById(codModalidade);
        if (modalidade.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma modalidade encontrada.");
        }
        modalidadeInterface.delete(modalidade.get());
        return ResponseEntity.status(HttpStatus.OK).body("Modalidade deletada.");
    }


}
