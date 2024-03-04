package com.example.springbootcrudapi.repository;


import com.example.springbootcrudapi.model.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Integer> {
}
