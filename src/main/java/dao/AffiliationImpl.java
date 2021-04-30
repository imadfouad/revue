package dao;

import java.util.Collection;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Affiliation;
import entities.Auteur;

public class AffiliationImpl implements IAffiliation {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Affiliation ajouterAffiliation(Affiliation affiliation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(affiliation);
		
		return affiliation;
	}

	public void supprimerAffiliation(Affiliation affiliation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(affiliation);
		
	}

	public Affiliation modifierAffiliation(Affiliation affiliation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(affiliation);
		return affiliation;
	}

	public Collection<Affiliation> getAllAffiliation() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Affiliation").list();
	}

	
	public Affiliation findByAffiliation(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Affiliation) session.createQuery("from Affiliation a where a.id = "+id).uniqueResult();
	}

	public void deleteByAffiliation(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Affiliation affiliation = this.findByAffiliation(id);
		session.delete(affiliation);
	}

	

}
