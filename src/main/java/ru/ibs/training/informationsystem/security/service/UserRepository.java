package ru.ibs.training.informationsystem.security.service;

import ru.ibs.training.informationsystem.security.User;

public interface UserRepository {

    User findByUsername(String username);
    void add(User user);
}
