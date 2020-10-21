package eNotes.group.eNotes.repository;

import eNotes.group.eNotes.models.Matiere;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatiereRepository  extends MongoRepository<Matiere,String> {
    Matiere findMatiereById (String id);
    Matiere findMatiereByNom (String nom);
    List<Matiere> findAll();

    void deleteMatiereById(String id);

    List<Matiere> findMatiereByIdEtudiant(String idEtudiant);
    List<Matiere> findMatiereByIneEtudiant(String ineEtudiant);

    List<Matiere> findMatiereByIdFiliere(String idFiliere);
    List<Matiere> findMatiereByNomFiliere(String nomFiliere);

    List<Matiere> findMatiereByIneProf(String idProf);
    List<Matiere> findMatiereByIdProf(String ineProf);
}
