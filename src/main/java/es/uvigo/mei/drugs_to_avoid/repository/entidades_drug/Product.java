package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToMany(mappedBy = "productList", fetch = FetchType.EAGER)
    @JsonIgnore
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    List<Drug> drugList;
}
