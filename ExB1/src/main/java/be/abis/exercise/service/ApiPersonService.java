package be.abis.exercise.service;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.model.Persons;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiPersonService implements PersonService {

    String apiUrl = "http://localhost:8085/exercise/api";

    @Autowired
    private RestTemplate rt;

    @Override
    public Person findPerson(int id) {
        return rt.getForObject(apiUrl+"/persons/"+id, Person.class);
    }

    @Override
    public Person findPerson(String emailAddress, String passWord) {
        Login login = new Login();
        login.setEmail(emailAddress);
        login.setPassword(passWord);
        return rt.postForObject(apiUrl+"/login", login, Person.class);
    }

    @Override
    public ArrayList<Person> getAllPersons() {
        ResponseEntity<ArrayList<Person>> persons = rt.exchange(apiUrl + "/persons", HttpMethod.GET, null,
            new ParameterizedTypeReference<ArrayList<Person>>() {});
        ArrayList<Person> listPerson = new ArrayList<>();
        int i = 0;
        for (Person p:persons.getBody()) {
            listPerson.add(i, p);
            i++;
        }
        return listPerson;
    }

    @Override
    public void addPerson(Person p) throws IOException {
        rt.postForObject(apiUrl+"/persons", p, Void.class);
    }

    @Override
    public void deletePerson(int id) throws PersonCanNotBeDeletedException {
        rt.delete(apiUrl+"/persons/"+id, Void.class);
    }

    @Override
    public void changePassword(Person p, String newPswd) throws IOException {
        p.setPassword(newPswd);
        rt.put(apiUrl+"/persons/"+p.getPersonId(), p, Void.class);
    }
}
