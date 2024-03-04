package com.example.springbootcrudapi.repository;

import com.example.springbootcrudapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    Employee findByNameAndMatricule(String name, int matricule);
}
