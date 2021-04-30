package dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Reponse;

public class ReponseImpl implements IReponse {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Reponse ajouterReponse(Reponse reponse) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(reponse);
		return reponse;
	}

	public void supprimerReponse(Reponse reponse) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(reponse);
		
	}
	public Reponse modifierReponse(Reponse reponse) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(reponse);
		return reponse;
	}

	public Collection<Reponse> getAllReponse() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Auteur").list();
	}
	public Reponse findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Reponse) session.createQuery("from Auteur a where a.id = "+id).uniqueResult();
	}
	
	public void deleteById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Reponse reponse = this.findById(id);
		session.delete(reponse);
	}


}
