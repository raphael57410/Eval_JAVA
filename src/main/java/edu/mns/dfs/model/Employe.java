package edu.mns.dfs.model;

import com.fasterxml.jackson.annotation.JsonView;
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
public class Employe extends Utilisateur{

    @JsonView(AffichageEmploye.class)
    private Boolean administrateur;

    @OneToMany(mappedBy = "gestionnaire")
    @JsonView(AffichageEmploye.class)
    private List<Article> listArticleAgerer = new ArrayList<>();
}
