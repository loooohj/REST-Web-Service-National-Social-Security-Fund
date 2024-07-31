package lobna.hajlaoui.prodcnns.Service;

import lobna.hajlaoui.prodcnns.Entity.Karama;
import lobna.hajlaoui.prodcnns.Repository.KaramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
