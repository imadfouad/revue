package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component @Entity
public class Affiliation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
}
