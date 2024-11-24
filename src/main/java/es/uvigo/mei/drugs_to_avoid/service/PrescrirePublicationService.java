package es.uvigo.mei.drugs_to_avoid.service;

import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.DrugDao;
import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.PublicationDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Drug;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescrirePublicationService {
    @Autowired
    PublicationDao publicationDao;
    @Autowired
    DrugDao drugDao;

    /**
     * Elimina un medicamento de una publicación
     * @param publicationID
     * @param drugId
     * @return
     */
    public Publication removeDrug(Long publicationID, Long drugId) {
        // Encontrar la publicación por el año (ID)
        Publication publication = publicationDao.findById(publicationID)
                .orElseThrow(() -> new IllegalArgumentException("Publicación no encontrada con el ID: " + publicationID));

        // Encontrar el medicamento por su ID
        Drug drug = drugDao.findById(drugId)
                .orElseThrow(() -> new IllegalArgumentException("Medicamento no encontrado con el ID: " + drugId));

        // Remover el medicamento de la lista si está presente
        if (publication.getDrugList().contains(drug)) {
            publication.getDrugList().remove(drug);
        } else {
            throw new IllegalArgumentException("El medicamento no está asociado a la publicación.");
        }

        // Guardar los cambios en la publicación
        return publicationDao.save(publication);
    }

    /**
     * Añade un medicamento a una publicación
     * @param publicationID
     * @param drugId
     * @return
     */
    public Publication addDrug(Long publicationID, Long drugId) {
        // Encontrar la publicación por el año (ID)
        Publication publication = publicationDao.findById(publicationID)
                .orElseThrow(() -> new IllegalArgumentException("Publicación no encontrada con el ID: " + publicationID));

        // Encontrar el medicamento por su ID
        Drug drug = drugDao.findById(drugId)
                .orElseThrow(() -> new IllegalArgumentException("Medicamento no encontrado con el ID: " + drugId));

        // Agregar el medicamento a la lista de la publicación si no está ya presente
        if (!publication.getDrugList().contains(drug)) {
            publication.getDrugList().add(drug);
        } else {
            throw new IllegalArgumentException("El medicamento ya está asociado a la publicación.");
        }

        // Guardar los cambios en la publicación
        return publicationDao.save(publication);
    }
}
