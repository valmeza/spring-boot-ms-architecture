package com.example.user.controllers;
import com.example.user.dtos.UserDetailsDTO;
import com.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/saveUpdate")
    public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser) {
        return userService.saveUpdate(inputUser);
    }
    @GetMapping(value = "/getById/{id}")
    public UserDetailsDTO getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }
    @GetMapping("/getByName/{name}")
    public List<UserDetailsDTO> getUsersByName(@PathVariable String name) {
        return userService.getByName(name);
    }
}
