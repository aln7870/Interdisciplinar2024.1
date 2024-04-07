package com.api.controller;

import com.api.dtos.UserRecordDto;
import com.api.models.UserModel;
import com.api.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


//@RequestMapping("/") é o parametro para endereçamento
@RequestMapping("/usuarios")
@RestController
public class UserController{
    //acesso aos metodos
    @Autowired
    UserRepository userRepository;

    //ResponseEntity é um metodo de retornar algo mais personalizado
    //dto vai receber o Json e passar pra objeto java userModel
    //pqp git
    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
        var userModel = new UserModel();
        //conversao de string para objeto user
        Date dataNasc = Date.valueOf(userRecordDto.dataNasc());
        //mandando a data para o objeto user
        userModel.setDataNasc(dataNasc);
        //conversao de string para char
        char status = userRecordDto.status().charAt(0);
        //enviando char para o objeto
        userModel.setStatus(status);
        //BeanUtil = userRecordDto e converte em userModel
        BeanUtils.copyProperties(userRecordDto, userModel);
        //body utiliza o crud para salvar os dados
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }
    //get all Users
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }
    //get one User
    @GetMapping("/{idUser}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "idUser")Long idUser){
        Optional<UserModel> user0 = userRepository.findById(idUser);
        if (user0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user0.get());
    }
    //update user
    @PutMapping("/{idUser}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "idUser") Long idUser, @RequestBody @Valid UserRecordDto userRecordDto){
        Optional<UserModel> user0 = userRepository.findById(idUser);
        if (user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var userModel = user0.get();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userModel));
    }
    //delete user
    @DeleteMapping("/{idUser}")
    public  ResponseEntity<Object> deleteProduct(@PathVariable(value = "idUser")Long idUser){
        Optional<UserModel> user0 = userRepository.findById(idUser);
        if (user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        userRepository.delete(user0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted.");
    }

}