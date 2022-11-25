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
public class FilmographieEntreDeuxAnneesService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		System.out.println("Veuillez saisir la première année");
		String saisiePremiereAnnee = scanner.nextLine();
		System.out.println("Veuillez saisir la seconde année");
		String saisieSecondeAnnee = scanner.nextLine();
		System.out.println(
				"Veuillez saisir l'acteur dont vous souhaitez afficher la filmographie entre les deux années définies");
		String saisieActeur = scanner.nextLine();

		TypedQuery<Film> queryFilmEntreAnneesAvecActeur = em.createQuery(
				"SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite = :saisieActeur AND f.anneeSortie BETWEEN :saisiePremiereAnnee AND :saisieSecondeAnnee",
				Film.class);
		queryFilmEntreAnneesAvecActeur.setParameter("saisiePremiereAnnee", Year.parse(saisiePremiereAnnee));
		queryFilmEntreAnneesAvecActeur.setParameter("saisieSecondeAnnee", Year.parse(saisieSecondeAnnee));
		queryFilmEntreAnneesAvecActeur.setParameter("saisieActeur", saisieActeur);
		List<Film> queryFilmographieAnneeActeur = queryFilmEntreAnneesAvecActeur.getResultList();

		for (Film films : queryFilmographieAnneeActeur) {
			System.out.println(films.getNom());
		}

	}

}
