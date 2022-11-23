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
import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Film;
import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Realisateur;
import fr.diginamic.entites.Role;

/**
 * @author antPinot
 *
 */
public class Reader {

	public static List<Film> internetMovieDatabaseGenerator() throws StreamReadException, DatabindException, IOException {

		List<Film> internetMovieDatabase = new ArrayList<Film>();

		List<FilmDto> imdbDto = DtoGenerator();

		for (FilmDto film : imdbDto) {
			internetMovieDatabase.add(new Film(film.getIdImdb(), film.getNom(), film.getUrl(), film.getPlot(),
					film.getLangue(), film.getAnneeSortie(), DtoUtils.paysDtoToPays(film.getPays()),
					DtoUtils.lieuDtoToLieu(film.getLieuTournage()), 
					DtoUtils.genreDtoListToGenreList(film.getGenres()),
					DtoUtils.roleDtoListToRoleList(film.getRoles()), 
					DtoUtils.acteurDtoListToActeurList(film.getActeurs()), 
					DtoUtils.realisateurDtoListToRealisateurList(film.getRealisateurs())));
		}

		return internetMovieDatabase;
	}

	public static List<FilmDto> DtoGenerator() throws StreamReadException, DatabindException, IOException {

		File fileToParse = new File(
				"C://Users//Saranthony//Documents//Reconversion Professionnelle//Apprentissage Programmation//Diginamic//Projet//17 - PROJET JPA//Projet 1 - Internet Movie Database//films.json");

		ObjectMapper mapper = new ObjectMapper();

		CollectionType collFilm = mapper.getTypeFactory().constructCollectionType(List.class, FilmDto.class);

		List<FilmDto> films = mapper.readValue(fileToParse, collFilm);

		return films;
	}

}
