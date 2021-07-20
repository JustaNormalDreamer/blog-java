/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.GenericRepository;
import micronaut.java.users.User;

import java.util.UUID;

@Repository
public interface AuthRepository extends GenericRepository<User, UUID> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
