package com.app.reactortest.interfaces;

import com.app.reactortest.domain.dto.PersonDTO;
import com.app.reactortest.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/** @author Jhon Baron */
@RestController
@RequestMapping("/person")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class PersonController {

  private final PersonService personService;

  @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<PersonDTO> listPerson() {
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
