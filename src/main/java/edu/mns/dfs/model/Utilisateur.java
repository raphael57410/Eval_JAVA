package edu.mns.dfs.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.view.AffichageCommande;
import edu.mns.dfs.view.AffichageEmploye;
import edu.mns.dfs.view.AffichageUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView({ AffichageEmploye.class,AffichageCommande.class})
    private String login;

    private String password;

    @OneToMany(mappedBy = "client")
    @JsonView(AffichageUtilisateur.class)
    private List<Commande> commande = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "utilisateur_moyen_paiement",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "moyen_paiement_id")
    )
    @JsonView(AffichageUtilisateur.class)
    private List<MoyenPaiement> moyenPaiement = new ArrayList<>();

}
