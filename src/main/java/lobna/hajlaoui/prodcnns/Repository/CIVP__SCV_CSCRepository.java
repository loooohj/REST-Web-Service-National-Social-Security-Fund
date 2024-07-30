package lobna.hajlaoui.prodcnns.Repository;

import lobna.hajlaoui.prodcnns.DTO.CIVP__SCV_CSCDTO;
import lobna.hajlaoui.prodcnns.Model.CIVP__SCV_CSC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CIVP__SCV_CSCRepository extends JpaRepository<CIVP__SCV_CSC,Long> {
    @Query("SELECT new lobna.hajlaoui.prodcnns.DTO.CIVP__SCV_CSCDTO(csc.cin, csc.nom_prenom, csc.genre, csc.type_contrat, csc.date_debut, csc.date_fin_prevesionnelle, csc.date_fin_reelle,csc.matricule, csc.numero_affiliation,csc.raison_sociale_entreprise, csc.nom_etablissement, csc.date_saisi) FROM CIVP__SCV_CSC csc WHERE TO_DATE(csc.date_debut,'DD/MM/YYYY')>= TO_DATE(:date,'DD/MM/YYYY')")
    List<CIVP__SCV_CSCDTO> getBy_Date(@Param("date") String date);
}
