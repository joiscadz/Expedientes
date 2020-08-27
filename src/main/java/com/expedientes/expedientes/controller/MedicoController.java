package com.expedientes.expedientes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expedientes.expedientes.entity.Medico;
import com.expedientes.expedientes.model.Response;
import com.expedientes.expedientes.service.MedicoService;

import io.swagger.annotations.ApiOperation;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/medico")
public class MedicoController {

	@Autowired
	MedicoService medicoService;

	@PostMapping(value = "/agregar")
	@ApiOperation(value = "registro de nuevo auto", notes = "registro de nuevo auto")
	public Response<Object> agregar(@Valid @RequestBody Medico instance) {
		return medicoService.autoguardar(instance);

	}

	@GetMapping(value = "/lista")
	@ApiOperation(value = "lista de autos", notes = "lista de auto")
	public Response<Object> lista() {
		return medicoService.buscar();

	}

}
