package org.pfe.administration.service;

import javassist.NotFoundException;
import org.pfe.administration.dto.EmployeUpdateDto;
import org.pfe.administration.dto.EquipeDto;
import org.pfe.administration.dto.EquipeUpdateDto;

import java.util.List;

public interface IEquipeService {
    public EquipeDto save(EquipeDto equipeDto);
    public List<EquipeDto> getAll() throws NotFoundException;
    public Boolean delete(Long id) throws NotFoundException;
    public EquipeUpdateDto update(Long id, EquipeUpdateDto equipeUpdateDto) throws NotFoundException;
    public EquipeDto getOne(Long id) throws NotFoundException;
}
