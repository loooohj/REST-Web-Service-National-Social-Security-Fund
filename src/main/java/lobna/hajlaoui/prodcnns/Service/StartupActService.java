package lobna.hajlaoui.prodcnns.Service;
import lobna.hajlaoui.prodcnns.DTO.Startup_actDTO;
import lobna.hajlaoui.prodcnns.Entity.Startup_act;
import lobna.hajlaoui.prodcnns.Repository.StartupActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import java.util.List;
@Data
@Service
public class StartupActService {
    @Autowired
    StartupActRepository startup_act_repository;
    public Startup_act save_startup_act(Startup_act st){
        return startup_act_repository.save(st);
    }
    public List<Startup_actDTO> findByDate(String date){
        return startup_act_repository.getByDate(date);
    }
}
