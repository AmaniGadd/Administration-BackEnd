package org.pfe.administration.service.impl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.pfe.administration.dao.CongeRepository;
import org.pfe.administration.dao.EmployeRepository;
import org.pfe.administration.dto.AbsenceUpdateDto;
import org.pfe.administration.dto.CongeDto;
import org.pfe.administration.dto.CongeUpdateDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.entities.Absence;
import org.pfe.administration.entities.Conge;
import org.pfe.administration.entities.Employe;
import org.pfe.administration.entities.Equipe;
import org.pfe.administration.service.ICongeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service

public class CongeServiceImpl implements ICongeService {
    private final ModelMapper modelMapper;
    private final CongeRepository congeRepository;
    private final EmployeRepository employeRepository;

    public CongeServiceImpl(ModelMapper modelMapper, CongeRepository congeRepository,EmployeRepository employeRepository) {
        super();
        this.modelMapper = modelMapper;
        this.congeRepository = congeRepository;
        this.employeRepository = employeRepository;
    }

    @Override
   public CongeDto save(CongeDto congeDto) {
        Conge congeChecked = congeRepository.findByCause(congeDto.getCause());
        if (congeChecked != null) {
            throw new IllegalArgumentException("Conge already exist");
        }
        Conge conge = modelMapper.map(congeDto, Conge.class);
        congeRepository.save(conge);
        congeDto.setId(conge.getId());
        return congeDto;
    }

    public List<CongeDto> getAll() throws NotFoundException {
        List<Conge> conges = congeRepository.findAll();
        if (conges.size() < 1) {

            throw new NotFoundException("conge doesn't already exist");

        }
        CongeDto[] congeDtos = modelMapper.map(conges, CongeDto[].class);

        return Arrays.asList(congeDtos);
    }


    public Boolean delete(Long id) throws NotFoundException {

        Optional<Conge> conge = congeRepository.findById(id);
        if (!conge.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        congeRepository.deleteById(id);
        return true;

    }


    @Transactional
    public CongeUpdateDto update(Long id, CongeUpdateDto congeUpdateDto) throws NotFoundException {

        Optional<Conge> congeOpt = congeRepository.findById(id);
        if (!congeOpt.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        Optional<Employe> employe = employeRepository.findById(congeUpdateDto.getEmploye().getId());
        if (!employe.isPresent()) {
            throw new NotFoundException("Author does not exist id : " + congeUpdateDto.getEmploye().getId());
        }
        Conge realconge = modelMapper.map(congeUpdateDto, Conge.class);
        realconge.setEmploye(employe.get());
        //realemploye.setStudent(employeOpt.get().getStudent());
        congeRepository.save(realconge);
        congeUpdateDto = modelMapper.map(realconge, CongeUpdateDto.class);
        congeUpdateDto.getEmploye().setId(employe.get().getId());

        return congeUpdateDto;

    }


}
