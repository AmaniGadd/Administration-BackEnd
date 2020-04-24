package org.pfe.administration.api;

import javassist.NotFoundException;
import org.pfe.administration.dto.EquipeDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.dto.SanctionDto;
import org.pfe.administration.dto.SanctionUpdateDto;
import org.pfe.administration.service.impl.EquipeServiceImpl;
import org.pfe.administration.service.impl.SanctionServiceImpl;
import org.pfe.administration.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping(ApiPaths.SanctionCtrl.CTRL)
@CrossOrigin
public class SanctionRestController {
    private final SanctionServiceImpl sanctionServiceImpl;


    public SanctionRestController(SanctionServiceImpl sanctionServiceImpl) {
        super();
        this.sanctionServiceImpl = sanctionServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<SanctionDto>> getAll() throws NotFoundException {
        List<SanctionDto> sanctionDtos = sanctionServiceImpl.getAll();
        return ResponseEntity.ok(sanctionDtos);
    }
    @PostMapping()
    public ResponseEntity<SanctionDto> createSanction(@Valid @RequestBody SanctionDto sanctionDto) {
        return ResponseEntity.ok(sanctionServiceImpl.save(sanctionDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSanction(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(sanctionServiceImpl.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SanctionUpdateDto> updateSanction(@PathVariable(name = "id", required = true) Long id,
                                                            @Valid @RequestBody SanctionUpdateDto sanctionUpdateDto) throws NotFoundException {
        return ResponseEntity.ok(sanctionServiceImpl.update(id, sanctionUpdateDto));
    }
}
