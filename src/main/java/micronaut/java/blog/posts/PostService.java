/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.blog.posts;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import micronaut.java.auth.roles.Role;
import micronaut.java.helpers.JsonResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class PostService implements IPostService {
    @Inject
    private PostRepository postRepository;

    @Override
    public HttpResponse<?> fetchModels() {
        JsonResponse<Post> res = new JsonResponse<>("PL-200", "Posts has been fetched.", "Posts has been fetched.", postRepository.findAll());
        return HttpResponse.status(HttpStatus.OK).body(res.response());
    }

    @Override
    public HttpResponse<?> fetchModel(UUID id) {
        Optional<PostResource> postResource = postRepository.findOne(id);

        if(postResource.isPresent()) {
            JsonResponse<Optional<PostResource>> res = new JsonResponse<>("P-200", "Post has been fetched.", "Post has been fetched.", postRepository.findOne(id));
            return HttpResponse.status(HttpStatus.OK).body(res.response());
        }

        String message = String.format("Post of id: %s not found.", id);
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(new JsonResponse<>("P-404", message, message));
    }

    @Override
    public HttpResponse<?> storeModel(Post model) {
        JsonResponse<Post> res = new JsonResponse<>("PC-201", "Post has been created.", "Post has been created.", postRepository.save(model));
        return HttpResponse.status(HttpStatus.CREATED).body(res.response());
    }

    @Override
    public HttpResponse<?> updateModel(Post model) {
        JsonResponse<Post> res = new JsonResponse<>("PU-200", "Post has been updated.", "Post has been updated.", postRepository.update(model));
        return HttpResponse.status(HttpStatus.OK).body(res.response());
    }

    @Override
    public HttpResponse<?> deleteModel(UUID id) {
        postRepository.deleteById(id);
        JsonResponse<Role> res = new JsonResponse<>("PD-200", "Post has been deleted.", "Post has been deleted.");
        return HttpResponse.status(HttpStatus.OK).body(res.response());
    }
}
