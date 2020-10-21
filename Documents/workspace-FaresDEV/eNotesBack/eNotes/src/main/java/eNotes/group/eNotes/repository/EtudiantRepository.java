package eNotes.group.eNotes.repository;

import eNotes.group.eNotes.models.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends MongoRepository<Etudiant,String> {
    Etudiant findEtudiantByIneAndDateNaissance(String ine, String dataNaissance);
    Etudiant findEtudiantByIne(String ine);
    Etudiant findEtudiantByNum(String num);

}
