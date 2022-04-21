package ru.ibs.training.informationsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ru.ibs.training.informationsystem.security.filters.AuthenticationFilter;
import ru.ibs.training.informationsystem.security.filters.JwtProvider;
import ru.ibs.training.informationsystem.security.filters.TokenVerifierFilter;

@Configuration
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtProvider jwtProvider;

    @Autowired
    public SecurityConfig(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/user/**").permitAll()
                .antMatchers("/api/v1/**").hasAnyRole("ROLE_ROOT","ROLE_USER")
                .antMatchers("/api/v1/**").hasAnyAuthority("ROLE_ROOT","ROLE_USER")
                .antMatchers(HttpMethod.DELETE).hasAnyAuthority("ROLE_ROOT")
                .antMatchers(HttpMethod.DELETE).hasAnyRole("ROLE_ROOT")

                .and()
                .addFilter(new AuthenticationFilter(authenticationManager(), jwtProvider))
                .addFilterAfter(new TokenVerifierFilter(jwtProvider), AuthenticationFilter.class);
    }
}
