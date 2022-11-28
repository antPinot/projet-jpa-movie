/**
 * 
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Film;
import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Realisateur;
import fr.diginamic.entites.Role;

/**
 * Classe qui gère la persistance d'un film et de ses attributs en base de données
 * 
 * @author antPinot
 *
 */
public class FilmManager {

	/** em */
	private EntityManager em;
	
	/** filmService */
	private FilmService filmService;

	/** acteurService */
	private ActeurService acteurService;

	/** genreService */
	private GenreService genreService;

	/** lieuService */
	private LieuService lieuService;

	/** paysService */
	private PaysService paysService;

	/** realisateurService */
	private RealisateurService realisateurService;

	/** roleService */
	private RoleService roleService;

	
	/**
	 * Constructeur
	 * 
	 */
	public FilmManager() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-jpa-movie");
		EntityManager em = entityManagerFactory.createEntityManager();

		filmService = new FilmService(em);
		acteurService = new ActeurService(em);
		genreService = new GenreService(em);
		lieuService = new LieuService(em);
		paysService = new PaysService(em);
		realisateurService = new RealisateurService(em);
		roleService = new RoleService(em);

	}

	/**
	 * Méthode de traitement d'un film qui gère la persistance du film et de ses attributs
	 * 
	 * @param film
	 */
	public void traiteFilm(Film film) {

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		RealisateurService.removeDoublonsRealisateurs(film.getRealisateurs());
		ActeurService.removeDoublonsActeur(film.getActeurs());
		GenreService.removeDoublonsGenre(film.getGenres());

		// Persistance du pays de réalisation
		if (film.getPays() != null) {
			paysService.selectOrCreate(film.getPays());
		}

		// Persistance du lieu de tournage
		if (film.getLieuTournage() != null) {
			paysService.selectOrCreate(film.getLieuTournage().getPays());
			lieuService.selectOrCreate(film.getLieuTournage());
		}

		// Persistance des roles
		for (Role roles : film.getRoles()) {

			for (Acteur acteurs : roles.getActeurs()) {
				if (acteurs.getLieuNaissance() != null) {
					paysService.selectOrCreate(acteurs.getLieuNaissance().getPays());
					lieuService.selectOrCreate(acteurs.getLieuNaissance());
				}
				acteurService.selectOrCreate(acteurs);
			}

			roleService.selectOrCreate(roles);

		}

		// Persistance des genres
		for (Genre genres : film.getGenres()) {

			genreService.selectOrCreate(genres);
		}

		for (Realisateur realisateurs : film.getRealisateurs()) {

			realisateurService.selectOrCreate(realisateurs);
		}

		// Persistance des acteurs
		for (Acteur acteurs : film.getActeurs()) {

			paysService.selectOrCreate(acteurs.getLieuNaissance().getPays());
			lieuService.selectOrCreate(acteurs.getLieuNaissance());
			acteurService.selectOrCreate(acteurs);

		}
		
		// Persistance du film
		filmService.selectOrCreate(film);

		transaction.commit();

	}

}
