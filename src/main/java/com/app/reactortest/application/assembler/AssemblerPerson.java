package com.app.reactortest.application.assembler;

import com.app.reactortest.domain.dto.PersonDTO;
import com.app.reactortest.domain.model.Person;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@NoArgsConstructor
public class AssemblerPerson {

  public static PersonDTO toDto(final Person person) {
    if (!Objects.isNull(person)) {
      PersonDTO personDTO = PersonDTO.builder().build();
      BeanUtils.copyProperties(person, personDTO);
      return personDTO;
    }
    return null;
  }

  public static Person toEntity(final PersonDTO personDTO) {
    if (!Objects.isNull(personDTO)) {
      Person person = Person.builder().build();
      BeanUtils.copyProperties(personDTO, person);
      return person;
    }
    return null;
  }
}
