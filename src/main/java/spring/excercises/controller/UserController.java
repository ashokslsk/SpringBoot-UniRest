package spring.excercises.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.excercises.model.UserModel;
import spring.excercises.services.UserService;
import spring.excercises.services.UserServiceImpl;

import java.util.Optional;

@RestController
public class UserController {

    private UserService service;


    public UserController(@Qualifier("primary") UserService userService){
        this.service = userService;
    }
    @GetMapping("/getUser/{userName}")
    public ResponseEntity<UserModel> getUser(@PathVariable String userName){
            return ResponseEntity.of(Optional.ofNullable(service.getUser(userName)));
    }
    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserModel user){
         service.addUser(user);
         return ResponseEntity.accepted().build();
    }
    @DeleteMapping("/deleteUser/{userName}")
    public ResponseEntity<HttpStatus> createUser(@PathVariable String userName){
         service.deleteUser(userName);
         return ResponseEntity.noContent().build();
    }
}
