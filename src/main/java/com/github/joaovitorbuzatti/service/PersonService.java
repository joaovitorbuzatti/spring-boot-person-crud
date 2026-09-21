package com.github.joaovitorbuzatti.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.joaovitorbuzatti.data.DTO.PersonDTO;
import com.github.joaovitorbuzatti.exception.ResourceNotFoundException;
import static com.github.joaovitorbuzatti.mapper.ObjectMapper.parseListObject;
import static com.github.joaovitorbuzatti.mapper.ObjectMapper.parseObject;
import static com.github.joaovitorbuzatti.mapper.ObjectMapper.parseListObject;
import com.github.joaovitorbuzatti.model.Person;
import com.github.joaovitorbuzatti.repository.PersonRepository;

@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired 
    PersonRepository repository;

    public List<PersonDTO> findAll(){
        logger.info("Finding all person!");

        return parseListObject(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));
        return parseObject(entity, PersonDTO.class);         
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one person!");

        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person){
        logger.info("updating one person!");
        Person entity = repository.findById(person.getId())
              .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());      
        
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);

    }
}
