package ru.ibs.training.informationsystem.filters;

import org.springframework.web.filter.OncePerRequestFilter;
import ru.ibs.training.informationsystem.services.interfaces.JwtService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private JwtService jwtService;

    public JwtAuthorizationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        final String servletPath = request.getServletPath();
        if (!servletPath.equals("/api/auth") && !servletPath.equals("/api/token-access")) {
            String accessToken = getToken(request);
            if (accessToken != null && !accessToken.isEmpty()) {
                jwtService.validateAccessToken(accessToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    public static String getToken(HttpServletRequest req) {
        final String authHeader = req.getHeader(AUTHORIZATION);
        if (authHeader != null && !authHeader.isEmpty()) {
            return authHeader.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public static final String TOKEN_PREFIX = "Bearer ";
}