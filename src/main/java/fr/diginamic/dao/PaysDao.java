/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Pays;

/**
 * @author antPinot
 *
 */
public class PaysDao {

	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public PaysDao(EntityManager em) {
		this.em = em;
	}

	public Pays getPaysByNom(String nom) {
		TypedQuery<Pays> queryPays = em.createQuery("SELECT p FROM Pays p WHERE p.nom = :param1", Pays.class);
		queryPays.setParameter("param1", nom);
		List<Pays> paysResult = queryPays.getResultList();

		if (paysResult.size() == 0) {
			return null;
		} else {
			return paysResult.get(0);
		}
	}

	public void insert(Pays pays) {
		em.persist(pays);
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
