/**
 * 
 */
package fr.diginamic.dao;

import java.time.Year;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Film;

/**
 * Classe d'accès à la base de données pour l'object Film
 * 
 * @author antPinot
 *
 */
public class FilmDao {

	/** em EntityManager pour les opérations avec la base de données*/
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public FilmDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode qui recherche un film via son nom
	 * 
	 * @param nom du film
	 * @return le résultat de la requête s'il existe ou null si la requête n'a pas abouti à un résultat
	 */
	public Film getFilmByNom(String nom) {
		TypedQuery<Film> queryFilm = em.createQuery("SELECT f FROM Film f WHERE f.nom = :param1", Film.class);
		queryFilm.setParameter("param1", nom);
		List<Film> filmsResult = queryFilm.getResultList();

		if (filmsResult.size() == 0) {
			return null;
		} else {
			return filmsResult.get(0);
		}
	}

	/**
	 * Méthode qui recherche la filmographie d'un acteur donné
	 * 
	 * @param saisieActeur Acteur saisi par l'utilisateur
	 * @return queryFilmographieResult la filmographie
	 */
	public List<Film> getFilmographie(String saisieActeur) {
		TypedQuery<Film> queryFilmographie = em
				.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite = :saisieActeur", Film.class);
		queryFilmographie.setParameter("saisieActeur", saisieActeur);
		List<Film> queryFilmographieResult = queryFilmographie.getResultList();

		return queryFilmographieResult;
	}

	/**
	 * Méthode qui recherche la liste des films sorties entre deux années données
	 * 
	 * @param saisiePremiereAnnee premiere borne saisie par l'utilisateur
	 * @param saisieSecondeAnnee seconde borne saisie par l'utilisateur
	 * @return queryFilmEntreDeuxAnneesResult liste des films entre deux annees
	 */
	public List<Film> getFilmsEntreDeuxAnnees(String saisiePremiereAnnee, String saisieSecondeAnnee) {
		TypedQuery<Film> queryFilmEntreAnnees = em.createQuery(
				"SELECT f FROM Film f WHERE f.anneeSortie BETWEEN :saisiePremiereAnnee AND :saisieSecondeAnnee",
				Film.class);
		queryFilmEntreAnnees.setParameter("saisiePremiereAnnee", Year.parse(saisiePremiereAnnee));
		queryFilmEntreAnnees.setParameter("saisieSecondeAnnee", Year.parse(saisieSecondeAnnee));
		List<Film> queryFilmEntreDeuxAnneesResult = queryFilmEntreAnnees.getResultList();

		return queryFilmEntreDeuxAnneesResult;
	}
	
	/**
	 * Méthode qui recherche la filmographie d'un acteur entre deux années données
	 * 
	 * @param saisiePremiereAnnee premiere borne saisie par l'utilisateur
	 * @param saisieSecondeAnnee seconde borne saisie par l'utilisateur
	 * @param saisieActeur Acteur saisi par l'utilisateur
	 * @return queryFilmographieAnneeActeur filmographie entre deux années
	 */
	public List<Film> getFilmsEntreDeuxAnneesActeur (String saisiePremiereAnnee, String saisieSecondeAnnee, String saisieActeur){
		TypedQuery<Film> queryFilmEntreAnneesAvecActeur = em.createQuery(
				"SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite = :saisieActeur AND f.anneeSortie BETWEEN :saisiePremiereAnnee AND :saisieSecondeAnnee",
				Film.class);
		queryFilmEntreAnneesAvecActeur.setParameter("saisiePremiereAnnee", Year.parse(saisiePremiereAnnee));
		queryFilmEntreAnneesAvecActeur.setParameter("saisieSecondeAnnee", Year.parse(saisieSecondeAnnee));
		queryFilmEntreAnneesAvecActeur.setParameter("saisieActeur", saisieActeur);
		List<Film> queryFilmographieAnneeActeur = queryFilmEntreAnneesAvecActeur.getResultList();
		
		return queryFilmographieAnneeActeur;
	}

	/**
	 * Gère la persistance du film
	 * 
	 * @param film
	 */
	public void insert(Film film) {
		em.persist(film);
	}

	/**
	 * Getter pour l'attribut em
	 * 
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * Setter pour l'attribut em
	 * 
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
