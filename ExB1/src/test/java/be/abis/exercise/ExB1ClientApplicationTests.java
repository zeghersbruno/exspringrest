package be.abis.exercise;

import static org.junit.Assert.assertEquals;

import be.abis.exercise.model.Person;
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
		assertEquals("Mary", p.getFirstName());
	}
}
