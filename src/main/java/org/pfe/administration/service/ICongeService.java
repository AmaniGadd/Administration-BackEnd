package org.pfe.administration.service;

import javassist.NotFoundException;
import org.pfe.administration.dto.CongeDto;
import org.pfe.administration.dto.CongeUpdateDto;
import org.pfe.administration.dto.EquipeUpdateDto;

import java.util.List;

public interface ICongeService {
    public CongeDto save(CongeDto equipeDto);
    public List<CongeDto> getAll() throws NotFoundException;
    public Boolean delete(Long id) throws NotFoundException;
    public CongeUpdateDto update(Long id, CongeUpdateDto congeUpdateDto) throws NotFoundException;
}
