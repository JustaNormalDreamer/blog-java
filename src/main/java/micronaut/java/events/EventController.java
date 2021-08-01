/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.events;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.UUID;

@Controller("events")
@Secured(SecurityRule.IS_ANONYMOUS)
public class EventController {

    @Inject
    private EventService eventService;

//    @Get("{?page,size,name,eventDate}")
//    public HttpResponse<?> index(
//            @QueryValue(value = "page", defaultValue = "1") int page,
//            @QueryValue(value = "size", defaultValue = "10") int size,
//            @Nullable @QueryValue(value = "name") String name,
//            @Nullable @QueryValue(value = "eventDate") String eventDate
//    ) {
//        return eventService.fetchModels(page, size, name, eventDate);
//    }

    @Get("{?page,size,name,eventDate}")
    public HttpResponse<?> index(
        @Valid @RequestBean EntityBean entityBean
    ) {
        return eventService.fetchModels(entityBean);
    }

    @Get("{id}")
    public HttpResponse<?> show(@PathVariable("id") UUID id) {
        return eventService.fetchModel(id);
    }

    @Post
    public HttpResponse<?> store(@Valid @Body EventRequest eventRequest) {
        System.out.println(eventRequest);
        return eventService.storeModel(eventRequest);
    }
}
