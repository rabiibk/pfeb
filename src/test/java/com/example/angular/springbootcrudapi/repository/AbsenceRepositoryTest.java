package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Absence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AbsenceRepositoryTest {

    @Autowired
    private AbsenceRepository absenceRepository;

    @MockBean
    private JpaRepository<Absence, Integer> jpaRepository;

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

    // Ajoutez d'autres tests pour les autres méthodes de AbsenceRepository si nécessaire
}
