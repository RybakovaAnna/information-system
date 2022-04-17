package ru.ibs.training.informationsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.ibs.training.informationsystem.repositories.security.InMemoryUserRepository;
import ru.ibs.training.informationsystem.repositories.security.UserRepository;
import ru.ibs.training.informationsystem.security.User;
import ru.ibs.training.informationsystem.security.UserService;

import java.util.Collections;

import static java.util.Arrays.asList;

@Configuration
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Profile("in-memory")
    public InMemoryUserRepository userRepository(PasswordEncoder passwordEncoder) {
        final InMemoryUserRepository repo = new InMemoryUserRepository();
        repo.add(
                new User("head", passwordEncoder.encode("head"), "head_branch", Collections.singletonList("ROLE_HEAD")));
        repo.add(
                new User("branch", passwordEncoder.encode("branch"), "branch1", asList("ROLE_BRANCH")));
        repo.add(
                new User("branch", passwordEncoder.encode("branch"), "branch2", asList("ROLE_BRANCH")));
        repo.add(
                new User("branch", passwordEncoder.encode("branch"), "branch3", asList("ROLE_BRANCH")));
        repo.add(
                new User("branch", passwordEncoder.encode("branch"), "branch4", asList("ROLE_BRANCH")));
        repo.add(
                new User("branch", passwordEncoder.encode("branch"), "branch5", asList("ROLE_BRANCH")));

        return repo;
    }

}
