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

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Inject
    private AuthService authService;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {

            String username = (String) authenticationRequest.getIdentity();
            String password = (String) authenticationRequest.getSecret();

            if(authService.validCredentials(username, password)) {
                emitter.onNext(new UserDetails(username, new ArrayList<>()));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }, BackpressureStrategy.ERROR);
    }
}
