/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.blog.posts;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class PostService {
    @Inject
    private PostRepository postRepository;

    public Iterable<Post> fetchPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> fetchPost(UUID id) {
        return postRepository.findById(id);
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
