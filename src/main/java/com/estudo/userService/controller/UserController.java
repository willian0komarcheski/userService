package com.example.libs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libs.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService = new UserService();


    @GetMapping
    public String index() {
        return "Lista de cu!";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        String result = userService.returnName(id);
        return String.format("usuario $s tem o id $d", result, id);
    }

    @PostMapping
    public String createUser(@RequestBody String nome) {
        return "Usuário " + nome + " criado!";
    }
}
