/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth.roles;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import micronaut.java.users.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @DateCreated
    private Date created_at;

    @DateUpdated
    private Date updated_at;

    public Role() {}

    public Role(UUID id, String name, User user, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Role(String name, User user) {
        this.name = name;
        this.user = user;
    }

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
}
