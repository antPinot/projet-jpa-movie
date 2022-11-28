/**
 * 
 */
package fr.diginamic.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import fr.diginamic.dao.ActeurDao;
import fr.diginamic.entites.Acteur;

/**
 * Classe de service qui fournit des méthodes de traitement des acteurs
 * 
 * @author antPinot
 *
 */
public class ActeurService {
	
	/** acteurDao */
	private ActeurDao acteurDao;

	/**Constructeur
	 * @param acteurDao
	 */
	public ActeurService(EntityManager em) {
		this.acteurDao = new ActeurDao(em);
	}
	
	/**
	 * Méthode qui insère un acteur s'il n'existe pas en base de données
	 * ou référence l'acteur s'il existe
	 * 
	 * @param acteur
	 */
	public void selectOrCreate(Acteur acteur) {
		Acteur query = acteurDao.getActeurByIdentite(acteur.getIdentite());
		if (query == null) {
			acteurDao.insert(acteur);
		} else {
			acteur.setId(query.getId());
		}
	}
	
	/**
	 * Méthode pour supprimer les doublons d'acteurs dans un film
	 * 
	 * @param acteurs
	 */
	public static void removeDoublonsActeur(Set<Acteur> acteurs) {
		HashMap<String, Acteur> gestionDoublons = new HashMap<String, Acteur>();
		Set<Acteur> doublonsToRemove = new HashSet<Acteur>();
		for (Acteur acteurDoublons : acteurs) {
			if (gestionDoublons.put(acteurDoublons.getIdentite(), acteurDoublons) != null) {
				doublonsToRemove.add(acteurDoublons);
			}
		}
		acteurs.removeAll(doublonsToRemove);
	}

	/**Getter pour l'attribut acteurDao
	 * @return the acteurDao
	 */
	public ActeurDao getActeurDao() {
		return acteurDao;
	}

	/**Setter pour l'attribut acteurDao
	 * @param acteurDao the acteurDao to set
	 */
	public void setActeurDao(ActeurDao acteurDao) {
		this.acteurDao = acteurDao;
	}
	

}
