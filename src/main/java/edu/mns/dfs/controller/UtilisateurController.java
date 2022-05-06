package edu.mns.dfs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.UtilisateurDao;
import edu.mns.dfs.model.Utilisateur;
import edu.mns.dfs.view.AffichageCommande;
import edu.mns.dfs.view.AffichageUtilisateur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {

    UtilisateurDao utilisateurDao;

    public UtilisateurController(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    // retourne le nombre d'utilisateur
    @GetMapping("/compte-utilisateur")
    @JsonView(AffichageUtilisateur.class)
    public int compteUtilisateur() {

        return utilisateurDao.findAll().size();
    }

    @DeleteMapping("/utilisateur/{id}")
    public String supprimeUtilisateur(@PathVariable int id) {

        utilisateurDao.deleteById(id);

        return "OK";
    }
}
