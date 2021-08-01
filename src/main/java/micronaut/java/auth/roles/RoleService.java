/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth.roles;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import micronaut.java.helpers.JsonResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class RoleService implements IRoleService {
    @Inject
    private RoleRepository roleRepository;

    public HttpResponse<?> fetchModels() {
        JsonResponse<Role> res = new JsonResponse<>("RL-200", "Roles has been fetched.", "Roles has been fetched.", roleRepository.findAll());
        return HttpResponse.status(HttpStatus.OK).body(res.response());
    }

    public HttpResponse<?> fetchModel(UUID id) {
        Optional<RoleResource> roleResource = roleRepository.findOne(id);

        if(roleResource.isPresent()) {
            JsonResponse<Optional<RoleResource>> res = new JsonResponse<>("R-200", "Role has been fetched.", "Role has been fetched.", roleRepository.findOne(id));
            return HttpResponse.status(HttpStatus.OK).body(res.response());
        }

        String message = String.format("Role of id: %s not found.", id);
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(new JsonResponse<>("R-404", message, message));
    }

    public HttpResponse<?> storeModel(Role role) {
        JsonResponse<Role> res = new JsonResponse<>("RC-201", "Role has been created.", "Role has been created.", roleRepository.save(role));
        return HttpResponse.status(HttpStatus.CREATED).body(res.response());
    }

    public HttpResponse<?> updateModel(Role role) {
        JsonResponse<Role> res = new JsonResponse<>("RU-200", "Role has been updated.", "Role has been updated.", roleRepository.update(role));
        return HttpResponse.status(HttpStatus.OK).body(res.response());
    }

    public HttpResponse<?> deleteModel(UUID id) {
        roleRepository.deleteById(id);
        JsonResponse<Role> res = new JsonResponse<>("RD-200", "Role has been deleted.", "Role has been deleted.");
        return HttpResponse.status(HttpStatus.OK).body(res.response());
    }
}
