package lobna.hajlaoui.prodcnns.Repository;

import lobna.hajlaoui.prodcnns.Model.Karama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface KaramaRepository extends JpaRepository<Karama,Long> {
    @Query("SELECT k FROM Karama k WHERE k.type_contrat = 'karama' AND TO_DATE(k.date_situation,'DD/MM/YYYY')>= TO_DATE(:dateSituation,'DD/MM/YYYY')")
    List<Karama> getByProgram_Date(@Param("dateSituation") String dateSituation);
}
