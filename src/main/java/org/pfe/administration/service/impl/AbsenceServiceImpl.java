package org.pfe.administration.service.impl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.pfe.administration.dao.AbsenceRepository;
import org.pfe.administration.dto.AbsenceDto;
import org.pfe.administration.dto.AbsenceUpdateDto;
import org.pfe.administration.dao.EmployeRepository;
import org.pfe.administration.dto.EmployeUpdateDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.entities.Absence;
import org.pfe.administration.entities.Employe;
import org.pfe.administration.entities.Equipe;
import org.pfe.administration.service.IAbsenceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service

public class AbsenceServiceImpl implements IAbsenceService {
    private final ModelMapper modelMapper;
    private final AbsenceRepository absenceRepository;
    private final EmployeRepository employeRepository;


    public AbsenceServiceImpl(ModelMapper modelMapper, AbsenceRepository absenceRepository, EmployeRepository employeRepository) {
        super();
        this.modelMapper = modelMapper;
        this.absenceRepository = absenceRepository;
        this.employeRepository = employeRepository;
    }

    @Override
   public AbsenceDto save(AbsenceDto absenceDto) {
        Absence absenceChecked = absenceRepository.findByDureeAbs(absenceDto.getDureeAbs());
        if (absenceChecked != null) {
            throw new IllegalArgumentException("Absence already exist");
        }
        Absence absence = modelMapper.map(absenceDto, Absence.class);
        absenceRepository.save(absence);
        absenceDto.setId(absence.getId());
        return absenceDto;
    }

    public List<AbsenceDto> getAll() throws NotFoundException {
        List<Absence> absences = absenceRepository.findAll();
        if (absences.size() < 1) {

            throw new NotFoundException("absence doesn't already exist");

        }
        AbsenceDto[] absenceDtos = modelMapper.map(absences, AbsenceDto[].class);

        return Arrays.asList(absenceDtos);
    }

    public Boolean delete(Long id) throws NotFoundException {

        Optional<Absence> absence = absenceRepository.findById(id);
        if (!absence.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        absenceRepository.deleteById(id);
        return true;

    }

    @Transactional
    public AbsenceUpdateDto update(Long id, AbsenceUpdateDto absenceUpdateDto) throws NotFoundException {

        Optional<Absence> absenceOpt = absenceRepository.findById(id);
        if (!absenceOpt.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        Optional<Employe> employe = employeRepository.findById(absenceUpdateDto.getEmploye().getId());
        if (!employe.isPresent()) {
            throw new NotFoundException("Author does not exist id : " + absenceUpdateDto.getEmploye().getId());
        }
        Absence realabsence = modelMapper.map(absenceUpdateDto, Absence.class);
        realabsence.setEmploye(employe.get());
        //realemploye.setStudent(employeOpt.get().getStudent());
        absenceRepository.save(realabsence);
        absenceUpdateDto = modelMapper.map(realabsence, AbsenceUpdateDto.class);
        absenceUpdateDto.getEmploye().setId(employe.get().getId());

        return absenceUpdateDto;

    }


}
