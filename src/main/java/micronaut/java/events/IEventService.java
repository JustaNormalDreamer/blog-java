/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.events;

import io.micronaut.http.HttpResponse;
import micronaut.java.IService;

import java.util.UUID;

public interface IEventService extends IService<Event, UUID> {

}
