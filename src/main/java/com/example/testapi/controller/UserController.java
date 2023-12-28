package com.example.testapi.controller;

import com.example.testapi.model.UserModel;
import com.example.testapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsersData();
    }

    @PostMapping("/register")
    public String createUserModel(@RequestBody UserModel userModel) {
        return jwtToken(userService.createUser(userModel));
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody UserModel userModel) {
        String jwt = jwtToken(userModel);

        return jsonJwtToken(jwt);
    }

    private String jwtToken(UserModel userModel) {
        Date issuedAt = new Date();
        System.out.println(issuedAt);

        // token expiration in 1 hour in millisecond
        Date expiration = new Date(issuedAt.getTime() + 3600000);

        // Generate key for JWT with HS256 as the algorithm
        SecretKey key = Jwts.SIG.HS256.key().build();

        // Buat ngecek keynya valid atau engga di https://jwt.io/
        // Ambil yang setelah tanda at "@"
        System.out.println(key);
        String jws = Jwts.builder().subject(userModel.getUsername()).issuedAt(issuedAt).expiration(expiration).signWith(key).compact();

        return jws;
    }

    private Map<String, Object> jsonJwtToken(String jwt) {
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("access-token", jwt);

        return jsonData;
    }
}
