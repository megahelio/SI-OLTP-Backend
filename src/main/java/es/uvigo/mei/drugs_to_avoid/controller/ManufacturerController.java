package es.uvigo.mei.drugs_to_avoid.controller;

import es.uvigo.mei.drugs_to_avoid.controller.error_response.ErrorResponse;
import es.uvigo.mei.drugs_to_avoid.repository.daos.ManufacturerDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "manufacturers", produces = "application/json")
public class ManufacturerController {

    @Autowired
    ManufacturerDao manufacturerDao;

    @GetMapping
    public ResponseEntity<List<Manufacturer>> findAll() {
        return ResponseEntity.ok(manufacturerDao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable String id) {
        Optional<Manufacturer> manufacturer = manufacturerDao.findById(id);
        if (manufacturer.isPresent()) {
            return ResponseEntity.ok(manufacturer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "cif")
    public ResponseEntity<Manufacturer> findByCIF(@RequestParam(required = true) String cif) {
        return manufacturerDao.findByCif(cif)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping(params = "name")
    public ResponseEntity<List<Manufacturer>> findByName(@RequestParam(required = true) String name) {
        return ResponseEntity.ok(manufacturerDao.findByNameContaining(name));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody Manufacturer manufacturer) {
        if (manufacturerDao.findByCif(manufacturer.getCif()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("CIF ya existe"));
        }
        if (manufacturerDao.findById(manufacturer.getName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Nombre ya existe"));
        }
        Manufacturer savedManufacturer = manufacturerDao.save(manufacturer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedManufacturer);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> update(@PathVariable String id, @RequestBody Manufacturer manufacturerDetails) {
        Optional<Manufacturer> existingManufacturer = manufacturerDao.findById(id);
        if (existingManufacturer.isPresent()) {
            manufacturerDetails.setCif(existingManufacturer.get().getCif());
            Manufacturer updatedManufacturer = manufacturerDao.save(manufacturerDetails);
            return ResponseEntity.ok(updatedManufacturer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Optional<Manufacturer> manufacturer = manufacturerDao.findById(id);
        if (manufacturer.isPresent()) {
            manufacturerDao.delete(manufacturer.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}