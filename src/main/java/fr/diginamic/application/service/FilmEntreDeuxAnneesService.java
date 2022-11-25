/**
 * 
 */
package fr.diginamic.application.service;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Film;

/**
 * @author antPinot
 *
 */
public class FilmEntreDeuxAnneesService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		System.out.println("Veuillez saisir la première année");
		String saisiePremiereAnnee = scanner.nextLine();
		System.out.println("Veuillez saisir la seconde année");
		String saisieSecondeAnnee = scanner.nextLine();

		// Films sortis entre 2 années données

		TypedQuery<Film> queryFilmEntreAnnees = em
				.createQuery("SELECT f FROM Film f WHERE f.anneeSortie BETWEEN :saisiePremiereAnnee AND :saisieSecondeAnnee", Film.class);
		queryFilmEntreAnnees.setParameter("saisiePremiereAnnee", Year.parse(saisiePremiereAnnee));
		queryFilmEntreAnnees.setParameter("saisieSecondeAnnee", Year.parse(saisieSecondeAnnee));
		List<Film> queryFilmographieResult = queryFilmEntreAnnees.getResultList();

		for (Film films : queryFilmographieResult) {
			System.out.println(films.getNom());
		}

	}

}
