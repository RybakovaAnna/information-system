package ru.ibs.training.informationsystem.repositories.security;

import org.springframework.stereotype.Component;
import ru.ibs.training.informationsystem.security.User;

import java.util.HashMap;
import java.util.Map;


@Component
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<>();

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }

    @Override
    public void add(User user) {
        users.put(user.getUsername(), user);
    }

}
