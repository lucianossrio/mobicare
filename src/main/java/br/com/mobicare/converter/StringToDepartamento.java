package br.com.mobicare.converter;

import org.springframework.core.convert.converter.Converter;

import br.com.mobicare.modelo.Departamento;

final class StringToDepartamento implements Converter<String, Departamento>{

	public Departamento convert(String id) {
		Departamento departamento = new Departamento();
		departamento.setId(Integer.valueOf(id));
		return departamento;
	}

}