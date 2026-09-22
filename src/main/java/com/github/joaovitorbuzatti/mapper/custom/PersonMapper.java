package com.github.joaovitorbuzatti.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.github.joaovitorbuzatti.data.DTO.v2.PersonDTOv2;
import com.github.joaovitorbuzatti.model.Person;
@Service 
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person){

        PersonDTOv2 dto = new PersonDTOv2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        // Se a sua entidade Person tiver o campo birthDate, utilize person.getBirthDate()
        dto.setBirthDate(new Date()); 
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;

    }

    public Person ConvertDTOToEntity(PersonDTOv2 person){

        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;

    }

}
