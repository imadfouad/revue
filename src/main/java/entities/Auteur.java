package entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
@Component @Entity
public class Auteur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String nom;
	String prenom;
	String email;
	
	@ManyToMany
	Collection<Comite> comites = new ArrayList<Comite>();
	
	@OneToMany(mappedBy = "auteur")
	Collection<Article> articles = new ArrayList<Article>();
	
	@ManyToMany
	Collection<Article> articles_coAuteur = new ArrayList<Article>();
	
	@ManyToMany
	private Collection<Article> etatArticleReferee;

	@OneToMany(mappedBy = "referee")
	private Collection<Reponse> reponsesReferee;
	
	
}
