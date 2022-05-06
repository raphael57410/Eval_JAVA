package edu.mns.dfs.controller;

import edu.mns.dfs.dao.ArticleDao;
import edu.mns.dfs.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AticleController {

    ArticleDao articleDao;

    @Autowired
    public AticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    // ajout d'un article
    @PostMapping("/article")
    public String ajoutArticle(@RequestBody Article article) {

        articleDao.save(article);

        return "Article ajouté !";
    }
}
