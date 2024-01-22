package com.webatrio.test.webatrio.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String job;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Employment() {}

    public Employment(String companyName, String job, LocalDate startDate, LocalDate endDate) {
        this.companyName = companyName;
        this.job = job;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Employment(Long id, String companyName, String job, LocalDate startDate) {
        this.id = id;
        this.companyName = companyName;
        this.job = job;
        this.startDate = startDate;
    }

    public Employment(Long id, String companyName, String job, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.companyName = companyName;
        this.job = job;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}