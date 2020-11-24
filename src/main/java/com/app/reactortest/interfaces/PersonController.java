package com.app.reactortest.interfaces;

import com.app.reactortest.domain.dto.PersonDTO;
import com.app.reactortest.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/** @author Jhon Baron */
@RestController
@RequestMapping("/person")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Slf4j
public class PersonController {
  private static volatile int numberOfRequest;

  private final PersonService personService;
  private final Object synchronizedObject = new Object();

  @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<PersonDTO> listPerson() {
    synchronized (synchronizedObject) {
      log.info(
          "[PersonController Request] ::: #{} :::  [PersonController Request]", numberOfRequest++);
    }
    return personService.listPerson();
  }

  @PostMapping(
      value = "/",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<PersonDTO> savePerson(@RequestBody PersonDTO personDTO) {
    return personService.savePerson(personDTO);
  }
}
