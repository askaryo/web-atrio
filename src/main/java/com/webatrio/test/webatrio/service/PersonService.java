package com.webatrio.test.webatrio.service;

import com.webatrio.test.webatrio.model.Employment;
import com.webatrio.test.webatrio.model.Person;

import java.util.Date;
import java.util.List;

public interface PersonService {
    Person savePerson(Person person);
    List<Person> getAllPersons();
    List<Person> getPersonsByCompany(String companyName);

}