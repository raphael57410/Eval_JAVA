package edu.mns.dfs.dao;

import edu.mns.dfs.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Integer> {
}
