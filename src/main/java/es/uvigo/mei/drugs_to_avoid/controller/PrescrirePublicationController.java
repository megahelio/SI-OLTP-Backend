package es.uvigo.mei.drugs_to_avoid.controller;

import es.uvigo.mei.drugs_to_avoid.repository.daos.PublicationDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "prescrire-publications", produces = "application/json")
public class PrescrirePublicationController {

    @Autowired
    PublicationDao publicationDao;

    @GetMapping()
    public ResponseEntity<List<Publication>> findAll() {
        return ResponseEntity.ok(publicationDao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> findById(@PathVariable Long id) {
        Optional<Publication> prescrirePublication = publicationDao.findById(id);
        if (prescrirePublication.isPresent()) {
            return ResponseEntity.ok(prescrirePublication.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(params = "year")
    public ResponseEntity<List<Publication>> findByName(@RequestParam(name = "year", required = true) Integer year) {
        return ResponseEntity.ok(publicationDao.findByYear(year));
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Publication> create(@RequestBody Publication publication) {

        Publication savedPublication = publicationDao.save(publication);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPublication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publication> update(@PathVariable Long id, @RequestBody Publication publicationDetails) {
        Optional<Publication> existingPrescrirePublication = publicationDao.findById(id);
        if (existingPrescrirePublication.isPresent()) {
            Publication updatedPublication = publicationDao.save(publicationDetails);
            return ResponseEntity.ok(updatedPublication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Publication> prescrirePublication = publicationDao.findById(id);
        if (prescrirePublication.isPresent()) {
            publicationDao.delete(prescrirePublication.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}