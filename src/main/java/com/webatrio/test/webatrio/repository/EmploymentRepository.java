package com.webatrio.test.webatrio.repository;

import com.webatrio.test.webatrio.model.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment, Long> {

    @Query("SELECT e FROM Employment e WHERE e.person.id = :personId AND e.endDate IS NULL")
    List<Employment> findCurrentEmploymentsByPersonId(@Param("personId") Long personId);

    @Query("SELECT e FROM Employment e " +
            "WHERE e.person.id = :personId " +
            "AND ((e.startDate BETWEEN :startDate AND :endDate) " +
            "OR (e.startDate <= :startDate AND e.endDate IS NULL))")
    List<Employment> findEmploymentsByPersonIdAndDateRange(
            @Param("personId") Long personId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}