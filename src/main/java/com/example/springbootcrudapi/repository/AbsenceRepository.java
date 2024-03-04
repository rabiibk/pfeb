package com.example.springbootcrudapi.repository;


import com.example.springbootcrudapi.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
}
