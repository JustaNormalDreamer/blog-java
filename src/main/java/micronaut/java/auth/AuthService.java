/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth;

import io.micronaut.http.HttpResponse;
import micronaut.java.HashPassword;
import micronaut.java.users.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Singleton
public class AuthService {
    @Inject
    private AuthRepository authRepository;

    @Inject
    private HashPassword hashPassword;

    public HttpResponse<ProfileResource> fetchByUsername(String username) {
        User user = authRepository.findByUsername(username);
        ProfileResource profileResource = new ProfileResource(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getCreated_at(), user.getUpdated_at());
        return HttpResponse.ok(profileResource);
    }

    public boolean validCredentials(String username, String password) {
        User user = authRepository.findByUsername(username);

        if(user == null) {
            throw new UnauthorizedException("User doesn't exist.");
        }

        return hashPassword.matchPassword(password, user.getPassword());
    }
}
