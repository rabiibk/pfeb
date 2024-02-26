package com.example.angular.springbootcrudapi.repository;


import com.example.angular.springbootcrudapi.model.CongeMaladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeMaladieRepository extends JpaRepository<CongeMaladie,Integer> {
}
