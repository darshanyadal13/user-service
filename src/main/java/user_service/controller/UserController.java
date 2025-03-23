package user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user_service.dto.LoginRequest;
import user_service.model.Users;
import user_service.service.UserService;
import user_service.util.ResponseStructure;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<Users>> register(@RequestBody Users user) {
         ResponseStructure<Users> rs = userService.register(user);
         return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login() {
        System.out.println("Login successfully !!!");
        return "Login successfully !!!";
    }
}
