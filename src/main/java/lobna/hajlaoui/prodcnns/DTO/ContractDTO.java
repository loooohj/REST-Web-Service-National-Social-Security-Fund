package lobna.hajlaoui.prodcnns.DTO;

public record ContractDTO(
         String cin,
         String nom_prenom,
         String genre,
         String type_contrat,
         String date_debut,
         String date_fin_prevesionnelle,
         String date_fin_reelle,
         String situation,
         String date_situation,
         String matricule,
         String numero_affiliation,
         String reference_accord,
         String date_accord,
         String raison_sociale_entreprise,
         String nom_etablissement
        ) {
}
