package dao;

import java.util.Collection;

import entities.Article;

public interface IArticle {

	public Article ajouterArticle(Article article);
	public void supprimerArticle(Article article);
	public Article modifierArticle(Article article);
	public Collection<Article> getAllArticles();
	public Article findById(long id);
	public void deleteById(long id);
}
