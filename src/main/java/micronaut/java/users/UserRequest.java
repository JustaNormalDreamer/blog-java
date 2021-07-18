/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.users;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Introspected
public class UserRequest {
    @NotBlank
    @Min(8)
    @Max(25)
    private String name;

    @NotBlank
    @Min(6)
    @Max(20)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Min(8)
    @Max(25)
    private String password;

    @NotBlank
    @Min(8)
    @Max(25)
    private String confirm_password;

    public UserRequest(@NotBlank @Min(8) @Max(25) String name, @NotBlank @Min(6) @Max(20) String username, @NotBlank @Email String email, @NotBlank @Min(8) @Max(25) String password, @NotBlank @Min(8) @Max(25) String confirm_password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}
