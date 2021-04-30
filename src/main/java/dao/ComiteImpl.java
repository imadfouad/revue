package dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Comite;

public class ComiteImpl implements IComite {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Comite ajouterComite(Comite comite) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(comite);
		return comite;
	}

	public void supprimerComite(Comite comite) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(comite);
		
	}

	public Comite modifierComite(Comite comite) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(comite);
		return comite;
	}

	public Collection<Comite> getAllComite() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Comite").list();
	}

	public Comite findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Comite) session.createQuery("from Comite a where a.id = "+id).uniqueResult();
	}

	public void deleteById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Comite comite = this.findById(id);
		session.delete(comite);
	}


}
