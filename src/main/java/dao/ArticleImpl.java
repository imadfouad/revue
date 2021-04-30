package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import entities.Article;

@Transactional 
public class ArticleImpl implements IArticle{
	private static final Logger logger = LoggerFactory.getLogger(Article.class);
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	@Transactional
	public Article ajouterArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(article);
		return article;
	}
	@Transactional(propagation=Propagation.REQUIRED)

	public void modifierArticle(Article article) {
		try 
		{
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(article.getIdArticle()) ; 
		System.out.println(article.getContenu());
		session.update(article);
		session.flush() ; 
		System.out.println("Modified ! ");
		}
		catch ( Exception e)
		{
			System.out.print(e.getMessage()) ; 
		}
		
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Article> getAllArticles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Article> articleList = session.createQuery("from Article").list();
		
		for(Article a : articleList){
			logger.info("Article List::"+a);
		}
		return articleList;
	}

	@Transactional
	public Article findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Article a = (Article) session.load(Article.class, new Long(id));
		return a ; 
	}

	@Transactional
	public void deleteById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Article article = this.findById(id);
		session.remove(article);
	}
	@Transactional
	public void supprimerArticle(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Article a = (Article) session.load(Article.class, new Long(id));
		if(null != a){
			session.delete(a);
		}
		
		session.remove(a);
		
	}

	

	
}
