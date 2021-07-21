/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth.roles;

import io.micronaut.core.annotation.Introspected;
import micronaut.java.validation.Exists;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Introspected
public class RoleRequest {
    @NotBlank
    @Min(5)
    @Max(25)
    private String name;

    @NotBlank
    @Exists(bodyMessage = "Hello this body exists!")
    private UUID user_id;

    public RoleRequest(@NotBlank @Min(5) @Max(25) String name, @NotBlank UUID user_id) {
        this.name = name;
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }
}
