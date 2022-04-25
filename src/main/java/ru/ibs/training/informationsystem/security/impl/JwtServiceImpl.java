package ru.ibs.training.informationsystem.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.AuthDto;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.TokenDto;
import ru.ibs.training.informationsystem.security.User;
import ru.ibs.training.informationsystem.security.filters.JwtProvider;
import ru.ibs.training.informationsystem.security.service.AuthService;
import ru.ibs.training.informationsystem.security.service.JwtService;

@Service
public class JwtServiceImpl implements JwtService {

    private final JwtProvider jwtProvider;
    private final AuthService authService;

    @Autowired
    public JwtServiceImpl(JwtProvider jwtProvider, AuthService authService) {
        this.jwtProvider = jwtProvider;
        this.authService = authService;
    }

    @Override
    public TokenDto authorise(AuthDto authDto) {
        User user = authService.authByLoginAndPassword(authDto.getLogin(), authDto.getPass());
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        authDto.getLogin(), null, ((UserDetails) user).getAuthorities());

        authentication.setDetails(user);
        String token = jwtProvider.createToken(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        return new TokenDto(token);
    }
}
