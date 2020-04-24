package org.pfe.administration.service;

import javassist.NotFoundException;
import org.pfe.administration.dto.AddEmployeDto;
import org.pfe.administration.dto.EmployeDto;
import org.pfe.administration.dto.EmployeUpdateDto;
import org.pfe.administration.entities.Employe;

import java.util.List;

public interface IEmployeService {
    public String save(AddEmployeDto addEmployeDto);
    public List<EmployeDto> getAll() throws NotFoundException;
    public Boolean delete(Long id) throws NotFoundException;
    public AddEmployeDto getOne(Long id) throws NotFoundException ;
   public String update(Long id, AddEmployeDto addEmployeDto) throws NotFoundException;
}
