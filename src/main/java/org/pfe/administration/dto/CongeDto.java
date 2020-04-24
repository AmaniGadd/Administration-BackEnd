package org.pfe.administration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CongeDto {
    private Long id;
    private String cause,reponse,causeRefus,typeConge,pieceJointe,dureeConge;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut,dateFin;
    private EmployeDtoForOneEntity employe;

}
