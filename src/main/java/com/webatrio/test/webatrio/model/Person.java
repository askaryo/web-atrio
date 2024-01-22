package com.webatrio.test.webatrio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    @Transient private Integer age;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employment> employments;

    public Person() {
    }

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(Long id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(Long id, String name, LocalDate dateOfBirth, Integer age, List<Employment> employments) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.employments = employments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(List<Employment> employments) {
        this.employments = employments;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", employments=" + employments +
                '}';
    }
}
