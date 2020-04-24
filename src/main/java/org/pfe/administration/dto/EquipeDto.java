package org.pfe.administration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EquipeDto {
    private Long id;
    private String nomEquipe,chefEquipe,departement;
    private List<EmployeDto> employes;
}
