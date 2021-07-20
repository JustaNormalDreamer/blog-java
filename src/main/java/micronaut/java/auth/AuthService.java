/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth;

import io.micronaut.http.HttpResponse;
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

    public HttpResponse<ProfileResource> fetchByUsername(String username) {
        User user = authRepository.findByUsername(username);
        ProfileResource profileResource = new ProfileResource(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getCreated_at(), user.getUpdated_at());
        return HttpResponse.ok(profileResource);
    }

    public boolean validCredentials(String username, String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashed = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        System.out.println(password);
        User user = authRepository.findByUsernameAndPassword(username, password);
        if(user == null) {
            throw new UnauthorizedException("Invalid credentials, either the username or password is incorrect.");
        }
        return true;
    }
}
