/**
 * 
 */
package fr.diginamic.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * Classe fournissant une méthode de déserialisation d'une String en LocalDate
 * <p> 
 * Note de l'auteur : Vu l'utilité de cette méthode dans ce code, on pourrait la classer
 * dans un package inutils
 * 
 * @author antPinot
 *
 */
@SuppressWarnings("serial")
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

	/**Constructeur
	 * 
	 */
	protected LocalDateDeserializer() {
		super(LocalDate.class);
	}

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String stringDateNaissance = p.readValueAs(String.class);
		return LocalDate.parse(stringDateNaissance, DateTimeFormatter.ofPattern("yyyy/M/dd"));
	}

}
