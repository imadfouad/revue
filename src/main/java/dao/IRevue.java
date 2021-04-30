package dao;

import java.util.Collection;

import entities.Revue;

public interface IRevue {
	public Revue ajouterRevue(Revue revue);
	public void supprimerRevue(Revue revue);
	public Revue modifierRevue(Revue revue);
	public Collection<Revue> getAllRevue();
	public Revue findById(long id);
	public void deleteById(long id);

}
