package org.pfe.administration.service.impl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.pfe.administration.dao.EquipeRepository;
import org.pfe.administration.dto.EquipeDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.entities.Employe;
import org.pfe.administration.entities.Equipe;
import org.pfe.administration.service.IEquipeService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service

public class EquipeServiceImpl implements IEquipeService {
    private final ModelMapper modelMapper;
    private final EquipeRepository equipeRepository;


    public EquipeServiceImpl(ModelMapper modelMapper, EquipeRepository equipeRepository) {
        super();
        this.modelMapper = modelMapper;
        this.equipeRepository = equipeRepository;
    }

    @Override
   public EquipeDto save(EquipeDto equipeDto) {
        Equipe equipeChecked = equipeRepository.findByNomEquipe(equipeDto.getNomEquipe());
        if (equipeChecked != null) {
            throw new IllegalArgumentException("Equipe already exist");
        }
        Equipe equipe = modelMapper.map(equipeDto, Equipe.class);
        equipeRepository.save(equipe);
        equipeDto.setId(equipe.getId());
        return equipeDto;
    }

    public List<EquipeDto> getAll() throws NotFoundException {
        List<Equipe> equipes = equipeRepository.findAll();
        if (equipes.size() < 1) {

            throw new NotFoundException("employe doesn't already exist");

        }
        EquipeDto[] equipeDtos = modelMapper.map(equipes, EquipeDto[].class);

        return Arrays.asList(equipeDtos);
    }

    public Boolean delete(Long id) throws NotFoundException {

        Optional<Equipe> equipe = equipeRepository.findById(id);
        if (!equipe.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        equipeRepository.deleteById(id);
        return true;

    }
    public EquipeDto getOne(Long id) throws NotFoundException {

        Optional<Equipe> equipe = equipeRepository.findById(id);
        if (!equipe.isPresent()) {
            throw new NotFoundException("User dosen't exist : " + id);
        }

        EquipeDto equipeDto = modelMapper.map(equipe.get(), EquipeDto.class);
        equipeDto.setId(id);
        equipeDto.getEmployes().forEach(data -> {
            data.getEquipe().setId(id);
        });
        return equipeDto;

    }

    public EquipeUpdateDto update(Long id, @Valid EquipeUpdateDto equipeUpdateDto) throws NotFoundException {
        Optional<Equipe> equipeOpt = equipeRepository.findById(id);
        if (!equipeOpt.isPresent()) {
            throw new NotFoundException("equipe dosen't exist : " + id);
        }
        Equipe equipe = modelMapper.map(equipeUpdateDto, Equipe.class);
        equipe.setId(id);
        equipeRepository.save(equipe);
        equipeUpdateDto.setId(equipe.getId());
        return equipeUpdateDto;

    }



}
