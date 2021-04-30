package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component @Entity @Table(name = "reponse")
public class Reponse {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String commentaire;
	private EtatArticle etatRefereeArticle;
	
	@ManyToOne
	private Comite comite;
	
	@ManyToOne
	private Article article;
	
	@ManyToOne
	private Auteur referee;
	
}
