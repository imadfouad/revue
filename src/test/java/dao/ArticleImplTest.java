package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.hibernate.ObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import entities.Article;
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class ArticleImplTest {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	IArticle articleImpl;
	
	@Transactional
	@Test
	public void testAjouterArticle() {
		Article article = new Article();
		article.setContenu("test");
		articleImpl.ajouterArticle(article);
		long id = article.getIdArticle();
		
		assertEquals("test", articleImpl.findById(id).getContenu());

	}
	
	@Test
	public void testSupprimerArticle() {
		Article article = new Article();
		
		articleImpl.ajouterArticle(article);

		long id = article.getIdArticle();

		articleImpl.supprimerArticle(article);
		System.out.print("im supprimer");
		
		boolean check = false;
		
		try{
			articleImpl.findById(id);
		}
		catch(ObjectNotFoundException e)
		{
			check = true;
		}
		finally {
			assertTrue(check);
		}	
		
	}
	/*
	public void testUpdateProduct() {
		    Product product = repo.findByName("iPhone 10");
		    product.setPrice(1000);
		     
		    repo.save(product);
		     
		    Product updatedProduct = repo.findByName("iPhone 10");
		     
		    assertThat(updatedProduct.getPrice()).isEqualTo(1000);
		}
	*/
	@Test
	public void testModifierArticle() {
		Article article = new Article();
		article.setContenu("test 1");
		articleImpl.ajouterArticle(article);

		article.setContenu("test modifie");
		articleImpl.modifierArticle(article);

		long id = article.getIdArticle();
		assertEquals("test modifie",articleImpl.findById(id).getContenu());

		System.out.print("im modif");

		 
	}
	
	@Test
	public void testfindByIdArticle() {
		
		Collection<Article> articles = articleImpl.getAllArticles();
		long idLast=0;
		for(Article a : articles)
		{
			idLast = a.getIdArticle();
		}
		idLast += 1;
		
		Article article = new Article();
		articleImpl.ajouterArticle(article);
		long id = article.getIdArticle();
		assertEquals(idLast, id);
		System.out.print("im testfind");

	}
	
	@Test
	public void testDeleteByIdArticle() {
		
		Article article = new Article();
		articleImpl.ajouterArticle(article);
		long id = article.getIdArticle();
		articleImpl.deleteById(id);
		
		boolean check = false;
		
		try{
			articleImpl.findById(id);
		}
		catch(ObjectNotFoundException e)
		{
			check = true;
		}
		finally {
			assertTrue(check);
		}

	}
	
}
