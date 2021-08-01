/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.events;

import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.transaction.annotation.ReadOnly;
import micronaut.java.helpers.JsonResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Singleton
public class EventService {

    @Inject
    private EventRepository eventRepository;

    @ReadOnly
    public HttpResponse<?> fetchModels(EntityBean entityBean) {
        List<Sort.Order> sort = new ArrayList<>();
        if(entityBean.getName() != null) {
            sort.add(entityBean.getName().equals("asc") ? Sort.Order.asc("name") : Sort.Order.desc("name"));
        }

        if(entityBean.getEventDate() != null) {
            sort.add(entityBean.getEventDate().equals("asc") ? Sort.Order.asc("event_date") : Sort.Order.desc("event_date"));
        }

        if(entityBean.getUpdatedAt() != null) {
            sort.add(entityBean.getUpdatedAt().equals("asc") ? Sort.Order.asc("updatedAt") : Sort.Order.desc("updatedAt"));
        }

        sort.add(entityBean.getCreatedAt().equals("asc") ? Sort.Order.asc("createdAt") : Sort.Order.desc("createdAt"));


        JsonResponse<Event> res = new JsonResponse<>(
                "EL-200",
                "Events has been fetched.",
                "Events has been fetched.",
                eventRepository.findAll(Pageable.from(entityBean.getPage(), entityBean.getSize(), Sort.of(sort)))
        );
        return HttpResponse.status(HttpStatus.OK).body(res.response());
    }

    @ReadOnly
    public HttpResponse<?> fetchModel(UUID id) {
        Optional<Event> event = eventRepository.findById(id);

        if(event.isPresent()) {
            JsonResponse<Optional<Event>> res = new JsonResponse<>("E-200", "Event has been fetched.", "Event has been fetched.", event);
            return HttpResponse.status(HttpStatus.OK).body(res.response());
        }

        String message = String.format("Event of id: %s not found.", id);
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(new JsonResponse<>("E-404", message, message));

    }

    @Transactional
    public HttpResponse<?> storeModel(EventRequest eventRequest) {
        LocalDate date = eventRequest.getEventDate();

        int days;
        switch(eventRequest.getFrequency()) {
            case "daily":
                days = 1;
               break;

            case "weekly":
                days = 7;
                break;

            case "monthly":
                days = 30;
                break;

            case "yearly":
                days = 365;
                break;

            default:
                days = 0;
        }

        List<Event> events = new ArrayList<>();

        while(eventRequest.getTillDate().isAfter(date)) {
            events.add(new Event(eventRequest.getName(), date));
            date = date.plusDays(days);
        }

        eventRepository.saveAll(events);

        JsonResponse<Event> res = new JsonResponse<>("E-201", "Event has been created.", "Event has been created.");
        return HttpResponse.status(HttpStatus.CREATED).body(res.response());
    }

    public HttpResponse<?> updateModel(Event model) {
        return null;
    }

    public HttpResponse<?> deleteModel(UUID id) {
        return null;
    }
}
