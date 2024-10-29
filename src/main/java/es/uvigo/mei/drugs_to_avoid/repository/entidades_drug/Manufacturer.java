package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.embedables.Address;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Manufacturer implements Serializable {
    @Id
    String name;

    @Column(unique = true)
    String cif;

    @Embedded
    Address address;


}
