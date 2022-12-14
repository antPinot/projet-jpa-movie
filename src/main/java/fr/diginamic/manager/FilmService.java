/**
 * 
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;

import fr.diginamic.dao.FilmDao;
import fr.diginamic.entites.Film;

/**
 * 
 * Classe de service qui fournit des méthodes de traitement des films
 * 
 * @author antPinot
 *
 */
public class FilmService {

	/** filmDao */
	private FilmDao filmDao;

	/**
	 * Constructeur
	 * 
	 * @param filmDao
	 */
	public FilmService(EntityManager em) {
		this.filmDao = new FilmDao(em);
	}

	/**
	 * Méthode qui insère un film s'il n'existe pas en base de données
	 * ou référence le film s'il existe
	 * 
	 * @param film
	 */
	public void selectOrCreate(Film film) {
		Film query = filmDao.getFilmByNom(film.getNom());
		if (query == null) {
			filmDao.insert(film);
		} else {
			film.setId(query.getId());
		}
	}

	/**
	 * Getter pour l'attribut filmDao
	 * 
	 * @return the filmDao
	 */
	public FilmDao getFilmDao() {
		return filmDao;
	}

	/**
	 * Setter pour l'attribut filmDao
	 * 
	 * @param filmDao the filmDao to set
	 */
	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}

}
