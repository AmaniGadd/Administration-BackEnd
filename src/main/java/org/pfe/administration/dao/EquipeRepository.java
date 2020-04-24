package org.pfe.administration.dao;
import org.pfe.administration.entities.Employe;
import org.pfe.administration.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    List<Equipe> getById(Long id);

    Equipe findByNomEquipe(String nomEquipe);
    @Query("select a from Equipe a where a.nomEquipe like %:nomEquipe% or a.chefEquipe like %:chefEquipe%")
    List<Equipe> findByNomEquipeOrChefEquipe(String nomEquipe, String chefEquipe);
}
