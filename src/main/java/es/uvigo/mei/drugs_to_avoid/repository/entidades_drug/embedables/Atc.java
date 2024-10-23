package es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.embedables;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class Atc implements Serializable {

    String grupoAnatomicoPrincipal;
    String subgrupoTerapeutico;
    String subgrupoFarmacologico;
    String subgrupoQuimico;
    String principioActivo;

    String grupoAnatomicoPrincipalDescripcion;
    String subgrupoTerapeuticoDescripcion;
    String subgrupoFarmacologicoDescripcion;
    String subgrupoQuimicoDescripcion;
    String principioActivoDescripcion;

}
