package lobna.hajlaoui.prodcnns.Service;

import lobna.hajlaoui.prodcnns.DTO.CIVP__SCV_CSCDTO;
import lobna.hajlaoui.prodcnns.Entity.*;
import lobna.hajlaoui.prodcnns.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CIVP__SCV_CSCService {
    @Autowired
    CIVP__SCV_CSCRepository civp__scv_csc_repository;
    public CIVP__SCV_CSC save_civp__scv_csc(CIVP__SCV_CSC csc){
        return civp__scv_csc_repository.save(csc);

    }
    public List<CIVP__SCV_CSCDTO> findBy_Date(String date){
        return civp__scv_csc_repository.getBy_Date(date);
    }


}
