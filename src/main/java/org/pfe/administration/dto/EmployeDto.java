package org.pfe.administration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeDto {
    private Long id;
    private String nom,prenom,matricule,poste;

    @NotNull

    private EquipeDtoForOneEntity equipe;
}
