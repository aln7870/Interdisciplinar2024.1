package com.api.controller;

import com.api.dtos.LoginRequestDto;
import com.api.dtos.UsuarioRecordDto;
import com.api.models.UsuarioModel;
import com.api.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;


//@RequestMapping("/") é o parametro para endereçamento
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {
    //acesso aos metodos

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //ResponseEntity é um metodo de retornar algo mais personalizado
    //dto vai receber o Json e passar pra objeto java userModel
    //pqp git
    @PostMapping
    public ResponseEntity<UsuarioModel> saveUser(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto){
        var userModel = new UsuarioModel();
        //conversao de string para objeto user
        Date dataNasc = Date.valueOf(usuarioRecordDto.dataNasc());
        //mandando a data para o objeto user
        userModel.setDataNasc(dataNasc);
        //conversao de string para char
        char status = usuarioRecordDto.status().charAt(0);
        //enviando char para o objeto
        userModel.setStatus(status);
        //BeanUtil = userRecordDto e converte em userModel
        BeanUtils.copyProperties(usuarioRecordDto, userModel);
        userModel.setSenha(passwordEncoder.encode(usuarioRecordDto.senha()));
        //body utiliza o crud para salvar os dados
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(userModel));
    }

    @PostMapping("/login")
     public ResponseEntity<String> loginUsuario(@RequestBody @Valid LoginRequestDto loginRequestDto) {
            Optional<UsuarioModel> usuariologin = usuarioRepository.findByNome(loginRequestDto.nome());
            if (usuariologin.isEmpty()) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado.");
            }
            if (!passwordEncoder.matches(loginRequestDto.senha(), usuariologin.get().getSenha())) {
             return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Login ou senha errado.");
            }
            return ResponseEntity.ok("Login realizado.");
    }

    //get all Users
    @GetMapping
    public ResponseEntity<Object> getAllUsers(){
        List<UsuarioModel> users = usuarioRepository.findAll();
        if (users.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no registered users.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    //get one User
    @GetMapping("/{codUsuario}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "codUsuario")Integer codUsuario){
        Optional<UsuarioModel> user0 = usuarioRepository.findById(codUsuario);
        if (user0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user0.get());
    }
    //update user
    @PutMapping("/{codUsuario}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "codUsuario") Integer codUsuario, @RequestBody @Valid UsuarioRecordDto usuarioRecordDto){
        Optional<UsuarioModel> user0 = usuarioRepository.findById(codUsuario);
        if (user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var userModel = user0.get();
        BeanUtils.copyProperties(usuarioRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(userModel));
    }
    //delete user
    @DeleteMapping("/{codUsuario}")
    public  ResponseEntity<Object> deleteUser(@PathVariable(value = "codUsuario")Integer codUsuario){
        Optional<UsuarioModel> user0 = usuarioRepository.findById(codUsuario);
        if (user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        usuarioRepository.delete(user0.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted.");
    }

}