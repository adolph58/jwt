package com.example.jwt.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Arte
 * @create 2020/6/18.
 */
@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private Boolean state;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
