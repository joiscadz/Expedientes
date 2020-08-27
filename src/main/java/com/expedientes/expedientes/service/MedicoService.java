package com.expedientes.expedientes.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedientes.expedientes.entity.Medico;
import com.expedientes.expedientes.exceptios.ExpedientesExceptions;
import com.expedientes.expedientes.model.Response;
import com.expedientes.expedientes.repository.MedicoRepository;
import com.expedientes.expedientes.util.ExpedientesUtils;
import com.expedientes.expedientes.util.Constantes;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MedicoService {

	@Autowired
	MedicoRepository medicoRepository;

	public  Response<Object> autoguardar(Medico instance) {
	

		Response<Object> response = new Response<Object>();
		try {

			Medico auto = new Medico();

			auto.setNombre(instance.getNombre());
			auto.setApellido(instance.getApellido());
			if (Objects.isNull(auto))
				throw new ExpedientesExceptions(Constantes.MENSAJE_NULL_AUTO, Constantes.CODIGO_ERROR_PROCESO);

			Medico guardar = medicoRepository.save(auto);

			response.setResultset(guardar);
			
			
		} catch (Exception e) {
			log.error(e.toString(), e);
			ExpedientesUtils.catchResponse(response, e);
		}

		return response;

	}

	public Response<Object> buscar() {

		Response<Object> response = new Response<Object>();
		try {

			medicoRepository.findAll();

			response.setResultset(medicoRepository.findAll());

		} catch (Exception e) {
			log.error(e.toString(), e);
			ExpedientesUtils.catchResponse(response, e);
		}

		return response;

	}
}
