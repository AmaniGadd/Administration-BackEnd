package org.pfe.administration.api;
import javassist.NotFoundException;
import org.pfe.administration.dto.AddEmployeDto;
import org.pfe.administration.dto.EmployeDto;
import org.pfe.administration.dto.EmployeUpdateDto;
import org.pfe.administration.entities.Employe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.pfe.administration.service.impl.EmployeServiceImpl;

import javax.validation.Valid;
import org.pfe.administration.util.ApiPaths;

import java.util.List;

@RestController
//@RequestMapping(value = "/employes")
@RequestMapping(ApiPaths.EmployeCtrl.CTRL)
@CrossOrigin(origins = "*")


public class EmployeRestController {
    private final EmployeServiceImpl employeServiceImpl;


    public EmployeRestController(EmployeServiceImpl employeServiceImpl) {
        super();
        this.employeServiceImpl = employeServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<EmployeDto>> getAll() throws NotFoundException {
        List<EmployeDto> employeDtos = employeServiceImpl.getAll();
        return ResponseEntity.ok(employeDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddEmployeDto> getAll(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(employeServiceImpl.getOne(id));
    }
    @PostMapping()
    public ResponseEntity<String> createEmploye(@Valid @RequestBody AddEmployeDto addEmployeDto) {
        return ResponseEntity.ok(employeServiceImpl.save(addEmployeDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmploye(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(employeServiceImpl.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmploye(@PathVariable Long id,
                                                       @Valid @RequestBody AddEmployeDto addEmployeDto) throws NotFoundException {
        return ResponseEntity.ok(employeServiceImpl.update(id, addEmployeDto));
    }
}
