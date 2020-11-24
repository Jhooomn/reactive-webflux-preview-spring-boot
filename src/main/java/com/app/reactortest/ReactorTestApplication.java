package com.app.reactortest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/** @author Jhon Baron */
@SpringBootApplication
@Slf4j
public class ReactorTestApplication {

  public static void main(String... args) {
    log.info("[ReactorTestApplication] ::: has started!!! ::: [ReactorTestApplication]");
    SpringApplication.run(ReactorTestApplication.class, args);
  }

}
