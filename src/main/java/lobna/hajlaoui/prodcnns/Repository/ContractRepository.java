package lobna.hajlaoui.prodcnns.Repository;
import lobna.hajlaoui.prodcnns.Entity.Contract;
import lobna.hajlaoui.prodcnns.DTO.ContractDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Long> {
    @Query("SELECT new lobna.hajlaoui.prodcnns.DTO.ContractDTO(c.cin, c.nom_prenom, c.genre, c.type_contrat, c.date_debut, c.date_fin_prevesionnelle, c.date_fin_reelle, c.situation, c.date_situation, c.matricule, c.numero_affiliation, c.reference_accord, c.date_accord, c.raison_sociale_entreprise, c.nom_etablissement) FROM Contract c WHERE c.cin = :cin AND TO_DATE(c.date_debut,'DD/MM/YYYY')>= TO_DATE(:dateDebut,'DD/MM/YYYY')")
    List<ContractDTO> getByCin_Date(@Param("cin") String cin,@Param("dateDebut") String dateDebut);
    @Query("SELECT sk FROM Contract sk WHERE sk.type_contrat = :typeContrat AND sk.type_contrat !='karama' AND TO_DATE(sk.date_debut,'DD/MM/YYYY')>= TO_DATE(:dateDebut,'DD/MM/YYYY')")
    List<Contract> getByProgramDate(@Param("dateDebut") String dateDebut, @Param("typeContrat") String typeContrat);

}
