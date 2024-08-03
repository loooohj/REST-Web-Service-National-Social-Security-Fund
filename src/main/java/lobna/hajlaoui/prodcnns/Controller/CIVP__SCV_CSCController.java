package lobna.hajlaoui.prodcnns.Controller;
import lobna.hajlaoui.prodcnns.DTO.CIVP__SCV_CSCDTO;
import lobna.hajlaoui.prodcnns.Entity.CIVP__SCV_CSC;
import lobna.hajlaoui.prodcnns.Service.CIVP__SCV_CSCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CIVP__SCV_CSCController {
    @Autowired
    CIVP__SCV_CSCService civp__scv_csc_service;
    @GetMapping("/csc/{date}")
    public List<CIVP__SCV_CSCDTO> findBy_Date(@PathVariable("date") String date) {
        return civp__scv_csc_service.findBy_Date(date);
    }
    @PostMapping("/store_civp__scv_csc")
    public CIVP__SCV_CSC addCivp__scv_csc(@RequestBody CIVP__SCV_CSC csc) {
        return  civp__scv_csc_service.save_civp__scv_csc(csc);
    }
}
