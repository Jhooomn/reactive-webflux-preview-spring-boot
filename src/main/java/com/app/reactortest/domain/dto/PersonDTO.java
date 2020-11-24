package com.app.reactortest.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
/** @author Jhon Baron */
@Builder
@Data
public class PersonDTO implements Serializable {
  private String id;
  private String name;
  private int age;
}
