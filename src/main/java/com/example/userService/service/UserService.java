package com.example.userService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userService.repository.UserRepository;
import com.example.userService.model.UserModel;

@Service
public class UserService {

    private UserRepository userRepository = new UserRepository();

    public void teste() {
        UserModel teste = new UserModel("teste", "senhaTeste");
        userRepository.create(teste);
        List<UserModel> users = userRepository.getAll();
        for(UserModel user : users) {
            System.out.println(user.getName());
        }
    }
    
}
