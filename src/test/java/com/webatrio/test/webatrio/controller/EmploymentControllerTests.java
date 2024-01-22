package com.webatrio.test.webatrio.controller;

import com.webatrio.test.webatrio.model.Employment;
import com.webatrio.test.webatrio.service.EmploymentService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmploymentControllerTests {

    @Mock
    private EmploymentService employmentService;

    @InjectMocks
    private EmploymentController employmentController;

    @Test
    public void testGetEmploymentsByPersonIdAndDateRange() {

        Long personId = 1L;
        LocalDate startDate = LocalDate.parse("2022-01-01");
        LocalDate endDate = LocalDate.parse("2022-12-31");

        List<Employment> expectedEmployments = Arrays.asList(
                new Employment("Web-atrio", "Software Engineer", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 6, 30)),
                new Employment("CompanyA", "Senior Developer", LocalDate.of(2022, 7, 1), null)
        );
        when(employmentService.getEmploymentsByPersonIdAndDateRange(personId, startDate, endDate))
                .thenReturn(expectedEmployments);

        List<Employment> actualEmployments = employmentController.getEmploymentsByPersonIdAndDateRange(personId, startDate, endDate);

        assertEquals(expectedEmployments, actualEmployments);

        verify(employmentService, times(1)).getEmploymentsByPersonIdAndDateRange(personId, startDate, endDate);
    }
}