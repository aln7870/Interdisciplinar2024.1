package com.api.controller;

import com.api.dtos.EnderecoRecordDto;
import com.api.dtos.HorarioRecordDto;
import com.api.models.EnderecoModel;
import com.api.models.HorarioModel;
import com.api.models.StudentModel;
import com.api.repositories.EnderecoInterface;
import com.api.repositories.HorarioInterface;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/horarios")
@RestController
public class HorarioController {
    @Autowired
    HorarioInterface horarioInterface;

    @PostMapping
    public ResponseEntity<HorarioModel> saveHorario(@RequestBody @Valid HorarioRecordDto horarioRecordDto){
        var horarioModel = new HorarioModel();

        //BeanUtils get the rest of Dtos and convert in alunoModel;
        BeanUtils.copyProperties(horarioRecordDto, horarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioInterface.save(horarioModel));
    }

    @GetMapping
    public ResponseEntity<Object> getAllHorario(){
        List<HorarioModel> horario = horarioInterface.findAll();
        if (horario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nenhum horario registrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(horario);
    }

    @GetMapping("/{idHorario}")
    public ResponseEntity<Object> getOnehorario(@PathVariable(value = "idHorario")Long idHorario){
        Optional<HorarioModel> horario = horarioInterface.findById(idHorario);
        if (horario.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("horario não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(horario.get());
    }


    @PutMapping("/{idHorario}")
    public ResponseEntity<Object> updateHorario(@PathVariable(value = "idHorario") Long idHorario, @RequestBody @Valid HorarioRecordDto horarioRecordDto){
        Optional<HorarioModel> horario = horarioInterface.findById(idHorario);
        if (horario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Horario não encontrado.");
        }
        var horarioModel = horario.get();
        BeanUtils.copyProperties(horarioRecordDto, horarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(horarioInterface.save(horarioModel));
    }

    @DeleteMapping("/{idHorario}")
    public  ResponseEntity<Object> deleteHorario(@PathVariable(value = "idHorario")Long idHorario){
        Optional<HorarioModel> horario = horarioInterface.findById(idHorario);
        if (horario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Horario não encontrado.");
        }
        horarioInterface.delete(horario.get());
        return ResponseEntity.status(HttpStatus.OK).body("Horario deletado.");
    }


}
