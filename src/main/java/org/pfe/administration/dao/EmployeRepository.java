package org.pfe.administration.dao;
import org.pfe.administration.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    Employe findByNom(String nom);
    @Query("select a from Employe a where a.nom like %:nom% or a.prenom like %:prenom%")
    List<Employe> findByNomOrPrenom(String nom, String prenom);
}
