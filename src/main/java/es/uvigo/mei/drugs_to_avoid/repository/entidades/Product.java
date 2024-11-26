package es.uvigo.mei.drugs_to_avoid.repository.entidades;

import jakarta.persistence.*;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_name", referencedColumnName = "name")
    Manufacturer manufacturer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PRODUCT_DRUG",
            joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "gtin"),
            inverseJoinColumns = @JoinColumn(name = "DRUG_ID", referencedColumnName = "id"))
    List<Drug> drugList;
}
