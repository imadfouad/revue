package entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component @Entity @Table(name = "comite")
public class Comite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@ManyToMany
	Collection<Auteur> experts = new ArrayList<Auteur>();
	
	@OneToMany
	Collection<Reponse> reponsesReferees = new ArrayList<Reponse>();
	
	
}
