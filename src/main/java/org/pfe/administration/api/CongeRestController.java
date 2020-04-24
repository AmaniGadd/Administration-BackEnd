package org.pfe.administration.api;

import javassist.NotFoundException;
import org.pfe.administration.dto.CongeDto;
import org.pfe.administration.dto.CongeUpdateDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.service.impl.CongeServiceImpl;
import org.pfe.administration.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping(ApiPaths.CongeCtrl.CTRL)
@CrossOrigin
public class CongeRestController {
    private final CongeServiceImpl congeServiceImpl;


    public CongeRestController(CongeServiceImpl congeServiceImpl) {
        super();
        this.congeServiceImpl = congeServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<CongeDto>> getAll() throws NotFoundException {
        List<CongeDto> congeDtos = congeServiceImpl.getAll();
        return ResponseEntity.ok(congeDtos);
    }
    @PostMapping()
    public ResponseEntity<CongeDto> createConge(@Valid @RequestBody CongeDto congeDto) {
        return ResponseEntity.ok(congeServiceImpl.save(congeDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteConge(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(congeServiceImpl.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CongeUpdateDto> updateEquipe(@PathVariable(name = "id", required = true) Long id,
                                                       @Valid @RequestBody CongeUpdateDto congeUpdateDto) throws NotFoundException {
        return ResponseEntity.ok(congeServiceImpl.update(id, congeUpdateDto));
    }
}
