package ru.ibs.training.informationsystem.repositories.security;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("in-memory")
public class InMemoryAccessTokenRepository implements AccessTokenRepository {

    private final Map<String, String> storage = new ConcurrentHashMap<>();


    @Override
    public void newToken(String username, String newRefreshToken) {
        storage.put(username, newRefreshToken);
    }

    @Override
    public boolean checkAndDelete(String username, String refreshToken) {
        final boolean contains = refreshToken.equals(storage.get(username));
        if (contains)
            storage.remove(username, refreshToken);
        return contains;
    }
}
