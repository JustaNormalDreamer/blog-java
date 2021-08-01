/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.events;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Introspected
public class EventRequest {
    @NotBlank
    @Min(value = 2)
    @Max(value = 25)
    private String name;

    @NotBlank
    private LocalDate eventDate;

    private String frequency;

    @NotBlank
    private LocalDate tillDate;

    public EventRequest(String name, LocalDate eventDate, String frequency, LocalDate tillDate) {
        this.name = name;
        this.eventDate = eventDate;
        this.frequency = frequency;
        this.tillDate = tillDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDate getTillDate() {
        return tillDate;
    }

    public void setTillDate(LocalDate tillDate) {
        this.tillDate = tillDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
