package com.expedientes.expedientes.util;

import com.expedientes.expedientes.exceptios.ExpedientesExceptions;
import com.expedientes.expedientes.model.Response;

public class ExpedientesUtils {
	
	public static void catchResponse(Response<?> response, Exception e) {
		response.setResultset(null);
		 if (e instanceof ExpedientesExceptions) {
			response.setStatuscode(((ExpedientesExceptions) e).getStatusCode());
			response.setStatusmessage(((ExpedientesExceptions) e).getMessage());
		} else { // Errores internos
			response.setStatuscode(Constantes.CODIGO_ERROR_PROCESO);
			response.setStatusmessage(Constantes.MENSAJE_ERROR_PROCESO);
		}
	}

}
