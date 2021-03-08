package com.ctt.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctt.agenda.converter.TelefoneConverter;
import com.ctt.agenda.dto.input.TelefoneDtoInput;
import com.ctt.agenda.dto.output.TelefoneDtoOutput;
import com.ctt.agenda.entity.Telefone;
import com.ctt.agenda.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private TelefoneConverter telefoneConverter;

	public TelefoneDtoOutput create(TelefoneDtoInput telefoneDtoInput) {
		Telefone telefone = telefoneConverter.dtoToModel(telefoneDtoInput);
		this.telefoneRepository.save(telefone);
		return this.telefoneConverter.modelToDto(telefone);
	}

	public TelefoneDtoOutput update(TelefoneDtoInput telefoneDtoInput, Long id) {
		Optional<Telefone> telefoneOptional = this.telefoneRepository.findById(id);
		Telefone telefone = telefoneOptional.get();

		this.telefoneConverter.dtoToModel(telefoneDtoInput, telefone);
		this.telefoneRepository.save(telefone);
		return this.telefoneConverter.modelToDto(telefone);
	}

	public List<TelefoneDtoOutput> getAll() {
		
		/*
		 * return this.telefoneRepository.findAll() .stream() .map(
		 * this.telefoneConverter::modelToDto ) .collect(Collectors.toList());
		 */
		
		return this.telefoneConverter.modelToDto(this.telefoneRepository.findAll());
		
	}

	public TelefoneDtoOutput get(Long id) {
		Optional<Telefone> telefoneOptional = this.telefoneRepository.findById(id);
		Telefone telefone = telefoneOptional.get();
		return this.telefoneConverter.modelToDto(telefone);
	}

	public void delete(Long id) {
		this.telefoneRepository.deleteById(id);
	}

}