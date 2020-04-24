package org.pfe.administration.dto;



import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@Data
public class EquipeUpdateDto {

	private Long id;
	private String nomEquipe,chefEquipe,departement;

}
