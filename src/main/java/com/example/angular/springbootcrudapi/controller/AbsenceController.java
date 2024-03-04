package com.example.angular.springbootcrudapi.controller;

import com.example.angular.springbootcrudapi.ResourceNotFoundException;
import com.example.angular.springbootcrudapi.model.Absence;
import com.example.angular.springbootcrudapi.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AbsenceController {



    @Autowired
    private AbsenceRepository absenceRepository;

    @PostMapping("/absences")
    public Absence addAbsence(@RequestBody Absence absence) {
        return absenceRepository.save(absence);
    }


    @GetMapping("/absences")
    public ResponseEntity<List<Absence>> getAllAbsences() {

        return ResponseEntity.ok(absenceRepository.findAll());
    }

    @GetMapping("/absences/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable(value = "id") Integer absenceId)
            throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Absence not found for this id :: " + absenceId));
        return ResponseEntity.ok().body(absence);
    }

    @PutMapping("/absences/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable(value = "id") Integer absenceId,
                                                   @RequestBody Absence absenceDetails) throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + absenceId));

        absence.setDateDebut(absenceDetails.getDateDebut());
        absence.setDateFin(absenceDetails.getDateFin());
        absence.setMotif(absenceDetails.getMotif());
        absence.setNameE(absenceDetails.getNameE());
        absence.setMatriculeE(absenceDetails.getMatriculeE());


        final Absence updatedAbsence = absenceRepository.save(absence);
        return ResponseEntity.ok(updatedAbsence);
    }

    @DeleteMapping("/absences/{id}")
    public Map<String, Boolean> deleteAbsence(@PathVariable(value = "id") Integer absenceId)
            throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + absenceId));

        absenceRepository.delete(absence);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
