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
public class FilmographieEntreDeuxAnneesService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		FilmDao filmDao = new FilmDao(em);

		System.out.println("Veuillez saisir la première année");
		String saisiePremiereAnnee = scanner.nextLine();
		System.out.println("Veuillez saisir la seconde année");
		String saisieSecondeAnnee = scanner.nextLine();
		System.out.println(
				"Veuillez saisir l'acteur dont vous souhaitez afficher la filmographie entre les deux années définies");
		String saisieActeur = scanner.nextLine();

		List<Film> filmographieEntreDeuxAnnees = filmDao.getFilmsEntreDeuxAnneesActeur(saisiePremiereAnnee,
				saisieSecondeAnnee, saisieActeur);

		for (Film films : filmographieEntreDeuxAnnees) {
			System.out.println(films.getNom());
		}

	}

}
