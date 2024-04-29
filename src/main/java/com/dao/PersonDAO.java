package com.dao;

import java.util.List;
import java.util.ArrayList;
import com.models.Person;


public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(1, "John"));
        people.add(new Person(2, "Jane"));
        people.add(new Person(3, "Bob"));
        people.add(new Person(4, "Jill"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }
}
