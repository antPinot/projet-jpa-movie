package fr.diginamic;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.application.service.ActeursCommunsDeuxFilmsService;
import fr.diginamic.application.service.CastingService;
import fr.diginamic.application.service.FilmEntreDeuxAnneesService;
import fr.diginamic.application.service.FilmographieEntreDeuxAnneesService;
import fr.diginamic.application.service.FilmographieService;
import fr.diginamic.application.service.FilmsCommunsDeuxActeursService;

public class ApplicationRecherche {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-jpa-movie");
		EntityManager em = entityManagerFactory.createEntityManager();

		boolean applicationRuns = true;

		while (applicationRuns) {
			
			afficherMenu();

			String choixMenu = scanner.nextLine();

			int choixInt = Integer.parseInt(choixMenu);

			switch (choixInt) {
			case 1:
				FilmographieService rechercheFilmographie = new FilmographieService();
				rechercheFilmographie.TraitementService(scanner, em);
				break;
			case 2:
				CastingService rechercheCasting = new CastingService();
				rechercheCasting.TraitementService(scanner, em);
				break;
			case 3:
				FilmEntreDeuxAnneesService rechercheFilmAnnees = new FilmEntreDeuxAnneesService();
				rechercheFilmAnnees.TraitementService(scanner, em);
				break;
			case 4:
				FilmsCommunsDeuxActeursService rechercheFilmsCommuns = new FilmsCommunsDeuxActeursService();
				rechercheFilmsCommuns.TraitementService(scanner, em);
				break;
			case 5:
				ActeursCommunsDeuxFilmsService rechercheActeursCommuns = new ActeursCommunsDeuxFilmsService();
				rechercheActeursCommuns.TraitementService(scanner, em);
			case 6:
				FilmographieEntreDeuxAnneesService rechercheFilmographieAnnees = new FilmographieEntreDeuxAnneesService();
				rechercheFilmographieAnnees.TraitementService(scanner, em);
				break;
			case 7:
				System.out.println("Enfin une vraie nuit de sommeil qui se profile, merci cher utilisateur !\nFin d'éxécution");
				applicationRuns = false;
				break;
			default:
				System.out.println(
						"Nous n'avons pas compris votre requête. Merci de choisir une option entre 1 et 6 ou de taper 7 si vous souhaitez sortir");
				break;
			}
		}
	}

	private static void afficherMenu() {
		System.out.println("***** Rechercher une donnée après avoir parsé le pire JSON de l'histoire *****");
		System.out.println("1. Afficher la filmographie d'un acteur donné");
		System.out.println("2. Afficher le casting d'un film donné");
		System.out.println("3. Afficher les films sortis entre deux années données");
		System.out.println("4. Afficher la filmographie commune de deux acteurs donnés");
		System.out.println("5. Afficher le casting commun de deux films donnés");
		System.out.println("6. Afficher la filmographie d'un acteur entre deux années données");
		System.out.println("7. Sortir et laisser le développeur derrière ce code dormir enfin");
	}

}
