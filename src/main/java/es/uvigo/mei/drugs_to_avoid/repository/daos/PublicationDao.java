package es.uvigo.mei.drugs_to_avoid.repository.daos;

import es.uvigo.mei.drugs_to_avoid.repository.entidades.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationDao extends JpaRepository<Publication, Long> {
    List<Publication> findByYear(Integer year);
}
