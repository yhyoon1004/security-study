package com.example.security4.service;

import com.example.security4.dto.UserForm;
import com.example.security4.entity.User;
import com.example.security4.repository.UserRepository;
import com.example.security4.userDetails.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username);
        return new UserDetailsImpl(principal);
    }

    public void enrollUser(UserForm userForm) {
        User save = userRepository.save(userForm.toEntity());
        System.out.println(save.getUsername()+"enrolled!!");

    }
}
