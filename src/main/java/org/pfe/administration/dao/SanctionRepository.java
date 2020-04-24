package org.pfe.administration.dao;
import org.pfe.administration.entities.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface SanctionRepository extends JpaRepository<Sanction,Long> {
    Sanction findByCause(String cause);
    @Query("select a from Sanction a where a.cause like %:cause% or a.typeSanction like %:typeSanction%")
    List<Sanction> findByCauseOrTypeSanction(String cause,String typeSanction);
}
