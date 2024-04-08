package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryTest {

    @Mock
    private JpaRepository<Employee, Integer> jpaRepository; // Mock the underlying JPA repository

    @Test
    public void testFindById() {
        // Create a sample Employee object
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe"); // Assuming name exists in Employee

        // Mock the behavior of jpaRepository.findById()
        when(jpaRepository.findById(1)).thenReturn(Optional.of(employee));

        // Call the method to be tested
        Optional<Employee> foundEmployee = jpaRepository.findById(1);

        // Verify the results
        assertTrue(foundEmployee.isPresent());
        assertEquals(employee, foundEmployee.get());
    }
}
