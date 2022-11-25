/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Genre;

/**
 * @author antPinot
 *
 */
public class GenreDao {

	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public GenreDao(EntityManager em) {
		this.em = em;
	}

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
