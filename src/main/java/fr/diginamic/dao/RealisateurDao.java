/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Realisateur;

/**
 * @author antPinot
 *
 */
public class RealisateurDao {

	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public RealisateurDao(EntityManager em) {
		this.em = em;
	}

	public Realisateur getRealisateurByIdentite(String identite) {
		TypedQuery<Realisateur> queryRealisateur = em
				.createQuery("SELECT real FROM Realisateur real WHERE real.identite = :param1", Realisateur.class);
		queryRealisateur.setParameter("param1", identite);
		List<Realisateur> realisateursResult = queryRealisateur.getResultList();

		if (realisateursResult.size() == 0) {
			return null;
		} else {
			return realisateursResult.get(0);
		}
	}
	
	public void insert (Realisateur realisateur) {
		em.persist(realisateur);
	}

	/**
	 * Getter pour l'attribut em
	 * 
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * Setter pour l'attribut em
	 * 
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
