package eNotes.group.eNotes.controllers;

import eNotes.group.eNotes.models.Matiere;
import eNotes.group.eNotes.models.Prof;
import eNotes.group.eNotes.repository.MatiereRepository;
import eNotes.group.eNotes.repository.ProfRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/prof")
public class ProfController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    MatiereRepository matiereRepository;

    @Autowired
    ProfRepository profRepository;

    @PostMapping("/signin/{ine}/{dateNaissance}")
    public ResponseEntity<Prof> authenticateUser(@PathVariable ("ine") String ine, @PathVariable("dateNaissance") String dateNaissance) {
        try {
            Prof prof =profRepository.findProfByIneAndDateNaissance(ine,dateNaissance);
            return new ResponseEntity<>(prof, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }



    @PostMapping("/addProf")
    public ResponseEntity<Prof> addProf(@RequestBody Prof prof){
        Prof _prof= profRepository.save(prof);
        return new ResponseEntity<>(_prof, HttpStatus.ACCEPTED);
    }
    @GetMapping("allProf")
    public ResponseEntity<List<Prof>> getAllProf(){
        return new ResponseEntity<>(profRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/idProf/{id}")
    public ResponseEntity<List<Matiere>> getByIdProf(@PathVariable("id") String idProf){
        return  new ResponseEntity<>(matiereRepository.findMatiereByIdProf(idProf), HttpStatus.OK);
    }

    @PutMapping("/idProf/{id}")
    public ResponseEntity<Prof> updateProf(@PathVariable("id") String id, @RequestBody Prof prof) {
        Optional<Prof> profData = profRepository.findById(id);

        profData.get().setId(prof.getId());
        profData.get().setNom(prof.getNom());
        profData.get().setPrenom(prof.getPrenom());
        profData.get().setDateNaissance(prof.getDateNaissance());
        profData.get().setMail(prof.getMail());
        profData.get().setNum(prof.getNum());
        profData.get().setIne(prof.getIne());

        Prof updatedprof = profRepository.save(profData.get());
        return new ResponseEntity<>(updatedprof, HttpStatus.OK);

    }

    @DeleteMapping("/idProf/{id}")
    public Map<String, Boolean> deleteProf(@PathVariable("id") String id) {
        Optional<Prof> etudiant =profRepository.findById(id);

        profRepository.delete(etudiant.get());

        Map<String, Boolean> response = new HashMap<>();
        response.put("Teacher has been deleted!", Boolean.TRUE);

        return response;

    }
}
