package br.com.eds.Application.endpoint;

import br.com.eds.Application.model.Patients;
import br.com.eds.Application.repository.PatientsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("patients")
public class PatientsEndPoint {

    private final PatientsRepository patientsRepository;

    public PatientsEndPoint(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }


    @GetMapping
    public ResponseEntity<?> listAll(){
        try {
            return new ResponseEntity<>(patientsRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
    //    @RequestMapping("{/id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(patientsRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }


//    @GetMapping(path = "/name/{name}")
//    //    @RequestMapping("{/id}")
//    public ResponseEntity<?> findByName(@RequestBody String name) {
//        try {
//            return new ResponseEntity<>(patientsRepository.findFormularyOphtalmologistiesByPatientName(name), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
//        }
//    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Patients patients){
        try {
            return new ResponseEntity<>(patientsRepository.save(patients), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Patients patients) {
        try {
            return new ResponseEntity<>(patientsRepository.save(patients), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try {
            patientsRepository.getOne(id).setDeleted(true);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }
}
