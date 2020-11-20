package com.example.resource.controllers;
import com.example.resource.clients.UserCrudFeign;
import com.example.resource.dtos.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResourceController {
    @Autowired
    private UserCrudFeign userCrudFeign;
    @PostMapping("/save-user")
    public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser) {
        return userCrudFeign.callUserCrudToSaveUser(inputUser);
    }

    @GetMapping("/getById/{id}")
    public UserDetailsDTO getById(@PathVariable Long id){
        return userCrudFeign.callUserCrudToGetById(id);
    }

    @GetMapping("/getByName/{name}")
    public List<UserDetailsDTO> getUsersByName(@PathVariable String name){
        return userCrudFeign.callUserCrudToGetUsersByName(name);
    }
}
