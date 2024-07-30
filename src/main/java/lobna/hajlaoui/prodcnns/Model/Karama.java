package lobna.hajlaoui.prodcnns.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "karama")
public class Karama extends Contract{
    @OneToMany(
     mappedBy = "karama"
    )
    @JsonManagedReference
    private List<Regulation> regulations;

    public Karama(Long id, String cin, String nom_prenom, String genre, String type_contrat, String date_debut, String date_fin_prevesionnelle, String date_fin_reelle, String situation, String date_situation, String matricule, String numero_affiliation, String reference_accord, String date_accord, String raison_sociale_entreprise, String nom_etablissement, List<Regulation> regulations) {
        super(id, cin, nom_prenom, genre, type_contrat, date_debut, date_fin_prevesionnelle, date_fin_reelle, situation, date_situation, matricule, numero_affiliation, reference_accord, date_accord, raison_sociale_entreprise, nom_etablissement);
        this.regulations = regulations;
    }
}
