package com.github.joaovitorbuzatti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.github.joaovitorbuzatti.model.Person;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all person!");
        List<Person> persons = new ArrayList<Person>();

        for(int i = 0; i < 8; i++){

            Person person = mockPerson(i);
            persons.add(person);

        }

        return persons;
    }

    public Person findById(String id){

        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Joao vitor");
        person.setLastName("buzatti");
        person.setAddress("São jose do rio preto - SP - Brasil");
        person.setGender("Male");

        return person;

    }

    public Person create(Person person){
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person){
        logger.info("updating one person!");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one person!");
    }

    private Person mockPerson(int i) {
        
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("firstName" + i);
        person.setLastName("lastname" + i);
        person.setAddress("some address in brasil" + i);
        person.setGender("Male");

        return person;

    }

}
