/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Acteur;

/**
 * @author antPinot
 *
 */
public class ActeurDao {

	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public ActeurDao(EntityManager em) {
		this.em = em;
	}

	public Acteur getActeurByIdentite(String identite) {
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

	public void insert(Acteur acteur) {
		em.persist(acteur);
	}

	/**Getter pour l'attribut em
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**Setter pour l'attribut em
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	

}
