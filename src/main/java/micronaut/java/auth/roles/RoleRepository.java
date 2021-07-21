/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth.roles;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends PageableRepository<Role, UUID> {
    Optional<RoleResource> findOne(UUID id);
}
