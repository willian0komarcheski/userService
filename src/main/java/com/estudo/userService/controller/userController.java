package com.estudo.userService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user") // Rota base
public class userController {

    // Endpoint GET para retornar todos os usuários
    @GetMapping
    public String getAll() {
        return "Lista de cu!";
    }

    // Endpoint GET com parâmetro na rota
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        return "Usuário com ID: " + id;
    }

    // Endpoint POST para criar um novo usuário
    @PostMapping
    public String createUser(@RequestBody String nome) {
        return "Usuário " + nome + " criado!";
    }
}
