/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.person;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Optional;

@Controller("/persons")
public class PersonController {

    @Inject
    private PersonService personService;

    @Get
    public Iterable<Person> index() {
        return personService.fetchPersons();
    }

    @Get("{id}")
    public Optional<Person> show(@PathVariable("id") Long id) {
        return personService.fetchPerson(id);
    }

    @Post
    public Person store(@Body @Valid Person person) {
        return personService.storePerson(person);
    }

    @Put("{id}")
    public Person update(@PathVariable("id") Long id, @Body @Valid Person person) {
        return personService.updatePerson(person);
    }

    @Delete("{id}")
    public HttpResponse<?> destroy(@PathVariable("id") Long id) {
        return personService.deletePerson(id);
    }
}
