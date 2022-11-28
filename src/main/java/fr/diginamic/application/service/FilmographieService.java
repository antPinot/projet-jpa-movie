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
 * Classe qui utilise un FilmDao pour rechercher
 * la filmographie entre deux années d'un acteur
 * 
 * @author antPinot
 *
 */
public class FilmographieService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		// Filmographie d'un acteur donné
		
		FilmDao filmDao = new FilmDao(em);
		
		System.out.println("Veuillez saisir l'acteur dont vous souhaitez afficher la filmographie");
		String saisieActeur = scanner.nextLine();

		List<Film> filmographie = filmDao.getFilmographie(saisieActeur);

		for (Film films : filmographie) {
			System.out.println(films.getNom());
		}

	}

}
