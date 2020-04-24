package org.pfe.administration.dao;
import org.pfe.administration.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface CongeRepository extends JpaRepository<Conge,Long> {
    Conge findByCause(String cause);
    @Query("select a from Conge a where a.cause like %:cause% or a.reponse like %:reponse%")
    List<Conge> findByCauseOrReponse(String cause, String reponse);
}
