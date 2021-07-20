/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.blog.posts;

import io.micronaut.http.HttpResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class PostService {
    @Inject
    private PostRepository postRepository;

    public HttpResponse<List<PostResource>> fetchPosts() {
        List<PostResource> postResources = new ArrayList<>();
        for (Post post: postRepository.findAll()) {
            postResources.add(new PostResource(post.getId(), post.getName(), post.getDescription(), post.isStatus(), post.getCreated_at(), post.getUpdated_at()));
        }

        return HttpResponse.ok(postResources);
    }

    public Optional<PostResource> fetchPost(UUID id) {
        return postRepository.findOne(id);
    }

    public Post storePost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
        return postRepository.update(post);
    }

    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }
}
