/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth.roles;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import micronaut.java.IService;
import micronaut.java.users.User;
import micronaut.java.users.UserRepository;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller("roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Secured(SecurityRule.IS_AUTHENTICATED)
public class RoleController {
    @Inject
    private IRoleService roleService;

    @Inject
    private UserRepository userRepository;

    @Get
    @RolesAllowed({ "INDEX_ROLE" })
    public HttpResponse<?> index() {
        return roleService.fetchModels();
    }

    @Get("{id}")
    @RolesAllowed({ "SHOW_ROLE" })
    public HttpResponse<?> show(@PathVariable("id")UUID id) {
        return roleService.fetchModel(id);
    }

    @Post
    @RolesAllowed({ "CREATE_ROLE" })
    public HttpResponse<?> store(@Body @Valid RoleRequest roleRequest) {
        Optional<User> user = userRepository.findById(roleRequest.getUser_id());
        Role role = new Role(roleRequest.getName(), user.get());
        return roleService.storeModel(role);
    }

    @Put("{id}")
    @RolesAllowed({ "UPDATE_ROLE" })
    public HttpResponse<?> store(@PathVariable("id") UUID id, @Body @Valid RoleRequest roleRequest) {
        Optional<User> user = userRepository.findById(roleRequest.getUser_id());
        Role role = new Role(roleRequest.getName(), user.get());
        role.setId(id);
        return roleService.updateModel(role);
    }

    @Delete("{id}")
    @RolesAllowed({ "DELETE_ROLE" })
    public HttpResponse<?> destroy(@PathVariable("id") UUID id) {
        return roleService.deleteModel(id);
    }
}
