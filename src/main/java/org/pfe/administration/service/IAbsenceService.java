package org.pfe.administration.service;

import javassist.NotFoundException;
import org.pfe.administration.dto.AbsenceDto;
import org.pfe.administration.dto.AbsenceUpdateDto;
import org.pfe.administration.dto.EquipeUpdateDto;

import java.util.List;

public interface IAbsenceService {
    public AbsenceDto save(AbsenceDto absenceDto);
    public List<AbsenceDto> getAll() throws NotFoundException;
    public Boolean delete(Long id) throws NotFoundException;
    public AbsenceUpdateDto update(Long id, AbsenceUpdateDto absenceUpdateDto) throws NotFoundException;
}
