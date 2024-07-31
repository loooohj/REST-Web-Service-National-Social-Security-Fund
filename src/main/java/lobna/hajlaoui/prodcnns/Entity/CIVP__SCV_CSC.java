package lobna.hajlaoui.prodcnns.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "civp__scv_csc")
public class CIVP__SCV_CSC extends Contract{
private String date_saisi;

    public CIVP__SCV_CSC(Long id, String cin, String nom_prenom, String genre, String type_contrat, String date_debut, String date_fin_prevesionnelle, String date_fin_reelle, String situation, String date_situation, String matricule, String numero_affiliation, String reference_accord, String date_accord, String raison_sociale_entreprise, String nom_etablissement, String date_saisi) {
        super(id, cin, nom_prenom, genre, type_contrat, date_debut, date_fin_prevesionnelle, date_fin_reelle, situation, date_situation, matricule, numero_affiliation, reference_accord, date_accord, raison_sociale_entreprise, nom_etablissement);
        this.date_saisi = date_saisi;
    }
}
