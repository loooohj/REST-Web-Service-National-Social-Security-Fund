package lobna.hajlaoui.prodcnns.Controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lobna.hajlaoui.prodcnns.DTO.ContractDTO;
import lobna.hajlaoui.prodcnns.Entity.Contract;
import lobna.hajlaoui.prodcnns.Entity.Karama;
import lobna.hajlaoui.prodcnns.Repository.ContractRepository;
import lobna.hajlaoui.prodcnns.Repository.KaramaRepository;
import lobna.hajlaoui.prodcnns.Service.ContractService;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    KaramaRepository karamaRepository;
    @GetMapping("/fetchSaufkaramaData/{date}/{programme}")
    public void fetchStartupData(@PathVariable("date") String date,@PathVariable("programme") String programme) throws Exception {
        String url = "http://10.222.6.3/CNSS/beneficiaire_dt.php?date=" + date + "&programme=" + programme;
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
                Karama contract = new Karama();
                contract.setCin(e.get(0).asText(null));
                contract.setNom_prenom(e.get(1).asText(null));
                contract.setGenre(e.get(2).asText(null));
                contract.setType_contrat(e.get(3).asText(null));
                contract.setDate_debut(e.get(4).asText(null));
                contract.setDate_fin_prevesionnelle(e.get(5).asText(null));
                contract.setDate_fin_reelle(e.get(6).asText(null));
                contract.setSituation(e.get(7).asText(null));
                contract.setDate_situation(e.get(8).asText(null));
                contract.setMatricule(e.get(9).asText(null));
                contract.setNumero_affiliation(e.get(10).asText(null));
                contract.setReference_accord(e.get(11).asText(null));
                contract.setDate_accord(e.get(12).asText(null));
                contract.setRaison_sociale_entreprise(e.get(13).asText(null));
                contract.setNom_etablissement(e.get(14).asText(null));
                if(programme=="KARAMA") {
                    JsonNode regulationsNode = e.get(15);
                    if (regulationsNode != null && regulationsNode.isArray()) {
                        List<String> regulations = new ArrayList<>();
                        Iterator<JsonNode> iterator = regulationsNode.elements();
                        while (iterator.hasNext()) {
                            JsonNode node = iterator.next();
                            regulations.add(node.asText());
                        }
                        contract.setRegulations(regulations);
                    } else {
                        // Handle the case where the node is not an array or is null
                        contract.setRegulations(new ArrayList<>());
                    }

                }
                else
                contractRepository.save(contract);
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse JSON response: " + e.getMessage(), e);
        }
    }
}
