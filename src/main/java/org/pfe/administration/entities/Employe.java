package org.pfe.administration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String nom,prenom,matricule,poste;


    @JoinColumn(name = "equipe_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Equipe equipe;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Absence> absences;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conge> conges;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sanction> sanctions;
}



