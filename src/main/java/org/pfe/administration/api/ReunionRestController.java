package org.pfe.administration.api;

import javassist.NotFoundException;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.dto.ReunionDto;
import org.pfe.administration.dto.ReunionUpdateDto;
import org.pfe.administration.service.impl.ReunionServiceImpl;
import org.pfe.administration.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping(ApiPaths.ReunionCtrl.CTRL)
@CrossOrigin
public class ReunionRestController {
    private final ReunionServiceImpl reunionServiceImpl;


    public ReunionRestController(ReunionServiceImpl reunionServiceImpl) {
        super();
        this.reunionServiceImpl = reunionServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<ReunionDto>> getAll() throws NotFoundException {
        List<ReunionDto> reunionDtos = reunionServiceImpl.getAll();
        return ResponseEntity.ok(reunionDtos);
    }
    @PostMapping()
    public ResponseEntity<ReunionDto> createReunion(@Valid @RequestBody ReunionDto reunionDto) {
        return ResponseEntity.ok(reunionServiceImpl.save(reunionDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReunion(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(reunionServiceImpl.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReunionUpdateDto> updateReunion(@PathVariable(name = "id", required = true) Long id,
                                                          @Valid @RequestBody ReunionUpdateDto reunionUpdateDto) throws NotFoundException {
        return ResponseEntity.ok(reunionServiceImpl.update(id, reunionUpdateDto));
    }
}
