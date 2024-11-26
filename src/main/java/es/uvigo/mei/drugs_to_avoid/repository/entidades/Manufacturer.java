package es.uvigo.mei.drugs_to_avoid.repository.entidades;

import es.uvigo.mei.drugs_to_avoid.repository.entidades.embedables.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

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
