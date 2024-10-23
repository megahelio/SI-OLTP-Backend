package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class HealthAlert implements Serializable {
    @Id
    Long idHealthAlert;
    String alertLink;
    String organization;
    Drug drug;
}
