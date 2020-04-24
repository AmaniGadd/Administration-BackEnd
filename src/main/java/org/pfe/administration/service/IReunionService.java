package org.pfe.administration.service;

import javassist.NotFoundException;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.dto.ReunionDto;
import org.pfe.administration.dto.ReunionUpdateDto;

import java.util.List;

public interface IReunionService {
    public ReunionDto save(ReunionDto reunionDto);
    public List<ReunionDto> getAll() throws NotFoundException;
    public Boolean delete(Long id) throws NotFoundException;
    public ReunionUpdateDto update(Long id, ReunionUpdateDto reunionUpdateDto) throws NotFoundException;
}
