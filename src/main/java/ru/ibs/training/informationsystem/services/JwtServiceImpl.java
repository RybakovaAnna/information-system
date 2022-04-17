package ru.ibs.training.informationsystem.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.ibs.training.informationsystem.repositories.security.AccessTokenRepository;
import ru.ibs.training.informationsystem.services.interfaces.JwtService;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class JwtServiceImpl implements JwtService {

    private static final long TIMEOUT_ACCESS = 1000L * 60 * 60 * 3;

    private final AccessTokenRepository accessTokenRepository;
    private final Algorithm algo;
    private final JWTVerifier verifier;

    @Autowired
    public JwtServiceImpl(AccessTokenRepository accessTokenRepository, @Value("${my-config.auth.secret:secret}") String secret) {
        this.accessTokenRepository = accessTokenRepository;
        this.algo = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algo).build();
    }

    @Override
    public String generateAccessToken(UserDetails user) {

        final List<String> roleNames = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(toList());

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TIMEOUT_ACCESS))

                .withClaim("roles", roleNames)

                .sign(algo);
    }

    @Override
    public String validateAccessToken(String token) {
        try {
            final DecodedJWT decodedJwt = verifier.verify(token);
            final String username = decodedJwt.getSubject();

            if (accessTokenRepository.checkAndDelete(username, token)) {
                return username;
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean validateTokenAndPutSecurityContext(String token) {
        try {
            final DecodedJWT decodedJwt = verifier.verify(token);
            final String username = decodedJwt.getSubject();
            final List<String> roleNames = decodedJwt.getClaim("roles").asList(String.class);

            final List<SimpleGrantedAuthority> roles = roleNames.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(toList());

            final SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(
                    new UsernamePasswordAuthenticationToken(username, null, roles));
            return true;
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        }
    }
}
