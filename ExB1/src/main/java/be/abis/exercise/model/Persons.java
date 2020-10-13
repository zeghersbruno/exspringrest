package be.abis.exercise.model;

import java.util.ArrayList;

public class Persons {

    private ArrayList<Person> persons;

    public Persons() {
        persons = new ArrayList<>();
    }
    public Persons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
}
