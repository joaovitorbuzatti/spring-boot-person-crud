package com.github.joaovitorbuzatti.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.joaovitorbuzatti.model.Person;
import com.github.joaovitorbuzatti.service.PersonService;



@RequestMapping("/person")
@RestController
public class PersonControllers {

    @Autowired
    private PersonService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable("id") String id) {
        return service.findById(id);
    }

}
