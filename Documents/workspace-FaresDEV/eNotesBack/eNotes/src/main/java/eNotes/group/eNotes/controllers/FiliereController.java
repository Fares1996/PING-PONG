package eNotes.group.eNotes.controllers;

import eNotes.group.eNotes.models.Filiere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/filiere")
public class FiliereController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private eNotes.group.eNotes.repository.FiliereRepository filiereRepository;


    @GetMapping("allFiliere")
    public ResponseEntity<List<Filiere>> getAllFiliere(){
        return new ResponseEntity<>(filiereRepository.findAll(),HttpStatus.OK);
    }

    @PostMapping("/addFiliere")
    public ResponseEntity<Filiere> addFiliere(@RequestBody Filiere filiere){
        try {
            filiereRepository.save((filiere));
            return new ResponseEntity<>(filiere, HttpStatus.CREATED);
        } catch (Exception e){
            LOGGER.debug("la création de la filiere est en échec");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/updateFiliere")
    public ResponseEntity<Filiere> updateFiliere(@RequestBody Filiere filiere){
        try {
            filiereRepository.save(filiere);
            return new ResponseEntity<>(filiere, HttpStatus.CREATED);
        } catch (Exception e){
            LOGGER.debug("la création de la filiere est en échec");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    @DeleteMapping(value = "/deleteFiliereByid/{idFiliere}")
    public String deleteFiliere(@PathVariable(value = "idFiliere") String idFiliere) {
        LOGGER.debug("Suppression matiere par id matiere : {}.", idFiliere);
        try {
            filiereRepository.deleteFilieresById(idFiliere);
            LOGGER.debug("La  filiere dont l'id est  : {}.", idFiliere + "a été supprimée");
            return ("La  filiere dont l'id est : {}." + idFiliere + "a été supprimée");
        }catch (Exception e){
            return "La  filiere dont l'id est " + idFiliere + "n'existe pas pour etre supprimée";
        }
    }

    @PutMapping(value="/putFiliere/{idFiliere}")
    public String putFiliere(@PathVariable (value= "idFiliere") String id, @RequestBody Filiere filiere){
        try {
            filiere.setId(id);
            filiereRepository.save(filiere);
            return "filiere " + filiere.getNom()+ "a été mis à jour";
        }catch( Exception e){
            return "filiere " + filiere.getNom()+ "n'a pas été mis à jour";
        }
    }
}
