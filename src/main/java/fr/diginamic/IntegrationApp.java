/**
 * 
 */
package fr.diginamic;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import fr.diginamic.dao.ActeurDao;
import fr.diginamic.dao.GenreDao;
import fr.diginamic.dao.LieuDao;
import fr.diginamic.dao.PaysDao;
import fr.diginamic.dao.RealisateurDao;
import fr.diginamic.dao.RoleDao;
import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Film;
import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Realisateur;
import fr.diginamic.entites.Role;
import fr.diginamic.utils.InternetMovieDatabase;

/**
 * @author antPinot
 *
 */
public class IntegrationApp {

	/**
	 * @param args
	 * @throws IOException
	 * @throws DatabindException
	 * @throws StreamReadException
	 */
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		InternetMovieDatabase imdb = new InternetMovieDatabase();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-jpa-movie");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		for (Film films : imdb.getFilms()) {
			transaction.begin();

			// RoleDao.removeDoublonsRole(films.getRoles());
			RealisateurDao.removeDoublonsRealisateurs(films.getRealisateurs());
			ActeurDao.removeDoublonsActeur(films.getActeurs());
			GenreDao.removeDoublonsGenre(films.getGenres());

			if (films.getPays() != null) {
				PaysDao.selectOrCreate(films.getPays(), em);
			}
			if (films.getLieuTournage() != null) {
				PaysDao.selectOrCreate(films.getLieuTournage().getPays(), em);
				LieuDao.selectOrCreate(films.getLieuTournage(), em);
			}

			// Persistance des roles
			for (Role roles : films.getRoles()) {

				for (Acteur acteurs : roles.getActeurs()) {
					if (acteurs.getLieuNaissance() != null) {
						PaysDao.selectOrCreate(acteurs.getLieuNaissance().getPays(), em);
						LieuDao.selectOrCreate(acteurs.getLieuNaissance(), em);
					}		
					ActeurDao.selectOrCreate(acteurs, em);
				}

				RoleDao.selectOrCreate(roles, em);

			}

			for (Genre genres : films.getGenres()) {

				GenreDao.selectOrCreate(genres, em);
			}

			for (Realisateur realisateurs : films.getRealisateurs()) {

				RealisateurDao.selectOrCreate(realisateurs, em);
			}

			// Persistance des acteurs
			for (Acteur acteurs : films.getActeurs()) {

				PaysDao.selectOrCreate(acteurs.getLieuNaissance().getPays(), em);
				LieuDao.selectOrCreate(acteurs.getLieuNaissance(), em);
				ActeurDao.selectOrCreate(acteurs, em);

			}
			em.persist(films);

			transaction.commit();
		}

	}

}
