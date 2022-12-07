package com.sprint2.book_store_webservice.service.impl;

import com.sprint2.book_store_webservice.model.Account;
import com.sprint2.book_store_webservice.model.AppRole;
import com.sprint2.book_store_webservice.repository.IAccountRepository;
import com.sprint2.book_store_webservice.repository.IAppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDetailsService implements UserDetailsService {
    @Autowired
    private IAccountRepository iAccountRepository;
    @Autowired
    private IAppRoleRepository iAppRoleRepository;
    @Override
    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.iAccountRepository.findByEmail(username);
        if (account == null){
          throw  new UsernameNotFoundException("Account" + username + "not exits");
        }
        List<AppRole> appRoles = this.iAppRoleRepository.findRole(account.getEmail());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (AppRole role: appRoles) {
            grantedAuthorities .add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(account.getEmail(),account.getPassword(),grantedAuthorities);
    }
}
