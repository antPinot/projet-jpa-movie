/**
 * 
 */
package fr.diginamic;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import fr.diginamic.entites.Film;

import fr.diginamic.manager.FilmManager;
import fr.diginamic.utils.InternetMovieDatabase;

/**
 * Application qui permet l'insertion en base de données de la totalité des films
 * parsés depuis le fichier JSON
 * 
 * @author antPinot
 *
 */
public class IntegrationApp {

	/**
	 * Méthode main de l'application
	 * Crée un objet InternetMovieDatabase 
	 * 
	 * @param args
	 * @throws IOException
	 * @throws DatabindException
	 * @throws StreamReadException
	 */
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		InternetMovieDatabase imdb = new InternetMovieDatabase();

		FilmManager filmManager = new FilmManager();

		for (Film films : imdb.getFilms()) {
			filmManager.traiteFilm(films);
		}
	}
}
