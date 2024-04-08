package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.CongeMaladie;
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
public class CongeMaladieRepositoryTest {

    @Mock
    private CongeMaladieRepository congeMaladieRepository;

    @Test
    public void testSave() {
        // Given
        CongeMaladie congeMaladieToSave = new CongeMaladie();
        congeMaladieToSave.setDateDebut(new Date(2024 - 1900, 3, 1)); // 1st April 2024
        congeMaladieToSave.setDateFin(new Date(2024 - 1900, 3, 5));   // 5th April 2024
        congeMaladieToSave.setMotif("Sickness");
        congeMaladieToSave.setNbrjours(5);
        congeMaladieToSave.setMatriculeM(12345);
        congeMaladieToSave.setNameM("John Doe");

        CongeMaladie savedCongeMaladie = new CongeMaladie();

        // Mock the behavior of the repository
        when(congeMaladieRepository.save(congeMaladieToSave)).thenReturn(savedCongeMaladie);

        // When
        CongeMaladie result = congeMaladieRepository.save(congeMaladieToSave);

        // Then
        assertEquals(savedCongeMaladie, result);
    }

    @Test
    public void testFindById() {
        // Given
        CongeMaladie foundCongeMaladie = new CongeMaladie();
        foundCongeMaladie.setId(1); // Assuming the conge maladie with ID 1 exists
        when(congeMaladieRepository.findById(1)).thenReturn(Optional.of(foundCongeMaladie));

        // When
        Optional<CongeMaladie> result = congeMaladieRepository.findById(1);

        // Then
        assertTrue(result.isPresent());
        assertEquals(foundCongeMaladie, result.get());
    }

    @Test
    public void testFindAll() {
        // Given
        List<CongeMaladie> congesMaladie = new ArrayList<>();
        congesMaladie.add(new CongeMaladie(/* Sample data */));
        congesMaladie.add(new CongeMaladie(/* Sample data */));
        when(congeMaladieRepository.findAll()).thenReturn(congesMaladie);

        // When
        List<CongeMaladie> result = congeMaladieRepository.findAll();

        // Then
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteById() {
        // Given
        int idToDelete = 1;

        // When
        congeMaladieRepository.deleteById(idToDelete);

        // Then
        verify(congeMaladieRepository, times(1)).deleteById(idToDelete);
    }

    // Add more test methods as needed for other CRUD operations
}
