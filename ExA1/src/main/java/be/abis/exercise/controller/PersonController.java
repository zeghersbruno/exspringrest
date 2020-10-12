package be.abis.exercise.controller;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import java.security.PublicKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("person/{id}")
    Person findPersonById(@PathVariable("id") int personId) {
        return personService.findPerson(personId);
    }

}
