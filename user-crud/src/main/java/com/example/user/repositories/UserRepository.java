package com.example.user.repositories;

import com.example.user.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

    @Query("SELECT ud FROM UserDetails ud Where ud.name=?1")
    List<UserDetails> findUserByName(String name);
}
