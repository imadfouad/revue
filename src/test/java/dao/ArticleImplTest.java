package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entities.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springContext.xml"})
public class ArticleImplTest {

	@Autowired
	IArticle articleImpl;
	
	
	@Test
	public void testAjouterArticle() {
		Article article = new Article();
		article.setContenu("test");
		articleImpl.ajouterArticle(article);
		long id = article.getIdArticle();
		assertEquals("test", articleImpl.findById(id).getContenu());
	}
	/*
	@Test
	public void testSupprimerArticle() {
		Article article = new Article();
		articleImpl.ajouterArticle(article);
		long id = article.getIdArticle();
		articleImpl.supprimerArticle(article);	
		assertNull(articleImpl.findById(id));
	}
	
	@Test
	public void testModifierArticle() {
		Article article = new Article();
		article.setContenu("test");
		articleImpl.ajouterArticle(article);
		long id = article.getIdArticle();
		article.setContenu("test modifie");
		articleImpl.modifierArticle(article);
		assertEquals("test modifie",articleImpl.findById(id).getContenu());
	}
	
	@Test
	public void testfindByIdArticle() {
		
		Collection<Article> articles = articleImpl.getAllArticles();
		long idLast=0;
		for(Article a : articles)
		{
			idLast = a.getIdArticle();
		}
		idLast += idLast;
		
		Article article = new Article();
		articleImpl.ajouterArticle(article);
		long id = article.getIdArticle();
		assertEquals(idLast, id);
	}
	
	@Test
	public void testDeleteByIdArticle() {
		Article article = new Article();
		articleImpl.ajouterArticle(article);
		long id = article.getIdArticle();
		articleImpl.deleteById(id);
		assertNull(articleImpl.findById(id));
	}
*/	
}
