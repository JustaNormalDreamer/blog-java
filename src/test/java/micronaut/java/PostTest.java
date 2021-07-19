/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import micronaut.java.blog.posts.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class PostTest {
    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void test_it_is_able_to_fetch_posts_list() {
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/posts"));
        Assertions.assertEquals("", response);
    }
}
