package ru.ibs.training.informationsystem.repositories.security;


public interface AccessTokenRepository {

    public void newToken(String userName, String accessToken);
    boolean checkToken(String username, String accessToken);
}
