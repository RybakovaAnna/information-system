package ru.ibs.training.informationsystem.repositories.security;

public interface AccessTokenRepository {

    void newToken(String username, String newRefreshToken);
    boolean checkAndDelete(String username, String refreshToken);
}
