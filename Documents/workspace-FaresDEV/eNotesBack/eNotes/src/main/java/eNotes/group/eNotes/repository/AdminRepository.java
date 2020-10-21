package eNotes.group.eNotes.repository;

import eNotes.group.eNotes.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin,String> {
    Admin findAdminByIneAndDateNaissance(String ine, String dataNaissance);

}
