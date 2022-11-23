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

import fr.diginamic.dao.GenreDao;
import fr.diginamic.dao.PaysDao;
import fr.diginamic.dao.RealisateurDao;
import fr.diginamic.dao.RoleDao;
import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Film;
import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Lieu;
import fr.diginamic.entites.Pays;
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
			
			//Pays p = PaysDao.getPaysByNom(films.getPays().getNom(), em);
			PaysDao.selectOrCreate(films.getPays(), em);
			PaysDao.selectOrCreate(films.getLieuTournage().getPays(), em);
			
			// Recherche du pays d'un Lieu de tournage d'un film
			/*TypedQuery<Pays> queryLieuPays = em.createQuery("SELECT p FROM Pays p WHERE l.pays.nom =: param3",
					Pays.class);
			queryLieuPays.setParameter("param3", films.getLieuTournage().getPays().getNom());
			List<Pays> lieuPaysResult = queryLieuPays.getResultList();

			if (lieuPaysResult.size() == 0) {
				em.persist(films.getLieuTournage().getPays());
			} else {
				films.getLieuTournage().setPays(lieuPaysResult.get(0));
			}*/

			// Recherche du Lieu de tournage d'un film
			
			TypedQuery<Lieu> queryLieu = em.createQuery("SELECT l FROM Lieu l WHERE l.libelle= :param1 AND l.complement= :param2 AND l.pays = :param3", Lieu.class);
			queryLieu.setParameter("param1", films.getLieuTournage().getLibelle());
			queryLieu.setParameter("param2", films.getLieuTournage().getComplement());
			queryLieu.setParameter("param3", films.getLieuTournage().getPays());
			List<Lieu> lieuResult = queryLieu.getResultList();

			if (lieuResult.size() == 0) {

				em.persist(films.getLieuTournage());
			} else {
				films.setLieuTournage(lieuResult.get(0));
			}

			//Set<Role> rolesUpdate = new HashSet<Role>();

			for (Role roles : films.getRoles()) {
				
				/*TypedQuery<Role> queryRole = em.createQuery("SELECT r FROM Role r WHERE r.characterName = :param4",
						Role.class);
				queryRole.setParameter("param4", roles.getCharacterName());
				List<Role> rolesResult = queryRole.getResultList();

				if (rolesResult.size() == 0) {
					em.persist(roles);
				} else {
					rolesUpdate.add(rolesResult.get(0));
				}*/
				
				RoleDao.getRoleByCharacterName(roles.getCharacterName(), em);
			}

			//films.setRoles(rolesUpdate);

			//Set<Genre> genresUpdate = new HashSet<Genre>();

			for (Genre genres : films.getGenres()) {
				/*TypedQuery<Genre> queryGenre = em.createQuery("SELECT g FROM Genre g WHERE g.libelle = :param5",
						Genre.class);
				queryGenre.setParameter("param5", genres.getLibelle());
				List<Genre> genresResult = queryGenre.getResultList();

				if (genresResult.size() == 0) {
					em.persist(genres);
				} else {
					genresUpdate.add(genresResult.get(0));
				}*/
				
				GenreDao.getGenreByLibelle(genres.getLibelle(), em);
			}

			//films.setGenres(genresUpdate);

			//Set<Realisateur> realisateursUpdate = new HashSet<Realisateur>();

			for (Realisateur realisateurs : films.getRealisateurs()) {
				/*TypedQuery<Realisateur> queryRealisateur = em.createQuery(
						"SELECT real FROM Realisateur real WHERE real.identite = :param6", Realisateur.class);
				queryRealisateur.setParameter("param6", realisateurs.getIdentite());
				List<Realisateur> realisateursResult = queryRealisateur.getResultList();

				if (realisateursResult.size() == 0) {
					em.persist(realisateurs);
				} else {
					realisateursUpdate.add(realisateursResult.get(0));
				}*/
				
				RealisateurDao.getRealisateurByIdentite(realisateurs.getIdentite(), em);
			}

			//films.setRealisateurs(realisateursUpdate);

			Set<Acteur> acteursUpdate = new HashSet<Acteur>();

			for (Acteur acteurs : films.getActeurs()) {
				TypedQuery<Acteur> queryActeur = em.createQuery("SELECT a FROM Acteur a WHERE a.identite = :param7",
						Acteur.class);
				queryActeur.setParameter("param7", acteurs.getIdentite());
				List<Acteur> acteursResult = queryActeur.getResultList();
				TypedQuery<Lieu> queryActeurLieu = em
						.createQuery("SELECT a FROM Acteur a WHERE a.lieuNaissance = :param8", Lieu.class);
				queryActeurLieu.setParameter("param8", acteurs.getLieuNaissance());
				List<Lieu> acteursLieuResult = queryActeurLieu.getResultList();
				TypedQuery<Pays> queryActeurPays = em
						.createQuery("SELECT p FROM Pays p WHERE a.lieuNaissance.pays = :param9", Pays.class);
				queryActeur.setParameter("param9", acteurs.getLieuNaissance().getPays());
				List<Pays> acteursPaysResult = queryActeurPays.getResultList();

				if (acteursResult.size() == 0 && acteursLieuResult.size() == 0 && acteursPaysResult.size() == 0) {
					em.persist(acteurs);
					em.persist(acteurs.getLieuNaissance());
					em.persist(acteurs.getLieuNaissance().getPays());
				} else if (acteursResult.size() == 1 && acteursLieuResult.size() == 1
						&& acteursPaysResult.size() == 0) {
					em.persist(acteurs.getLieuNaissance().getPays());
					acteursUpdate.add(acteursResult.get(0));
				}
			}

			/*
			 * if (films.getPays() != null) { em.persist(films.getPays()); }
			 */

			/*for (Acteur acteurs : films.getActeurs()) {
				em.persist(acteurs);
				em.persist(acteurs.getLieuNaissance());
				em.persist(acteurs.getLieuNaissance().getPays());
			}*/

			/*
			 * for (Realisateur realisateurs : films.getRealisateurs()) {
			 * em.persist(realisateurs); }
			 */

			/*
			 * for (Genre genres : films.getGenres()) { em.persist(genres); }
			 */

			/*
			 * for (Role roles : films.getRoles()) { em.persist(roles); }
			 */

			/*
			 * if (films.getLieuTournage() != null) { em.persist(films.getLieuTournage());
			 * em.persist(films.getLieuTournage().getPays()); }
			 */

			em.persist(films);

			transaction.commit();
		}

	}

}
