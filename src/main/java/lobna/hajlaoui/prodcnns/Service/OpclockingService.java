package lobna.hajlaoui.prodcnns.Service;

import lobna.hajlaoui.prodcnns.Entity.OpClocking;
import lobna.hajlaoui.prodcnns.Repository.OpclockingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpclockingService {
    @Autowired
    OpclockingRepository opclocking_repository;
    public OpClocking save_clocking(OpClocking clocking){
        return opclocking_repository.save(clocking);
    }
    public List<OpClocking> findByCin(String cin){
        return opclocking_repository.getByCin(cin);
    }
}
