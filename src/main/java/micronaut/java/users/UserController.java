/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.users;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@Controller("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Secured(SecurityRule.IS_AUTHENTICATED)
public class UserController {
    @Inject
    private UserService userService;

    @Get
    public HttpResponse<List<UserResource>> index() {
        return userService.fetchUsers();
    }

    @Get("{id}")
    public MutableHttpResponse<UserResource> show(@PathVariable("id") UUID id) {
        return userService.fetchUser(id);
    }

    @Post
    public User store(@Body @Valid UserRequest userRequest) throws NoSuchAlgorithmException {
        User user = new User(userRequest.getName(), userRequest.getUsername(), userRequest.getEmail(), userRequest.getPassword());
        return userService.storeUser(user);
    }

    @Put("{id}")
    public User update(@PathVariable("id") UUID id, @Body @Valid UserRequest userRequest) {
        User user = new User(id, userRequest.getName(), userRequest.getUsername(), userRequest.getEmail(), userRequest.getPassword());
        return userService.updateUser(user);
    }

    @Delete("{id}")
    public HttpResponse<?> destroy(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
        return HttpResponse.ok("User has been deleted successfully.");
    }
}
