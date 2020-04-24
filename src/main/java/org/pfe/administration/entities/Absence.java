package org.pfe.administration.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Absence implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateAbs,dateRetour;
    @Column(length = 75)
    private String dureeAbs,certif,pieceJointe,commentaire;

    @JoinColumn(name = "employe_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Employe employe;

}
