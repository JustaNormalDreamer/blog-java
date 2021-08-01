/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import micronaut.java.helpers.JsonResponse;
import micronaut.java.users.User;
import micronaut.java.users.UserRequest;
import micronaut.java.users.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller("auth")
public class AuthController {
    @Inject
    private AuthService authService;

    @Inject
    private UserService userService;

    @Get("profile")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    public HttpResponse<ProfileResource> profile(Authentication authentication) {
        return authService.fetchByUsername(authentication.getName());
    }

    @Post("register")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public HttpResponse<?> register(@Body @Valid UserRequest userRequest) throws NoSuchAlgorithmException {
        User user = new User(userRequest.getName(), userRequest.getUsername(), userRequest.getEmail(), userRequest.getPassword());
        userService.storeUser(user);

        JsonResponse<User> jsonResponse = new JsonResponse<>("USR-201", "User has been registered successfully.", "User has been registered successfully.");
        return HttpResponse.status(HttpStatus.CREATED).body(jsonResponse);
    }
}
