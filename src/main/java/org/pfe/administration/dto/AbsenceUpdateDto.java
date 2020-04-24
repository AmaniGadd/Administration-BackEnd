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
public class AbsenceUpdateDto {

	private Long id;
	private Date dateAbs;
	private String dureeAbs,certif,pieceJointe,commentaire;
	private EmployeDtoForOneEntity employe;


}
