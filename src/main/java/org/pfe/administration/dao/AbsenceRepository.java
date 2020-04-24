package org.pfe.administration.dao;
import org.pfe.administration.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    Absence findByDureeAbs(String dureeAbs);
    @Query("select a from Absence a where a.dureeAbs like %:dureeAbs% or a.certif like %:certif%")
    List<Absence> findByDureeAbsOrCertif(String dureeAbs, String certif);
}
