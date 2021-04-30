package dao;

import java.util.Collection;

import entities.Auteur;


public interface IAuteur {
	public Auteur ajouterAuteur(Auteur auteur);
	public void supprimerAuteur(Auteur auteur);
	public Auteur modifierAuteur(Auteur auteur);
	public Collection<Auteur> getAllAuteur();
	public Auteur findById(long id);
	public void deleteById(long id);

}
