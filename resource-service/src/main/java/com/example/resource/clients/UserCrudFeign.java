package com.example.resource.clients;
import com.example.resource.dtos.UserDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="user-crud")
public interface UserCrudFeign {
    @PostMapping("/api/saveUpdate")
    UserDetailsDTO callUserCrudToSaveUser(@RequestBody UserDetailsDTO inputUser);

    @GetMapping("/api/getById/{id}")
    UserDetailsDTO callUserCrudToGetById(@PathVariable Long id);

    @GetMapping("api/getByName/{name}")
    List<UserDetailsDTO > callUserCrudToGetUsersByName(@PathVariable String name);

}
