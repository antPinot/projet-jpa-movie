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
 * 
 * Classe de service qui fournit des méthodes de traitement des genres
 * 
 * @author antPinot
 *
 */
public class GenreService {

	/** genreDao */
	private GenreDao genreDao;

	/**
	 * Constructeur
	 * 
	 * @param genreDao
	 */
	public GenreService(EntityManager em) {
		this.genreDao = new GenreDao(em);
	}

	/**
	 * Méthode qui insère un genre s'il n'existe pas en base de données
	 * ou référence le genre s'il existe
	 * 
	 * @param genre
	 */
	public void selectOrCreate(Genre genre) {
		Genre query = genreDao.getGenreByLibelle(genre.getLibelle());
		if (query == null) {
			genreDao.insert(genre);
		} else {
			genre.setId(query.getId());
		}
	}

	/**
	 * Méthode pour supprimer les doublons de genres dans un film
	 * 
	 * @param genres
	 */
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
