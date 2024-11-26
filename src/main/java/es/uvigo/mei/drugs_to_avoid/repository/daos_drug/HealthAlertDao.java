package es.uvigo.mei.drugs_to_avoid.repository.daos_drug;

import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.HealthAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthAlertDao extends JpaRepository<HealthAlert, Long> {
    List<HealthAlert> findByOrganizationContaining(String organization);
}
