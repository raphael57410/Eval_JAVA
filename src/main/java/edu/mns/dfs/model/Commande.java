package edu.mns.dfs.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.view.AffichageCommande;
import edu.mns.dfs.view.AffichageLigneCommande;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(AffichageCommande.class)
    private Date datePaiement;

    @OneToMany(mappedBy = "commande")
    @JsonView(AffichageCommande.class)
    private List<LigneCommande> listeLigneCommande = new ArrayList<>();

    @ManyToOne
    @JsonView(AffichageCommande.class)
    private Utilisateur client;

}
