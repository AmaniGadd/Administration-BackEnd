package org.pfe.administration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Conge implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String cause,reponse,causeRefus,typeConge,pieceJointe,dureeConge;
    private Date dateDebut,dateFin;

    @JoinColumn(name = "employe_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Employe employe;
}
