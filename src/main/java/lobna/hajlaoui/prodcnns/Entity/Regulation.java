/*package lobna.hajlaoui.prodcnns.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regulation")
public class Regulation {
    @Id
    @GeneratedValue
    private int id_regulation;
    private String situation_regulation;
    private String mois_regulation;
    private String annee_regulation;
    private String salaire;
    private String montant_verse;
    @ManyToOne
    @JoinColumn(
            name="karama_id"
    )
    @JsonBackReference
    private Karama karama;
}*/
