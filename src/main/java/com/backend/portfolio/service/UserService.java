package com.backend.portfolio.service;

import com.backend.portfolio.dto.UserDTO;
import com.backend.portfolio.dto.request.LoginDTO;
import com.backend.portfolio.dto.request.UserCreationDTO;
import com.backend.portfolio.model.User;

import java.util.Optional;

public interface UserService {

    User createUser(UserCreationDTO userCreationDTO);

    Optional<UserDTO> getUserById(Long userId);

    User loginUser(LoginDTO loginDTO);

    void updateUserById(Long userId, UserCreationDTO userCreationDTO);
}
