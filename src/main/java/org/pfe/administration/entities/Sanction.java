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
public class Sanction implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String cause,typeSanction,ajoutePar;
    private Date dateSanction;

    @JoinColumn(name = "employe_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Employe employe;

}
