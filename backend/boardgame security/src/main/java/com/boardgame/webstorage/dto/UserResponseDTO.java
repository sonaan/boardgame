package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private int id;
    private String login;
    private String sex;
    private Date activity;
    private String email;
    private String password;
    private String role;

    public UserResponseDTO(UserEntity userEntity) {
        id = userEntity.getId();
        login = userEntity.getLogin();
        sex = userEntity.getSex();
        activity = userEntity.getActivity();
        email = userEntity.getEmail();
        password = userEntity.getPassword();
        role = userEntity.getRole().name();
    }

}
