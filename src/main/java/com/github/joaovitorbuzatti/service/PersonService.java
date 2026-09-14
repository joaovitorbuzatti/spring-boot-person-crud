package com.github.joaovitorbuzatti.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.joaovitorbuzatti.exception.ResourceNotFoundException;
import com.github.joaovitorbuzatti.model.Person;
import com.github.joaovitorbuzatti.repository.PersonRepository;

@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired 
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all person!");
        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one Person!");
        return repository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));
    }

    public Person create(Person person){
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("updating one person!");
        Person entity = repository.findById(person.getId())
              .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());      
        
        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);

    }
}
