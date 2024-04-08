package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Conge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CongeRepositoryTest {

    @Mock
    private CongeRepository congeRepository;

    @Test
    public void testSave() {
        // Given
        Conge congeToSave = new Conge();
        congeToSave.setDateDebut(new Date(2024 - 1900, 3, 1)); // 1st April 2024
        congeToSave.setDateFin(new Date(2024 - 1900, 3, 5));   // 5th April 2024
        congeToSave.setNbrJours(5);
        congeToSave.setMatriculeC(12345);
        congeToSave.setNameC("John Doe");

        Conge savedConge = new Conge();
        savedConge.setId(1); // Assuming the saved conge gets an ID

        // Mock the behavior of the repository
        when(congeRepository.save(congeToSave)).thenReturn(savedConge);

        // When
        Conge result = congeRepository.save(congeToSave);

        // Then
        assertEquals(savedConge, result);
    }

    @Test
    public void testFindById() {
        // Given
        Conge foundConge = new Conge();
        foundConge.setId(1); // Assuming the conge with ID 1 exists
        when(congeRepository.findById(1)).thenReturn(Optional.of(foundConge));

        // When
        Optional<Conge> result = congeRepository.findById(1);

        // Then
        assertTrue(result.isPresent());
        assertEquals(foundConge, result.get());
    }

    @Test
    public void testFindAll() {
        // Given
        List<Conge> conges = new ArrayList<>();
        conges.add(new Conge(/* Sample data */));
        conges.add(new Conge(/* Sample data */));
        when(congeRepository.findAll()).thenReturn(conges);

        // When
        List<Conge> result = congeRepository.findAll();

        // Then
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteById() {
        // Given
        int idToDelete = 1;

        // When
        congeRepository.deleteById(idToDelete);

        // Then
        verify(congeRepository, times(1)).deleteById(idToDelete);
    }

    // Add more test methods as needed for other CRUD operations
}
