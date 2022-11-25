/**
 * 
 */
package fr.diginamic.application.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Acteur;

/**
 * @author antPinot
 *
 */
public class ActeursCommunsDeuxFilmsService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		System.out.println("Veuillez saisir le premier film");
		String saisiePremierFilm = scanner.nextLine();
		System.out.println("Veuillez saisir le second film");
		String saisieSecondFilm = scanner.nextLine();

		// Acteurs communs à deux films donnés

		TypedQuery<Acteur> queryActeurFilm1 = em
				.createQuery("SELECT a FROM Acteur a JOIN a.films f WHERE f.nom = :saisie", Acteur.class);
		queryActeurFilm1.setParameter("saisie", saisiePremierFilm);
		List<Acteur> queryActeurFilm1Result = queryActeurFilm1.getResultList();

		TypedQuery<Acteur> queryActeurFilm2 = em
				.createQuery("SELECT a FROM Acteur a JOIN a.films f WHERE f.nom = :saisie", Acteur.class);
		queryActeurFilm2.setParameter("saisie", saisieSecondFilm);
		List<Acteur> queryActeurFilm2Result = queryActeurFilm2.getResultList();

		for (Acteur Acteurs : queryActeurFilm1Result) {
			if (queryActeurFilm2Result.contains(Acteurs)) {
				System.out.println(Acteurs.getIdentite());
			}
		}

	}

}
