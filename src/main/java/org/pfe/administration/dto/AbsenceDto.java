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
public class AbsenceDto {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateAbs;
    private String dureeAbs,certif,pieceJointe,commentaire;
    private EmployeDtoForOneEntity employe;
}
