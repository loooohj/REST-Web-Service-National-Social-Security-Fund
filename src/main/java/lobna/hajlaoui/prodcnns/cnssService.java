package lobna.hajlaoui.prodcnns;

import lobna.hajlaoui.prodcnns.DTO.CIVP__SCV_CSCDTO;
import lobna.hajlaoui.prodcnns.DTO.ContractDTO;
import lobna.hajlaoui.prodcnns.DTO.Startup_actDTO;
import lobna.hajlaoui.prodcnns.Model.*;
import lobna.hajlaoui.prodcnns.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cnssService {
    @Autowired
    KaramaRepository karama_repository;
    @Autowired
    RegulationRepository regulation_repository;
    @Autowired
    ContractRepository contract_repository;
    @Autowired
    OpclockingRepository opclocking_repository;
    @Autowired
   StartupActRepository startup_act_repository;
    @Autowired
    CIVP__SCV_CSCRepository civp__scv_csc_repository;
    public List<Contract> findByDateProgram(String date, String program){
        return contract_repository.getByProgramDate(date,program);
    }

    public List<Contract> getAll() {
        return contract_repository.findAll();
    }
    public Contract save_beneficiaries_SaufKarama(Contract saufKarama){
       return contract_repository.save(saufKarama);

    }
    public OpClocking save_clocking(OpClocking clocking){
       return opclocking_repository.save(clocking);

    }
   public Karama save_beneficiaries_Karama(Karama ka){
        return karama_repository.save(ka);

    }
    public Regulation save_regulation(Regulation re){
        return regulation_repository.save(re);

    }
    public Startup_act save_startup_act(Startup_act st){
        return startup_act_repository.save(st);

    }
    public CIVP__SCV_CSC save_civp__scv_csc(CIVP__SCV_CSC csc){
        return civp__scv_csc_repository.save(csc);

    }
    public List<Karama> findByDate_Program(String date){
        return karama_repository.getByProgram_Date(date);
    }
    public List<ContractDTO> findByCin_Date(String cin, String date){
        return contract_repository.getByCin_Date(cin,date);
    }
    public List<OpClocking> findByCin(String cin){
        return opclocking_repository.getByCin(cin);
    }
    public List<Startup_actDTO> findByDate(String date){
        return startup_act_repository.getByDate(date);
    }
    public List<CIVP__SCV_CSCDTO> findBy_Date(String date){
        return civp__scv_csc_repository.getBy_Date(date);
    }


}
