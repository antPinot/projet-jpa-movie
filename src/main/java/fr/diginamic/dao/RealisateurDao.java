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

import fr.diginamic.entites.Realisateur;
import fr.diginamic.entites.Role;

/**
 * @author antPinot
 *
 */
public class RealisateurDao {
	
	public static Realisateur getRealisateurByIdentite(String identite, EntityManager em) {
		TypedQuery<Realisateur> queryRealisateur = em.createQuery("SELECT real FROM Realisateur real WHERE real.identite = :param1",
				Realisateur.class);
		queryRealisateur.setParameter("param1", identite);
		List<Realisateur> realisateursResult = queryRealisateur.getResultList();
	
	
	if (realisateursResult.size() == 0) {
		return null;
	} else {
		return realisateursResult.get(0);
	}
}
	public static void selectOrCreate(Realisateur realisateur, EntityManager em) {
		Realisateur query = getRealisateurByIdentite(realisateur.getIdentite(), em);
		if (query == null) {
			em.persist(realisateur);
		} else {
			realisateur.setId(query.getId());
		}
	}
	
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

}
