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
public class SanctionUpdateDto {

	private Long id;
	private String cause,typeSanction,ajoutePar;
	private Date dateSanction;
	private EmployeDtoForOneEntity employe;

}
