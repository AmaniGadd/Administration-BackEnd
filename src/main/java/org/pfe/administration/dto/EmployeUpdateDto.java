package org.pfe.administration.dto;



import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Data
public class EmployeUpdateDto {

	private Long id;
	private String nom,prenom,matricule,poste;
	private EquipeDtoForOneEntity equipe;


}
