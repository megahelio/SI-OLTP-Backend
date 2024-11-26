package es.uvigo.mei.drugs_to_avoid.repository.daos_drug;

import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugDao extends JpaRepository<Drug, Long> {
    List<Drug> findByActivePrincipleContaining(String patron);
    List<Drug> findByAtcContaining(String patron);
    List<Drug> findByIsPrimaryCare(Boolean isPrimaryCare);
}
