package eNotes.group.eNotes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="prof")
public class Prof {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String num;
    private String ine;
    private String dateNaissance;
    private String mail;
}
