package com.example.testapi.service;

import com.example.testapi.model.UserModel;
import com.example.testapi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final Map<Long, User> userData = new HashMap<>();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsersData() {
        return userRepository.findAll();
    }

    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }


}
