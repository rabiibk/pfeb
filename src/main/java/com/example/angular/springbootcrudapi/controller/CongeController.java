package com.example.angular.springbootcrudapi.controller;


import com.example.angular.springbootcrudapi.ResourceNotFoundException;
import com.example.angular.springbootcrudapi.model.Conge;
import com.example.angular.springbootcrudapi.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CongeController {


    @Autowired
    private CongeRepository congeRepository;

    @PostMapping("/conges")
    public Conge addConge(@RequestBody Conge conge) {
        return congeRepository.save(conge);
    }


    @GetMapping("/conges")
    public ResponseEntity<List<Conge>> getAllConges() {

        return ResponseEntity.ok(congeRepository.findAll());
    }

    @GetMapping("/conges/{id}")
    public ResponseEntity<Conge> getCongeById(@PathVariable(value = "id") Integer congeId)
            throws ResourceNotFoundException {
        Conge conge = congeRepository.findById(congeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Congé not found for this id :: " + congeId));
        return ResponseEntity.ok().body(conge);
    }

    @PutMapping("/conges/{id}")
    public ResponseEntity<Conge> updateConge(@PathVariable(value = "id") Integer congeId,
                                                 @RequestBody Conge congeDetails) throws ResourceNotFoundException {
        Conge conge = congeRepository.findById(congeId)
                .orElseThrow(() -> new ResourceNotFoundException("Congé not found for this id :: " + congeId));

        conge.setDateDebut(congeDetails.getDateDebut());
        conge.setDateFin(congeDetails.getDateFin());

        conge.setNameC(congeDetails.getNameC());
        conge.setMatriculeC(congeDetails.getMatriculeC());

        conge.setNbrJours(congeDetails.getNbrJours());
        conge.setEtat(congeDetails.getEtat());


        final Conge updatedConge = congeRepository.save(conge);
        return ResponseEntity.ok(updatedConge);
    }

    @DeleteMapping("/conges/{id}")
    public Map<String, Boolean> deleteConge(@PathVariable(value = "id") Integer congeId)
            throws ResourceNotFoundException {
        Conge conge= congeRepository.findById(congeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + congeId));

        congeRepository.delete(conge);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
