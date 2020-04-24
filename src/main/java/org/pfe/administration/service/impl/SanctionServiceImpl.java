package org.pfe.administration.service.impl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.pfe.administration.dao.EmployeRepository;
import org.pfe.administration.dao.EquipeRepository;
import org.pfe.administration.dao.SanctionRepository;
import org.pfe.administration.dto.*;
import org.pfe.administration.entities.Absence;
import org.pfe.administration.entities.Employe;
import org.pfe.administration.entities.Equipe;
import org.pfe.administration.entities.Sanction;
import org.pfe.administration.service.IEquipeService;
import org.pfe.administration.service.ISanctionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service

public class SanctionServiceImpl implements ISanctionService {
    private final ModelMapper modelMapper;
    private final SanctionRepository sanctionRepository;
    private final EmployeRepository employeRepository;

    public SanctionServiceImpl(ModelMapper modelMapper, SanctionRepository sanctionRepository,EmployeRepository employeRepository) {
        super();
        this.modelMapper = modelMapper;
        this.sanctionRepository = sanctionRepository;
        this.employeRepository = employeRepository;
    }

    @Override
   public SanctionDto save(SanctionDto sanctionDto) {
        Sanction sanctionChecked = sanctionRepository.findByCause(sanctionDto.getCause());
        if (sanctionChecked != null) {
            throw new IllegalArgumentException("Sanction already exist");
        }
        Sanction sanction = modelMapper.map(sanctionDto, Sanction.class);
        sanctionRepository.save(sanction);
        sanctionDto.setId(sanction.getId());
        return sanctionDto;
    }

    public List<SanctionDto> getAll() throws NotFoundException {
        List<Sanction> sanctions = sanctionRepository.findAll();
        if (sanctions.size() < 1) {

            throw new NotFoundException("sanction doesn't already exist");

        }
        SanctionDto[] sanctionDtos = modelMapper.map(sanctions, SanctionDto[].class);

        return Arrays.asList(sanctionDtos);
    }


    public Boolean delete(Long id) throws NotFoundException {

        Optional<Sanction> sanction = sanctionRepository.findById(id);
        if (!sanction.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        sanctionRepository.deleteById(id);
        return true;

    }

    @Transactional
    public SanctionUpdateDto update(Long id, SanctionUpdateDto sanctionUpdateDto) throws NotFoundException {

        Optional<Sanction> sanctionOpt = sanctionRepository.findById(id);
        if (!sanctionOpt.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        Optional<Employe> employe = employeRepository.findById(sanctionUpdateDto.getEmploye().getId());
        if (!employe.isPresent()) {
            throw new NotFoundException("Author does not exist id : " + sanctionUpdateDto.getEmploye().getId());
        }
        Sanction realsanction = modelMapper.map(sanctionUpdateDto, Sanction.class);
        realsanction.setEmploye(employe.get());
        //realemploye.setStudent(employeOpt.get().getStudent());
        sanctionRepository.save(realsanction);
        sanctionUpdateDto = modelMapper.map(realsanction, SanctionUpdateDto.class);
        sanctionUpdateDto.getEmploye().setId(employe.get().getId());

        return sanctionUpdateDto;

    }



}
