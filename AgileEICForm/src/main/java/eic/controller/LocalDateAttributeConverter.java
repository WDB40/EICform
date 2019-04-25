package eic.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate eventDate) {
		return (eventDate == null ? null : Date.valueOf(eventDate));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		// TODO Auto-generated method stub
		return (date == null ? null : date.toLocalDate());
	}

}
