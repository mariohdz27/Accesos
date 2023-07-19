package com.unchesquito.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class Utilidades {

	public List<String> getErrors(BindingResult result) {

		List<String> array = new ArrayList<>();

		for (FieldError lstErrors : result.getFieldErrors()) {


				array.add(lstErrors.getDefaultMessage());
			

		}
		return array;
	}

	public Date stringToDate(String dateString) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.parse(dateString);

	}
}
