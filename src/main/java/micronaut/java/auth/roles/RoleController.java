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
import micronaut.java.users.User;
import micronaut.java.users.UserRepository;

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
    private RoleService roleService;

    @Inject
    private UserRepository userRepository;

    @Get
    public Iterable<Role> index() {
        return roleService.fetchRoles();
    }

    @Get("{id}")
    public Optional<RoleResource> show(@PathVariable("id")UUID id) {
        return roleService.fetchRole(id);
    }

    @Post
    public Role store(@Body @Valid RoleRequest roleRequest) {
        Optional<User> user = userRepository.findById(roleRequest.getUser_id());
        Role role = new Role(roleRequest.getName(), user.get());
        return roleService.storeRole(role);
    }

    @Put("{id}")
    public Role store(@PathVariable("id") UUID id, @Body @Valid RoleRequest roleRequest) {
        Optional<User> user = userRepository.findById(roleRequest.getUser_id());
        Role role = new Role(roleRequest.getName(), user.get());
        role.setId(id);
        return roleService.updateRole(id, role);
    }

    @Delete("{id}")
    public HttpResponse<?> destroy(@PathVariable("id") UUID id) {
        return roleService.deleteRole(id);
    }
}
