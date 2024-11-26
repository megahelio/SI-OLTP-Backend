package es.uvigo.mei.drugs_to_avoid.repository.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(unique = true)
    String activePrinciple;
    String atc;
    String reasonToAvoid;
    String alternative;
    Boolean isPrimaryCare;

}
