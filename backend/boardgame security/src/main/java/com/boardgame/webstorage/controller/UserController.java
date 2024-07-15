package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.AuthenticationRequest;
import com.boardgame.webstorage.dto.AuthenticationResponse;
import com.boardgame.webstorage.dto.UserRequestDTO;
import com.boardgame.webstorage.dto.UserResponseDTO;
import com.boardgame.webstorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/allrows")
    public ResponseEntity<List<UserResponseDTO>> getAllRows() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping(value = "/{login}")
    public ResponseEntity<List<UserResponseDTO>> getUserByLogin(@PathVariable("login") String login) {
        return ResponseEntity.ok(userService.getUserByLogin(login));
    }

    @GetMapping(value = "/find/{email}")
    public ResponseEntity<Integer> existUserByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.existUserByEmail(email));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(userService.authenticate(request));
    }


    @GetMapping(value = "/finduser/{email}")
    public ResponseEntity<UserResponseDTO> existUser(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.existUser(email));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createUser(@RequestBody UserRequestDTO body) {
        return ResponseEntity.ok(userService.createUser(body.getLogin(),body.getSex(),body.getEmail(),body.getPassword()));
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO body) {
        return ResponseEntity.ok(userService.updateUser(body.getId(),body.getLogin(),body.getSex(),body.getEmail(),body.getPassword()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
