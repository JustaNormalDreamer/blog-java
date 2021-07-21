/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth.roles;

import io.micronaut.http.HttpResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class RoleService {
    @Inject
    private RoleRepository roleRepository;

    public Iterable<Role> fetchRoles() {
        return roleRepository.findAll();
    }

    public Optional<RoleResource> fetchRole(UUID id) {
        return roleRepository.findOne(id);
    }

    public Role storeRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(UUID id, Role role) {
        return roleRepository.update(role);
    }

    public HttpResponse<?> deleteRole(UUID id) {
        roleRepository.deleteById(id);

        Map<String, String> message = new HashMap<>();
        message.put("code", "RL-D-200");
        message.put("localizedMessage", "Role has been deleted successfully.");
        message.put("message", "Role has been deleted successfully.");

        return HttpResponse.ok(message);
    }



}
