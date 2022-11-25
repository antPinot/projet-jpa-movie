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
public class ActeursCommunsDeuxFilmsService extends MenuService {

	@Override
	public void TraitementService(Scanner scanner, EntityManager em) {
		
		ActeurDao acteurDao = new ActeurDao(em);

		System.out.println("Veuillez saisir le premier film");
		String saisiePremierFilm = scanner.nextLine();
		System.out.println("Veuillez saisir le second film");
		String saisieSecondFilm = scanner.nextLine();
		
		List<Acteur> castingPremierFilm = acteurDao.getCasting(saisiePremierFilm);
		List<Acteur> castingSecondFilm = acteurDao.getCasting(saisieSecondFilm);

		for (Acteur acteurs : castingPremierFilm) {
			if (castingSecondFilm.contains(acteurs)) {
				System.out.println(acteurs.getIdentite());
			}
		}

	}

}
