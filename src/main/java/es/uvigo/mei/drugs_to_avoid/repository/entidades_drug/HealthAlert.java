package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class HealthAlert implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idHealthAlert;
    String alertLink;
    String organization;
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    Drug drug;
}
