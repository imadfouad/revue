package dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Article;

public class ArticleImpl implements IArticle{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Article ajouterArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(article);
		return article;
	}

	
	public void supprimerArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(article);
		
	}

	
	public Article modifierArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(article);
		return article;
	}

	
	public Collection<Article> getAllArticles() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Article").list();
	}

	
	public Article findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Article) session.createQuery("from Article a where a.id = "+id).uniqueResult();
	}

	
	public void deleteById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Article article = this.findById(id);
		session.delete(article);
	}

	
}
