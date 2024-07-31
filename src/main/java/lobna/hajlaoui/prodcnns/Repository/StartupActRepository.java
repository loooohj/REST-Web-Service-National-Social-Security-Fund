package lobna.hajlaoui.prodcnns.Repository;
import lobna.hajlaoui.prodcnns.DTO.Startup_actDTO;
import lobna.hajlaoui.prodcnns.Entity.Startup_act;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StartupActRepository extends JpaRepository<Startup_act,Long>{
    @Query("SELECT new lobna.hajlaoui.prodcnns.DTO.Startup_actDTO(st.annee, st.num_exo, st.date_label, st.date_creation, st.date_decision, st.date_demande, st.nombre_salaries_declares) FROM Startup_act st WHERE TO_DATE(st.date_label,'DD/MM/YYYY')>= TO_DATE(:date,'DD/MM/YYYY')")
    List<Startup_actDTO> getByDate(@Param("date") String date);

}
