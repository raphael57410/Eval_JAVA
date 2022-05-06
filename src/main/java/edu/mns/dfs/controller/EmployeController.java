package edu.mns.dfs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.EmployeDao;
import edu.mns.dfs.model.Employe;
import edu.mns.dfs.view.AffichageEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeController {

    EmployeDao employeDao;

    @Autowired
    public EmployeController(EmployeDao employeDao) {
        this.employeDao = employeDao;
    }

    // retourne un employé par sont id
    @GetMapping("/employe/{id}")
    @JsonView(AffichageEmploye.class)
    public Employe employe(@PathVariable int id) {

        return employeDao.findById(id).orElse(null);
    }

    // retourne la liste des employés
    @GetMapping("/liste-employe")
    @JsonView(AffichageEmploye.class)
    public List<Employe> listEmploye() {

        return employeDao.findAll();
    }

    // retourne la liste des administrateur
    @GetMapping("/compte-administrateur")
    @JsonView(AffichageEmploye.class)
    public int compteAdministrateur() {

        return employeDao.trouveLesAdministrateurs().size();
    }
}

