package eNotes.group.eNotes.controllers;

import eNotes.group.eNotes.models.*;
import eNotes.group.eNotes.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);


    @Autowired
    public MatiereRepository matiereRepository;

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private ProfRepository profRepository;

    @Autowired
    private AdminRepository adminRepository;


    @PostMapping("/signin/{ine}/{dateNaissance}")
    public ResponseEntity<Admin> authenticateAdmin(@PathVariable ("ine") String ine, @PathVariable("dateNaissance") String dateNaissance) {
        try{
            Admin admin= adminRepository.findAdminByIneAndDateNaissance(ine,dateNaissance);
            System.out.println("etudiant ="+ admin.getDateNaissance() + admin.getIne()+ admin.getNom());
            return new ResponseEntity<>(admin,HttpStatus.OK);
        }catch( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }


}

