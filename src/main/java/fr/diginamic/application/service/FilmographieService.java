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
public class FilmographieService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		// Filmographie d'un acteur donné
		
		System.out.println("Veuillez saisir l'acteur dont vous souhaitez afficher la filmographie");
		String saisieActeur = scanner.nextLine();

		TypedQuery<Film> queryFilmographie = em
				.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite = :saisieActeur", Film.class);
		queryFilmographie.setParameter("saisieActeur", saisieActeur);
		List<Film> queryFilmographieResult = queryFilmographie.getResultList();

		for (Film films : queryFilmographieResult) {
			System.out.println(films.getNom());
		}

	}

}
