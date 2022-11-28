/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Acteur;

/**
 * Classe d'accès à la base de données pour l'object Acteur
 * 
 * @author antPinot
 *
 */
public class ActeurDao {

	/** em EntityManager pour les opérations avec la base de données*/
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public ActeurDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode qui recherche un acteur via son identité
	 * 
	 * @param identite de l'acteur
	 * @return le résultat de la requête s'il existe ou null si la requête n'a pas abouti à un résultat
	 */
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
	
	/**
	 * Méthode qui recherche le casting principal d'un film donné
	 * 
	 * @param saisieFilm Film saisi par l'utilisateur
	 * @return queryCastingResult le casting principal
	 */
	public List<Acteur> getCasting(String saisieFilm){
		TypedQuery<Acteur> queryCasting = em.createQuery("SELECT a FROM Acteur a JOIN a.films f WHERE f.nom = :saisieFilm",
				Acteur.class);
		queryCasting.setParameter("saisieFilm", saisieFilm);
		List<Acteur> queryCastingResult = queryCasting.getResultList();
		
		return queryCastingResult;
		
	}

	/**
	 * Gère la persistance de l'acteur
	 * 
	 * @param acteur
	 */
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
