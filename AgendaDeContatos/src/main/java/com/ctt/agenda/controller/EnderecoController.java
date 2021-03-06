package com.ctt.agenda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctt.agenda.dto.input.EnderecoDtoInput;
import com.ctt.agenda.dto.output.EnderecoDtoOutput;
import com.ctt.agenda.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(produces = "application/json")
	public List<EnderecoDtoOutput> get() {
		return this.enderecoService.getAll();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public EnderecoDtoOutput get(@PathVariable Long id) {
		return this.enderecoService.get(id);
	}

	// Entrada do meu DTO sendo validado @Valid
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public EnderecoDtoOutput post(@Valid @RequestBody EnderecoDtoInput enderecoDtoInput) {
		return this.enderecoService.create(enderecoDtoInput);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public EnderecoDtoOutput put(@Valid @RequestBody EnderecoDtoInput enderecoDtoInput, @PathVariable Long id) {
		return this.enderecoService.update(enderecoDtoInput, id);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.enderecoService.delete(id);
	}	

	
}
