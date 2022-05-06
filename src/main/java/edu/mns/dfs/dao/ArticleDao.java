package edu.mns.dfs.dao;

import edu.mns.dfs.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article,Integer> {
}
