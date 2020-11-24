package com.app.reactortest.services.impl;

import com.app.reactortest.application.assembler.AssemblerPerson;
import com.app.reactortest.domain.dto.PersonDTO;
import com.app.reactortest.domain.model.Person;
import com.app.reactortest.infrastructure.repositories.PersonRepository;
import com.app.reactortest.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
/** @author Jhon Baron */
@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class DefaultPersonService implements PersonService {

  private final PersonRepository personRepository;

  @Override
  public Flux<PersonDTO> listPerson() {
    Flux<Person> personFlux = personRepository.findAll();
    return personFlux
        .map(AssemblerPerson::toDto)
        .delayElements(Duration.ofMillis(150))
        .limitRequest(10);
  }

  public void importData() {
    List<String> alist = new ArrayList<>();
    alist.add("Steve");
    alist.add("Tim");
    alist.add("Lucy");
    alist.add("Pat");
    alist.add("Angela");
    alist.add("Tom");
    Random random = new Random();
    for (String element : alist) {
      Mono<Person> personMono =
          personRepository.save(Person.builder().age(random.nextInt()).name(element).build());
      personMono.subscribe();
    }
  }

  @Override
  public Mono<PersonDTO> savePerson(PersonDTO personDTO) {
    if (!Objects.isNull(personDTO)) {
      final Mono<Person> personMono =
          personRepository.save(Objects.requireNonNull(AssemblerPerson.toEntity(personDTO)));
      return personMono.map(AssemblerPerson::toDto);
    }
    return null;
  }
}
