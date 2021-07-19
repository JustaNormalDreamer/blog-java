/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.blog.posts;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Introspected
public class PostRequest {
    @NotBlank
    @Min(5)
    @Max(25)
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private boolean status;

    @NotBlank
    private UUID user_id;

    public PostRequest(@NotBlank @Min(5) @Max(25) String name, @NotBlank String description, @NotBlank boolean status, @NotBlank UUID user_id) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }
}
