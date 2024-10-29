package es.uvigo.mei.drugs_to_avoid.controller;

import es.uvigo.mei.drugs_to_avoid.controller.error_response.ErrorResponse;
import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.PrescrirePublicationDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.PrescrirePublication;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.embedables.Atc;
import es.uvigo.mei.drugs_to_avoid.service.PrescrirePublicationService;
import org.apache.coyote.BadRequestException;
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
    PrescrirePublicationDao prescrirePublicationDao;
    @Autowired
    PrescrirePublicationService prescrirePublicationService;

    @GetMapping()
    public ResponseEntity<List<PrescrirePublication>> findAll() {
        return ResponseEntity.ok(prescrirePublicationDao.findAll());
    }

    @GetMapping("/{year}")
    public ResponseEntity<PrescrirePublication> findById(@PathVariable Integer year) {
        Optional<PrescrirePublication> prescrirePublication = prescrirePublicationDao.findById(year);
        if (prescrirePublication.isPresent()) {
            return ResponseEntity.ok(prescrirePublication.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PrescrirePublication> create(@RequestBody PrescrirePublication prescrirePublication) {
        PrescrirePublication savedPrescrirePublication = prescrirePublicationDao.save(prescrirePublication);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrescrirePublication);
    }

    @PutMapping("/{year}")
    public ResponseEntity<PrescrirePublication> update(@PathVariable Integer year, @RequestBody PrescrirePublication prescrirePublicationDetails) {
        Optional<PrescrirePublication> existingPrescrirePublication = prescrirePublicationDao.findById(year);
        if (existingPrescrirePublication.isPresent()) {
            prescrirePublicationDetails.setYear(year);
            PrescrirePublication updatedPrescrirePublication = prescrirePublicationDao.save(prescrirePublicationDetails);
            return ResponseEntity.ok(updatedPrescrirePublication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{year}")
    public ResponseEntity<Void> delete(@PathVariable Integer year) {
        Optional<PrescrirePublication> prescrirePublication = prescrirePublicationDao.findById(year);
        if (prescrirePublication.isPresent()) {
            prescrirePublicationDao.delete(prescrirePublication.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{year}")
    public ResponseEntity<?> removeDrug(
            @PathVariable Integer year,
            @RequestParam(name = "drug_id", required = true) Long drug_id,
            @RequestParam(name = "action", required = true) String action) {

        PrescrirePublication publicationSaved;
        switch (action) {
            case "removeDrug":
                publicationSaved = prescrirePublicationService.removeDrug(year, drug_id);
                return ResponseEntity.ok(publicationSaved);
            case "addDrug":
                publicationSaved = prescrirePublicationService.addDrug(year, drug_id);
                return ResponseEntity.ok(publicationSaved);
            default:
                // Si la acción no es válida, lanzar una excepción o devolver un error
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorResponse("Las acciones disponibles son 'addDrug' y 'removeDrug'")); //

        }
    }
}