package org.pfe.administration.dto;



import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Data
public class CongeUpdateDto {

	private Long id;
	private String cause,reponse,causeRefus,typeConge,pieceJointe,dureeConge;
	private Date dateDebut,dateFin;
	private EmployeDtoForOneEntity employe;

}
