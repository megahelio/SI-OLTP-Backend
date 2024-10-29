package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manufacturer_name", referencedColumnName = "name")
    Manufacturer manufacturer;

    @ManyToMany(mappedBy = "productList")
    @JsonIgnore
    List<Drug> drugList;
}
