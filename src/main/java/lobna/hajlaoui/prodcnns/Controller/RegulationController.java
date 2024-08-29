/*package lobna.hajlaoui.prodcnns.Controller;

import lobna.hajlaoui.prodcnns.Entity.Regulation;
import lobna.hajlaoui.prodcnns.Service.RegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegulationController {
    @Autowired
    RegulationService regulation_service;
    @PostMapping("/store_regulation")
    public Regulation addRegulation(@RequestBody Regulation re) {
        return  regulation_service.save_regulation(re);
    }
}*/
