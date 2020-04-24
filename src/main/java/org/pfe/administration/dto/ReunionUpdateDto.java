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
public class ReunionUpdateDto {

	private Long id;
	private String objet,salle;
	private Date dateDebut,dateFin;


}
