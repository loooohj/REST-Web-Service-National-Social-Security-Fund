package lobna.hajlaoui.prodcnns.Entity;
import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "startup_act")
public class Startup_act{
    @Id
    @GeneratedValue
    private Long id;
    private String annee;
    private String num_exo;
    private String date_label;
    private String date_creation;
    private String date_decision;
    private String date_demande;
    private String nombre_salaries_declares;
    private String date_fin_prevesionnelle;
    private String date_fin_reelle;
    private String situation;
    private String date_situation;
    private String matricule;
    private String numero_affiliation;
    private String raison_sociale_entreprise;
}
