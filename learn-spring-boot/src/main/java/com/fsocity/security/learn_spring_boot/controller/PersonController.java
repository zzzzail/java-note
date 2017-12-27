package com.fsocity.security.learn_spring_boot.controller;

import com.fsocity.security.learn_spring_boot.entity.Person;
import com.fsocity.security.learn_spring_boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zail
 * @version 0.0.1
 */
@RestController
@RequestMapping("/cache/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {

        personRepository.savePerson(person);

        return person;
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable String id) {
        System.out.println(id);
        Person person = personRepository.findPerson(id);
        return person;
    }

}
