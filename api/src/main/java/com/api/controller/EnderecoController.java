package com.api.controller;

import com.api.dtos.EnderecoRecordDto;
import com.api.models.EnderecoModel;
import com.api.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/enderecos")
@CrossOrigin(origins = "*")
@RestController
public class EnderecoController {

    private final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping
    public ResponseEntity<EnderecoModel> saveEndereco(@RequestBody @Valid EnderecoRecordDto enderecoRecordDto){
        var enderecoModel = new EnderecoModel();
        char status = enderecoRecordDto.status().charAt(0);
        enderecoModel.setStatus(status);
        BeanUtils.copyProperties(enderecoRecordDto, enderecoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(enderecoModel));
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<Object> saveALlEnderecos(){
        List<EnderecoModel> enderecos = enderecoRepository.findAll();
        if (enderecos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum endereco encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecos);
    }

    @GetMapping("/{codEndereco}")
    public ResponseEntity<Object> getOneEndereco(@PathVariable(value = "codEndereco")Integer codEndereco){
        Optional<EnderecoModel> endereco = enderecoRepository.findById(codEndereco);
        if (endereco.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum endereco encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(endereco.get());
    }

    @PutMapping("/{codEndereco}")
    public ResponseEntity<Object> updateEndereco(@PathVariable(value = "codEndereco") Integer codEndereco, @RequestBody @Valid EnderecoRecordDto enderecoRecordDto){
        Optional<EnderecoModel> endereco = enderecoRepository.findById(codEndereco);
        if (endereco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado.");
        }
        var enderecoModel = endereco.get();
        BeanUtils.copyProperties(enderecoRecordDto, enderecoModel);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.save(enderecoModel));
    }

    @DeleteMapping("/{codEndereco}")
    public  ResponseEntity<Object> deleteEndereco(@PathVariable(value = "codEndereco")Integer codEndereco){
        Optional<EnderecoModel> endereco = enderecoRepository.findById(codEndereco);
        if (endereco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado.");
        }
        enderecoRepository.delete(endereco.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereco deletado.");
    }
}
