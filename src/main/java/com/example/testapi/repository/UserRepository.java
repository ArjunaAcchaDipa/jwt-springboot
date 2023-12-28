package com.example.testapi.repository;

import com.example.testapi.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<UserModel> users = new ArrayList<>();

    public UserModel save (UserModel userRepository) {
        userRepository.setId((long) (users.size()+1));
        users.add(userRepository);
        return userRepository;
    }

    public List<UserModel> findAll() {
        return users;
    }

    public Optional<UserModel> findById(Long id) {
        return users.stream().filter(userRepository -> userRepository.getId().equals(id)).findFirst();
    }


}
