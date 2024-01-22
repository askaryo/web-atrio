package com.webatrio.test.webatrio.service;

import com.webatrio.test.webatrio.model.Employment;
import com.webatrio.test.webatrio.model.Person;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmploymentService {
    Employment addEmployment(Long personId, Employment employment);
    public String getAllPersonsOrderedSituations();
    List<Employment> getEmploymentsByPersonIdAndDateRange(Long personId, LocalDate startDate, LocalDate endDate);
}
