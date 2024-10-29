package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.embedables.Atc;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Drug implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    @Column(unique = true)
    Atc atc;
    String reasonToAvoid;
    String alternative;
    Boolean isPrimaryCare;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
    List<HealthAlert> healthAlertList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "DRUG_PRODUCT",
            joinColumns = @JoinColumn(name = "DRUG_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "gtin"))
    List<Product> productList;
}
