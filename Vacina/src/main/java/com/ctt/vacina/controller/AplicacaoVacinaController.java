package com.ctt.vacina.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctt.vacina.dto.request.AplicacaoVacinaRequest;
import com.ctt.vacina.dto.response.AplicacaoVacinaResponse;
import com.ctt.vacina.service.AplicacaoVacinaService;

@RestController
@RequestMapping("/aplicacaoVacina")

public class AplicacaoVacinaController {

	@Autowired
	private AplicacaoVacinaService aplicacaoVacinaService;

//	@PostMapping(consumes = "application/json", produces = "application/json")
//	@ResponseStatus(HttpStatus.CREATED)
//	public AplicacaoVacina post(@RequestBody AplicacaoVacina aplicacaoVacina) {
//		this.aplicacaoVacinaService.create(aplicacaoVacina);
//		return aplicacaoVacina;
//	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public AplicacaoVacinaResponse post(@Valid @RequestBody AplicacaoVacinaRequest aplicacaoVacina) {
		return this.aplicacaoVacinaService.create(aplicacaoVacina);

	}

}
