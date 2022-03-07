package com.example.tpjpa;

import com.example.tpjpa.model.Users;
import com.example.tpjpa.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class TpjpaApplication {


    public static void main(String[] args) {
        SpringApplication.run(TpjpaApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            userRepository.save(new Users(1,"hatem","hatem@gmail.com"));
            userRepository.save(new Users(2,"zied","zied@gmail.com"));
            userRepository.save(new Users(3,"mohamed","mohamed@gmail.com"));
            userRepository.save(new Users(4,"mohamed","mohamed@gmail.com"));
            for (Users users : userRepository.findAll()){
                System.out.println(users);
            }
        };
    }

}
