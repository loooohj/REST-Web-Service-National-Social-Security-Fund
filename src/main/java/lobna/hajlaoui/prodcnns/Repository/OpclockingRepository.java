package lobna.hajlaoui.prodcnns.Repository;
import lobna.hajlaoui.prodcnns.Entity.OpClocking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OpclockingRepository extends JpaRepository<OpClocking,Long> {
    @Query("SELECT cl FROM OpClocking cl WHERE cl.cin = :cin ")
    List<OpClocking> getByCin(@Param("cin") String cin);
}
