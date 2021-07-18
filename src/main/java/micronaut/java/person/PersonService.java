/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.person;

import io.micronaut.http.HttpResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class PersonService {
    @Inject
    private PersonRepository personRepository;

    public Iterable<Person> fetchPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> fetchPerson(Long id) {
        return personRepository.findById(id);
    }

    public Person storePerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.update(person);
    }

    public HttpResponse<?> deletePerson(Long id) {
        personRepository.deleteById(id);
        return HttpResponse.ok();
    }
}
