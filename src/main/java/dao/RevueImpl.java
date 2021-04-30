package dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Revue;

public class RevueImpl implements IRevue {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Revue ajouterRevue(Revue revue) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(revue);
		return revue;
	}
	public void supprimerRevue(Revue revue) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(revue);
		
	}
	public Revue modifierRevue(Revue revue) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(revue);
		return revue;
	}

	public Collection<Revue> getAllRevue() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Revue").list();
	}
	public Revue findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Revue) session.createQuery("from Auteur a where a.id = "+id).uniqueResult();
	}
	public void deleteById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Revue revue = this.findById(id);
		session.delete(revue);
	}

	

}
