package com.webatrio.test.webatrio.service.impl;

import com.webatrio.test.webatrio.model.Employment;
import com.webatrio.test.webatrio.model.Person;
import com.webatrio.test.webatrio.repository.PersonRepository;
import com.webatrio.test.webatrio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        if(person.getAge()>=150){
            throw new IllegalArgumentException("We cannot register people older than 150 years old");
        }
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> getPersonsByCompany(String companyName) {
        return personRepository.findPersonsByCompany(companyName);
    }
}
