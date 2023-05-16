package com.backend.portfolio.controller;

import com.backend.portfolio.dto.UserDTO;
import com.backend.portfolio.dto.request.LoginDTO;
import com.backend.portfolio.dto.request.UserCreationDTO;
import com.backend.portfolio.model.User;
import com.backend.portfolio.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody  UserCreationDTO userCreationDTO) {
        return userService.createUser(userCreationDTO);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }

    @GetMapping("/{userId}")
    public Optional<UserDTO> getUserWithEntities(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/update/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePortfolio(@PathVariable Long userId, @RequestBody  UserCreationDTO userCreationDTO) {
         userService.updateUserById(userId, userCreationDTO);
    }


}
