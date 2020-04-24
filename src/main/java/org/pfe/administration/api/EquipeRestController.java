package org.pfe.administration.api;

import javassist.NotFoundException;
import org.pfe.administration.dto.EmployeUpdateDto;
import org.pfe.administration.dto.EquipeDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.service.impl.EquipeServiceImpl;
import org.pfe.administration.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping(ApiPaths.EquipeCtrl.CTRL)
@CrossOrigin
public class EquipeRestController {
    private final EquipeServiceImpl equipeServiceImpl;


    public EquipeRestController(EquipeServiceImpl equipeServiceImpl) {
        super();
        this.equipeServiceImpl = equipeServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<EquipeDto>> getAll() throws NotFoundException {
        List<EquipeDto> equipeDtos = equipeServiceImpl.getAll();
        return ResponseEntity.ok(equipeDtos);
    }
    @PostMapping()
    public ResponseEntity<EquipeDto> createEquipe(@Valid @RequestBody EquipeDto equipeDto) {
        return ResponseEntity.ok(equipeServiceImpl.save(equipeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEquipe(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(equipeServiceImpl.delete(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EquipeDto> getOneAuthor(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(equipeServiceImpl.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipeUpdateDto> updateEquipe(@PathVariable(name = "id", required = true) Long id,
                                                        @Valid @RequestBody EquipeUpdateDto equipeUpdateDto) throws NotFoundException {
        return ResponseEntity.ok(equipeServiceImpl.update(id, equipeUpdateDto));
    }
}
