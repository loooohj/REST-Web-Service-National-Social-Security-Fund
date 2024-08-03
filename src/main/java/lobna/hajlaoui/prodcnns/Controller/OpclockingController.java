package lobna.hajlaoui.prodcnns.Controller;

import lobna.hajlaoui.prodcnns.Entity.OpClocking;
import lobna.hajlaoui.prodcnns.Service.OpclockingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OpclockingController {

    @Autowired
    OpclockingService opclocking_service;
    @GetMapping("/clocking/{cin}")
    public List<OpClocking> findByCin(@PathVariable("cin") String cin) {
        return opclocking_service.findByCin(cin);
    }
    @PostMapping("/store_clocking")
    public OpClocking addClocking(@RequestBody OpClocking clocking) {
        return  opclocking_service.save_clocking(clocking);
    }
}
