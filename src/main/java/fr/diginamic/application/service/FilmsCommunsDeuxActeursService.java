/**
 * 
 */
package fr.diginamic.application.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Film;

/**
 * @author antPinot
 *
 */
public class FilmsCommunsDeuxActeursService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		System.out.println("Veuillez saisir le premier acteur");
		String saisiePremierActeur = scanner.nextLine();
		System.out.println("Veuillez saisir le second acteur");
		String saisieSecondActeur = scanner.nextLine();

		// Films communs à deux acteurs donnés

		TypedQuery<Film> queryFilmographieActeur1 = em
				.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite = :saisie", Film.class);
		queryFilmographieActeur1.setParameter("saisie", saisiePremierActeur);
		List<Film> queryFilmographieActeur1Result = queryFilmographieActeur1.getResultList();

		TypedQuery<Film> queryFilmographieActeur2 = em
				.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite = :saisie", Film.class);
		queryFilmographieActeur2.setParameter("saisie", saisieSecondActeur);
		List<Film> queryFilmographieActeur2Result = queryFilmographieActeur2.getResultList();

		for (Film films : queryFilmographieActeur1Result) {
			if (queryFilmographieActeur2Result.contains(films)) {
				System.out.println(films.getNom());
			}
		}

	}

}
