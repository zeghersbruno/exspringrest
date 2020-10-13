package be.abis.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
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
	private String urlApi = "http://localhost:8085/exercise/api";

	@Test
	public void contextLoads() {
	}

	@Test
	public void findPersonByIdTest() {
		int id = 2;
		Person p = rt.getForObject(urlApi+"/persons/"+id, Person.class);
		assertNotNull(p);
		assertEquals("Mary", p.getFirstName());
	}

	@Test
	public void findPersonByEmailAndPassword() {
		Login login = new Login();
		login.setEmail("mjones@abis.be");
		login.setPassword("abc123");
		Person p = rt.postForObject(urlApi+"/login", login, Person.class);
		assertNotNull(p);
		assertEquals("Mary", p.getFirstName());
	}

	@Test
	public void findAllPersonsTest() {
		//TODO
	}
}
