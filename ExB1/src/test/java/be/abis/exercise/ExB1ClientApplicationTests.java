package be.abis.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.AbisTrainingService;
import be.abis.exercise.service.ApiPersonService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExB1ClientApplicationTests {

	@Autowired
	private RestTemplate rt;

	@Autowired
	ApiPersonService apiPersonService;

	@Autowired
	AbisTrainingService abisTrainingService;

	private String apiUrl = "http://localhost:8085/exercise/api";

	@Test
	public void contextLoads() {
	}

	/**
	 * Tests via Url
	 *
	 */
	@Test
	public void findPersonByIdTest() {
		int id = 2;
		Person p = rt.getForObject(apiUrl+"/persons/"+id, Person.class);
		assertNotNull(p);
		assertEquals("Mary", p.getFirstName());
	}

	@Test
	public void findPersonByEmailAndPassword() {
		Login login = new Login();
		login.setEmail("mjones@abis.be");
		login.setPassword("abc123");
		Person p = rt.postForObject(apiUrl+"/login", login, Person.class);
		assertNotNull(p);
		assertEquals("Mary", p.getFirstName());
	}

	/**
	 * Tests via ApiPersonService
	 *
	 */
	@Test
	public void finPersonByIdViaApiPersonServiceTest() {
		int id = 2;
		Person p = apiPersonService.findPerson(id);
		assertNotNull(p);
		assertEquals("Mary", p.getFirstName());
	}

	@Test
	public void getAllPersonsViaApiPersonService() {
		ArrayList<Person> persons = apiPersonService.getAllPersons();
		assertNotNull(persons);
	}


	@Test
	public void changePasswordViaApiTest() throws IOException {
		int id = 2;
		Person p = apiPersonService.findPerson(id);
		assertNotNull(p);
		System.out.println("current password " + p.getPassword());
		apiPersonService.changePassword(p, "xyz789");
		Person pAfter = apiPersonService.findPerson(2);
		assertNotNull(pAfter);
		assertEquals("xyz789", pAfter.getPassword());
	}

	@Test
	public void changePasswordViaAbisTrainingTest() throws IOException {
		int id = 2;
		Person p = abisTrainingService.findPerson(id);
		assertNotNull(p);
		System.out.println("current password " + p.getPassword());
		abisTrainingService.changePassword(p, "abc123");
		Person pAfter = apiPersonService.findPerson(2);
		assertNotNull(pAfter);
		assertEquals("abc123", pAfter.getPassword());
	}
}
