package com.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dormmate.model.User;
import com.dormmate.repository.UserRepository;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
    	user.getUsername();
    	user.getPassword();
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
