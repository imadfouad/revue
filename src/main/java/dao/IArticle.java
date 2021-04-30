package dao;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import entities.Article;

@Transactional
public interface IArticle {

	public Article ajouterArticle(Article article);
	public void supprimerArticle(Article article);
	@Modifying(clearAutomatically = true)
	@Transactional
	public Article modifierArticle(Article article);
	public Collection<Article> getAllArticles();
	public Article findById(long id);
	public void deleteById(long id);
}
