package com.example.libs.service;

import com.example.libs.model.UserModel;
import com.example.libs.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public String returnName(Long id) {
        UserModel user = userRepository.read(id);
        return user.getUsername();
    }
    
}
