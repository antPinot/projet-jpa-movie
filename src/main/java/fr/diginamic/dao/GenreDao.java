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

import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Role;

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
	
	public static void removeDoublonsGenre(Set<Genre> genres) {
		HashMap<String, Genre> gestionDoublons = new HashMap<String, Genre>();
		Set<Genre> doublonsToRemove = new HashSet<Genre>();
		for (Genre genreDoublons : genres) {
			if (gestionDoublons.put(genreDoublons.getLibelle(), genreDoublons) != null) {
				doublonsToRemove.add(genreDoublons);
			}
		}
		genres.removeAll(doublonsToRemove);
	}

}
