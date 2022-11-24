/**
 * 
 */
package fr.diginamic.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Role;

/**
 * @author antPinot
 *
 */
public class ActeurDao {
	
	public static Acteur getActeurByIdentite(String identite, EntityManager em) {
		TypedQuery<Acteur> queryActeur = em.createQuery("SELECT a FROM Acteur a WHERE a.identite = :param1",
				Acteur.class);
		queryActeur.setParameter("param1", identite);
		List<Acteur> acteursResult = queryActeur.getResultList();
		
		if (acteursResult.size() == 0) {
			return null;
		} else {
			return acteursResult.get(0);
		}
	}
	
	public static void selectOrCreate(Acteur acteur, EntityManager em) {
		Acteur query = getActeurByIdentite(acteur.getIdentite(), em);
		if (query == null) {
			em.persist(acteur);
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

}
