package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Absence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AbsenceRepositoryTest {

    @Mock
    private JpaRepository<Absence, Integer> jpaRepository; // Mock le dépôt JPA sous-jacent

    @InjectMocks
    private AbsenceRepository absenceRepository; // Injecte le dépôt JPA simulé dans AbsenceRepository

    @Test
    public void testFindById() {
        // Crée un objet Absence d'exemple
        Absence absence = new Absence();
        absence.setId(1);
        absence.setMatriculeE(123); // En supposant que 'matricule' remplace 'employeeId'
        absence.setDateDebut(new Date());

        // Simule le comportement de jpaRepository.findById()
        when(jpaRepository.findById(1)).thenReturn(Optional.of(absence));

        // Appelle la méthode à tester
        Optional<Absence> absenceTrouvee = absenceRepository.findById(1);

        // Vérifie les résultats
        assertTrue(absenceTrouvee.isPresent());
        assertEquals(absence, absenceTrouvee.get());
    }

    @Test
    public void testSave() {
        // Crée un objet Absence d'exemple à sauvegarder
        Absence absence = new Absence();
        absence.setId(1);
        absence.setMatriculeE(123);
        absence.setDateDebut(new Date());

        // Simule le comportement de jpaRepository.save()
        when(jpaRepository.save(absence)).thenReturn(absence);

        // Appelle la méthode à tester
        Absence savedAbsence = absenceRepository.save(absence);

        // Vérifie les résultats
        assertNotNull(savedAbsence);
        assertEquals(absence, savedAbsence);
    }

    @Test
    public void testFindAll() {
        // Crée une liste d'objets Absence d'exemple
        List<Absence> absences = new ArrayList<>();
        Absence absence1 = new Absence();
        absence1.setId(1);
        absence1.setMatriculeE(123);
        absence1.setDateDebut(new Date());

        Absence absence2 = new Absence();
        absence2.setId(2);
        absence2.setMatriculeE(456);
        absence2.setDateDebut(new Date());

        absences.add(absence1);
        absences.add(absence2);

        // Simule le comportement de jpaRepository.findAll()
        when(jpaRepository.findAll()).thenReturn(absences);

        // Appelle la méthode à tester
        List<Absence> foundAbsences = absenceRepository.findAll();

        // Vérifie les résultats
        assertNotNull(foundAbsences);
        assertEquals(absences.size(), foundAbsences.size());
        assertTrue(foundAbsences.contains(absence1));
        assertTrue(foundAbsences.contains(absence2));
    }

    // Ajoutez d'autres tests pour d'autres méthodes de AbsenceRepository si nécessaire
}
