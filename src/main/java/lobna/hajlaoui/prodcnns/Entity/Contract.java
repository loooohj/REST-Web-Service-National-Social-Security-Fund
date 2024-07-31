package lobna.hajlaoui.prodcnns.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy =InheritanceType.JOINED)
public class Contract {

    @Id
    @GeneratedValue
    private Long id;
    private String cin;
    private String nom_prenom;
    private String genre;
    private String type_contrat;
    private String date_debut;
    private String date_fin_prevesionnelle;
    private String date_fin_reelle;
    private String situation;
    private String date_situation;
    private String matricule;
    private String numero_affiliation;
    private String reference_accord;
    private String date_accord;
    private String raison_sociale_entreprise;
    private String nom_etablissement;

}
