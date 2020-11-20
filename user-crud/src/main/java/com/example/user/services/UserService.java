package com.example.user.services;
import com.example.user.dtos.UserDetailsDTO;
import com.example.user.entities.UserDetails;
import com.example.user.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository repository;
    @Transactional
    public UserDetailsDTO saveUpdate(UserDetailsDTO inputUser) {
        try {
            UserDetails userDetails = new UserDetails();
            userDetails.setName(inputUser.getName());
            userDetails.setAge(Integer.parseInt(inputUser.getAge()));
            return getUserDetailsDTO(repository.save(userDetails));
        } catch (Exception e) {
            LOGGER.warn("*/**************************** Exception in UserService -> saveUpdate(): " + e);
        }
        return null;
    }
    public UserDetailsDTO getById(Long id) {
        return getUserDetailsDTO(repository.getOne(id));
    }
    public List<UserDetailsDTO> getByName(String name) {
        List<UserDetails> userDetailsList = repository.findUserByName(name);
        if (CollectionUtils.isEmpty(userDetailsList)) {
            return null;
        }
        return userDetailsList
                .stream()
                .map(this::getUserDetailsDTO)
                .collect(Collectors.toList());
    }
    public UserDetailsDTO getUserDetailsDTO(UserDetails userDetails) {
        return new UserDetailsDTO(
                userDetails.getId().toString(),
                userDetails.getName(),
                userDetails.getAge().toString()
        );
    }
}
