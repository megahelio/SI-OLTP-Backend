package es.uvigo.mei.drugs_to_avoid.repository.entidades.embedables;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class Address implements Serializable {
    int number;
    int floor;
    String letra;
    String road;
    String city;
    String country;
    String region;
}
