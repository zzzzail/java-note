package com.fsocity.security.springboot.repository;

import com.fsocity.security.springboot.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zail
 * @version 0.0.1
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

  private final Map<String, Person> repository = new HashMap<>();

  @Override
  public Person findPerson(String id) {
    return repository.get(id);
  }

  @Override
  public boolean savePerson(Person person) {
    return repository.put(person.getId(), person) == null;
  }

}
