package com.webatrio.test.webatrio.controller;

import com.webatrio.test.webatrio.model.Employment;
import com.webatrio.test.webatrio.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employments")
public class EmploymentController {

    @Autowired
    private EmploymentService employmentService;

    @PostMapping("/{personId}")
    public Employment addEmployment(@PathVariable Long personId, @RequestBody Employment employment) {
        // Endpoint pour ajouter un emploi à une personne
        return employmentService.addEmployment(personId, employment);
    }

    @GetMapping("/byPersonAndDateRange")
    public List<Employment> getEmploymentsByPersonIdAndDateRange(
            @RequestParam("personId") Long personId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return employmentService.getEmploymentsByPersonIdAndDateRange(personId, startDate, endDate);
    }

    @GetMapping("/orderedSituations")
    public String getAllPersonsOrderedSituations(){
        return employmentService.getAllPersonsOrderedSituations();
    }
}