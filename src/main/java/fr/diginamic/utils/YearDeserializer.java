package fr.diginamic.utils;

import java.io.IOException;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class YearDeserializer extends StdDeserializer<Year> {
	
	protected YearDeserializer() {
		super(Year.class);
	}
	
	@Override
	public Year deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String stringDate = p.readValueAs(String.class);
		if (stringDate.length() >= 4) {
			StringBuffer stringDateToFormat = new StringBuffer(stringDate);
			StringBuffer stringFormatee = stringDateToFormat.replace(4, (stringDateToFormat.length()-1), "");
			return Year.parse(stringFormatee, DateTimeFormatter.ofPattern("yyyy"));
		}
		return null;
	}

}
