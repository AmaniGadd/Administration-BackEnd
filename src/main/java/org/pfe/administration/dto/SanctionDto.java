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
public class SanctionDto {
    private Long id;
    private String cause,typeSanction,ajoutePar;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateSanction;
    private EmployeDtoForOneEntity employe;

}
