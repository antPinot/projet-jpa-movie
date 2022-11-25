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
public class CastingService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		// Casting d'un film donné
		
		System.out.println("Veuillez saisir le film dont vous souhaitez afficher le casting");
		String saisieFilm = scanner.nextLine();

		TypedQuery<Acteur> queryCasting = em.createQuery("SELECT a FROM Acteur a JOIN a.films f WHERE f.nom = :saisieFilm",
				Acteur.class);
		queryCasting.setParameter("saisieFilm", saisieFilm);
		List<Acteur> queryCastingResult = queryCasting.getResultList();

		for (Acteur acteurs : queryCastingResult) {
			System.out.println(acteurs.getIdentite());
		}

	}

}
