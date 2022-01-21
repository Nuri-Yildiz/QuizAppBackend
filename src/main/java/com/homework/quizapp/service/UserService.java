package com.homework.quizapp.service;


import com.homework.quizapp.controller.rest.requestDTO.UserLogin;
import com.homework.quizapp.controller.rest.requestDTO.UserRegister;
import com.homework.quizapp.entity.Role;
import com.homework.quizapp.entity.User;
import com.homework.quizapp.repository.RoleRepository;
import com.homework.quizapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public String registerUser(UserRegister user) {

        Role role = roleRepository.getById(2L);

        User userEntity = new User();

        userEntity.getRoles().add(role);
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstName());
        userEntity.setLastname(user.getLastName());
        userEntity.setPassword((passwordEncoder.encode(user.getPassword())));

        userRepository.save(userEntity);
        return userEntity.getFirstname();
    }


    public String login(UserLogin userLogin) {
        User user = userRepository.findByEmail(userLogin.getEmail()).get();
        return user.getEmail();
    }

    public User getUser(String email){
       return userRepository.findByEmail(email).get();
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("username not found "));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
}