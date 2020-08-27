package com.expedientes.expedientes.exceptios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpedientesExceptions extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private final String statusCode;

	public ExpedientesExceptions(String message, String statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

}
