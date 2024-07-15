package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private int id;
    private String login;
    private String sex;
    private Date activity;
    private String email;
    private String password;

    public UserRequestDTO(UserEntity userEntity) {
        login = userEntity.getLogin();
        sex = userEntity.getSex();
        activity = userEntity.getActivity();
        email = userEntity.getEmail();
        password = userEntity.getPassword();
    }

}
