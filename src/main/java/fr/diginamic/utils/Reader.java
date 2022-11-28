/**
 * 
 */
package fr.diginamic.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import fr.diginamic.dto.FilmDto;
import fr.diginamic.entites.Film;

/**
 * Classe Reader fournissant des méthodes pour
 * lire et parser le fichier JSON
 * 
 * @author antPinot
 *
 */
public class Reader {

	/**
	 * Méthode statique qui convertit les Dto en entités 
	 * 
	 * @return internetMovieDatabase la liste de films utilisée par l'application de mise en base
	 * @throws StreamReadException
	 * @throws DatabindException
	 * @throws IOException
	 */
	public static List<Film> internetMovieDatabaseGenerator()
			throws StreamReadException, DatabindException, IOException {

		List<Film> internetMovieDatabase = new ArrayList<Film>();

		List<FilmDto> imdbDto = dtoGenerator();

		for (FilmDto film : imdbDto) {
			internetMovieDatabase.add(new Film(film.getIdImdb(), film.getNom(), film.getUrl(), film.getPlot(),
					film.getLangue(), film.getAnneeSortie(), DtoUtils.paysDtoToPays(film.getPays()),
					DtoUtils.lieuDtoToLieu(film.getLieuTournage()), DtoUtils.genreDtoListToGenreList(film.getGenres()),
					DtoUtils.roleDtoListToRoleList(film.getRoles()),
					DtoUtils.acteurDtoListToActeurList(film.getActeurs()),
					DtoUtils.realisateurDtoListToRealisateurList(film.getRealisateurs())));
		}

		return internetMovieDatabase;
	}

	/**
	 * Méthode statique qui lit le fichier JSON et utiliser la dépendance jackson
	 * pour parser le fichier JSON en DTO (Data Transfer Object)
	 * 
	 * @return films La liste de FilmDto
	 * @throws StreamReadException
	 * @throws DatabindException
	 * @throws IOException
	 */
	public static List<FilmDto> dtoGenerator() throws StreamReadException, DatabindException, IOException {

		File fileToParse = new File(
				"C://Users//Saranthony//Documents//Reconversion Professionnelle//Apprentissage Programmation//Diginamic//Projet//17 - PROJET JPA//Projet 1 - Internet Movie Database//films.json");

		ObjectMapper mapper = new ObjectMapper();

		CollectionType collFilm = mapper.getTypeFactory().constructCollectionType(List.class, FilmDto.class);

		List<FilmDto> films = mapper.readValue(fileToParse, collFilm);

		return films;
	}

}
