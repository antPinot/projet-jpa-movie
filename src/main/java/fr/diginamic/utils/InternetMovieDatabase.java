/**
 * 
 */
package fr.diginamic.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import fr.diginamic.entites.Film;

/**
 * Représente la base de données imdb déserialisée depuis le fichier json
 * 
 * @author antPinot
 *
 */
public class InternetMovieDatabase {

	/** liste de tous les films déserialisés depuis le fichier json imdb */
	private List<Film> films = new ArrayList<Film>();

	/**
	 * Constructeur utilisant la méthode statique internetMovieDatabaseGenerator de la 
	 * classe Reader pour construire la liste de films
	 * 
	 * @param films
	 * @throws IOException
	 * @throws DatabindException
	 * @throws StreamReadException
	 */
	public InternetMovieDatabase() throws StreamReadException, DatabindException, IOException {
		this.films = Reader.internetMovieDatabaseGenerator();
	}

	/**
	 * Getter pour l'attribut films
	 * 
	 * @return the films
	 */
	public List<Film> getFilms() {
		return films;
	}

	/**
	 * Setter pour l'attribut films
	 * 
	 * @param films the films to set
	 */
	public void setFilms(List<Film> films) {
		this.films = films;
	}

}
