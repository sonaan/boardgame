package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.AuthenticationRequest;
import com.boardgame.webstorage.dto.AuthenticationResponse;
import com.boardgame.webstorage.dto.UserResponseDTO;
import com.boardgame.webstorage.entity.Role;
import com.boardgame.webstorage.entity.UserEntity;
import com.boardgame.webstorage.repositories.UserRepo;
import com.boardgame.webstorage.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.boardgame.webstorage.exception.CustomException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public List<UserResponseDTO> getAllUsers() {
        log.debug("getAllUsers");
        return userRepo.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(int id) {
        log.debug("getUserById: " + id);
        return new UserResponseDTO(userRepo.findById(id).get());
    }

    public List<UserResponseDTO> getUserByLogin(String login) {
        log.debug("getUserByLogin: " + login);
        return userRepo.findByLoginLike(login).stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    public UserResponseDTO getUserByEmail(String email) {
        log.debug("getUserByEmail: " + email);
        return new UserResponseDTO(userRepo.findByEmail(email));
    }

    public Integer existUserByEmail(String email) {
        log.debug("existUserByEmail: " + email);
        try {
            return userRepo.findByEmail(email).getId();
        } catch (Exception e) {
            return -1;
        }
    }
    public UserResponseDTO existUser(String email) {
        log.debug("existUser: " + email);
        try {
            return new UserResponseDTO(userRepo.findByEmail(email));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean existUserById(int id) {
        log.debug("existUserById: " + id);
        try {
            return userRepo.findById(id).get().getId() > 0 ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

    public int createUser(String login, String sex, String email, String password) {
        UserEntity userEntity = new UserEntity(login, sex, email, passwordEncoder.encode(password), Role.USER);
        log.debug("User creation: " + userEntity);
        return userRepo.save(userEntity).getId();
    }

    public UserResponseDTO updateUser(int id, String login, String sex, String email, String password) {
        UserEntity userEntity = userRepo.findById(id).get();
        userEntity.setLogin(login);
        userEntity.setSex(sex);
        userEntity.setEmail(email);
        userEntity.setPassword(passwordEncoder.encode(password));
        userRepo.save(userEntity);
        log.debug("User was updated " + userEntity);
        return new UserResponseDTO(userRepo.findById(id).get());
    }

    public UserResponseDTO deleteUser(int id) {
        UserEntity userEntity = userRepo.findById(id).get();
        userRepo.deleteById(id);
        log.debug("User with id " + id + " was deleted");
        return new UserResponseDTO(userEntity);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepo.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
