package es.uvigo.mei.drugs_to_avoid.controller;

import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.DrugDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Drug;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.HealthAlert;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.embedables.Atc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/drugs",produces = MediaType.APPLICATION_JSON_VALUE)
public class DrugController {

    @Autowired
    DrugDao drugDao;

    @GetMapping()
    public ResponseEntity<List<Drug>> findAll() {
        return ResponseEntity.ok(drugDao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drug> findById(@PathVariable Long id) {
        Optional<Drug> drug = drugDao.findById(id);
        if (drug.isPresent()) {
            return ResponseEntity.ok(drug.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Drug> create(@RequestBody Drug drug) {
        // Asignar el Drug a cada HealthAlert para establecer la relación bidireccional
        if (drug.getHealthAlertList() != null) {
            for (HealthAlert alert : drug.getHealthAlertList()) {
                alert.setDrug(drug); // Establecer el drug en cada HealthAlert
            }
        }

        Drug savedDrug = drugDao.save(drug);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDrug);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Drug> update(@PathVariable Long id, @RequestBody Drug drugDetails) {
        Optional<Drug> existingDrug = drugDao.findById(id);
        if (existingDrug.isPresent()) {
            drugDetails.setId(existingDrug.get().getId());
            Drug updatedDrug = drugDao.save(drugDetails);
            return ResponseEntity.ok(updatedDrug);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Drug> drug = drugDao.findById(id);
        if (drug.isPresent()) {
            drugDao.delete(drug.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}