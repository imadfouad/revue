package entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component @Entity
public class Revue {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@OneToMany
	Collection<Article> articles = new ArrayList<Article>();
	
}
