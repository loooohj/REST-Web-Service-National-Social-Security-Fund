package lobna.hajlaoui.prodcnns.Service;

import lobna.hajlaoui.prodcnns.DTO.KaramaDTO;
import lobna.hajlaoui.prodcnns.Entity.Karama;
import lobna.hajlaoui.prodcnns.Repository.KaramaRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Data


@Service
public class KaramaService {
    @Autowired
    KaramaRepository karama_repository;
    public List<Karama> findByDate_Program(String date){
        return karama_repository.getByProgram_Date(date);
    }
    public Karama save_beneficiaries_Karama(Karama ka){
        return karama_repository.save(ka);
    }
    private static String BASE_Karama_URL = "http://10.222.6.3/CNSS/beneficiaire_dt.php";
    @Autowired
    public KaramaService(RestTemplate restTemplate) {
        this.restTemplate1 = restTemplate;
    }

    private RestTemplate restTemplate1;
    public List<KaramaDTO> getByDate_Program(String date, String program){
            ResponseEntity<List> result = restTemplate1.getForEntity(BASE_Karama_URL + "?date=" + date+ "&programme=" + program, List.class);
            return result.getBody();
    }
}
