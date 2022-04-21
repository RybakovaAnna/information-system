package ru.ibs.training.informationsystem.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.ibs.training.informationsystem.security.User;
import ru.ibs.training.informationsystem.security.service.AuthService;
import ru.ibs.training.informationsystem.security.service.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User authByLoginAndPassword(String username, String password) {
        final User user = userRepository.findByUsername(username);
        if (user == null)
            throw  new UsernameNotFoundException("Нет пользователя с таким логином");

        if(!passwordEncoder.matches(password, user.getPassword()))
            throw  new UsernameNotFoundException("Неверный пароль");
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) throw new UsernameNotFoundException("Нет такого пользователя!");
        return byUsername;
    }
}
