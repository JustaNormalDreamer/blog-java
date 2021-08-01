/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth;

import io.micronaut.security.authentication.UserDetails;

import java.util.Collection;

public class ClaimUserDetails extends UserDetails {

    private String email;

    public ClaimUserDetails(String username, Collection<String> roles) {
        super(username, roles);
    }

    public ClaimUserDetails(String username, Collection<String> roles, String email) {
        super(username, roles);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
