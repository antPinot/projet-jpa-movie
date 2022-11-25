/**
 * 
 */
package fr.diginamic.application.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import fr.diginamic.dao.ActeurDao;
import fr.diginamic.entites.Acteur;

/**
 * @author antPinot
 *
 */
public class CastingService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {

		// Casting d'un film donné
		
		ActeurDao acteurDao = new ActeurDao(em);
		
		System.out.println("Veuillez saisir le film dont vous souhaitez afficher le casting");
		String saisieFilm = scanner.nextLine();

		List<Acteur> casting = acteurDao.getCasting(saisieFilm);

		for (Acteur acteurs : casting) {
			System.out.println(acteurs.getIdentite());
		}

	}

}
