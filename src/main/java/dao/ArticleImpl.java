package dao;

import java.util.Collection;

import javax.persistence.PersistenceContext;

import org.hibernate.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import entities.Article;

@Transactional 
public class ArticleImpl implements IArticle{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Article ajouterArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(article);
		return article;
	}

	//@Transactional 
	public void supprimerArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		/*Query query = session.createQuery("delete from Article a where a.idArticle = :id");
		query.setParameter("id", article.getIdArticle());
		query.executeUpdate();*/
		session.remove(article);
		
	}

	//@Transactional
	public Article modifierArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(article);
		
		System.out.println("hahya "+findById(article.getIdArticle()).getContenu());
		
		return article;
	}

	
	public Collection<Article> getAllArticles() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Article").list();
	}

	
	public Article findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Article) session.createQuery("from Article a where a.idArticle = "+id).uniqueResult();
	}

	
	public void deleteById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Article article = this.findById(id);
		session.remove(article);
	}

	
}
