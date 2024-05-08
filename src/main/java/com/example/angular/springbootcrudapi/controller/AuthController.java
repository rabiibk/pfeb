package com.example.angular.springbootcrudapi.controller;

import com.example.angular.springbootcrudapi.model.Employee;
import com.example.angular.springbootcrudapi.model.LoginRequest;
import com.example.angular.springbootcrudapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {


    EmployeeRepository employeeRepository;

    @Autowired
    public AuthController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        // Récupération des informations d'authentification fournies par l'utilisateur
        String name = loginRequest.getName();
        int matricule = loginRequest.getMatricule();

        // Vérification des informations d'authentification (logique simplifiée)
        if (isValidCredentials(name, matricule)) {
            // Authentification réussie
            // Créez un objet Map pour contenir le message de réussite
            Map<String, String> response = new HashMap<>();

             response.put("message", "Authentification réussie pour l'utilisateur : " + name + "," + matricule);
            // Renvoyer une réponse JSON avec l'objet Map
            return ResponseEntity.ok(response);
        } else {
            // Authentification échouée
            // Créez un objet Map pour contenir le message d'erreur
            Map<String, String> response = new HashMap<>();
            response.put("error", "Informations d'authentification invalides");
            // Renvoyer une réponse JSON avec l'objet Map
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    private boolean isValidCredentials(String name, int matricule) {
        // Recherche de l'employé par nom et numéro de téléphone dans la base de données
        Employee employee = employeeRepository.findByNameAndMatricule(name, matricule);

        // Vérification si l'employé a été trouvé
        return employee != null;
    }
}
