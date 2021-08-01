/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.events;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.QueryValue;

@Introspected
public class PageBean {
    @QueryValue(value = "page", defaultValue = "1")
    private int page;

    @QueryValue(value = "size", defaultValue = "10")
    private int size;

    public PageBean(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
