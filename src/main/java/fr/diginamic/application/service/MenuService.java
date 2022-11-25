/**
 * 
 */
package fr.diginamic.application.service;

import java.util.Scanner;

import javax.persistence.EntityManager;

/**
 * Classe mère représentant un service de recherche en base de données
 * 
 * @author antPinot
 *
 */
public abstract class MenuService {
	
	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les classes filles de service
	 * 
	 * @param scanner
	 * @param em
	 */
	public  abstract void TraitementService(Scanner scanner, EntityManager em);

}
