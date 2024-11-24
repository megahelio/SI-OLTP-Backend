package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer year;

    @Column(unique = true)
    String publicationLink;

    @ManyToMany
    @JoinTable(
            name = "PUBLICATION_DRUG",
            joinColumns = @JoinColumn(name = "PUBLICATION_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "DRUG_ID", referencedColumnName = "id"))
    List<Drug> drugList;
}
