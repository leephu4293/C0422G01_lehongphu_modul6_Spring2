package com.sprint2.book_store_webservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String jwt;

    private List<String> roles;

    private String username;

    private Long accountId;



}
