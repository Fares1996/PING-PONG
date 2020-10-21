package eNotes.group.eNotes.repository;

import eNotes.group.eNotes.models.Filiere;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiliereRepository  extends MongoRepository<Filiere, String> {
    Filiere findFiliereById (String id);
    Filiere findFiliereByNom (String nom);
    List<Filiere> findAll();
    void deleteFilieresById(String id);

}