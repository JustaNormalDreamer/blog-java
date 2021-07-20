/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.blog.posts;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller("posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Secured(SecurityRule.IS_AUTHENTICATED)
@PermitAll
public class PostController {
    @Inject
    private PostService postService;

    @Get
    public HttpResponse<List<PostResource>> index() {
        return postService.fetchPosts();
    }

    @Get("{id}")
    public Optional<PostResource> show(@PathVariable("id") UUID id) {
        return postService.fetchPost(id);
    }

    @io.micronaut.http.annotation.Post
    public Post store(@Body @Valid PostRequest postRequest) {
        Post post = new Post(postRequest.getName(), postRequest.getDescription(), postRequest.isStatus());
        return postService.storePost(post);
    }

    @Put("{id}")
    public Post update(@PathVariable("id") UUID id, @Body @Valid PostRequest postRequest) {
        Post post = new Post(id, postRequest.getName(), postRequest.getDescription(), postRequest.isStatus());
        return postService.updatePost(post);
    }

    @Delete("{id}")
    public HttpResponse<?> destroy(@PathVariable("id") UUID id) {
        postService.deletePost(id);
        return HttpResponse.ok("Post has been deleted.");
    }

}
