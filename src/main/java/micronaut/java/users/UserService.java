/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.users;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class UserService {
    @Inject
    private UserRepository userRepository;

    public HttpResponse<List<UserResource>> fetchUsers() {
        List<UserResource> userResources = new ArrayList<>();

        for (User user: userRepository.findAll()) {
            userResources.add(new UserResource(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getCreated_at(), user.getUpdated_at()));
        }

        return HttpResponse.ok(userResources);
    }

    public MutableHttpResponse<UserResource> fetchUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> HttpResponse.ok(new UserResource(value.getId(), value.getName(), value.getUsername(), value.getEmail(), value.getCreated_at(), value.getUpdated_at()))).orElse(null);
    }

    public User storeUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
