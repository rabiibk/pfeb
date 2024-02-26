package com.example.angular.springbootcrudapi.repository;


import com.example.angular.springbootcrudapi.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
}
