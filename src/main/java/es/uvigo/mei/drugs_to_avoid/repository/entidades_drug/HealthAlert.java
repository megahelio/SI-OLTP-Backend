package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class HealthAlert implements Serializable {
    @Id
    Long idHealthAlert;
    String alertLink;
    String organization;
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    Drug drug;
}
