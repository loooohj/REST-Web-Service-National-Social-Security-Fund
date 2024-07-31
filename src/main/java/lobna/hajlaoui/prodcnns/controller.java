package lobna.hajlaoui.prodcnns;

import lobna.hajlaoui.prodcnns.DTO.CIVP__SCV_CSCDTO;
import lobna.hajlaoui.prodcnns.DTO.ContractDTO;
import lobna.hajlaoui.prodcnns.DTO.Startup_actDTO;
import lobna.hajlaoui.prodcnns.Entity.*;
import lobna.hajlaoui.prodcnns.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {
    @Autowired
    KaramaService karama_service;
    @Autowired
    RegulationService regulation_service;
    @Autowired
    ContractService contract_service;
    @Autowired
    OpclockingService opclocking_service;
    @Autowired
    StartupActService startup_act_service;
    @Autowired
    CIVP__SCV_CSCService civp__scv_csc_service;
    @GetMapping("/beneficiaries_SaufKarama/{date}/{program}")
    public List<Contract> findByDateProgram(@PathVariable("date") String date, @PathVariable("program") String program) {
        return contract_service.findByDateProgram(date,program);
    }
    @GetMapping("/allavg")
    public List<Contract> findAll() {
        return contract_service.getAll();
    }
    @PostMapping("/store_beneficiaries_SaufKarama")
    public Contract addSaufKarama(@RequestBody Contract sauf_karama) {
        return  contract_service.save_beneficiaries_SaufKarama(sauf_karama);
    }
    @PostMapping("/store_clocking")
    public OpClocking addClocking(@RequestBody OpClocking clocking) {
        return  opclocking_service.save_clocking(clocking);
    }
    @PostMapping("/store_Karama")
    public Karama addKarama(@RequestBody Karama karama) {
        return  karama_service.save_beneficiaries_Karama(karama);
    }
    @PostMapping("/store_regulation")
    public Regulation addRegulation(@RequestBody Regulation re) {
        return  regulation_service.save_regulation(re);
    }
    @PostMapping("/store_startup_act")
    public Startup_act addStartupAct(@RequestBody Startup_act st) {
        return  startup_act_service.save_startup_act(st);
    }
    @PostMapping("/store_civp__scv_csc")
    public CIVP__SCV_CSC addCivp__scv_csc(@RequestBody CIVP__SCV_CSC csc) {
        return  civp__scv_csc_service.save_civp__scv_csc(csc);
    }
    @GetMapping("/beneficiaries_Karama/{date}/{program}")
    public List<Karama> findByDate_Program(@PathVariable("date") String date) {
        return karama_service.findByDate_Program(date);
    }
    @GetMapping("/contracts/{cin}/{date}")
    public List<ContractDTO> findByCin_Date(@PathVariable("date") String date, @PathVariable("cin") String cin) {
        return contract_service.findByCin_Date(cin,date);
    }
    @GetMapping("/clocking/{cin}")
    public List<OpClocking> findByCin(@PathVariable("cin") String cin) {
        return opclocking_service.findByCin(cin);
    }
    @GetMapping("/startup_act/{date}")
    public List<Startup_actDTO> findByDate(@PathVariable("date") String date) {
        return startup_act_service.findByDate(date);
    }
    @GetMapping("/csc/{date}")
    public List<CIVP__SCV_CSCDTO> findBy_Date(@PathVariable("date") String date) {
        return civp__scv_csc_service.findBy_Date(date);
    }
}
