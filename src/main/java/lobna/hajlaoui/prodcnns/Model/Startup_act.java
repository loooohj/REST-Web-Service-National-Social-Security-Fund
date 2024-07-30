package lobna.hajlaoui.prodcnns.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "startup_act")
public class Startup_act extends Contract{
    private String annee;
    private String num_exo;
    private String date_label;
    private String date_creation;
    private String date_decision;
    private String date_demande;
    private String nombre_salaries_declares;

    public Startup_act(Long id, String cin, String nom_prenom, String genre, String type_contrat, String date_debut, String date_fin_prevesionnelle, String date_fin_reelle, String situation, String date_situation, String matricule, String numero_affiliation, String reference_accord, String date_accord, String raison_sociale_entreprise, String nom_etablissement, String annee, String num_exo, String date_label, String date_creation, String date_decision, String date_demande, String nombre_salaries_declares) {
        super(id, cin, nom_prenom, genre, type_contrat, date_debut, date_fin_prevesionnelle, date_fin_reelle, situation, date_situation, matricule, numero_affiliation, reference_accord, date_accord, raison_sociale_entreprise, nom_etablissement);
        this.annee = annee;
        this.num_exo = num_exo;
        this.date_label = date_label;
        this.date_creation = date_creation;
        this.date_decision = date_decision;
        this.date_demande = date_demande;
        this.nombre_salaries_declares = nombre_salaries_declares;
    }
}
