package ru.ibs.training.informationsystem.security.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ru.ibs.training.informationsystem.security.filters.JwtProvider.BEARER_PREFIX;

public class TokenVerifierFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Autowired
    public TokenVerifierFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = jwtProvider.resolveToken(request);
            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }
            String username = jwtProvider.getUsername(token);
            List<GrantedAuthority> authorities = jwtProvider.getAuthorities(token);

            response.setHeader(HttpHeaders.AUTHORIZATION, BEARER_PREFIX + token);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
        } catch (Exception err) {
            System.out.println("Невалидный токен");
        }
        filterChain.doFilter(request, response);
    }
}
