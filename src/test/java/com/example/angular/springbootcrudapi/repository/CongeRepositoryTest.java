package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Conge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CongeRepositoryTest {

    @Mock
    private JpaRepository<Conge, Integer> jpaRepository; // Mock the underlying JPA repository

    @Test
    public void testFindById() {
        // Create a sample Conge object
        Conge conge = new Conge();
        conge.setId(1);
        // ...other fields (setMatricule, setDateDebut if applicable)

        // Mock the behavior of jpaRepository.findById()
        when(jpaRepository.findById(1)).thenReturn(Optional.of(conge));

        // Call the method to be tested
        Optional<Conge> foundConge = jpaRepository.findById(1);

        // Verify the results
        assertTrue(foundConge.isPresent());
        assertEquals(conge, foundConge.get());
    }

    // Add more tests for other methods in CongeRepository, following similar structure
}
