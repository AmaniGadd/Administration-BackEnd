package org.pfe.administration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.pfe.administration.entities.Equipe;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddEmployeDto {
    private Long id;
    private String nom,prenom,matricule,poste;

    private EquipeDtoForOneEntity equipe;
    private Long eqId;

}
