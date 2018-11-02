package br.com.eds.Application.endpoint;

import br.com.eds.Application.model.FormularyOphtalmologisty;
import br.com.eds.Application.repository.FormularyOphtalmologistyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("formularyOphtalmologisty")
public class FormularyOphtalmologistyEndPoint  {

    private final FormularyOphtalmologistyRepository formularyOphtalmologistyRepository;

    public FormularyOphtalmologistyEndPoint(FormularyOphtalmologistyRepository formularyOphtalmologistyRepository) {
        this.formularyOphtalmologistyRepository = formularyOphtalmologistyRepository;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        try {
            return new ResponseEntity<>(formularyOphtalmologistyRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?>getOne(@PathVariable ("id") Long id){
        try {
            return new ResponseEntity<>(formularyOphtalmologistyRepository.findById(id), HttpStatus.OK);
        } catch (Exception e ) {
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/formulary/{patientId}")
    public ResponseEntity<?> getFormularyByPatientId (@PathVariable ("patientId") Long id) {
        try {
            return new ResponseEntity<>(formularyOphtalmologistyRepository.findFormularyOphtalmologistiesByPatientId(id), HttpStatus.OK);
         } catch ( Exception e ) {
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FormularyOphtalmologisty formularyOphtalmologisty) {
        try {
            return new ResponseEntity<>(formularyOphtalmologistyRepository.save(formularyOphtalmologisty), HttpStatus.OK);
        } catch (Exception e ) {
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody FormularyOphtalmologisty formularyOphtalmologisty){
        try {
            return new ResponseEntity<>(formularyOphtalmologistyRepository.save(formularyOphtalmologisty), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Long id) {
        try {
            formularyOphtalmologistyRepository.getOne(id).setDeleted(true);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }
}
