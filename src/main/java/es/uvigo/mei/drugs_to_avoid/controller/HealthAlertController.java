package es.uvigo.mei.drugs_to_avoid.controller;

import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.HealthAlertDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.HealthAlert;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="health-alerts", produces = "application/json")
public class HealthAlertController {

    @Autowired
    HealthAlertDao healthAlertDao;

    @GetMapping
    public ResponseEntity<List<HealthAlert>> findAll(){
        return  ResponseEntity.ok(healthAlertDao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthAlert> findById(@PathVariable Long id) {
        Optional<HealthAlert> healthAlert = healthAlertDao.findById(id);
        if (healthAlert.isPresent()) {
            return ResponseEntity.ok(healthAlert.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(params = "organization")
    public ResponseEntity<List<HealthAlert>> findByName(@RequestParam(name = "organization", required = true) String organization) {
        return ResponseEntity.ok(healthAlertDao.findByOrganizationContaining(organization));
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<HealthAlert> create(@RequestBody HealthAlert healthAlert) {
        HealthAlert savedHealthAlert = healthAlertDao.save(healthAlert);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHealthAlert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthAlert> update(@PathVariable Long id, @RequestBody HealthAlert healthAlertDetails) {
        Optional<HealthAlert> existingHealthAlert = healthAlertDao.findById(id);
        if (existingHealthAlert.isPresent()) {
            HealthAlert updatedHealthAlert = healthAlertDao.save(healthAlertDetails);
            return ResponseEntity.ok(updatedHealthAlert);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<HealthAlert> healthAlert = healthAlertDao.findById(id);
        if (healthAlert.isPresent()) {
            healthAlertDao.delete(healthAlert.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}