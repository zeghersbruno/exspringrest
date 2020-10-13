package be.abis.exercise.service;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Person;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ApiPersonService implements PersonService {

    String apiUrl = "http://localhost:8085/exercise/api";

    @Override
    public ArrayList<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person findPerson(int id) {
        return null;
    }

    @Override
    public Person findPerson(String emailAddress, String passWord) {
        return null;
    }

    @Override
    public void addPerson(Person p) throws IOException {

    }

    @Override
    public void deletePerson(int id) throws PersonCanNotBeDeletedException {

    }

    @Override
    public void changePassword(Person p, String newPswd) throws IOException {

    }
}
