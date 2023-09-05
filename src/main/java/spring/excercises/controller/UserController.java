package spring.excercises.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.excercises.model.UserModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private Map<String, UserModel> userMap = new HashMap<>();

    public UserController(){
        userMap.put("Geetha", new UserModel("Geetha", "Shree C", 3456567));
        userMap.put("Seetha", new UserModel("Seetha", "Shree C", 3454665));
    }

    @GetMapping("/getUser/{userName}")
    public ResponseEntity<UserModel> getUser(@PathVariable String userName){
        if (userMap.containsKey(userName)){
            return ResponseEntity.of(Optional.of(userMap.get(userName)));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserModel user){
         userMap.put(user.getFirstName(), user);
         return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/deleteUser/{userName}")
    public ResponseEntity<HttpStatus> createUser(@PathVariable String userName){
         userMap.remove(userName);
         return ResponseEntity.noContent().build();
    }

}
