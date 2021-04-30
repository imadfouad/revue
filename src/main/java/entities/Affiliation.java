package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;
import org.springframework.stereotype.Component;

@Component @Entity @javax.persistence.Table(name = "affiliation")
public class Affiliation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
}
