package com.sprint2.book_store_webservice.controller;

import com.sprint2.book_store_webservice.jwt.JwtFilter;
import com.sprint2.book_store_webservice.jwt.JwtUtility;
import com.sprint2.book_store_webservice.model.Account;
import com.sprint2.book_store_webservice.model.LoginRequest;
import com.sprint2.book_store_webservice.model.LoginResponse;
import com.sprint2.book_store_webservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private IAccountService iAccountService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Optional<LoginRequest> loginRequest) {

        if (!loginRequest.isPresent()) {
            return new ResponseEntity<>("Không được để trống tài khoản, mật khẩu", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.get().getUsername(), loginRequest.get().getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetailService = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account account = this.iAccountService.findByEmail(loginRequest.get().getUsername());
        List<String> roles = userDetailService.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String jwt = jwtUtility.generateJwtToken(loginRequest.get().getUsername());
        return new ResponseEntity<>(new LoginResponse(jwt, roles, loginRequest.get().getUsername(),account.getId()), HttpStatus.OK);
    }



}
