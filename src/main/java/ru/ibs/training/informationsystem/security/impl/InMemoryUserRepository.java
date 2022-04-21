package ru.ibs.training.informationsystem.security.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.ibs.training.informationsystem.security.User;
import ru.ibs.training.informationsystem.security.service.UserRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public InMemoryUserRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        users.put("julia",
                new User("julia", passwordEncoder.encode("head"), "head_branch", Collections.singletonList("ROLE_ROOT")));
        users.put("oleg",
                new User("oleg", passwordEncoder.encode("branch"), "branch1", Collections.singletonList("ROLE_USER")));
        users.put("peter",
                new User("peter", passwordEncoder.encode("branch"), "branch2", Collections.singletonList("ROLE_USER")));
        users.put("artur",
                new User("artur", passwordEncoder.encode("branch"), "branch3", Collections.singletonList("ROLE_USER")));
        users.put("olga",
                new User("olga", passwordEncoder.encode("branch"), "branch4", Collections.singletonList("ROLE_USER")));
        users.put("katya",
                new User("katya", passwordEncoder.encode("branch"),"branch5", Collections.singletonList("ROLE_USER")));
    }

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }

    @Override
    public void add(User user) {
        users.put(user.getUsername(), user);
    }

}
