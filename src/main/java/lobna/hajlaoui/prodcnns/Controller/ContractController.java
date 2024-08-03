package lobna.hajlaoui.prodcnns.Controller;

import lobna.hajlaoui.prodcnns.DTO.ContractDTO;
import lobna.hajlaoui.prodcnns.Entity.Contract;
import lobna.hajlaoui.prodcnns.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ContractController {
    @Autowired
    ContractService contract_service;
    @GetMapping("/beneficiaries_SaufKarama/{date}/{program}")
    public List<Contract> findByDateProgram(@PathVariable("date") String date, @PathVariable("program") String program) {
        return contract_service.findByDateProgram(date,program);
    }
    @GetMapping("/contracts/{cin}/{date}")
    public List<ContractDTO> findByCin_Date(@PathVariable("date") String date, @PathVariable("cin") String cin) {
        return contract_service.findByCin_Date(cin,date);
    }
    @GetMapping("/allavg")
    public List<Contract> findAll() {
        return contract_service.getAll();
    }
    @PostMapping("/store_beneficiaries_SaufKarama")
    public Contract addSaufKarama(@RequestBody Contract sauf_karama) {
        return  contract_service.save_beneficiaries_SaufKarama(sauf_karama);
    }
}
