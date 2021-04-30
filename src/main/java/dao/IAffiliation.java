package dao;

import java.util.Collection;

import entities.Affiliation;


public interface IAffiliation {
	
	public Affiliation ajouterAffiliation(Affiliation affiliation);
	public void supprimerAffiliation(Affiliation affilation);
	public Affiliation modifierAffiliation(Affiliation affilation);
	public Collection<Affiliation> getAllAffiliation();
	public Affiliation findByAffiliation(long id);
	public void deleteByAffiliation(long id);
}
