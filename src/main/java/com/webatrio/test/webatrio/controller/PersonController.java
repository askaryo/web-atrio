package com.webatrio.test.webatrio.controller;

import com.webatrio.test.webatrio.model.Employment;
import com.webatrio.test.webatrio.model.Person;
import com.webatrio.test.webatrio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        // Endpoint to add a person
        return personService.savePerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        // Endpoint to get all persons
        return personService.getAllPersons();
    }

    @GetMapping("/company/{companyName}")
    public List<Person> getPersonsByCompany(@PathVariable String companyName) {
        // Endpoint to get all people working for a given company
        return personService.getPersonsByCompany(companyName);
    }
}