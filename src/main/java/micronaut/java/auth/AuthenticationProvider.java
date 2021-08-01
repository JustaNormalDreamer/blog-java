/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Singleton
public class AuthenticationProvider implements io.micronaut.security.authentication.AuthenticationProvider {

    @Inject
    private AuthService authService;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {

            String username = (String) authenticationRequest.getIdentity();
            String password = (String) authenticationRequest.getSecret();

            if(authService.validCredentials(username, password)) {
                emitter.onNext(new ClaimUserDetails(username, new ArrayList<>(Arrays.asList("INDEX_ROLE", "SHOW_ROLE", "CREATE_ROLE", "UPDATE_ROLE", "DELETE_ROLE")), "team7hookage@gmail.com"));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }, BackpressureStrategy.ERROR);
    }
}
