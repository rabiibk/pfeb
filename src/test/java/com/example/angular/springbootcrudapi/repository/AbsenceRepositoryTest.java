package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Absence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AbsenceRepositoryTest {

    @Mock
    private AbsenceRepository absenceRepository;

    @Test
    public void testSave() {
        // Given
        Absence absenceToSave = new Absence(/* Sample data */);
        Absence savedAbsence = new Absence(/* Sample data */);

        // Mock the behavior of the repository
        when(absenceRepository.save(absenceToSave)).thenReturn(savedAbsence);

        // When
        Absence result = absenceRepository.save(absenceToSave);

        // Then
        assertEquals(savedAbsence, result);
    }

    @Test
    public void testFindById() {
        // Given
        Absence foundAbsence = new Absence(/* Sample data */);
        when(absenceRepository.findById(1)).thenReturn(Optional.of(foundAbsence));

        // When
        Optional<Absence> result = absenceRepository.findById(1);

        // Then
        assertTrue(result.isPresent());
        assertEquals(foundAbsence, result.get());
    }

    @Test
    public void testFindAll() {
        // Given
        List<Absence> absences = new ArrayList<>();
        absences.add(new Absence(/* Sample data */));
        absences.add(new Absence(/* Sample data */));
        when(absenceRepository.findAll()).thenReturn(absences);

        // When
        List<Absence> result = absenceRepository.findAll();

        // Then
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteById() {
        // Given
        int idToDelete = 1;

        // When
        absenceRepository.deleteById(idToDelete);

        // Then
        verify(absenceRepository, times(1)).deleteById(idToDelete);
    }

    // Add more test methods as needed for other CRUD operations
}
