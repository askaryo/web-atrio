package com.webatrio.test.webatrio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.webatrio.test.webatrio.model.Person;
import com.webatrio.test.webatrio.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTests {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @Test
    public void testSavePerson() {
        Person personToSave = new Person("John Doe", LocalDate.of(1990, 5, 15));
        Person savedPerson = new Person("John Depp", LocalDate.of(1993, 2, 1));

        when(personService.savePerson(personToSave)).thenReturn(savedPerson);

        Person actualSavedPerson = personController.savePerson(personToSave);

        assertEquals(savedPerson, actualSavedPerson);

        verify(personService, times(1)).savePerson(personToSave);
    }

    @Test
    public void testGetAllPersons() {
        List<Person> expectedPersons = Arrays.asList(
                new Person("John Doe", LocalDate.of(1990, 5, 15)),
                new Person("John Depp", LocalDate.of(1993, 2, 1))
        );
        when(personService.getAllPersons()).thenReturn(expectedPersons);

        List<Person> actualPersons = personController.getAllPersons();

        assertEquals(expectedPersons, actualPersons);

        verify(personService, times(1)).getAllPersons();
    }

    @Test
    public void testGetPersonsByCompany() {
        String companyName = "CompanyXYZ";

        List<Person> expectedPersons = Arrays.asList(
                new Person("John Doe", LocalDate.of(1990, 5, 15)),
                new Person("John Depp", LocalDate.of(1993, 2, 1))
        );
        when(personService.getPersonsByCompany(companyName)).thenReturn(expectedPersons);

        List<Person> actualPersons = personController.getPersonsByCompany(companyName);

        assertEquals(expectedPersons, actualPersons);

        verify(personService, times(1)).getPersonsByCompany(companyName);
    }
}
