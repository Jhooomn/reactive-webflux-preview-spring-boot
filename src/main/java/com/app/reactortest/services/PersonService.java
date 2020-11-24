package com.app.reactortest.services;

import com.app.reactortest.domain.dto.PersonDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
  Flux<PersonDTO> listPerson();

  Mono<PersonDTO> savePerson(PersonDTO personDTO);
}
