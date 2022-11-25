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
 * @author antPinot
 *
 */
public class ActeurService {
	
	private ActeurDao acteurDao;

	/**Constructeur
	 * @param acteurDao
	 */
	public ActeurService(EntityManager em) {
		this.acteurDao = new ActeurDao(em);
	}
	
	public void selectOrCreate(Acteur acteur) {
		Acteur query = acteurDao.getActeurByIdentite(acteur.getIdentite());
		if (query == null) {
			acteurDao.insert(acteur);
		} else {
			acteur.setId(query.getId());
		}
	}
	
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
