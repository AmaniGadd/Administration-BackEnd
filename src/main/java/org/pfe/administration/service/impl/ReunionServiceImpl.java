package org.pfe.administration.service.impl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.pfe.administration.dao.EquipeRepository;
import org.pfe.administration.dao.ReunionRepository;
import org.pfe.administration.dto.EquipeDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.dto.ReunionDto;
import org.pfe.administration.dto.ReunionUpdateDto;
import org.pfe.administration.entities.Employe;
import org.pfe.administration.entities.Equipe;
import org.pfe.administration.entities.Reunion;
import org.pfe.administration.service.IReunionService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service

public class ReunionServiceImpl implements IReunionService {
    private final ModelMapper modelMapper;
    private final ReunionRepository reunionRepository;


    public ReunionServiceImpl(ModelMapper modelMapper, ReunionRepository reunionRepository) {
        super();
        this.modelMapper = modelMapper;
        this.reunionRepository = reunionRepository;
    }

    @Override
   public ReunionDto save(ReunionDto reunionDto) {
        Reunion reunionChecked = reunionRepository.findByObjet(reunionDto.getObjet());
        if (reunionChecked != null) {
            throw new IllegalArgumentException("reunion already exist");
        }
        Reunion reunion = modelMapper.map(reunionDto, Reunion.class);
        reunionRepository.save(reunion);
        reunionDto.setId(reunion.getId());
        return reunionDto;
    }

    public List<ReunionDto> getAll() throws NotFoundException {
        List<Reunion> reunions = reunionRepository.findAll();
        if (reunions.size() < 1) {

            throw new NotFoundException("reunion doesn't already exist");

        }
        ReunionDto[] reunionDtos = modelMapper.map(reunions, ReunionDto[].class);

        return Arrays.asList(reunionDtos);
    }


    public Boolean delete(Long id) throws NotFoundException {

        Optional<Reunion> reunion = reunionRepository.findById(id);
        if (!reunion.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        reunionRepository.deleteById(id);
        return true;

    }

    public ReunionUpdateDto update(Long id, @Valid ReunionUpdateDto reunionUpdateDto) throws NotFoundException {
        Optional<Reunion> reunionOpt = reunionRepository.findById(id);
        if (!reunionOpt.isPresent()) {
            throw new NotFoundException("reunion dosen't exist : " + id);
        }
        Reunion reunion = modelMapper.map(reunionUpdateDto, Reunion.class);
        reunion.setId(id);
        reunionRepository.save(reunion);
        reunionUpdateDto.setId(reunion.getId());
        return reunionUpdateDto;

    }


}
