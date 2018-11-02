package br.com.eds.Application.endpoint;

import br.com.eds.Application.model.Users;
import br.com.eds.Application.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("users")
public class UsersEndPoint {

    private final UsersRepository usersRepository;

    public UsersEndPoint(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        try {
            return new ResponseEntity<>(usersRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
//    @RequestMapping("{/id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(usersRepository.findById( id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Users user){
        try {
            return new ResponseEntity<>(usersRepository.save(user), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try {
            usersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("error :" + e, HttpStatus.BAD_REQUEST);
        }
    }
}
