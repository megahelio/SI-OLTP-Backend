package es.uvigo.mei.drugs_to_avoid.repository.daos;

import es.uvigo.mei.drugs_to_avoid.repository.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
