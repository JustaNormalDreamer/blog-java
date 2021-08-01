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

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.UUID;

@Controller("posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Secured(SecurityRule.IS_AUTHENTICATED)
public class PostController {
    @Inject
    private IPostService postService;

    @Get
    public HttpResponse<?> index() {
        return postService.fetchModels();
    }

    @Get("{id}")
    public HttpResponse<?> show(@PathVariable("id") UUID id) {
        return postService.fetchModel(id);
    }

    @io.micronaut.http.annotation.Post
    public HttpResponse<?> store(@Body @Valid PostRequest postRequest) {
        Post post = new Post(postRequest.getName(), postRequest.getDescription(), postRequest.isStatus());
        return postService.storeModel(post);
    }

    @Put("{id}")
    public HttpResponse<?> update(@PathVariable("id") UUID id, @Body @Valid PostRequest postRequest) {
        Post post = new Post(id, postRequest.getName(), postRequest.getDescription(), postRequest.isStatus());
        return postService.updateModel(post);
    }

    @Delete("{id}")
    public HttpResponse<?> destroy(@PathVariable("id") UUID id) {
        postService.deleteModel(id);
        return HttpResponse.ok("Post has been deleted.");
    }

}
