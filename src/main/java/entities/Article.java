package entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component @Entity @Table(name = "article")
public class Article {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idArticle;
	
	private String titreArticle;
	
	@ManyToOne
	private Auteur auteur;
	
	@ManyToMany
	private Collection<Auteur> coAuteurs;
	
	/*@CollectionTable(name="keywords")
	private Collection<String> keywords = new ArrayList<String>();*/
	
	private String resume;

	@Enumerated(EnumType.STRING)
	private EtatArticle etatArticleFinal;
	
		
	private String contenu;

	@OneToMany
	private Collection<Affiliation> affiliations;
	
	@OneToMany(mappedBy = "article")
	private Collection<Reponse> reponsesReferees;

	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	public String getTitreArticle() {
		return titreArticle;
	}

	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Collection<Auteur> getCoAuteurs() {
		return coAuteurs;
	}

	public void setCoAuteurs(Collection<Auteur> coAuteurs) {
		this.coAuteurs = coAuteurs;
	}

	/*public Collection<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(Collection<String> keywords) {
		this.keywords = keywords;
	}*/

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public EtatArticle getEtatArticleFinal() {
		return etatArticleFinal;
	}

	public void setEtatArticleFinal(EtatArticle etatArticleFinal) {
		this.etatArticleFinal = etatArticleFinal;
	}


	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Collection<Affiliation> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(Collection<Affiliation> affiliations) {
		this.affiliations = affiliations;
	}

	public Collection<Reponse> getReponsesReferees() {
		return reponsesReferees;
	}

	public void setReponsesReferees(Collection<Reponse> reponsesReferees) {
		this.reponsesReferees = reponsesReferees;
	}
	
	
	
}
