/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.events;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.QueryValue;

@Introspected
public class EntityBean extends PageBean {
    @Nullable
    @QueryValue(value = "name")
    private String name;

    @Nullable
    @QueryValue(value = "eventDate")
    private String eventDate;

    @QueryValue(value = "createdAt", defaultValue = "desc")
    private String createdAt;

    @Nullable
    @QueryValue(value = "updatedAt")
    private String updatedAt;

    public EntityBean(int page, int size, @Nullable String name, @Nullable String eventDate, String createdAt, String updatedAt) {
        super(page, size);
        this.name = name;
        this.eventDate = eventDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Nullable
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(@Nullable String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(@Nullable String eventDate) {
        this.eventDate = eventDate;
    }
}
