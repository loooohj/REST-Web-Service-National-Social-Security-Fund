package lobna.hajlaoui.prodcnns.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pointage")
public class OpClocking {
    @Id
    @GeneratedValue
    private Long id;
    private String cin;
    private String nom_prenom;
    private String genre;
    private String prenom_pere;
    private String date_naissance;
    private String date_pointage;
    private String type_mouvement;

}
