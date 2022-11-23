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
	
	public static Genre getGenreByLibelle(String libelle, EntityManager em) {
		TypedQuery<Genre> queryGenre = em.createQuery("SELECT g FROM Genre g WHERE g.libelle = :param1",
				Genre.class);
		queryGenre.setParameter("param1", libelle);
		List<Genre> genresResult = queryGenre.getResultList();
	
	
	if (genresResult.size() == 0) {
		return null;
	} else {
		return genresResult.get(0);
	}
}
	public static void selectOrCreate(Genre genre, EntityManager em) {
		Genre query = getGenreByLibelle(genre.getLibelle(), em);
		if (query == null) {
			em.persist(genre);
		} else {
			genre.setId(query.getId());
		}
	}

}
