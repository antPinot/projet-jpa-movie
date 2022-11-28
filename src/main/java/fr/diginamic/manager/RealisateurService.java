/**
 * 
 */
package fr.diginamic.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import fr.diginamic.dao.RealisateurDao;
import fr.diginamic.entites.Realisateur;

/**
 * Classe de service qui fournit des méthodes de traitement des réalisateurs
 * 
 * @author antPinot
 *
 */
public class RealisateurService {

	/** realisateurDao */
	private RealisateurDao realisateurDao;

	/**
	 * Constructeur
	 * 
	 * @param realisateurDao
	 */
	public RealisateurService(EntityManager em) {
		this.realisateurDao = new RealisateurDao(em);
	}

	/**
	 * Méthode qui insère un réalisateur s'il n'existe pas en base de données
	 * ou référence le réalisateur s'il existe
	 * 
	 * @param realisateur
	 */
	public void selectOrCreate(Realisateur realisateur) {
		Realisateur query = realisateurDao.getRealisateurByIdentite(realisateur.getIdentite());
		if (query == null) {
			realisateurDao.insert(realisateur);
		} else {
			realisateur.setId(query.getId());
		}
	}

	/**
	 * Méthode pour supprimer les doublons de réalisateurs dans un film
	 * 
	 * @param realisateurs
	 */
	public static void removeDoublonsRealisateurs(Set<Realisateur> realisateurs) {
		HashMap<String, Realisateur> gestionDoublons = new HashMap<String, Realisateur>();
		Set<Realisateur> doublonsToRemove = new HashSet<Realisateur>();
		for (Realisateur realisaeurDoublons : realisateurs) {
			if (gestionDoublons.put(realisaeurDoublons.getIdentite(), realisaeurDoublons) != null) {
				doublonsToRemove.add(realisaeurDoublons);
			}
		}
		realisateurs.removeAll(doublonsToRemove);
	}

	/**
	 * Getter pour l'attribut realisateurDao
	 * 
	 * @return the realisateurDao
	 */
	public RealisateurDao getRealisateurDao() {
		return realisateurDao;
	}

	/**
	 * Setter pour l'attribut realisateurDao
	 * 
	 * @param realisateurDao the realisateurDao to set
	 */
	public void setRealisateurDao(RealisateurDao realisateurDao) {
		this.realisateurDao = realisateurDao;
	}

}
