/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Pays;

/**
 * Classe d'accès à la base de données pour l'object Lieu
 * 
 * @author antPinot
 *
 */
public class PaysDao {

	/** em EntityManager pour les opérations avec la base de données*/
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public PaysDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode qui recherche un pays par son nom
	 * 
	 * @param nom
	 * @return le résultat de la requête s'il existe ou null si la requête n'a pas abouti à un résultat
	 */
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

	/**
	 * Gère la persistance du pays
	 * 
	 * @param pays
	 */
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
