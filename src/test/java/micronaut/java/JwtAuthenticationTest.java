/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java;

import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.SignedJWT;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.text.ParseException;

@MicronautTest
public class JwtAuthenticationTest {
    @Inject
    @Client("/")
    HttpClient client;

//    @Test
//    public void accessingASecuredUrlWithoutAuthenticationReturnsUnAuthorized() {
//        HttpClientResponseException e = Assertions.assertThrows(HttpClientResponseException.class, () -> {
//            client.toBlocking().exchange(HttpRequest.GET("dashboard").accept(MediaType.TEXT_PLAIN));
//        });
//
//        Assertions.assertEquals(e.getStatus(), HttpStatus.UNAUTHORIZED);
//    }
//
//    @Test
//    public void upon_success_authentication_a_json_web_token_is_issued_to_the_user() throws ParseException {
//        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("justadreamer", "password");
//        HttpRequest request = HttpRequest.POST("/login", creds);
//        HttpResponse<BearerAccessRefreshToken> rsp = client.toBlocking().exchange(request, BearerAccessRefreshToken.class);
//        Assertions.assertEquals(HttpStatus.OK, rsp.getStatus());
//
//        BearerAccessRefreshToken bearerAccessRefreshToken = rsp.body();
//        Assertions.assertEquals("justadreamer", bearerAccessRefreshToken.getUsername());
//        Assertions.assertNotNull(bearerAccessRefreshToken.getAccessToken());
//        Assertions.assertTrue(JWTParser.parse(bearerAccessRefreshToken.getAccessToken()) instanceof SignedJWT);
//
//        String accessToken = bearerAccessRefreshToken.getAccessToken();
//        HttpRequest requestWithAuthorization = HttpRequest.GET("dashboard")
//                .accept(MediaType.TEXT_PLAIN)
//                .bearerAuth(accessToken);
//
//        HttpResponse<String> response = client.toBlocking().exchange(requestWithAuthorization, String.class);
//
//        Assertions.assertEquals(HttpStatus.OK, rsp.getStatus());
//        Assertions.assertEquals("justadreamer", response.body());
//
//    }
}
