package eNotes.group.eNotes.repository;

import eNotes.group.eNotes.models.Prof;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfRepository extends MongoRepository<Prof,String> {
    Prof findProfByIneAndDateNaissance(String ine, String dataNaissance);

}
