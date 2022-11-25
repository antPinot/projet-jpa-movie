/**
 * 
 */
package fr.diginamic.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import fr.diginamic.dao.GenreDao;
import fr.diginamic.entites.Genre;

/**
 * @author antPinot
 *
 */
public class GenreService {

	private GenreDao genreDao;

	/**
	 * Constructeur
	 * 
	 * @param genreDao
	 */
	public GenreService(EntityManager em) {
		this.genreDao = new GenreDao(em);
	}

	public void selectOrCreate(Genre genre) {
		Genre query = genreDao.getGenreByLibelle(genre.getLibelle());
		if (query == null) {
			genreDao.insert(genre);
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

	/**
	 * Getter pour l'attribut genreDao
	 * 
	 * @return the genreDao
	 */
	public GenreDao getGenreDao() {
		return genreDao;
	}

	/**
	 * Setter pour l'attribut genreDao
	 * 
	 * @param genreDao the genreDao to set
	 */
	public void setGenreDao(GenreDao genreDao) {
		this.genreDao = genreDao;
	}

}
