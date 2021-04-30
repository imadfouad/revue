package dao;

import java.util.Collection;

import entities.Comite;


public interface IComite {
	public Comite ajouterComite(Comite comite);
	public void supprimerComite(Comite comite);
	public Comite modifierComite(Comite comite);
	public Collection<Comite> getAllComite();
	public Comite findById(long id);
	public void deleteById(long id);

}
