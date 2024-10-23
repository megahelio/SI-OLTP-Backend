package es.uvigo.mei.drugs_to_avoid.repository.daos_drug;

import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.PrescrirePublication;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescrirePublicationDao extends JpaRepository<PrescrirePublication, Integer> {
}
