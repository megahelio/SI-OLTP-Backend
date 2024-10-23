package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Product implements Serializable {
    @Id
    Long gtin;

    @Column(unique = true)
    String name;

    Integer units;
    Integer mgs;

    Manufacturer manufacturer;

    @ManyToMany(mappedBy = "productList")
    List<Drug> drugList;

}
