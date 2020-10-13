package be.abis.exercise.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.abis.exercise.exception.EnrollException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;

@Service
public class AbisTrainingService implements TrainingService {
    
	@Autowired
	private CourseService courseService;

	@Autowired
	private PersonService personService;
	
	@Override
	public CourseService getCourseService() {
		return courseService;
	}


	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

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

	@Override
	public List<Course> showFollowedCourses(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException {
		// TODO Auto-generated method stub

	}






}
