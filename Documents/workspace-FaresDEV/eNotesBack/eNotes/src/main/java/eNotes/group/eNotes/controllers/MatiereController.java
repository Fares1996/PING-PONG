package eNotes.group.eNotes.controllers;

import eNotes.group.eNotes.repository.MatiereRepository;
import eNotes.group.eNotes.models.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/matiere")
public class MatiereController {

    @Autowired
    MatiereRepository matiereRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Matiere>> getAll(HttpServletRequest request) {
        return new ResponseEntity<>(matiereRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Matiere> getByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(matiereRepository.findMatiereByNom(name), HttpStatus.OK);
    }

    @GetMapping("/idMatier/{id}")
    public ResponseEntity<Matiere> getByIdMatiere(@PathVariable("id") String idMatiere) {
        return new ResponseEntity<>(matiereRepository.findMatiereById(idMatiere), HttpStatus.OK);
    }

    @GetMapping("/idEtudiant/{id}")
    public ResponseEntity<List<Matiere>> getByIdEtudiant(@PathVariable("id") String idEtudiant) {
        return new ResponseEntity<>(matiereRepository.findMatiereByIdEtudiant(idEtudiant), HttpStatus.OK);
    }

    @GetMapping("/ineEtudiant/{ine}")
    public ResponseEntity<List<Matiere>> getByIneEtudiant(@PathVariable("ine") String ineEtudiant) {
        return new ResponseEntity<>(matiereRepository.findMatiereByIneEtudiant(ineEtudiant), HttpStatus.OK);
    }

    @GetMapping("/idProf/{id}")
    public ResponseEntity<List<Matiere>> getByIdProf(@PathVariable("id") String idProf) {
        return new ResponseEntity<>(matiereRepository.findMatiereByIdProf(idProf), HttpStatus.OK);
    }

    @GetMapping("/ineProf/{ine}")
    public ResponseEntity<List<Matiere>> getByIneProf(@PathVariable("ine") String ineProf) {
        return new ResponseEntity<>(matiereRepository.findMatiereByIneProf(ineProf), HttpStatus.OK);
    }


    @GetMapping("/idFiliere/{id}")
    public ResponseEntity<List<Matiere>> getByIdFiliere(@PathVariable("id") String idFiliere) {
        return new ResponseEntity<>(matiereRepository.findMatiereByIdFiliere(idFiliere), HttpStatus.OK);
    }

    @GetMapping("/nomFiliere/{nom}")
    public ResponseEntity<List<Matiere>> getByNomFiliere(@PathVariable("nom") String nomFiliere) {
        return new ResponseEntity<>(matiereRepository.findMatiereByNomFiliere(nomFiliere), HttpStatus.OK);
    }


    @GetMapping("/note")
    public double getBynote(@RequestBody Matiere matire) {
        return matire.calculNotes();
    }


}