package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Absence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AbsenceRepositoryTest {

    @Mock
    private JpaRepository<Absence, Integer> jpaRepository; // Simule le dépôt JPA sous-jacent

    @InjectMocks
    private AbsenceRepository absenceRepository; // Injecte le dépôt JPA simulé dans AbsenceRepository

    @Test
    public void testFindById() {
        // Crée un objet Absence d'exemple
        Absence absence = new Absence();
        absence.setId(1);
        absence.setMatriculeE(123); // En supposant que 'matricule' remplace 'employeeId'
        absence.setDateDebut("07-04-2022");
        // ...autres champs

        // Simule le comportement de jpaRepository.findById()
        when(jpaRepository.findById(1)).thenReturn(Optional.of(absence));

        // Appelle la méthode à tester
        Optional<Absence> absenceTrouvee = absenceRepository.findById(1);

        // Vérifie les résultats
        assertTrue(absenceTrouvee.isPresent());
        assertEquals(absence, absenceTrouvee.get());
    }

    // Ajoute des tests pour d'autres méthodes de AbsenceRepository en suivant une structure similaire
}
