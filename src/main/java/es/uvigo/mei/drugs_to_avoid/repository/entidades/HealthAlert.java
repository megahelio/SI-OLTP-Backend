package es.uvigo.mei.drugs_to_avoid.repository.entidades;

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
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="drug_id", nullable=false)
    Drug drug;
}
