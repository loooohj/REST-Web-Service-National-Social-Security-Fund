package lobna.hajlaoui.prodcnns;

import lobna.hajlaoui.prodcnns.DTO.CIVP__SCV_CSCDTO;
import lobna.hajlaoui.prodcnns.DTO.ContractDTO;
import lobna.hajlaoui.prodcnns.DTO.Startup_actDTO;
import lobna.hajlaoui.prodcnns.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {
@Autowired
cnssService service;
    @GetMapping("/beneficiaries_SaufKarama/{date}/{program}")
    public List<Contract> findByDateProgram(@PathVariable("date") String date, @PathVariable("program") String program) {
        return service.findByDateProgram(date,program);
    }
    @GetMapping("/allavg")
    public List<Contract> findAll() {
        return service.getAll();
    }
    @PostMapping("/store_beneficiaries_SaufKarama")
    public Contract addSaufKarama(@RequestBody Contract sauf_karama) {
        return  service.save_beneficiaries_SaufKarama(sauf_karama);
    }
    @PostMapping("/store_clocking")
    public OpClocking addClocking(@RequestBody OpClocking clocking) {
        return  service.save_clocking(clocking);
    }
    @PostMapping("/store_Karama")
    public Karama addKarama(@RequestBody Karama karama) {
        return  service.save_beneficiaries_Karama(karama);
    }
    @PostMapping("/store_regulation")
    public Regulation addRegulation(@RequestBody Regulation re) {
        return  service.save_regulation(re);
    }
    @PostMapping("/store_startup_act")
    public Startup_act addStartupAct(@RequestBody Startup_act st) {
        return  service.save_startup_act(st);
    }
    @PostMapping("/store_civp__scv_csc")
    public CIVP__SCV_CSC addCivp__scv_csc(@RequestBody CIVP__SCV_CSC csc) {
        return  service.save_civp__scv_csc(csc);
    }
    @GetMapping("/beneficiaries_Karama/{date}/{program}")
    public List<Karama> findByDate_Program(@PathVariable("date") String date) {
        return service.findByDate_Program(date);
    }
    @GetMapping("/contracts/{cin}/{date}")
    public List<ContractDTO> findByCin_Date(@PathVariable("date") String date, @PathVariable("cin") String cin) {
        return service.findByCin_Date(cin,date);
    }
    @GetMapping("/clocking/{cin}")
    public List<OpClocking> findByCin(@PathVariable("cin") String cin) {
        return service.findByCin(cin);
    }
    @GetMapping("/startup_act/{date}")
    public List<Startup_actDTO> findByDate(@PathVariable("date") String date) {
        return service.findByDate(date);
    }
    @GetMapping("/csc/{date}")
    public List<CIVP__SCV_CSCDTO> findBy_Date(@PathVariable("date") String date) {
        return service.findBy_Date(date);
    }
}
