package org.pfe.administration.service;

import javassist.NotFoundException;
import org.pfe.administration.dto.EquipeDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.dto.SanctionDto;
import org.pfe.administration.dto.SanctionUpdateDto;

import java.util.List;

public interface ISanctionService {
    public SanctionDto save(SanctionDto sanctionDto);
    public List<SanctionDto> getAll() throws NotFoundException;
    public Boolean delete(Long id) throws NotFoundException;
    public SanctionUpdateDto update(Long id, SanctionUpdateDto sanctionUpdateDto) throws NotFoundException;
}
