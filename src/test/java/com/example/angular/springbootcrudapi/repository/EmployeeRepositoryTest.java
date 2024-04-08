package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave() {
        // Given
        Employee employeeToSave = new Employee(/* Sample data */);
        Employee savedEmployee = new Employee(/* Sample data */);

        // Mock the behavior of the repository
        when(employeeRepository.save(employeeToSave)).thenReturn(savedEmployee);

        // When
        Employee result = employeeRepository.save(employeeToSave);

        // Then
        assertEquals(savedEmployee, result);
    }

    @Test
    public void testFindById() {
        // Given
        Employee foundEmployee = new Employee(/* Sample data */);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(foundEmployee));

        // When
        Optional<Employee> result = employeeRepository.findById(1);

        // Then
        assertTrue(result.isPresent());
        assertEquals(foundEmployee, result.get());
    }

    @Test
    public void testFindAll() {
        // Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(/* Sample data */));
        employees.add(new Employee(/* Sample data */));
        when(employeeRepository.findAll()).thenReturn(employees);

        // When
        List<Employee> result = employeeRepository.findAll();

        // Then
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteById() {
        // Given
        int idToDelete = 1;

        // When
        employeeRepository.deleteById(idToDelete);

        // Then
        verify(employeeRepository, times(1)).deleteById(idToDelete);
    }

    @Test
    public void testFindByNameAndMatricule() {
        // Given
        String name = "John Doe";
        int matricule = 12345;
        Employee foundEmployee = new Employee(/* Sample data */);
        when(employeeRepository.findByNameAndMatricule(name, matricule)).thenReturn(foundEmployee);

        // When
        Employee result = employeeRepository.findByNameAndMatricule(name, matricule);

        // Then
        assertEquals(foundEmployee, result);
    }

    // Add more test methods as needed for other CRUD operations
}
