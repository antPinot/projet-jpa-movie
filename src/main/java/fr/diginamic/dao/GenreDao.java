/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Genre;

/**
 * Classe d'accès à la base de données pour l'object Genre
 * 
 * @author antPinot
 *
 */
public class GenreDao {

	/** em EntityManager pour les opérations avec la base de données*/
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public GenreDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode qui recherche un genre via son libellé
	 * 
	 * @param libellé du genre
	 * @return le résultat de la requête s'il existe ou null si la requête n'a pas abouti à un résultat
	 */
	public Genre getGenreByLibelle(String libelle) {
		TypedQuery<Genre> queryGenre = em.createQuery("SELECT g FROM Genre g WHERE g.libelle = :param1", Genre.class);
		queryGenre.setParameter("param1", libelle);
		List<Genre> genresResult = queryGenre.getResultList();

		if (genresResult.size() == 0) {
			return null;
		} else {
			return genresResult.get(0);
		}
	}

	/**
	 * Gère la persistence du genre
	 * 
	 * @param genre
	 */
	public void insert(Genre genre) {
		em.persist(genre);
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
