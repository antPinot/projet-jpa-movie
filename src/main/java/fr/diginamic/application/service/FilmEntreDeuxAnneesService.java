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
public class FilmEntreDeuxAnneesService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		FilmDao filmDao = new FilmDao(em);

		System.out.println("Veuillez saisir la première année");
		String saisiePremiereAnnee = scanner.nextLine();
		System.out.println("Veuillez saisir la seconde année");
		String saisieSecondeAnnee = scanner.nextLine();

		// Films sortis entre 2 années données

		List<Film> filmEntreDeuxAnnees = filmDao.getFilmsEntreDeuxAnnees(saisiePremiereAnnee, saisieSecondeAnnee);

		for (Film films : filmEntreDeuxAnnees) {
			System.out.println(films.getNom());
		}

	}

}
