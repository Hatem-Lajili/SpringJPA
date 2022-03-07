package com.example.tpjpa.Controller;

import com.example.tpjpa.Services.UserService;
import com.example.tpjpa.model.Users;
import com.example.tpjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<Users> getallUser(){
        return userService.getAllUser();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Users> getUserbyId(@PathVariable("id") Integer id){
        Optional<Users> user = userService.getUserById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/create")
//    public ResponseEntity<Users> createUser(@RequestBody Users user){
//        try {
//            Users users = userRepository.save(new Users(user.getEmail(),user.getName()));
//            return new ResponseEntity<>(users, HttpStatus.CREATED);
//        }catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/add")
    private int saveUser(@RequestBody Users users){
        userService.saveUser(users);
        return users.getId();
    }

    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

    @PutMapping("/update")
    private Users updateUser(@RequestBody Users users){
        userService.update(users, users.getId());
        return users;
    }


}
