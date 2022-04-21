package ru.ibs.training.informationsystem.repositories.security;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryAccessTokenRepository implements AccessTokenRepository {

    private final Map<String, String> storage = new ConcurrentHashMap<>();


    @Override
    public void newToken(String userName, String accessToken) {
        storage.put(userName, accessToken);
    }

    @Override
    public boolean checkToken(String username, String accessToken) {
        final boolean contains = accessToken.equals(storage.get(username));
        return contains;
    }
}
