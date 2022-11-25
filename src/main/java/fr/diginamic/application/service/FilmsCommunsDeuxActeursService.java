/**
 * 
 */
package fr.diginamic.application.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import fr.diginamic.dao.FilmDao;
import fr.diginamic.entites.Film;

/**
 * @author antPinot
 *
 */
public class FilmsCommunsDeuxActeursService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		FilmDao filmDao = new FilmDao(em);

		System.out.println("Veuillez saisir le premier acteur");
		String saisiePremierActeur = scanner.nextLine();
		System.out.println("Veuillez saisir le second acteur");
		String saisieSecondActeur = scanner.nextLine();

		// Films communs à deux acteurs donnés

		List<Film> filmographiePremierActeur = filmDao.getFilmographie(saisiePremierActeur);
		List<Film> filmographieSecondActeur = filmDao.getFilmographie(saisieSecondActeur);

		for (Film films : filmographiePremierActeur) {
			if (filmographieSecondActeur.contains(films)) {
				System.out.println(films.getNom());
			}
		}

	}

}
