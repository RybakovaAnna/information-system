package ru.ibs.training.informationsystem.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component
public class JwtProvider {

    final static String BEARER_PREFIX = "Bearer ";
    private static long TIMEOUT_ACCESS = 1000L * 60 * 60 * 24 * 3;

    private final JWTVerifier verifier;
    private final Algorithm algo;

    @Autowired
    public JwtProvider(@Value("111111111111111111111") String secret) {
        this.algo = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algo).build();
    }


    public String createToken(Authentication authentication) {
        final List<String> roleNames = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(toList());

        return BEARER_PREFIX + JWT.create()
                .withSubject(authentication.getName())
                .withClaim("roles", roleNames)
                .withExpiresAt(
                        new Date(System.currentTimeMillis() + TIMEOUT_ACCESS))
                .sign(algo);
    }

    public String getUsername(String token) {
        final DecodedJWT decodedJwt = verifier.verify(token);
        return decodedJwt.getSubject();
    }

    public List<GrantedAuthority> getAuthorities(String token) {
        final DecodedJWT decodedJwt = verifier.verify(token);
        final List<String> roleNames = decodedJwt.getClaim("roles").asList(String.class);
        return roleNames.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(toList());
    }

    public String resolveToken(HttpServletRequest request) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!header.isEmpty() || header.startsWith(BEARER_PREFIX)) {
            return header.replace(BEARER_PREFIX, "");
        }
        return null;
    }
}
