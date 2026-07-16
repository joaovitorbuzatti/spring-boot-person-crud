package com.github.joaovitorbuzatti.service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.github.joaovitorbuzatti.model.Person;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

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

}
