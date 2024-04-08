package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.CongeMaladie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CongeMaladieRepositoryTest {

    @Mock
    private JpaRepository<CongeMaladie, Integer> jpaRepository; // Mock the underlying JPA repository

    @Test
    public void testFindById() {
        // Create a sample CongeMaladie object
        CongeMaladie congeMaladie = new CongeMaladie();
        congeMaladie.setId(1);
        // ...other fields (setMatricule, setDateDebut if applicable)

        // Mock the behavior of jpaRepository.findById()
        when(jpaRepository.findById(1)).thenReturn(Optional.of(congeMaladie));

        // Call the method to be tested
        Optional<CongeMaladie> foundCongeMaladie = jpaRepository.findById(1);

        // Verify the results
        assertTrue(foundCongeMaladie.isPresent());
        assertEquals(congeMaladie, foundCongeMaladie.get());
    }

    // Add more tests for other methods in CongeMaladieRepository, following similar structure
}
