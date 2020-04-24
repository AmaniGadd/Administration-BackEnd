package org.pfe.administration.api;

import javassist.NotFoundException;
import org.pfe.administration.dto.AbsenceDto;
import org.pfe.administration.dto.AbsenceUpdateDto;
import org.pfe.administration.dto.EquipeUpdateDto;
import org.pfe.administration.service.impl.AbsenceServiceImpl;
import org.pfe.administration.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping(ApiPaths.AbsenceCtrl.CTRL)
@CrossOrigin
public class AbsenceRestController {
    private final AbsenceServiceImpl absenceServiceImpl;


    public AbsenceRestController(AbsenceServiceImpl absenceServiceImpl) {
        super();
        this.absenceServiceImpl = absenceServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<AbsenceDto>> getAll() throws NotFoundException {
        List<AbsenceDto> absenceDtos = absenceServiceImpl.getAll();
        return ResponseEntity.ok(absenceDtos);
    }
    @PostMapping()
    public ResponseEntity<AbsenceDto> createAbsence(@Valid @RequestBody AbsenceDto absenceDto) {
        return ResponseEntity.ok(absenceServiceImpl.save(absenceDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAbsence(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(absenceServiceImpl.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbsenceUpdateDto> updateAbsence(@PathVariable(name = "id", required = true) Long id,
                                                          @Valid @RequestBody AbsenceUpdateDto absenceUpdateDto) throws NotFoundException {
        return ResponseEntity.ok(absenceServiceImpl.update(id, absenceUpdateDto));
    }
}
