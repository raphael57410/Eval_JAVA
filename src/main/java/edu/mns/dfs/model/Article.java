package edu.mns.dfs.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.view.*;
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
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(AffichageEmploye.class)
    private String nom;

    @JsonView(AffichageCommande.class)
    private Float prix;

    @ManyToOne
    private Employe gestionnaire;

    @ManyToMany
    @JoinTable(
            name = "caracteristique",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "propriete_id")
    )
    @JsonView(AffichageArticle.class)
    private List<Propriete> listeCaracteristique = new ArrayList<>();

}
