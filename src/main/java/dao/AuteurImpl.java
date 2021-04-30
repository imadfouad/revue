package dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Auteur;

public class AuteurImpl implements IAuteur {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Auteur ajouterAuteur(Auteur auteur) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(auteur);
		return auteur;
	}

	public void supprimerAuteur(Auteur auteur) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(auteur);
		
	}

	public Auteur modifierAuteur(Auteur auteur) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(auteur);
		return auteur;
	}

	
	public Collection<Auteur> getAllAuteur() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Auteur").list();
	}

	public Auteur findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Auteur) session.createQuery("from Auteur a where a.id = "+id).uniqueResult();
	}

	public void deleteById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Auteur auteur = this.findById(id);
		session.delete(auteur);
	}

}
