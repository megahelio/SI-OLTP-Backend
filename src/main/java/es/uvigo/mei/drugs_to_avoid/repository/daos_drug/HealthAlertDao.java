package es.uvigo.mei.drugs_to_avoid.repository.daos_drug;

import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Drug;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.HealthAlert;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.embedables.Atc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthAlertDao extends JpaRepository<HealthAlert, Long> {
}
