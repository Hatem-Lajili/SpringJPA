package com.example.tpjpa.Services;

import com.example.tpjpa.model.Users;
import com.example.tpjpa.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//cette class est un pont entre le controller et le repository
@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Users> getUserById(final Integer id){
        return userRepository.findById(id);
    }

    public Iterable<Users> getAllUser(){
        return userRepository.findAll();
    }

    public void deleteUser (final Integer id){
        userRepository.deleteById(id);
    }

    public Users saveUser (Users users){
        userRepository.save(users);
        return users;
    }

    public void update (Users users, Integer id){
        userRepository.save(users);
    }

}
