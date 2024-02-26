package com.example.angular.springbootcrudapi.controller;


import com.example.angular.springbootcrudapi.ResourceNotFoundException;
import com.example.angular.springbootcrudapi.model.Conge;
import com.example.angular.springbootcrudapi.model.CongeMaladie;
import com.example.angular.springbootcrudapi.repository.CongeMaladieRepository;
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
public class CongeMaladieController {


    @Autowired
    private CongeMaladieRepository congeMaladieRepository;

    @PostMapping("/congesmaladies")
    public CongeMaladie addCongeMaladie(@RequestBody CongeMaladie congeMaladie) {
        return congeMaladieRepository.save(congeMaladie);
    }


    @GetMapping("/congesmaladies")
    public ResponseEntity<List<CongeMaladie>> getAllCongesMaladies() {

        return ResponseEntity.ok(congeMaladieRepository.findAll());
    }

    @GetMapping("/congesmaladies/{id}")
    public ResponseEntity<CongeMaladie> getCongeById(@PathVariable(value = "id") Integer congeMaladieId)
            throws ResourceNotFoundException {
        CongeMaladie congeMaladie = congeMaladieRepository.findById(congeMaladieId)
                .orElseThrow(() -> new ResourceNotFoundException("Congé not found for this id :: " + congeMaladieId));
        return ResponseEntity.ok().body(congeMaladie);
    }

    @PutMapping("/congesmaladies/{id}")
    public ResponseEntity<CongeMaladie> updateCongeMaladie(@PathVariable(value = "id") Integer congeMaladieId ,
                                             @RequestBody CongeMaladie congeMaladieDetails) throws ResourceNotFoundException {
        CongeMaladie congeMaladie = congeMaladieRepository.findById(congeMaladieId)
                .orElseThrow(() -> new ResourceNotFoundException("Congé not found for this id :: " + congeMaladieId));

        congeMaladie.setDateDebut(congeMaladieDetails.getDateDebut());
        congeMaladie.setDateFin(congeMaladieDetails.getDateFin());
        congeMaladie.setNbrjours(congeMaladieDetails.getNbrjours());
        congeMaladie.setMotif(congeMaladieDetails.getMotif());

        congeMaladie.setMatriculeM(congeMaladieDetails.getMatriculeM());
        congeMaladie.setNameM(congeMaladieDetails.getNameM());


        final CongeMaladie updatedCongeMaladie = congeMaladieRepository.save(congeMaladie);
        return ResponseEntity.ok(updatedCongeMaladie);
    }

    @DeleteMapping("/congesmaladies/{id}")
    public Map<String, Boolean> deleteConge(@PathVariable(value = "id") Integer congeMaladieId)
            throws ResourceNotFoundException {
        CongeMaladie congeMaladie= congeMaladieRepository.findById(congeMaladieId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + congeMaladieId));

        congeMaladieRepository.delete(congeMaladie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
