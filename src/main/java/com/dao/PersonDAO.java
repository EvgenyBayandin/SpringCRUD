package com.dao;

import java.util.List;
import java.util.ArrayList;
import com.models.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "John", 24, "john@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jane", 27, "jane@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 44, "bob@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jill", 14, "jill@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
