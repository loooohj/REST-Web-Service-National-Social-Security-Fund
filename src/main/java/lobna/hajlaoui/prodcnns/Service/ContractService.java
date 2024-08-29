package lobna.hajlaoui.prodcnns.Service;
import lobna.hajlaoui.prodcnns.DTO.ContractDTO;
import lobna.hajlaoui.prodcnns.Entity.Contract;
import lobna.hajlaoui.prodcnns.Repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.Data;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Data
@Service
public class ContractService {
    @Autowired
    ContractRepository contract_repository;
    public List<Contract> findByDateProgram(String date, String program){
        return contract_repository.getByProgramDate(date,program);
    }
    public List<Contract> getAll() {
        return contract_repository.findAll();
    }
    public Contract save_beneficiaries_SaufKarama(Contract saufKarama){
        return contract_repository.save(saufKarama);

    }
    public List<ContractDTO> findByCin_Date(String cin, String date){
        return contract_repository.getByCin_Date(cin,date);
    }
}
