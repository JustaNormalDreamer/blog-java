/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.users;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Optional;

@Controller("users")
public class UserController {
    @Inject
    private UserService userService;

    @Get
    public Iterable<User> index() {
        return userService.fetchUsers();
    }

    @Get("{id}")
    public Optional<User> show(@PathVariable("id") Long id) {
        return userService.fetchUser(id);
    }

    @Post
    public User store(@Body @Valid UserRequest userRequest) {
        User user = new User(userRequest.getName(), userRequest.getUsername(), userRequest.getEmail(), userRequest.getPassword());
        return userService.storeUser(user);
    }

    @Put("{id}")
    public User update(@PathVariable("id") Long id, @Body @Valid UserRequest userRequest) {
        User user = new User(id, userRequest.getName(), userRequest.getUsername(), userRequest.getEmail(), userRequest.getPassword());
        return userService.updateUser(user);
    }

    @Delete("{id}")
    public HttpResponse<?> destroy(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return HttpResponse.ok("User has been deleted successfully.");
    }
}
