package com.webatrio.test.webatrio.repository;

import com.webatrio.test.webatrio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p FROM Person p JOIN FETCH p.employments e WHERE e.companyName = :companyName")
    List<Person> findPersonsByCompany(@Param("companyName") String companyName);

    List<Person> findAllByOrderByNameAsc();
}