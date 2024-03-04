package com.example.springbootcrudapi.repository;


import com.example.springbootcrudapi.model.CongeMaladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeMaladieRepository extends JpaRepository<CongeMaladie,Integer> {
}
