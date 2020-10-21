package eNotes.group.eNotes.controllers;

import eNotes.group.eNotes.models.Etudiant;
import eNotes.group.eNotes.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

    @Autowired
    EtudiantRepository etudiantRepository;
    /*  @PostMapping("/signin")
     public ResponseEntity<Etudiant> authenticateUser(@RequestBody Etudiant etudiant) {
         if(etudiant.equals(etudiantRepository.findEtudiantByIneAndDateNaissance(etudiant.getIne(),etudiant.getDateNaissance()))){
             System.out.println("etudiant   1 er post ="+ etudiant.getDateNaissance() + etudiant.getIne()+ etudiant.getNom());
             return new ResponseEntity<>(etudiant,HttpStatus.OK);
         }else {
             System.out.println("erreu");
             return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
         }
     }
     */
    @PostMapping("/signin/{ine}/{dateNaissance}")
    public ResponseEntity<Etudiant> authenticateEtudiant(@PathVariable("ine") String ine, @PathVariable("dateNaissance") String dateNaissance) {
        try{
            Etudiant etudiant= etudiantRepository.findEtudiantByIneAndDateNaissance(ine,dateNaissance);
            System.out.println("etudiant ="+ etudiant.getDateNaissance() + etudiant.getIne()+ etudiant.getNom());
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        }catch( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/allEtudiant")
    public ResponseEntity<List<Etudiant>> getAllEtudiant(){
        return new ResponseEntity<>(etudiantRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/idEtudiant/{id}")
    public ResponseEntity<Etudiant> getById(@PathVariable ("id") String id ){
        return new ResponseEntity<>(etudiantRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/addEtudiant")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant){
        Etudiant e= etudiantRepository.save(etudiant);
        return new ResponseEntity<>(e, HttpStatus.ACCEPTED);
    }

    @PutMapping("/idEtudiant/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id") String id, @RequestBody Etudiant etudiant) {

        Optional<Etudiant> etudiantData = etudiantRepository.findById(id);

        etudiantData.get().setId(etudiant.getId());
        etudiantData.get().setNum(etudiant.getNum());
        etudiantData.get().setNom(etudiant.getNom());
        etudiantData.get().setPrenom(etudiant.getPrenom());
        etudiantData.get().setMail(etudiant.getMail());
        etudiantData.get().setDateNaissance(etudiant.getDateNaissance());
        etudiantData.get().setIne(etudiant.getIne());


        Etudiant updatedetudiant = etudiantRepository.save(etudiantData.get());

        return new ResponseEntity<>(updatedetudiant, HttpStatus.OK);
    }
    @DeleteMapping("/idEtudiant/{id}")
    public Map<String, Boolean> deleteEtudiant(@PathVariable("id") String id) {
        Optional<Etudiant> etudiant =etudiantRepository.findById(id);

        etudiantRepository.delete(etudiant.get());

        Map<String, Boolean> response = new HashMap<>();
        response.put("Student has been deleted!", Boolean.TRUE);

        return response;

    }
}
