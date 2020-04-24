package org.pfe.administration.dao;
import org.pfe.administration.entities.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ReunionRepository extends JpaRepository<Reunion,Long> {
    Reunion findByObjet(String objet);
    @Query("select a from Reunion a where a.objet like %:objet% or a.salle like %:salle%")
    List<Reunion> findByObjetOrSalle(String objet, String salle);
}
