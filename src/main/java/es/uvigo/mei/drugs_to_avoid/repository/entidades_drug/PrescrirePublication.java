package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class PrescrirePublication implements Serializable {
    @Id
    Integer year;

    String publicationLink;

    @ManyToMany
    @JoinTable(
            name = "PUBLICATION_DRUG",
            joinColumns = @JoinColumn(name = "PUBLICATION_ID", referencedColumnName = "year"),
            inverseJoinColumns = @JoinColumn(name = "DRUG_ID", referencedColumnName = "id"))
    List<Drug> drugList;
}
