package com.webatrio.test.webatrio.service.impl;


import com.webatrio.test.webatrio.model.Employment;
import com.webatrio.test.webatrio.model.Person;
import com.webatrio.test.webatrio.repository.EmploymentRepository;
import com.webatrio.test.webatrio.repository.PersonRepository;
import com.webatrio.test.webatrio.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class EmploymentServiceImpl implements EmploymentService {

    @Autowired
    private EmploymentRepository employmentRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Employment addEmployment(Long personId, Employment employment) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));

        employment.setPerson(person);
        return employmentRepository.save(employment);
    }

    @Override
    public List<Employment> getEmploymentsByPersonIdAndDateRange(Long personId, LocalDate startDate, LocalDate endDate) {
        return employmentRepository.findEmploymentsByPersonIdAndDateRange(personId, startDate, endDate);
    }

    @Override
    public String getAllPersonsOrderedSituations() {
        List<Person> persons = personRepository.findAllByOrderByNameAsc();
        String situation = "";
        for(Iterator<Person> i = persons.iterator(); i.hasNext();) {
            situation += this.getAgeAndCurrentEmploymentByPerson(i.next());
        }
        return situation;
    }

    private String getAgeAndCurrentEmploymentByPerson(Person person) {
        // Get current jobs
        List<Employment> employments = employmentRepository.findCurrentEmploymentsByPersonId(person.getId());
        String situation =  person.getName()  + " has " + person.getAge() + " years old.";

        if(employments.isEmpty()){
            situation += " He actually don't work \n";
        }
        else {
            for(Iterator<Employment> i = employments.iterator(); i.hasNext();) {
                Employment employment = i.next();
                if(LocalDate.now().isAfter(employment.getStartDate()) && employment.getEndDate() == null){
                    situation += " He actually work as " + employment.getJob() + " at " + employment.getCompanyName() + "\n";
                }
            }
        }
        return situation;
    }
}
