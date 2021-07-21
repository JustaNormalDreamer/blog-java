/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth.roles;

import io.micronaut.core.annotation.Introspected;

import micronaut.java.users.User;
import java.util.Date;
import java.util.UUID;

@Introspected
public class RoleResource {
    private UUID id;

    private String name;

    private Date created_at;

    private Date updated_at;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public RoleResource(UUID id, String name, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
