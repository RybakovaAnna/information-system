package ru.ibs.training.informationsystem.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.ibs.training.informationsystem.security.User;

public interface AuthService extends UserDetailsService {

    User authByLoginAndPassword(String login, String password);
}
