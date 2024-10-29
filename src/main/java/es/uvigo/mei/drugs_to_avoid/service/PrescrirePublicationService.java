package es.uvigo.mei.drugs_to_avoid.service;

import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.DrugDao;
import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.PrescrirePublicationDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Drug;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.PrescrirePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PrescrirePublicationService {
    @Autowired
    PrescrirePublicationDao prescrirePublicationDao;
    @Autowired
    DrugDao drugDao;

    /**
     * Elimina un medicamento de una publicación
     * @param publicationID
     * @param drugId
     * @return
     */
    public PrescrirePublication removeDrug(Integer publicationID, Long drugId) {
        // Encontrar la publicación por el año (ID)
        PrescrirePublication publication = prescrirePublicationDao.findById(publicationID)
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
        return prescrirePublicationDao.save(publication);
    }

    /**
     * Añade un medicamento a una publicación
     * @param publicationID
     * @param drugId
     * @return
     */
    public PrescrirePublication addDrug(Integer publicationID, Long drugId) {
        // Encontrar la publicación por el año (ID)
        PrescrirePublication publication = prescrirePublicationDao.findById(publicationID)
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
        return prescrirePublicationDao.save(publication);
    }
}
