package com.acme.homehealthy.Meeting.domain.repository;

import com.acme.homehealthy.Meeting.domain.model.Rutine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RutineRepository extends JpaRepository<Rutine,Long> {
    Page<Rutine> findRutineByCustomerId(Long customerId, Pageable pageable);
    Page<Rutine> findRutineByCollaboratorId(Long collaboratorId, Pageable pageable);

    @Query("SELECT r FROM Rutine r WHERE r.name = ?1")
    Optional<Rutine>findRutineByname(String name);

    @Query("SELECT r FROM Rutine r WHERE r.level = ?1")
    Optional<Rutine>findRutineByLevel(String level);
    //Optional<Rutine>findDietBySession_Id(Long id);

    Optional<Rutine> findById(Long routineId);
}