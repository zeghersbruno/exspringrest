package be.abis.exercise.service;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiPersonService implements PersonService {

    String apiUrl = "http://localhost:8085/exercise/api";

    @Autowired
    private RestTemplate rt;

    @Override
    public ArrayList<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person findPerson(int id) {
        Person p = rt.getForObject(apiUrl+"/persons/"+id, Person.class);
        return p;
    }

    @Override
    public Person findPerson(String emailAddress, String passWord) {
        Login login = new Login();
        login.setEmail(emailAddress);
        login.setPassword(passWord);
        Person p = rt.postForObject(apiUrl+"/login", login, Person.class);
        return p;
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
