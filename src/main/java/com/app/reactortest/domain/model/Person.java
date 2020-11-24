package com.app.reactortest.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
/** @author Jhon Baron */
@Builder
@Data
@Document
public class Person implements Serializable {
  @Id private String id;
  private String name;
  private int age;
}
