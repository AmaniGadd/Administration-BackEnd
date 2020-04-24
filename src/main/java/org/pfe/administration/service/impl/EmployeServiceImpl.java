package org.pfe.administration.service.impl;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.pfe.administration.dao.EmployeRepository;
import org.pfe.administration.dao.EquipeRepository;
import org.pfe.administration.dto.AddEmployeDto;
import org.pfe.administration.dto.EmployeDto;
import org.pfe.administration.dto.EmployeUpdateDto;
import org.pfe.administration.entities.Employe;
import org.pfe.administration.entities.Equipe;
import org.pfe.administration.service.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "*")

public class EmployeServiceImpl implements IEmployeService {
    private final ModelMapper modelMapper;
    private final EmployeRepository employeRepository;
    private final EquipeRepository equipeRepository;


    public EmployeServiceImpl(ModelMapper modelMapper, EmployeRepository employeRepository, EquipeRepository equipeRepository ) {
        super();
        this.modelMapper = modelMapper;
        this.employeRepository = employeRepository;
        this.equipeRepository = equipeRepository;
    }

    @Override
   public String save(AddEmployeDto addEmployeDto) {
        Employe employeChecked = employeRepository.findByNom(addEmployeDto.getNom());
        Equipe equipe = equipeRepository.getOne(addEmployeDto.getEqId());
        if (employeChecked != null) {
            throw new IllegalArgumentException("Employe already exist");
        }
        //Employe employe = modelMapper.map(addEmployeDto, Employe.class);
        Employe employe=new Employe();
        employe.setId(addEmployeDto.getId());
        employe.setNom(addEmployeDto.getNom());
        employe.setPrenom(addEmployeDto.getPrenom());
        employe.setMatricule(addEmployeDto.getMatricule());
        employe.setPoste(addEmployeDto.getPoste());
        employe.setEquipe(equipe);
        employeRepository.save(employe);
        return ("success");

//        employeRepository.save(employe);
//        addEmployeDto.setId(employe.getId());
//        addEmployeDto.setEqId(equipe.ge);
//        return addEmployeDto;
    }
    public AddEmployeDto getOne(Long id) throws NotFoundException {

        Optional<Employe> employe = employeRepository.findById(id);
        if (!employe.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        //AddEmployeDto addEmployeDto=new AddEmployeDto();
        //Equipe equipe = equipeRepository.getOne(addEmployeDto.getEqId());

        Employe employe1=new Employe();
        AddEmployeDto addEmployeDto = modelMapper.map(employe.get(), AddEmployeDto.class);
        employe1.getEquipe();
        //addEmployeDto.setEqId(equipe.getId());

        return addEmployeDto;

    }

    public List<EmployeDto> getAll() throws NotFoundException {
        List<Employe> employes = employeRepository.findAll();
        if (employes.size() < 1) {

            throw new NotFoundException("employe doesn't already exist");

        }
        EmployeDto[] employeDtos = modelMapper.map(employes, EmployeDto[].class);

        return Arrays.asList(employeDtos);
    }

    public Boolean delete(Long id) throws NotFoundException {

        Optional<Employe> employe = employeRepository.findById(id);
        if (!employe.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        employeRepository.deleteById(id);
        return true;

    }

    /*@Transactional
   public String update(Long id, AddEmployeDto addEmployeDto) throws NotFoundException {

        Optional<Employe> employeOpt = employeRepository.findById(id);
        if (!employeOpt.isPresent()) {
            throw new NotFoundException("Book does not exist id : " + id);
        }
        Optional<Equipe> equipe = equipeRepository.findById(addEmployeDto.getEqId());
        if (!equipe.isPresent()) {
            throw new NotFoundException("Author does not exist id : " + addEmployeDto.getEqId());
        }
        Equipe eqForOne = equipeRepository.getOne(addEmployeDto.getEqId());
        //Employe realemploye = modelMapper.map(addEmployeDto, Employe.class);
        Employe realemploye=new Employe();
        realemploye.setNom(addEmployeDto.getNom());
        realemploye.setPrenom(addEmployeDto.getPrenom());
        realemploye.setMatricule(addEmployeDto.getMatricule());
        realemploye.setPoste(addEmployeDto.getPoste());
        realemploye.setEquipe(eqForOne);

        //realemploye.setEquipe(equipe.get());
        //realemploye.setStudent(employeOpt.get().getStudent());
        employeRepository.save(realemploye);

       // addEmployeDto = modelMapper.map(realemploye, AddEmployeDto.class);
        //addEmployeDto.setEqId(equipe.get().getId());

        return ("success");

    }*/
    @Transactional
    public String update(Long id, @RequestBody AddEmployeDto addEmployeDto) throws RuntimeException {
        // .orElseThrow(() -> new RuntimeException("Reservation not found for this id :: " + id));

        //Users user = userRepository.findByUsername(formRes.getUsername());



        Employe employe=employeRepository.getOne(id);
        employe.setNom(addEmployeDto.getNom());
        employe.setPrenom(addEmployeDto.getPrenom());
        employe.setMatricule(addEmployeDto.getMatricule());
        employe.setPoste(addEmployeDto.getPoste());
        //employe.setEquipe(addEmployeDto.getEqId());

        Equipe equipe= equipeRepository.getOne(addEmployeDto.getEqId());
        //equipe.setId(addEmployeDto.getEqId());
        employe.setEquipe(equipe);


        if( employe != null)
            return " updated successfully";
        else
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "error while updating reservation");
    }


}
