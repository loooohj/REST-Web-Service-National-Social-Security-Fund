package lobna.hajlaoui.prodcnns.Controller;

import lobna.hajlaoui.prodcnns.Entity.Karama;
import lobna.hajlaoui.prodcnns.Service.KaramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class KaramaController {
    @Autowired
    KaramaService karama_service;
    @GetMapping("/beneficiaries_Karama/{date}/{program}")
    public List<Karama> findByDate_Program(@PathVariable("date") String date) {
        return karama_service.findByDate_Program(date);
    }
    @PostMapping("/store_Karama")
    public Karama addKarama(@RequestBody Karama karama) {
        return  karama_service.save_beneficiaries_Karama(karama);
    }
    @GetMapping("/karama/{date}/{program}")
    public ResponseEntity<?> getByDate_Program(@PathVariable("date") String date,@PathVariable("program") String program) {

        return ResponseEntity.ok(karama_service.getByDate_Program(date,program));
    }
}
