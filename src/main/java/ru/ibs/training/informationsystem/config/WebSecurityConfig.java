package ru.ibs.training.informationsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.ibs.training.informationsystem.filters.JwtAuthenticationFilter;
import ru.ibs.training.informationsystem.filters.JwtAuthorizationFilter;
import ru.ibs.training.informationsystem.repositories.security.InMemoryUserRepository;
import ru.ibs.training.informationsystem.repositories.security.UserRepository;
import ru.ibs.training.informationsystem.security.User;
import ru.ibs.training.informationsystem.security.UserService;
import ru.ibs.training.informationsystem.services.interfaces.JwtService;

import java.util.Collections;

import static java.util.Arrays.asList;

@Configuration
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtService jwtService;

    @Autowired
    public WebSecurityConfig(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtService, authenticationManager());
        jwtAuthenticationFilter.setFilterProcessesUrl("api/auth");

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .anyRequest().permitAll()

                .and()
                .formLogin()
                .loginProcessingUrl("/api/auth")

                .and()
                .logout()
//                .logoutUrl("/api/logout")

                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(
                        new JwtAuthorizationFilter(jwtService),
                        UsernamePasswordAuthenticationFilter.class
                );
    }

    @Bean
    public UserDetailsService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserRepository userRepository(PasswordEncoder passwordEncoder){
        final InMemoryUserRepository repo = new InMemoryUserRepository();

        repo.add(
                new User("julia", passwordEncoder.encode("head"), "head_branch", Collections.singletonList("ROLE_ROOT")));
        repo.add(
                new User("oleg", passwordEncoder.encode("branch"), "branch1", Collections.singletonList("ROLE_USER")));
        repo.add(
                new User("peter", passwordEncoder.encode("branch"), "branch2", Collections.singletonList("ROLE_USER")));
        repo.add(
                new User("artur", passwordEncoder.encode("branch"), "branch3", Collections.singletonList("ROLE_USER")));
        repo.add(
                new User("olga", passwordEncoder.encode("branch"), "branch4", Collections.singletonList("ROLE_USER")));
        repo.add(
                new User("katya", passwordEncoder.encode("branch"),"branch5", Collections.singletonList("ROLE_USER")));
        return repo;
    }

}
