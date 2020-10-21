package eNotes.group.eNotes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "matiere")
public class Matiere {
    @Id
    private String id;
    private String nom;
    private String idEtudiant;
    private String ineEtudiant;
    private String idProf;
    private String ineProf;
    private String idFiliere;
    private String nomFiliere;
    private boolean hasDs = false;
    private double noteDs;
    private int coef;
    private int coefDs;
    private int coefPartiel;
    private double notePartiel;

    public double calculNotes() {
        double calculNoteMatiere;
        if (hasDs) {
            return (((noteDs * coefDs) + (notePartiel * coefPartiel)) / coefPartiel + coefDs);
        } else {
            return notePartiel;
        }
    }
}