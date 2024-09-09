package lobna.hajlaoui.prodcnns.Controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lobna.hajlaoui.prodcnns.DTO.Startup_actDTO;
import lobna.hajlaoui.prodcnns.Entity.Startup_act;
import lobna.hajlaoui.prodcnns.Repository.StartupActRepository;
import lobna.hajlaoui.prodcnns.Service.StartupActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.text.StringEscapeUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
@RestController
public class StartupActController {
    @Autowired
    StartupActService startup_act_service;
    @GetMapping("/startup_act/{date}")
    public List<Startup_actDTO> findByDate(@PathVariable("date") String date) {
        return startup_act_service.findByDate(date);
    }
    @PostMapping("/store_startup_act")
    public Startup_act addStartupAct(@RequestBody Startup_act st) {
        return  startup_act_service.save_startup_act(st);
    }
   @Autowired
   private RestTemplate restTemplate;
   @Autowired
   StartupActRepository startup_act_repository;
    @GetMapping("/fetchStartupData/{date}")
    public void fetchStartupData(@PathVariable("date") String date) throws Exception {
        startup_act_repository.deleteAll();
        String url = "http://10.222.6.3/CNSS/exo_startup.php?date=" + date;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String jsonResponse = response.getBody();
        jsonResponse = StringEscapeUtils.unescapeHtml4(jsonResponse);
        System.out.println("Received response: " + jsonResponse.substring(5));
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse.substring(5));
            JsonNode dataset = root.path("dataset");
            AtomicBoolean isHeader = new AtomicBoolean(true);
            dataset.forEach(e -> {
                if (isHeader.get()) {
                    isHeader.set(false);
                    return;
                }
                Startup_act startupAct = new Startup_act();
                startupAct.setAnnee(e.get(0).asText(null));
                startupAct.setNum_exo(e.get(1).asText(null));
                startupAct.setDate_demande(e.get(2).asText(null));
                startupAct.setDate_label(e.get(3).asText(null));
                startupAct.setDate_decision(e.get(4).asText(null));
                startupAct.setDate_creation(e.get(5).asText(null));
                startupAct.setDate_fin_prevesionnelle(e.get(6).asText(null));
                startupAct.setDate_fin_reelle(e.get(7).asText(null));
                startupAct.setSituation(e.get(8).asText(null));
                startupAct.setDate_situation(e.get(9).asText(null));
                startupAct.setMatricule(e.get(10).asText(null));
                startupAct.setNumero_affiliation(e.get(11).asText(null));
                startupAct.setRaison_sociale_entreprise(e.get(12).asText(null));
                startupAct.setNombre_salaries_declares(e.get(13).asText(null));
                startup_act_repository.save(startupAct);
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse JSON response: " + e.getMessage(), e);
        }
    }
}



