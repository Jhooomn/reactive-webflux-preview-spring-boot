package com.app.reactortest.infrastructure.repositories;

import com.app.reactortest.domain.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/** @author Jhon Baron */
@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {}
