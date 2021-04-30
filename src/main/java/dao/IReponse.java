package dao;

import java.util.Collection;

import entities.Reponse;

public interface IReponse {
	public Reponse ajouterReponse(Reponse reponse);
	public void supprimerReponse(Reponse reponse);
	public Reponse modifierReponse(Reponse reponse);
	public Collection<Reponse> getAllReponse();
	public Reponse findById(long id);
	public void deleteById(long id);

}
