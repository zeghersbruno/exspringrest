package be.abis.exercise.controller;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    Person loggedInPerson;

    @Autowired
    PersonService personService;

    @GetMapping("persons/{id}")
    Person findPersonById(@PathVariable("id") int personId) {
        return personService.findPerson(personId);
    }

    @GetMapping("persons")
    ArrayList<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("persons/{email}/{password}")
    public Person findPersonByEmailAndPassword(@PathVariable("email") String emailAddress, @PathVariable("password") String password) {
        return personService.findPerson(emailAddress, password);
    }

    @PostMapping("/")
    public Person login(Model model, @RequestBody Login login) {
        return personService.findPerson(login.getEmail(),login.getPassword());
    }

    @PostMapping("addperson")
    public void addPerson(@RequestBody Person person) {
        try {
            personService.addPerson(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("deleteperson/{id}")
    public void deletePerson(@PathVariable("id") int personId) {
        try {
            personService.deletePerson(personId);
        } catch (PersonCanNotBeDeletedException e) {
            e.printStackTrace();
        }
    }

    @PutMapping("persons/{id}/changepassword/{np}")
    public void changePassword(@PathVariable("id") int personId, @PathVariable("np") String newPassword) {
        try {
            personService.changePassword(personService.findPerson(personId), newPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
